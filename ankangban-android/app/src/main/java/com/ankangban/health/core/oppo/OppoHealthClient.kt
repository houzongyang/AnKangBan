package com.ankangban.health.core.oppo

import kotlinx.coroutines.flow.Flow

data class HeartRate(val bpm: Int, val timestamp: Long, val isResting: Boolean)
data class SpO2(val percent: Int, val timestamp: Long)
data class WristTemp(val celsius: Float, val timestamp: Long)
data class Steps(val count: Int, val calories: Float, val timestamp: Long)
data class RespRate(val rpm: Int, val timestamp: Long)
data class EcgSample(val value: Float, val timestamp: Long)

data class SleepSummary(
    val totalMinutes: Int,
    val efficiency: Float,
    val deepMinutes: Int,
    val lightMinutes: Int,
    val remMinutes: Int,
    val startTimestamp: Long,
    val endTimestamp: Long
)

interface OppoHealthClient {
    suspend fun initialize(): Boolean
    val heartRateStream: Flow<HeartRate>
    val spO2Stream: Flow<SpO2>
    val wristTempStream: Flow<WristTemp>
    val stepsStream: Flow<Steps>
    val respRateStream: Flow<RespRate>
    val ecgStream: Flow<EcgSample>
    val sleepSummaryStream: Flow<SleepSummary>
    fun setUpdateInterval(intervalMs: Long)
    fun setInitialSteps(steps: Int)
}

