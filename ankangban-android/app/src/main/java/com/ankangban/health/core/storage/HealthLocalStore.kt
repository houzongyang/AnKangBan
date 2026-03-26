package com.ankangban.health.core.storage

import android.content.Context
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class HealthLocalStore(context: Context) {
    private val db = HealthDatabase.get(context)
    private val stepsDao = db.stepsDao()
    private val healthDao = db.healthDataDao()
    private val sleepDao = db.sleepDao()

    suspend fun saveSteps(timestamp: Long, count: Int, calories: Float) {
        withContext(Dispatchers.IO) {
            stepsDao.insert(StepsEntity(timestamp = timestamp, count = count, calories = calories))
        }
    }

    suspend fun saveStepsList(list: List<StepsEntity>) {
        withContext(Dispatchers.IO) {
            stepsDao.insertAll(list)
        }
    }

    suspend fun getStepsCount(): Int {
        return withContext(Dispatchers.IO) {
            stepsDao.getCount()
        }
    }

    suspend fun getLastSteps(): Int {
        return withContext(Dispatchers.IO) {
            stepsDao.getLatest()?.count ?: 0
        }
    }

    suspend fun getLastStepsEntity(): StepsEntity? {
        return withContext(Dispatchers.IO) {
            stepsDao.getLatest()
        }
    }

    suspend fun saveMetric(type: String, value: Float, timestamp: Long) {
        withContext(Dispatchers.IO) {
            healthDao.insert(HealthDataEntity(type = type, value = value, timestamp = timestamp))
        }
    }

    suspend fun saveMetrics(list: List<HealthDataEntity>) {
        withContext(Dispatchers.IO) {
            healthDao.insertAll(list)
        }
    }

    suspend fun getHealthDataCount(): Int {
        return withContext(Dispatchers.IO) {
            healthDao.getCount()
        }
    }

    suspend fun saveSleep(data: com.ankangban.health.core.oppo.SleepSummary) {
        withContext(Dispatchers.IO) {
            sleepDao.insert(
                SleepDataEntity(
                    totalMinutes = data.totalMinutes,
                    deepMinutes = data.deepMinutes,
                    lightMinutes = data.lightMinutes,
                    remMinutes = data.remMinutes,
                    efficiency = data.efficiency,
                    startTime = data.startTimestamp,
                    endTime = data.endTimestamp
                )
            )
        }
    }

    suspend fun saveSleepList(list: List<SleepDataEntity>) {
        withContext(Dispatchers.IO) {
            sleepDao.insertAll(list)
        }
    }

    fun getMetricHistory(type: String, start: Long, end: Long) = healthDao.getHistory(type, start, end)
    fun getStepsHistory(start: Long, end: Long) = stepsDao.queryRange(start, end)
    fun getSleepHistory(start: Long, end: Long) = sleepDao.getHistory(start, end)

    // Real-time flows backed by DB
    fun getLatestStepsFlow() = stepsDao.observeLatest()
    fun getLatestMetricFlow(type: String) = healthDao.getLatest(type)
    fun getLatestSleepFlow() = sleepDao.getLatest()

    suspend fun clearAll() {
        withContext(Dispatchers.IO) {
            healthDao.deleteAll()
            stepsDao.deleteAll()
            sleepDao.deleteAll()
        }
    }
}

