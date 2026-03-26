package com.ankangban.health.core.oppo

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.util.Log
import com.heytap.health.sdk.HealthAgent
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class OppoHealthClientImpl(private val appContext: Context) : OppoHealthClient {

    // 使用 replay=1 保证新的订阅者能收到最新数据
    private val _heart = MutableSharedFlow<HeartRate>(replay = 1, onBufferOverflow = BufferOverflow.DROP_OLDEST)
    private val _spo2 = MutableSharedFlow<SpO2>(replay = 1, onBufferOverflow = BufferOverflow.DROP_OLDEST)
    private val _temp = MutableSharedFlow<WristTemp>(replay = 1, onBufferOverflow = BufferOverflow.DROP_OLDEST)
    private val _steps = MutableSharedFlow<Steps>(replay = 1, onBufferOverflow = BufferOverflow.DROP_OLDEST)
    private val _resp = MutableSharedFlow<RespRate>(replay = 1, onBufferOverflow = BufferOverflow.DROP_OLDEST)
    private val _ecg = MutableSharedFlow<EcgSample>(replay = 1, onBufferOverflow = BufferOverflow.DROP_OLDEST)
    private val _sleep = MutableSharedFlow<SleepSummary>(replay = 1, onBufferOverflow = BufferOverflow.DROP_OLDEST)

    private var isSdkInitialized = false
    private var sensorManager: SensorManager? = null
    private var lastStepCount: Float? = null
    private var mInitialSteps = 0
    private var useRealSensors = false

    override val heartRateStream: Flow<HeartRate> = _heart.asSharedFlow()
    override val spO2Stream: Flow<SpO2> = _spo2.asSharedFlow()
    override val wristTempStream: Flow<WristTemp> = _temp.asSharedFlow()
    override val stepsStream: Flow<Steps> = _steps.asSharedFlow()
    override val respRateStream: Flow<RespRate> = _resp.asSharedFlow()
    override val ecgStream: Flow<EcgSample> = _ecg.asSharedFlow()
    override val sleepSummaryStream: Flow<SleepSummary> = _sleep.asSharedFlow()

    override fun setUpdateInterval(intervalMs: Long) {
        HealthAgent.setUpdateInterval(intervalMs)
    }

    override fun setInitialSteps(steps: Int) {
        mInitialSteps = steps
        HealthAgent.setInitialSteps(steps)
    }

    override suspend fun initialize(): Boolean {
        if (isSdkInitialized) return true

        // Prioritize Android Sensors for steps if available
        useRealSensors = initAndroidSensors()

        // 1. 尝试初始化 OPPO Health SDK
        val initSuccess = suspendCoroutine { cont ->
            HealthAgent.init(appContext, "YOUR_APP_ID", "YOUR_APP_SECRET", object : HealthAgent.InitCallback {
                override fun onSuccess() {
                    cont.resume(true)
                }

                override fun onFailure(code: Int, msg: String) {
                    Log.e("OppoHealth", "SDK Init failed: $code, $msg")
                    cont.resume(false)
                }
            })
        }

        if (initSuccess) {
            // 2. 鉴权
            val authSuccess = suspendCoroutine { cont ->
                HealthAgent.checkAuth(appContext, object : HealthAgent.AuthCallback {
                    override fun onAuthSuccess() {
                        cont.resume(true)
                    }

                    override fun onAuthFailed(code: Int) {
                        Log.e("OppoHealth", "Auth failed: $code")
                        cont.resume(false)
                    }
                })
            }

            if (authSuccess) {
                // 3. 注册数据监听
                HealthAgent.registerDataListener(object : HealthAgent.HealthDataListener {
                    override fun onHeartRateChanged(bpm: Int, timestamp: Long) {
                        _heart.tryEmit(HeartRate(bpm, timestamp, bpm < 60)) // 简单判断静息
                    }

                    override fun onSpO2Changed(percent: Int, timestamp: Long) {
                        _spo2.tryEmit(SpO2(percent, timestamp))
                    }

                    override fun onStepsChanged(steps: Int, calories: Float, timestamp: Long) {
                        // Only use SDK steps if real sensors are not available
                        if (!useRealSensors) {
                            _steps.tryEmit(Steps(steps, calories, timestamp))
                        }
                    }

                    override fun onSleepChanged(totalMin: Int, deepMin: Int, lightMin: Int, remMin: Int, timestamp: Long) {
                        val efficiency = if (totalMin > 0) (deepMin + lightMin + remMin).toFloat() / totalMin else 0f
                        _sleep.tryEmit(SleepSummary(totalMin, efficiency, deepMin, lightMin, remMin, timestamp - totalMin * 60000, timestamp))
                    }

                    override fun onWristTempChanged(celsius: Float, timestamp: Long) {
                        _temp.tryEmit(WristTemp(celsius, timestamp))
                    }

                    override fun onRespRateChanged(rpm: Int, timestamp: Long) {
                        _resp.tryEmit(RespRate(rpm, timestamp))
                    }

                    override fun onEcgChanged(voltage: Float, timestamp: Long) {
                        _ecg.tryEmit(EcgSample(voltage, timestamp))
                    }
                })
                isSdkInitialized = true
                Log.d("OppoHealth", "OPPO Health SDK Initialized and Listening")
                return true
            }
        }

        return useRealSensors
    }

    private fun initAndroidSensors(): Boolean {
        sensorManager = appContext.getSystemService(Context.SENSOR_SERVICE) as SensorManager
        val stepCounter = sensorManager?.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)
        if (stepCounter != null) {
            sensorManager?.registerListener(object : SensorEventListener {
                override fun onSensorChanged(event: SensorEvent) {
                    val totalSteps = event.values[0]
                    val ts = System.currentTimeMillis()
                    
                    // 简单的增量计算，实际应根据当天 0 点重置
                    if (lastStepCount == null) {
                        lastStepCount = totalSteps
                    }
                    val delta = (totalSteps - (lastStepCount ?: 0f)).toInt()
                    val todaySteps = mInitialSteps + delta
                    
                    // 估算卡路里 (0.04 kcal/step)
                    val calories = todaySteps * 0.04f
                    
                    _steps.tryEmit(Steps(todaySteps, calories, ts))
                }

                override fun onAccuracyChanged(sensor: Sensor, accuracy: Int) {}
            }, stepCounter, SensorManager.SENSOR_DELAY_UI)
            return true
        }
        return false
    }
}
