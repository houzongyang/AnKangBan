package com.ankangban.health.core.source

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.content.ContextCompat
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class DataSourceStatusManager(private val context: Context) {

    private val _sensorState = MutableStateFlow(DataSourceState(DataSourceType.DEVICE_SENSOR, SourceStatus.NOT_CONNECTED, "正在检测..."))
    val sensorState: StateFlow<DataSourceState> = _sensorState.asStateFlow()

    private val _fileState = MutableStateFlow(DataSourceState(DataSourceType.LOCAL_FILE, SourceStatus.NOT_CONNECTED, "请先选择本地CSV健康数据文件"))
    val fileState: StateFlow<DataSourceState> = _fileState.asStateFlow()

    private val _sdkState = MutableStateFlow(DataSourceState(DataSourceType.THIRD_PARTY_SDK, SourceStatus.NO_PERMISSION, "第三方SDK暂未配置，当前版本不支持"))
    val sdkState: StateFlow<DataSourceState> = _sdkState.asStateFlow()

    suspend fun checkStatuses() {
        // Simulate async check
        delay(500)
        checkSensorStatus()
        checkSdkStatus()
        // File status is event-driven (by import), but we can re-verify if file exists if we stored path
    }

    private fun checkSdkStatus() {
        val prefs = context.getSharedPreferences("app_config", Context.MODE_PRIVATE)
        val provider = prefs.getString("sdk_provider", null)
        
        val isConnected = BleHelper.getInstance(context).isDeviceConnected()
        
        if (isConnected) {
            _sdkState.value = DataSourceState(
                DataSourceType.THIRD_PARTY_SDK,
                SourceStatus.CONNECTED,
                "已连接: ${provider ?: "蓝牙设备"}"
            )
        } else if (!provider.isNullOrEmpty()) {
            _sdkState.value = DataSourceState(
                DataSourceType.THIRD_PARTY_SDK,
                SourceStatus.NOT_CONNECTED,
                "已保存: $provider (点击重新连接)"
            )
        } else {
            _sdkState.value = DataSourceState(
                DataSourceType.THIRD_PARTY_SDK,
                SourceStatus.NOT_CONNECTED,
                "第三方SDK/蓝牙设备未配置"
            )
        }
    }

    private fun checkSensorStatus() {
        val hasPermission = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            ContextCompat.checkSelfPermission(context, Manifest.permission.ACTIVITY_RECOGNITION) == PackageManager.PERMISSION_GRANTED
        } else {
            true // Pre-Q didn't require runtime permission for step counter in same way
        }
        
        // Check for Body Sensors if applicable (Android 13+)
        val hasBodySensors = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
             ContextCompat.checkSelfPermission(context, Manifest.permission.BODY_SENSORS) == PackageManager.PERMISSION_GRANTED
        } else {
            true
        }

        if (!hasPermission || !hasBodySensors) {
            _sensorState.value = DataSourceState(
                DataSourceType.DEVICE_SENSOR, 
                SourceStatus.NO_PERMISSION, 
                "请先授予健康数据读取权限"
            )
            return
        }

        val pm = context.packageManager
        val hasStepCounter = pm.hasSystemFeature(PackageManager.FEATURE_SENSOR_STEP_COUNTER)
        val hasHeartRate = pm.hasSystemFeature(PackageManager.FEATURE_SENSOR_HEART_RATE)

        if (hasStepCounter || hasHeartRate) {
             _sensorState.value = DataSourceState(
                DataSourceType.DEVICE_SENSOR, 
                SourceStatus.CONNECTED, 
                "设备传感器已连接，可采集实时数据"
            )
        } else {
            // Fallback for emulator or device without sensors
             _sensorState.value = DataSourceState(
                DataSourceType.DEVICE_SENSOR, 
                SourceStatus.NOT_CONNECTED, 
                "设备无健康传感器，无法采集数据"
            )
        }
    }
    
    fun updateFileStatus(connected: Boolean, message: String) {
        _fileState.value = DataSourceState(
            DataSourceType.LOCAL_FILE,
            if (connected) SourceStatus.CONNECTED else SourceStatus.NOT_CONNECTED,
            message
        )
    }

    fun updateSdkStatus(connected: Boolean, message: String) {
        _sdkState.value = DataSourceState(
            DataSourceType.THIRD_PARTY_SDK,
            if (connected) SourceStatus.CONNECTED else SourceStatus.NOT_CONNECTED,
            message
        )
    }
}
