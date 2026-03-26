package com.ankangban.health.core.storage

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@Entity(tableName = "sleep_plans")
data class SleepPlanEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val date: String, // yyyy-MM-dd
    val dayIndex: Int, // 1-7
    val title: String,
    val itemsJson: String, // JSON list of instructions
    val isCompleted: Boolean = false
)

@Entity(tableName = "sleep_checkins")
data class SleepCheckInEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val date: String, // yyyy-MM-dd
    val qualityLevel: String, // EXCELLENT, GOOD, FAIR, POOR
    val timestamp: Long
)

class SleepTypeConverters {
    @TypeConverter
    fun fromStringList(value: String): List<String> {
        val listType = object : TypeToken<List<String>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun toStringList(list: List<String>): String {
        return Gson().toJson(list)
    }
}
