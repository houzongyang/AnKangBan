package com.ankangban.health.core.storage

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface AiContentDao {
    @Query("SELECT * FROM ai_content ORDER BY createdAt DESC")
    fun getAll(): Flow<List<AiContentEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(content: AiContentEntity)

    @Delete
    suspend fun delete(content: AiContentEntity)
    
    @Query("DELETE FROM ai_content")
    suspend fun clearAll()
}