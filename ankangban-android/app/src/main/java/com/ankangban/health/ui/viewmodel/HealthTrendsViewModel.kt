package com.ankangban.health.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.ankangban.health.core.repo.HealthRepository
import com.ankangban.health.core.storage.HealthDataEntity
import com.ankangban.health.core.storage.SleepDataEntity
import com.ankangban.health.core.storage.StepsEntity
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

import android.content.res.Configuration

class HealthTrendsViewModel(
    application: Application
) : AndroidViewModel(application) {

    private val repository = HealthRepository(
        client = com.ankangban.health.core.oppo.OppoHealthClientImpl(application),
        store = com.ankangban.health.core.storage.HealthLocalStore(application)
    )

    init {
        viewModelScope.launch {
            repository.checkAndSeedData()
            refreshData()
        }
    }

    enum class TimeDimension { DAY, WEEK, MONTH }
    enum class DataType { HEART_RATE, SPO2, STEPS, SLEEP, WRIST_TEMP, RESP_RATE }

    private val _chartOption = MutableStateFlow<String?>(null)
    val chartOption: StateFlow<String?> = _chartOption

    private val _stats = MutableStateFlow<Map<String, String>>(emptyMap())
    val stats: StateFlow<Map<String, String>> = _stats

    private val _trendInsight = MutableStateFlow<com.ankangban.health.core.api.TrendAnalysisResponse?>(null)
    val trendInsight: StateFlow<com.ankangban.health.core.api.TrendAnalysisResponse?> = _trendInsight

    var currentDimension = TimeDimension.DAY
        private set
    var currentType = DataType.HEART_RATE
        private set

    private fun isDarkMode(): Boolean {
        val nightModeFlags = getApplication<Application>().resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
        return nightModeFlags == Configuration.UI_MODE_NIGHT_YES
    }

    private fun getChartColors(): Pair<String, String> {
        return if (isDarkMode()) {
            Pair("#FFFFFF", "#333333") // Text, Axis
        } else {
            Pair("#333333", "#EEEEEE") // Text, Axis
        }
    }

    fun setDimension(dim: TimeDimension) {
        currentDimension = dim
        refreshData()
    }

    fun setDataType(type: DataType) {
        currentType = type
        refreshData()
    }

    fun refreshData() {
        val (start, end) = getTimeRange(currentDimension)
        
        viewModelScope.launch {
            when (currentType) {
                DataType.HEART_RATE -> loadHeartRate(start, end)
                DataType.SPO2 -> loadSpO2(start, end)
                DataType.STEPS -> loadSteps(start, end)
                DataType.SLEEP -> {
                    loadSleep(start, end)
                    loadTrendAnalysis()
                }
                DataType.WRIST_TEMP -> loadWristTemp(start, end)
                DataType.RESP_RATE -> loadRespRate(start, end)
            }
        }
    }

    fun loadTrendAnalysis() {
        viewModelScope.launch {
            // Only analyze for Sleep currently
            if (currentType == DataType.SLEEP) {
                val period = if (currentDimension == TimeDimension.MONTH) "近30天" else "近7天"
                // Only analyze if dimension is Week or Month, otherwise default to 7 days
                val actualPeriod = if (currentDimension == TimeDimension.DAY) "近7天" else period
                val result = repository.generateTrendAnalysis(actualPeriod)
                _trendInsight.value = result
            } else {
                _trendInsight.value = null
            }
        }
    }

    private fun getTimeRange(dim: TimeDimension): Pair<Long, Long> {
        val calendar = Calendar.getInstance()
        val end = calendar.timeInMillis
        when (dim) {
            TimeDimension.DAY -> {
                calendar.set(Calendar.HOUR_OF_DAY, 0)
                calendar.set(Calendar.MINUTE, 0)
                calendar.set(Calendar.SECOND, 0)
                calendar.set(Calendar.MILLISECOND, 0)
            }
            TimeDimension.WEEK -> {
                calendar.add(Calendar.DAY_OF_YEAR, -7)
            }
            TimeDimension.MONTH -> {
                calendar.add(Calendar.DAY_OF_YEAR, -30)
            }
        }
        return Pair(calendar.timeInMillis, end)
    }

    private suspend fun loadHeartRate(start: Long, end: Long) {
        repository.getHeartRateHistory(start, end)?.collectLatest { list ->
            val dataToUse = list
            
            val xAxis = mutableListOf<String>()
            val seriesData = mutableListOf<Float>()
            var sum = 0f
            var max = 0f
            var min = Float.MAX_VALUE
            var count = 0

            dataToUse.sortedBy { it.timestamp }.forEach {
                xAxis.add(formatTime(it.timestamp, currentDimension))
                seriesData.add(it.value)
                sum += it.value
                if (it.value > max) max = it.value
                if (it.value < min) min = it.value
                count++
            }
            
            if (count == 0) min = 0f

            val option = buildLineChartOption("心率", xAxis, seriesData, "#4CAF50", 120f, 50f)
            _chartOption.value = option
            
            _stats.value = mapOf(
                "均值" to "${(if (count > 0) sum / count else 0).toInt()} 次/分",
                "最高" to "${max.toInt()}",
                "最低" to "${min.toInt()}"
            )
        }
    }

    private suspend fun loadSpO2(start: Long, end: Long) {
        repository.getSpO2History(start, end)?.collectLatest { list ->
            val dataToUse = list
            
            val xAxis = mutableListOf<String>()
            val seriesData = mutableListOf<Float>()
            var sum = 0f
            var max = 0f
            var min = Float.MAX_VALUE
            var count = 0

            dataToUse.sortedBy { it.timestamp }.forEach {
                xAxis.add(formatTime(it.timestamp, currentDimension))
                seriesData.add(it.value)
                sum += it.value
                if (it.value > max) max = it.value
                if (it.value < min) min = it.value
                count++
            }

            if (count == 0) min = 0f

            val option = buildLineChartOption("血氧", xAxis, seriesData, "#2196F3", 100f, 90f)
            _chartOption.value = option

            _stats.value = mapOf(
                "均值" to "${(if (count > 0) sum / count else 0).toInt()}%",
                "最高" to "${max.toInt()}%",
                "最低" to "${min.toInt()}%"
            )
        }
    }

    private suspend fun loadSteps(start: Long, end: Long) {
         repository.getStepsHistory(start, end)?.collectLatest { list ->
            val dataToUse = list
             
            val xAxis = mutableListOf<String>()
            val seriesData = mutableListOf<Int>()
            var sum = 0
            var max = 0
            
            dataToUse.sortedBy { it.timestamp }.forEach {
                xAxis.add(formatTime(it.timestamp, currentDimension))
                seriesData.add(it.count)
                // For cumulative steps, max value represents the total/latest
                if (it.count > max) max = it.count
            }
            sum = max // Use max as total for cumulative data

            val option = buildBarChartOption("步数", xAxis, seriesData, "#FF9800")
            _chartOption.value = option

             _stats.value = mapOf(
                 "总步数" to "$sum",
                 "最高" to "$max",
                 "日均" to "${if (dataToUse.isNotEmpty()) sum / dataToUse.size else 0}"
             )
         }
    }

    private suspend fun loadSleep(start: Long, end: Long) {
        repository.getSleepHistory(start, end)?.collectLatest { list ->
            val dataToUse = list
            
            val xAxis = mutableListOf<String>()
            val deepData = mutableListOf<Float>()
            val lightData = mutableListOf<Float>()
            var totalDuration = 0f
            
            dataToUse.sortedBy { it.startTime }.forEach {
                xAxis.add(formatTime(it.startTime, currentDimension))
                deepData.add(it.deepMinutes / 60f)
                lightData.add(it.lightMinutes / 60f)
                totalDuration += it.totalMinutes
            }
            
            if (currentDimension == TimeDimension.MONTH) {
                val option = buildHeatmapChartOption(dataToUse)
                _chartOption.value = option
            } else {
                val option = buildStackedBarChartOption(xAxis, deepData, lightData)
                _chartOption.value = option
            }
            
             _stats.value = mapOf(
                 "总时长" to String.format("%.1f小时", totalDuration / 60f),
                 "深睡占比" to "${if (totalDuration > 0) (dataToUse.sumOf { it.deepMinutes } * 100 / totalDuration).toInt() else 0}%"
             )
        }
    }

    private fun buildHeatmapChartOption(data: List<SleepDataEntity>): String {
        // Y-axis: Day of Week (0-6), X-axis: Week Index (0-4)
        // Value: Sleep Efficiency
        val (textColor, axisColor) = getChartColors()
        val dataStr = StringBuilder()
        
        // Group by week
        val cal = Calendar.getInstance()
        data.forEach {
            cal.timeInMillis = it.startTime
            val dayOfWeek = (cal.get(Calendar.DAY_OF_WEEK) + 5) % 7 // Mon=0, Sun=6
            val weekOfMonth = cal.get(Calendar.WEEK_OF_MONTH) - 1
            // [x, y, value]
            if (dataStr.isNotEmpty()) dataStr.append(",")
            dataStr.append("[${weekOfMonth}, ${dayOfWeek}, ${it.efficiency.toInt()}]")
        }
        
        return """
            {
                "tooltip": { "position": "top" },
                "grid": { "height": "50%", "top": "10%" },
                "xAxis": { "type": "category", "data": ["第一周", "第二周", "第三周", "第四周", "第五周"], "splitArea": { "show": true }, "axisLabel": { "color": "$textColor" } },
                "yAxis": { "type": "category", "data": ["周一", "周二", "周三", "周四", "周五", "周六", "周日"], "splitArea": { "show": true }, "axisLabel": { "color": "$textColor" } },
                "visualMap": { "min": 60, "max": 100, "calculable": true, "orient": "horizontal", "left": "center", "bottom": "15%" },
                "series": [{
                    "name": "睡眠效率",
                    "type": "heatmap",
                    "data": [$dataStr],
                    "label": { "show": true },
                    "itemStyle": {
                        "emphasis": { "shadowBlur": 10, "shadowColor": "rgba(0, 0, 0, 0.5)" }
                    }
                }]
            }
        """.trimIndent()
    }

    private suspend fun loadWristTemp(start: Long, end: Long) {
        repository.getWristTempHistory(start, end)?.collectLatest { list ->
            val dataToUse = list
            val xAxis = mutableListOf<String>()
            val seriesData = mutableListOf<Float>()
            var sum = 0f
            var max = 0f
            var min = Float.MAX_VALUE
            var count = 0

            dataToUse.sortedBy { it.timestamp }.forEach {
                xAxis.add(formatTime(it.timestamp, currentDimension))
                seriesData.add(it.value)
                sum += it.value
                if (it.value > max) max = it.value
                if (it.value < min) min = it.value
                count++
            }
            if (count == 0) min = 0f
            val option = buildLineChartOption("腕温", xAxis, seriesData, "#FF5722", 37.5f, 36.0f)
            _chartOption.value = option
            _stats.value = mapOf(
                "均值" to String.format("%.1f℃", if (count > 0) sum / count else 0f),
                "最高" to String.format("%.1f℃", max),
                "最低" to String.format("%.1f℃", min)
            )
        }
    }

    private suspend fun loadRespRate(start: Long, end: Long) {
        repository.getRespRateHistory(start, end)?.collectLatest { list ->
            val dataToUse = list
            val xAxis = mutableListOf<String>()
            val seriesData = mutableListOf<Float>()
            var sum = 0f
            var max = 0f
            var min = Float.MAX_VALUE
            var count = 0

            dataToUse.sortedBy { it.timestamp }.forEach {
                xAxis.add(formatTime(it.timestamp, currentDimension))
                seriesData.add(it.value)
                sum += it.value
                if (it.value > max) max = it.value
                if (it.value < min) min = it.value
                count++
            }
            if (count == 0) min = 0f
            val option = buildLineChartOption("呼吸率", xAxis, seriesData, "#9C27B0", 25f, 12f)
            _chartOption.value = option
            _stats.value = mapOf(
                "均值" to "${(if (count > 0) sum / count else 0).toInt()} 次/分",
                "最高" to "${max.toInt()}",
                "最低" to "${min.toInt()}"
            )
        }
    }

    // Mock Generators
    private fun generateMockHeartRate(start: Long, end: Long): List<HealthDataEntity> {
        val list = mutableListOf<HealthDataEntity>()
        var time = start
        val interval = if (currentDimension == TimeDimension.DAY) 3600000L else 86400000L
        while (time <= end) {
            val value = (60..100).random().toFloat()
            // Add occasional anomaly
            val finalValue = if ((0..10).random() > 8) value + 30 else value
            list.add(HealthDataEntity(type = "HEART_RATE", value = finalValue, timestamp = time))
            time += interval
        }
        return list
    }

    private fun generateMockSpO2(start: Long, end: Long): List<HealthDataEntity> {
        val list = mutableListOf<HealthDataEntity>()
        var time = start
        val interval = if (currentDimension == TimeDimension.DAY) 3600000L else 86400000L
        while (time <= end) {
            val value = (95..100).random().toFloat()
            list.add(HealthDataEntity(type = "SPO2", value = value, timestamp = time))
            time += interval
        }
        return list
    }

    private fun generateMockSteps(start: Long, end: Long): List<StepsEntity> {
        val list = mutableListOf<StepsEntity>()
        var time = start
        val interval = if (currentDimension == TimeDimension.DAY) 3600000L else 86400000L
        while (time <= end) {
            val count = (100..1000).random()
            list.add(StepsEntity(timestamp = time, count = count, calories = count * 0.04f))
            time += interval
        }
        return list
    }

    private fun generateMockSleep(start: Long, end: Long): List<SleepDataEntity> {
        val list = mutableListOf<SleepDataEntity>()
        var time = start
        val interval = 86400000L // Sleep is usually daily
        while (time <= end) {
            val total = (300..540).random() // 5-9 hours
            val deep = (total * 0.3).toInt()
            val light = (total * 0.5).toInt()
            val rem = total - deep - light
            list.add(SleepDataEntity(
                startTime = time,
                endTime = time + total * 60000,
                totalMinutes = total,
                deepMinutes = deep,
                lightMinutes = light,
                remMinutes = rem,
                efficiency = 0.90f
            ))
            time += interval
        }
        return list
    }

    private fun formatTime(ts: Long, dim: TimeDimension): String {
        val fmt = when (dim) {
            TimeDimension.DAY -> SimpleDateFormat("HH:mm", Locale.getDefault())
            else -> SimpleDateFormat("MM-dd", Locale.getDefault())
        }
        return fmt.format(Date(ts))
    }

    private fun buildLineChartOption(name: String, xAxis: List<String>, data: List<Float>, color: String, maxMark: Float, minMark: Float): String {
        val (textColor, axisColor) = getChartColors()
        val xStr = xAxis.joinToString("\",\"", "\"", "\"")
        val dataStr = data.joinToString(",")
        
        return """
            {
                "grid": { "top": 30, "bottom": 30, "left": 40, "right": 20 },
                "tooltip": { "trigger": "axis" },
                "textStyle": { "color": "$textColor" },
                "xAxis": { 
                    "type": "category", 
                    "data": [$xStr],
                    "axisLine": { "lineStyle": { "color": "$axisColor" } }
                },
                "yAxis": { 
                    "type": "value",
                    "splitLine": { "lineStyle": { "color": "$axisColor" } }
                },
                "series": [{
                    "name": "$name",
                    "type": "line",
                    "data": [$dataStr],
                    "smooth": true,
                    "itemStyle": { "color": "$color" },
                    "markPoint": {
                        "data": [
                            { "type": "max", "name": "Max" },
                            { "type": "min", "name": "Min" }
                        ]
                    },
                    "markLine": {
                        "data": [
                             { "yAxis": $maxMark, "lineStyle": { "color": "red" } },
                             { "yAxis": $minMark, "lineStyle": { "color": "red" } }
                        ]
                    }
                }]
            }
        """.trimIndent()
    }
    
    private fun buildBarChartOption(name: String, xAxis: List<String>, data: List<Int>, color: String): String {
        val (textColor, axisColor) = getChartColors()
        val xStr = xAxis.joinToString("\",\"", "\"", "\"")
        val dataStr = data.joinToString(",")
        return """
            {
                "grid": { "top": 30, "bottom": 30, "left": 40, "right": 20 },
                "tooltip": { "trigger": "axis" },
                "textStyle": { "color": "$textColor" },
                "xAxis": { 
                    "type": "category", 
                    "data": [$xStr],
                    "axisLine": { "lineStyle": { "color": "$axisColor" } }
                },
                "yAxis": { 
                    "type": "value",
                    "splitLine": { "lineStyle": { "color": "$axisColor" } }
                },
                "series": [{
                    "name": "$name",
                    "type": "bar",
                    "data": [$dataStr],
                    "itemStyle": { "color": "$color" }
                }]
            }
        """.trimIndent()
    }
    
    private fun buildStackedBarChartOption(xAxis: List<String>, deep: List<Float>, light: List<Float>): String {
         val (textColor, axisColor) = getChartColors()
         val xStr = xAxis.joinToString("\",\"", "\"", "\"")
         val dStr = deep.joinToString(",")
         val lStr = light.joinToString(",")
         return """
            {
                "grid": { "top": 30, "bottom": 30, "left": 40, "right": 20 },
                "tooltip": { "trigger": "axis" },
                "textStyle": { "color": "$textColor" },
                "xAxis": { 
                    "type": "category", 
                    "data": [$xStr],
                    "axisLine": { "lineStyle": { "color": "$axisColor" } }
                },
                "yAxis": { 
                    "type": "value",
                    "splitLine": { "lineStyle": { "color": "$axisColor" } }
                },
                "series": [
                    {
                        "name": "深睡",
                        "type": "bar",
                        "stack": "sleep",
                        "data": [$dStr],
                        "itemStyle": { "color": "#673AB7" }
                    },
                    {
                        "name": "浅睡",
                        "type": "bar",
                        "stack": "sleep",
                        "data": [$lStr],
                        "itemStyle": { "color": "#E0E0E0" }
                    }
                ]
            }
         """.trimIndent()
    }
}