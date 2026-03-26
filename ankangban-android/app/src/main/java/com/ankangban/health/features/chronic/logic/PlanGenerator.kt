package com.ankangban.health.features.chronic.logic

import com.ankangban.health.core.storage.ChronicDiseaseType
import com.ankangban.health.core.storage.ChronicPlanEntity
import com.ankangban.health.core.storage.PlanType
import com.ankangban.health.core.storage.RiskLevel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object PlanGenerator {

    fun generateDailyPlans(
        type: ChronicDiseaseType,
        riskLevel: RiskLevel,
        date: String = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())
    ): List<ChronicPlanEntity> {
        val plans = mutableListOf<ChronicPlanEntity>()
        
        when (type) {
            ChronicDiseaseType.HYPERTENSION -> {
                // 1. Medication (If High/Medium Risk or just demo)
                // For demo, we always add a medication if risk is not low, or just assume user has prescriptions
                if (riskLevel != RiskLevel.LOW) {
                    plans.add(ChronicPlanEntity(
                        date = date,
                        diseaseType = type,
                        type = PlanType.MEDICATION,
                        title = "今日用药",
                        description = "氨氯地平片（1片/次，每日1次）",
                        targetValue = "1片"
                    ))
                }

                // 2. Monitoring
                plans.add(ChronicPlanEntity(
                    date = date,
                    diseaseType = type,
                    type = PlanType.MONITORING,
                    title = "血压监测",
                    description = "建议早晚各测量一次血压",
                    targetValue = "2次"
                ))

                // 3. Lifestyle
                plans.add(ChronicPlanEntity(
                    date = date,
                    diseaseType = type,
                    type = PlanType.LIFESTYLE,
                    title = "低盐饮食",
                    description = "每日食盐摄入不超过5g，避免腌制食品"
                ))
                
                if (riskLevel == RiskLevel.HIGH) {
                     plans.add(ChronicPlanEntity(
                        date = date,
                        diseaseType = type,
                        type = PlanType.LIFESTYLE,
                        title = "控制心率",
                        description = "避免剧烈运动，保持静息心率稳定"
                    ))
                }
            }
            ChronicDiseaseType.DIABETES -> {
                 plans.add(ChronicPlanEntity(
                    date = date,
                    diseaseType = type,
                    type = PlanType.MONITORING,
                    title = "血糖监测",
                    description = "空腹血糖及餐后2小时血糖",
                    targetValue = "2次"
                ))
                
                 plans.add(ChronicPlanEntity(
                    date = date,
                    diseaseType = type,
                    type = PlanType.LIFESTYLE,
                    title = "膳食纤维",
                    description = "多吃蔬菜粗粮，增加饱腹感"
                ))
            }
            else -> {}
        }
        
        return plans
    }
}
