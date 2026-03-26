package com.ankangban.health.core.storage

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface StepsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(data: StepsEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(data: List<StepsEntity>)

    @Query("SELECT COUNT(*) FROM steps")
    suspend fun getCount(): Int

    @Query("SELECT * FROM steps WHERE timestamp BETWEEN :start AND :end ORDER BY timestamp ASC")
    fun queryRange(start: Long, end: Long): Flow<List<StepsEntity>>

    @Query("SELECT * FROM steps ORDER BY timestamp DESC LIMIT 1")
    suspend fun getLatest(): StepsEntity?

    @Query("SELECT * FROM steps ORDER BY timestamp DESC LIMIT 1")
    fun observeLatest(): Flow<List<StepsEntity>>

    @Query("DELETE FROM steps")
    suspend fun deleteAll()
}

