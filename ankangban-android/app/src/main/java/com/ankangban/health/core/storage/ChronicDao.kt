package com.ankangban.health.core.storage

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface ChronicDao {
    // Risk Records
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRiskRecord(record: ChronicRiskEntity)

    @Query("SELECT * FROM chronic_risk_records WHERE diseaseType = :type ORDER BY timestamp DESC LIMIT 1")
    fun getLatestRisk(type: ChronicDiseaseType): Flow<ChronicRiskEntity?>

    @Query("SELECT * FROM chronic_risk_records WHERE diseaseType = :type ORDER BY timestamp DESC LIMIT 30")
    suspend fun getRiskHistory(type: ChronicDiseaseType): List<ChronicRiskEntity>

    // Plans
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPlans(plans: List<ChronicPlanEntity>)

    @Query("SELECT * FROM chronic_plans WHERE date = :date AND diseaseType = :type")
    fun getPlansFlow(date: String, type: ChronicDiseaseType): Flow<List<ChronicPlanEntity>>
    
    @Query("SELECT * FROM chronic_plans WHERE date = :date AND diseaseType = :type")
    suspend fun getPlans(date: String, type: ChronicDiseaseType): List<ChronicPlanEntity>

    @Update
    suspend fun updatePlan(plan: ChronicPlanEntity)
    
    @Query("DELETE FROM chronic_plans WHERE date = :date AND diseaseType = :type")
    suspend fun clearPlans(date: String, type: ChronicDiseaseType)
}
