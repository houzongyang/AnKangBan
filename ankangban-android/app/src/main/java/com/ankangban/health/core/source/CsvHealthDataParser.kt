package com.ankangban.health.core.source

import com.ankangban.health.core.storage.HealthDataEntity
import com.ankangban.health.core.storage.SleepDataEntity
import com.ankangban.health.core.storage.StepsEntity
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.text.SimpleDateFormat
import java.util.Locale

object CsvHealthDataParser {

    data class ParsedHealthData(
        val healthData: List<HealthDataEntity>,
        val stepsData: List<StepsEntity>,
        val sleepData: List<SleepDataEntity>
    )

    fun parse(inputStream: InputStream): ParsedHealthData {
        val healthList = mutableListOf<HealthDataEntity>()
        val stepsList = mutableListOf<StepsEntity>()
        val sleepList = mutableListOf<SleepDataEntity>()
        
        val reader = BufferedReader(InputStreamReader(inputStream))
        // Skip header
        reader.readLine() 
        
        var line: String? = reader.readLine()
        val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault())

        while (line != null) {
            try {
                // Expected format: timestamp,heart_rate,spo2,steps,sleep_minutes
                val tokens = line.split(",")
                if (tokens.size >= 5) {
                    val dateStr = tokens[0].trim()
                    val timestamp = dateFormat.parse(dateStr)?.time ?: System.currentTimeMillis()
                    
                    val hr = tokens[1].trim().toDoubleOrNull()
                    val spo2 = tokens[2].trim().toDoubleOrNull()
                    val steps = tokens[3].trim().toIntOrNull()
                    val sleep = tokens[4].trim().toIntOrNull()

                    if (hr != null) {
                        healthList.add(HealthDataEntity(timestamp = timestamp, type = "HEART_RATE", value = hr.toFloat()))
                    }
                    if (spo2 != null) {
                        healthList.add(HealthDataEntity(timestamp = timestamp, type = "SPO2", value = spo2.toFloat()))
                    }
                    if (steps != null) {
                        stepsList.add(StepsEntity(timestamp = timestamp, count = steps, calories = steps * 0.04f))
                    }
                    if (sleep != null && sleep > 0) {
                        // Assuming sleep efficiency is random/mocked for CSV
                        // Mock deep/light/rem breakdown: 20% deep, 60% light, 20% REM
                        val deep = (sleep * 0.2).toInt()
                        val rem = (sleep * 0.2).toInt()
                        val light = sleep - deep - rem
                        
                        sleepList.add(SleepDataEntity(
                            totalMinutes = sleep,
                            deepMinutes = deep,
                            lightMinutes = light,
                            remMinutes = rem,
                            efficiency = 0.85f,
                            startTime = timestamp,
                            endTime = timestamp + sleep * 60 * 1000L
                        ))
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
            line = reader.readLine()
        }
        
        return ParsedHealthData(healthList, stepsList, sleepList)
    }
}
