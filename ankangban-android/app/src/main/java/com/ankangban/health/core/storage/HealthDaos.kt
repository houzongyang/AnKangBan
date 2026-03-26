package com.ankangban.health.core.storage

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface HealthDataDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(data: HealthDataEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(data: List<HealthDataEntity>)

    @Query("SELECT COUNT(*) FROM health_data")
    suspend fun getCount(): Int

    @Query("SELECT * FROM health_data WHERE type = :type ORDER BY timestamp DESC LIMIT 1")
    fun getLatest(type: String): Flow<HealthDataEntity?>

    @Query("SELECT * FROM health_data WHERE type = :type AND timestamp BETWEEN :start AND :end")
    fun getHistory(type: String, start: Long, end: Long): Flow<List<HealthDataEntity>>

    @Query("DELETE FROM health_data")
    suspend fun deleteAll()
}

@Dao
interface SleepDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(data: SleepDataEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(data: List<SleepDataEntity>)

    @Query("SELECT * FROM sleep_data ORDER BY endTime DESC LIMIT 1")
    fun getLatest(): Flow<SleepDataEntity?>

    @Query("SELECT * FROM sleep_data WHERE startTime >= :start AND endTime <= :end ORDER BY startTime ASC")
    fun getHistory(start: Long, end: Long): Flow<List<SleepDataEntity>>

    @Query("DELETE FROM sleep_data")
    suspend fun deleteAll()
}
