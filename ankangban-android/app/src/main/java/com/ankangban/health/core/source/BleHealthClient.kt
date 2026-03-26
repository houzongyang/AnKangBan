package com.ankangban.health.core.source

import android.content.Context
import com.ankangban.health.core.oppo.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.map

class BleHealthClient(context: Context) : OppoHealthClient {

    private val bleHelper = BleHelper.getInstance(context)

    override suspend fun initialize(): Boolean {
        // BLE connection is managed by UI/BleHelper directly.
        // Here we just check if Bluetooth is enabled.
        return bleHelper.isBluetoothEnabled()
    }

    override val heartRateStream: Flow<HeartRate> = bleHelper.heartRateFlow.map { bpm ->
        HeartRate(bpm, System.currentTimeMillis(), bpm < 60)
    }

    // Other streams are empty for now as standard BLE mainly supports HR easily.
    // Steps usually require proprietary protocols for bands (Xiaomi/Huawei).
    // We can add more if needed.
    override val spO2Stream: Flow<SpO2> = emptyFlow()
    override val wristTempStream: Flow<WristTemp> = emptyFlow()
    override val stepsStream: Flow<Steps> = emptyFlow()
    override val respRateStream: Flow<RespRate> = emptyFlow()
    override val ecgStream: Flow<EcgSample> = emptyFlow()
    override val sleepSummaryStream: Flow<SleepSummary> = emptyFlow()

    override fun setUpdateInterval(intervalMs: Long) {
        // No-op for BLE notifications
    }

    override fun setInitialSteps(steps: Int) {
        // No-op
    }
}
