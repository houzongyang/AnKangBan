package com.ankangban.health.core.storage

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class WarningRule(
    val type: String, // HEART_RATE, SPO2, STEPS, SLEEP
    var isEnabled: Boolean = true,
    var min: Float = 0f,
    var max: Float = 0f, // Only for HEART_RATE
    var enableDialog: Boolean = true,
    var enableNotification: Boolean = true,
    var enableVibration: Boolean = false
)

class WarningRuleManager(context: Context) {
    private val prefs: SharedPreferences = context.getSharedPreferences("warning_rules", Context.MODE_PRIVATE)
    private val gson = Gson()

    companion object {
        const val TYPE_HEART_RATE = "HEART_RATE"
        const val TYPE_SPO2 = "SPO2"
        const val TYPE_STEPS = "STEPS"
        const val TYPE_SLEEP = "SLEEP"
        
        const val ACTION_RULES_CHANGED = "com.ankangban.health.ACTION_RULES_CHANGED"
    }

    fun getRule(type: String): WarningRule {
        val json = prefs.getString(type, null)
        return if (json != null) {
            gson.fromJson(json, WarningRule::class.java)
        } else {
            createDefaultRule(type)
        }
    }

    fun saveRule(rule: WarningRule) {
        prefs.edit().putString(rule.type, gson.toJson(rule)).apply()
    }

    fun resetToDefaults() {
        saveRule(createDefaultRule(TYPE_HEART_RATE))
        saveRule(createDefaultRule(TYPE_SPO2))
        saveRule(createDefaultRule(TYPE_STEPS))
        saveRule(createDefaultRule(TYPE_SLEEP))
    }

    private fun createDefaultRule(type: String): WarningRule {
        return when (type) {
            TYPE_HEART_RATE -> WarningRule(
                type = TYPE_HEART_RATE,
                isEnabled = true,
                min = 50f,
                max = 120f,
                enableDialog = true,
                enableNotification = true,
                enableVibration = false
            )
            TYPE_SPO2 -> WarningRule(
                type = TYPE_SPO2,
                isEnabled = true,
                min = 95f,
                enableDialog = true,
                enableNotification = true,
                enableVibration = false
            )
            TYPE_STEPS -> WarningRule(
                type = TYPE_STEPS,
                isEnabled = true,
                min = 5000f,
                enableDialog = true,
                enableNotification = true,
                enableVibration = false
            )
            TYPE_SLEEP -> WarningRule(
                type = TYPE_SLEEP,
                isEnabled = true,
                min = 6f,
                enableDialog = true,
                enableNotification = true,
                enableVibration = false
            )
            else -> WarningRule(type)
        }
    }
}
