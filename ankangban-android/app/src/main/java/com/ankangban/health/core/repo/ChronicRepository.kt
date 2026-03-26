package com.ankangban.health.core.repo

import com.ankangban.health.core.storage.*
import kotlinx.coroutines.flow.Flow

class ChronicRepository(private val db: HealthDatabase) {
    private val dao = db.chronicDao()

    fun getLatestRisk(type: ChronicDiseaseType): Flow<ChronicRiskEntity?> = dao.getLatestRisk(type)

    suspend fun saveRiskRecord(record: ChronicRiskEntity) {
        dao.insertRiskRecord(record)
    }
    
    suspend fun getRiskHistory(type: ChronicDiseaseType): List<ChronicRiskEntity> {
        return dao.getRiskHistory(type)
    }

    fun getDailyPlansFlow(date: String, type: ChronicDiseaseType): Flow<List<ChronicPlanEntity>> = dao.getPlansFlow(date, type)

    suspend fun getDailyPlans(date: String, type: ChronicDiseaseType): List<ChronicPlanEntity> = dao.getPlans(date, type)

    suspend fun savePlans(plans: List<ChronicPlanEntity>) {
        dao.insertPlans(plans)
    }

    suspend fun updatePlan(plan: ChronicPlanEntity) {
        dao.updatePlan(plan)
    }
    
    suspend fun clearPlans(date: String, type: ChronicDiseaseType) {
        dao.clearPlans(date, type)
    }
}
