package com.ankangban.health.core.storage

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "health_data")
data class HealthDataEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val type: String, // HEART_RATE, SPO2, TEMP, RESP
    val value: Float,
    val timestamp: Long
)

@Entity(tableName = "sleep_data")
data class SleepDataEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val totalMinutes: Int,
    val deepMinutes: Int,
    val lightMinutes: Int,
    val remMinutes: Int,
    val efficiency: Float,
    val startTime: Long,
    val endTime: Long
)
