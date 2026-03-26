package com.ankangban.health.core.storage

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

class UserManager(context: Context) {

    private val prefs: SharedPreferences = context.getSharedPreferences("user_prefs", Context.MODE_PRIVATE)

    var userName: String
        get() = prefs.getString("user_name", "健康体验官") ?: "健康体验官"
        set(value) = prefs.edit { putString("user_name", value) }

    var userAge: Int
        get() = prefs.getInt("user_age", 25)
        set(value) = prefs.edit { putInt("user_age", value) }

    var userGender: String
        get() = prefs.getString("user_gender", "保密") ?: "保密"
        set(value) = prefs.edit { putString("user_gender", value) }

    var userHeight: String
        get() = prefs.getString("user_height", "175") ?: "175"
        set(value) = prefs.edit { putString("user_height", value) }

    var userWeight: String
        get() = prefs.getString("user_weight", "65.0") ?: "65.0"
        set(value) = prefs.edit { putString("user_weight", value) }

    var avatarUri: String?
        get() = prefs.getString("user_avatar", null)
        set(value) = prefs.edit { putString("user_avatar", value) }

    var shareData: Boolean
        get() = prefs.getBoolean("share_data", true)
        set(value) = prefs.edit { putBoolean("share_data", value) }

    // Mock calculated properties for demo
    val healthLevel: Int
        get() = prefs.getInt("health_level", 3)

    val trackingDays: Int
        get() = prefs.getInt("tracking_days", 12)
        
    fun updateTrackingDays(days: Int) {
        prefs.edit { putInt("tracking_days", days) }
    }
}
