package com.ankangban.health.core.permissions

import android.app.Activity
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

object HealthPermissions {
    val REQUIRED = arrayOf(
        android.Manifest.permission.BODY_SENSORS,
        android.Manifest.permission.ACTIVITY_RECOGNITION,
        android.Manifest.permission.BLUETOOTH,
        android.Manifest.permission.BLUETOOTH_ADMIN,
        android.Manifest.permission.BLUETOOTH_CONNECT,
        android.Manifest.permission.BLUETOOTH_SCAN,
        android.Manifest.permission.ACCESS_FINE_LOCATION,
        android.Manifest.permission.ACCESS_COARSE_LOCATION,
        android.Manifest.permission.RECORD_AUDIO,
        // OPPO Health Permissions
        "com.heytap.health.permission.READ_HEALTH_DATA",
        "com.heytap.health.permission.READ_SLEEP_DATA"
    )

    fun ensure(activity: Activity, requestCode: Int = 1001) {
        val need = REQUIRED.filter {
            ContextCompat.checkSelfPermission(activity, it) != PackageManager.PERMISSION_GRANTED
        }
        if (need.isNotEmpty()) {
            ActivityCompat.requestPermissions(activity, need.toTypedArray(), requestCode)
        }
    }
}

