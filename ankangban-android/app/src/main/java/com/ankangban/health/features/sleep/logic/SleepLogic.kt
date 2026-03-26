package com.ankangban.health.features.sleep.logic

import com.ankangban.health.core.storage.SleepDataEntity
import com.ankangban.health.core.storage.SleepPlanEntity
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

enum class SleepQualityLevel {
    EXCELLENT, GOOD, FAIR, POOR
}

data class SleepQualityResult(
    val level: SleepQualityLevel,
    val score: Int,
    val reasons: List<String>,
    val improvements: List<String>,
    // Derived/Simulated metrics for display
    val latencyMinutes: Int,
    val awakeCount: Int
)

object SleepQualityEvaluator {
    
    fun evaluate(data: SleepDataEntity?, dailySteps: Int = 0): SleepQualityResult {
        if (data == null || data.totalMinutes == 0) {
            return SleepQualityResult(
                SleepQualityLevel.FAIR, 60,
                listOf("暂无睡眠数据"), listOf("请佩戴设备开启监测"),
                0, 0
            )
        }

        // Simulate metrics not in DB for demo purposes
        // Latency: usually 10-40 mins. Higher if efficiency is low.
        val latency = if (data.efficiency > 0.9) (10..20).random() 
                      else if (data.efficiency > 0.8) (20..30).random()
                      else (30..60).random()
                      
        // Awake count: usually 0-5.
        val awakeCount = if (data.efficiency > 0.9) (0..1).random()
                         else if (data.efficiency > 0.8) (1..2).random()
                         else (3..6).random()

        val deepPercent = if (data.totalMinutes > 0) data.deepMinutes.toFloat() / data.totalMinutes else 0f
        // Normalize efficiency: if > 1.0, assume it's legacy percentage (e.g. 85.0), convert to ratio (0.85)
        val efficiency = if (data.efficiency > 1.0) data.efficiency / 100f else data.efficiency

        val reasons = mutableListOf<String>()
        val improvements = mutableListOf<String>()
        var score = 0

        // Scoring Logic
        // 1. Deep Sleep (30 points)
        if (deepPercent >= 0.25) {
            score += 30
        } else if (deepPercent >= 0.15) {
            score += 20
            reasons.add("深睡占比偏低 (${(deepPercent * 100).toInt()}%)")
            improvements.add("增加日间运动量，如快走或慢跑")
        } else {
            score += 10
            reasons.add("深睡严重不足 (<15%)")
            improvements.add("尝试睡前4-7-8呼吸法，通过白噪音助眠")
        }

        // 2. Efficiency (30 points)
        if (efficiency >= 0.9) {
            score += 30
        } else if (efficiency >= 0.8) {
            score += 20
        } else {
            score += 10
            reasons.add("睡眠效率较低")
            improvements.add("减少床上非睡眠时间，建立条件反射")
        }

        // 3. Duration (20 points)
        val hours = data.totalMinutes / 60.0
        if (hours in 7.0..9.0) {
            score += 20
        } else if (hours in 6.0..7.0 || hours > 9.0) {
            score += 15
            reasons.add("睡眠时长未达最佳范围")
        } else {
            score += 10
            reasons.add("睡眠时间过短")
            improvements.add("固定作息时间，提前30分钟上床准备")
        }

        // 4. Latency & Awake (20 points simulated)
        if (latency <= 20 && awakeCount <= 1) score += 20
        else if (latency <= 30 && awakeCount <= 3) score += 15
        else {
            score += 10
            if (latency > 30) {
                reasons.add("入睡耗时较长")
                improvements.add("睡前1小时远离手机，温水泡脚")
            }
            if (awakeCount > 3) {
                reasons.add("夜间易醒次数多")
                improvements.add("改善卧室环境，保持黑暗安静")
            }
        }
        
        // 5. Steps correlation
        if (dailySteps < 3000) {
             reasons.add("日间活动量不足")
             improvements.add("每日步行5000步以上有助于提升深睡")
        }

        val level = when {
            score >= 90 -> SleepQualityLevel.EXCELLENT
            score >= 80 -> SleepQualityLevel.GOOD
            score >= 70 -> SleepQualityLevel.FAIR
            else -> SleepQualityLevel.POOR
        }
        
        // Ensure at least one improvement if not excellent
        if (improvements.isEmpty() && level != SleepQualityLevel.EXCELLENT) {
            improvements.add("保持当前良好习惯，继续监测")
        }

        return SleepQualityResult(level, score, reasons, improvements, latency, awakeCount)
    }
}

object SleepPlanGenerator {
    
    fun generateImmediatePlan(level: SleepQualityLevel): List<String> {
        return when (level) {
            SleepQualityLevel.EXCELLENT, SleepQualityLevel.GOOD -> listOf(
                "继续保持规律作息，固定23:00前入睡",
                "睡前阅读纸质书15分钟",
                "保持卧室温度在20-22度"
            )
            SleepQualityLevel.FAIR -> listOf(
                "睡前1小时停止使用电子设备",
                "进行5分钟4-7-8呼吸练习",
                "温水泡脚15分钟，促进血液循环"
            )
            SleepQualityLevel.POOR -> listOf(
                "尝试播放雨声白噪音助眠",
                "下午3点后避免摄入咖啡因",
                "进行10分钟身体扫描冥想"
            )
        }
    }

    fun generate7DayPlan(startDateStr: String, level: SleepQualityLevel): List<SleepPlanEntity> {
        val list = mutableListOf<SleepPlanEntity>()
        val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val cal = Calendar.getInstance()
        
        try {
            cal.time = sdf.parse(startDateStr) ?: Date()
        } catch (e: Exception) {
            cal.time = Date()
        }

        val basePlan = when (level) {
            SleepQualityLevel.EXCELLENT, SleepQualityLevel.GOOD -> listOf(
                "固定23:00上床，7:00起床",
                "晨起晒太阳10分钟",
                "午休不超过30分钟",
                "下午运动30分钟",
                "晚餐清淡，不吃夜宵",
                "睡前冥想5分钟",
                "记录睡眠日记"
            )
            else -> listOf(
                "严格限制床上时间，不困不上床",
                "无论睡眠好坏，固定7:00起床",
                "上午避免摄入咖啡因",
                "增加日间光照时间",
                "睡前进行呼吸放松训练",
                "卧室保持完全黑暗",
                "睡前禁止看时间"
            )
        }

        for (i in 1..7) {
            val dateStr = sdf.format(cal.time)
            val item = basePlan[(i-1) % basePlan.size]
            
            list.add(SleepPlanEntity(
                date = dateStr,
                dayIndex = i,
                title = "Day $i: 睡眠调理",
                itemsJson = "[\"$item\"]", // Simplified for demo
                isCompleted = false
            ))
            cal.add(Calendar.DAY_OF_YEAR, 1)
        }
        
        return list
    }
}
