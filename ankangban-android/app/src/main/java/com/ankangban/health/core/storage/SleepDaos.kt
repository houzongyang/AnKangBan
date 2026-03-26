package com.ankangban.health.core.storage

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface SleepPlanDao {
    @Query("SELECT * FROM sleep_plans WHERE date = :date")
    suspend fun getPlanByDate(date: String): SleepPlanEntity?

    @Query("SELECT * FROM sleep_plans WHERE date >= :startDate AND date <= :endDate ORDER BY date ASC")
    fun getPlansFlow(startDate: String, endDate: String): Flow<List<SleepPlanEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPlan(plan: SleepPlanEntity)

    @Query("UPDATE sleep_plans SET isCompleted = :completed WHERE id = :id")
    suspend fun updateCompletion(id: Long, completed: Boolean)
    
    @Query("SELECT COUNT(*) FROM sleep_plans WHERE date >= :startDate AND date <= :endDate AND isCompleted = 1")
    suspend fun getCompletedCount(startDate: String, endDate: String): Int
}

@Dao
interface SleepCheckInDao {
    @Query("SELECT * FROM sleep_checkins WHERE date = :date")
    suspend fun getCheckInByDate(date: String): SleepCheckInEntity?

    @Query("SELECT * FROM sleep_checkins WHERE date >= :startDate AND date <= :endDate")
    fun getCheckInsFlow(startDate: String, endDate: String): Flow<List<SleepCheckInEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCheckIn(checkIn: SleepCheckInEntity)
}
