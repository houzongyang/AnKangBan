package com.ankangban.health.core.storage

import android.content.Context
import android.content.SharedPreferences

class TokenManager(context: Context) {
    private val prefs: SharedPreferences = context.getSharedPreferences("auth_prefs", Context.MODE_PRIVATE)

    fun saveToken(token: String) {
        prefs.edit().putString("jwt_token", token).apply()
    }

    fun getToken(): String? {
        return prefs.getString("jwt_token", null)
    }

    fun clearToken() {
        prefs.edit().remove("jwt_token").apply()
    }
    
    fun saveUserId(userId: Int) {
        prefs.edit().putInt("user_id", userId).apply()
    }
    
    fun getUserId(): Int {
        return prefs.getInt("user_id", -1)
    }

    fun savePhone(phone: String) {
        prefs.edit().putString("last_phone", phone).apply()
    }

    fun getPhone(): String? {
        return prefs.getString("last_phone", "")
    }
}
