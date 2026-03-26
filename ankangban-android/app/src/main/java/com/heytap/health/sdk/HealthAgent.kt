package com.heytap.health.sdk

import android.content.Context

/**
 * 模拟 OPPO Health SDK 的核心入口类 (Stub)
 * 实际项目中请替换为官方 SDK jar/aar
 */
object HealthAgent {
    private var timer: java.util.Timer? = null
    private var currentSteps = 0
    private var updateInterval = 600000L // Default 10 minutes

    fun setInitialSteps(steps: Int) {
        this.currentSteps = steps
    }

    fun init(context: Context, appId: String, appSecret: String, callback: InitCallback) {
        // 模拟初始化成功
        callback.onSuccess()
    }

    fun checkAuth(context: Context, callback: AuthCallback) {
        // 模拟已授权
        callback.onAuthSuccess()
    }

    fun setUpdateInterval(interval: Long) {
        this.updateInterval = interval
        // Restart if running
        if (timer != null) {
            timer?.cancel()
            timer = null
            // We need a way to know the listener to re-register, 
            // but for simplicity in this stub, we might just need to wait for re-registration 
            // or we store the listener.
            // Since this is a simple stub object, let's store the listener.
        }
        if (activeListener != null) {
            startTimer(activeListener!!)
        }
    }

    private var activeListener: HealthDataListener? = null

    fun registerDataListener(listener: HealthDataListener) {
        activeListener = listener
        startTimer(listener)
    }

    private fun startTimer(listener: HealthDataListener) {
        if (timer != null) return
        timer = java.util.Timer()
        timer?.schedule(object : java.util.TimerTask() {
            override fun run() {
                val now = System.currentTimeMillis()
                currentSteps += (0..20).random()
                val calories = currentSteps * 0.04f
                
                listener.onHeartRateChanged((60..100).random(), now)
                listener.onSpO2Changed((95..100).random(), now)
                listener.onWristTempChanged(36.0f + (0..10).random()/10f, now)
                listener.onRespRateChanged((15..25).random(), now)
                listener.onStepsChanged(currentSteps, calories, now)
            }
        }, 1000, updateInterval)
    }

    fun unregisterDataListener(listener: HealthDataListener) {
        activeListener = null
        timer?.cancel()
        timer = null
    }

    interface InitCallback {
        fun onSuccess()
        fun onFailure(code: Int, msg: String)
    }

    interface AuthCallback {
        fun onAuthSuccess()
        fun onAuthFailed(code: Int)
    }

    interface HealthDataListener {
        fun onHeartRateChanged(bpm: Int, timestamp: Long)
        fun onSpO2Changed(percent: Int, timestamp: Long)
        fun onStepsChanged(steps: Int, calories: Float, timestamp: Long)
        fun onSleepChanged(totalMin: Int, deepMin: Int, lightMin: Int, remMin: Int, timestamp: Long)
        fun onWristTempChanged(celsius: Float, timestamp: Long)
        fun onRespRateChanged(rpm: Int, timestamp: Long)
        fun onEcgChanged(voltage: Float, timestamp: Long)
    }
}
