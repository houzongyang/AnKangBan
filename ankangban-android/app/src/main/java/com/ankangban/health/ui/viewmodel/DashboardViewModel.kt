package com.ankangban.health.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.ankangban.health.core.storage.HealthDatabase
import com.ankangban.health.core.storage.SleepDataEntity
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import java.util.Calendar

data class HealthSummary(
    val heartRate: Int = 0,
    val bloodOxygen: Int = 0,
    val stressLevel: Int = 0
)

class DashboardViewModel(application: Application) : AndroidViewModel(application) {

    private val db = HealthDatabase.get(application)
    private val stepsDao = db.stepsDao()
    private val healthDao = db.healthDataDao()
    private val sleepDao = db.sleepDao()

    private val _todaySteps = MutableStateFlow(0)
    val todaySteps: StateFlow<Int> = _todaySteps.asStateFlow()

    private val _latestHealthData = MutableStateFlow(HealthSummary())
    val latestHealthData: StateFlow<HealthSummary> = _latestHealthData.asStateFlow()

    private val _latestSleepData = MutableStateFlow<SleepDataEntity?>(null)
    val latestSleepData: StateFlow<SleepDataEntity?> = _latestSleepData.asStateFlow()

    init {
        loadTodaySteps()
        loadLatestHealthData()
        loadLatestSleepData()
    }

    private fun loadTodaySteps() {
        viewModelScope.launch {
            val latest = stepsDao.getLatest()
            _todaySteps.value = latest?.count ?: 0
        }
    }

    private fun loadLatestHealthData() {
        viewModelScope.launch {
            val hrFlow = healthDao.getLatest("HEART_RATE")
            val spo2Flow = healthDao.getLatest("SPO2")
            val stressFlow = healthDao.getLatest("STRESS")

            combine(hrFlow, spo2Flow, stressFlow) { hr, spo2, stress ->
                HealthSummary(
                    heartRate = hr?.value?.toInt() ?: 0,
                    bloodOxygen = spo2?.value?.toInt() ?: 0,
                    stressLevel = stress?.value?.toInt() ?: 0
                )
            }.collect { summary ->
                _latestHealthData.value = summary
            }
        }
    }

    private fun loadLatestSleepData() {
        viewModelScope.launch {
            sleepDao.getLatest().collect { data ->
                _latestSleepData.value = data
            }
        }
    }
}
