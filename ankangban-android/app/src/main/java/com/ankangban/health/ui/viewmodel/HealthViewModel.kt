package com.ankangban.health.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.ankangban.health.core.oppo.OppoHealthClientImpl
import com.ankangban.health.core.repo.HealthRepository
import com.ankangban.health.core.api.HunyuanService
import com.ankangban.health.core.api.HealthReportResponse
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.coroutines.Dispatchers

class HealthViewModel(app: Application) : AndroidViewModel(app) {
    private val repo = HealthRepository(
        client = OppoHealthClientImpl(app),
        store = com.ankangban.health.core.storage.HealthLocalStore(app),
        bleClient = com.ankangban.health.core.source.BleHealthClient(app)
    )

    private val _initStatus = MutableSharedFlow<Boolean>()
    val initStatus = _initStatus.asSharedFlow()

    // Risk Assessment State
    private val _riskResult = MutableSharedFlow<Pair<Double, String>>()
    val riskResult = _riskResult.asSharedFlow()

    // Health Report State
    private val _healthReport = MutableSharedFlow<HealthReportResponse>()
    val healthReport = _healthReport.asSharedFlow()

    val heartRate = repo.heartRate.stateIn(viewModelScope, SharingStarted.Lazily, null)
    val spO2 = repo.spO2.stateIn(viewModelScope, SharingStarted.Lazily, null)
    val wristTemp = repo.wristTemp.stateIn(viewModelScope, SharingStarted.Lazily, null)
    val steps = repo.steps.stateIn(viewModelScope, SharingStarted.Lazily, null)
    val respRate = repo.respRate.stateIn(viewModelScope, SharingStarted.Lazily, null)
    val ecg = repo.ecg.stateIn(viewModelScope, SharingStarted.Lazily, null)
    val sleep = repo.sleepSummary.stateIn(viewModelScope, SharingStarted.Lazily, null)

    fun start() {
        viewModelScope.launch { 
            // Initialize with saved data source
            val prefs = getApplication<Application>().getSharedPreferences("app_config", android.content.Context.MODE_PRIVATE)
            val sourceType = prefs.getString("data_source_type", "DEVICE_SENSOR") ?: "DEVICE_SENSOR"
            repo.setDataSource(sourceType)
            
            val success = repo.start()
            _initStatus.emit(success)
        }
    }

    fun updateDataSource(type: String) {
        repo.setDataSource(type)
    }

    fun setUpdateInterval(minutes: Int) {
        repo.setUpdateInterval(minutes * 60 * 1000L)
    }

    fun performRiskAssessment(riskInference: com.ankangban.health.core.risk.RiskInference) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                try {
                    val userManager = com.ankangban.health.core.storage.UserManager(getApplication())
                    
                    // 1. User Info
                    val age = userManager.userAge.toDouble()
                    val gender = if (userManager.userGender == "男") 1.0 else 0.0
                    val heightM = (userManager.userHeight.toDoubleOrNull() ?: 175.0) / 100.0
                    val weightKg = userManager.userWeight.toDoubleOrNull() ?: 65.0
                    val bmi = weightKg / (heightM * heightM)

                    // 2. 7-Day History
                    val end = System.currentTimeMillis()
                    val start = end - 7L * 24 * 60 * 60 * 1000

                    // HR
                    val hrList = repo.getHeartRateHistory(start, end)?.first() ?: emptyList()
                    val hrAvg = if (hrList.isNotEmpty()) hrList.map { it.value }.average() else 75.0

                    // Steps
                    val stepsList = repo.getStepsHistory(start, end)?.first() ?: emptyList()
                    // Sum total steps over 7 days, then divide by 7 for daily average
                    val totalSteps = stepsList.sumOf { it.count }
                    val stepsAvg = if (stepsList.isNotEmpty()) totalSteps / 7.0 else 5000.0

                    // 3. Mock/Derived Data (Missing from Sensors)
                    // Sleep HR (approx 90% of resting HR)
                    val hrSleep = hrAvg * 0.9 
                    // BP (Mock normal values for now as no BP sensor)
                    val sbp = 120.0
                    val dbp = 80.0

                    // Feature Vector: [age, gender, bmi, sbp, dbp, hr_sleep, steps]
                    val features = doubleArrayOf(age, gender, bmi, sbp, dbp, hrSleep, stepsAvg)
                    
                    val result = riskInference.predict(features)
                    _riskResult.emit(result)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
    }

    fun generateHealthReport(period: String) {
        viewModelScope.launch {
            try {
                val summary = repo.getHealthReportDataSummary(period)
                val response = withContext(Dispatchers.IO) {
                    HunyuanService.generateHealthReport(period, summary)
                }
                if (response != null) {
                    _healthReport.emit(response)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
