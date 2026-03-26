package com.ankangban.health.features.chronic.logic

import com.ankangban.health.core.storage.ChronicDiseaseType
import com.ankangban.health.core.storage.ChronicRiskEntity
import com.ankangban.health.core.storage.RiskLevel
import org.json.JSONArray
import java.util.Random

object ChronicDiseaseRiskEvaluator {

    // Simulating inputs for now as we might not have easy access to 7-day aggregation logic yet
    // In a real app, we would query HealthDatabase for last 7 days averages.
    fun evaluate(
        type: ChronicDiseaseType,
        age: Int,
        bmi: Float,
        avgSystolic: Int, // e.g., 120
        avgDiastolic: Int, // e.g., 80
        avgHeartRate: Int,
        avgSteps: Int
    ): ChronicRiskEntity {
        
        val factors = mutableListOf<String>()
        var score = 0 // 0-100, higher is worse

        // Base risk from age/BMI
        if (age > 50) {
            score += 10
            factors.add("年龄超过50岁")
        }
        if (bmi > 24) {
            score += 15
            factors.add("BMI超标 (${String.format("%.1f", bmi)})")
        } else if (bmi > 28) {
            score += 25
            factors.add("BMI严重超标 (肥胖)")
        }

        when (type) {
            ChronicDiseaseType.HYPERTENSION -> {
                // Hypertension Logic
                if (avgSystolic > 140 || avgDiastolic > 90) {
                    score += 40
                    factors.add("平均血压偏高 (${avgSystolic}/${avgDiastolic})")
                } else if (avgSystolic > 130 || avgDiastolic > 85) {
                    score += 20
                    factors.add("血压临界值")
                }

                if (avgHeartRate > 80) {
                    score += 15
                    factors.add("静息心率偏高 ($avgHeartRate)")
                }

                if (avgSteps < 5000) {
                    score += 10
                    factors.add("日常运动量不足")
                }
            }
            ChronicDiseaseType.DIABETES -> {
                // Diabetes Logic (Simulated since we might not have blood sugar data)
                // Use Steps and BMI as proxies + Random Sugar for demo
                val randomSugar = 5.0 + Random().nextDouble() * 3.0 // 5.0 - 8.0
                
                if (randomSugar > 7.0) {
                    score += 40
                    factors.add("随机血糖偏高 (${String.format("%.1f", randomSugar)})")
                }
                
                if (avgSteps < 4000) {
                    score += 15
                    factors.add("运动严重不足")
                }
            }
            else -> {}
        }

        // Determine Level
        val level = when {
            score >= 60 -> RiskLevel.HIGH
            score >= 30 -> RiskLevel.MEDIUM
            else -> RiskLevel.LOW
        }

        // Convert factors to JSON
        val factorsJson = JSONArray(factors).toString()

        return ChronicRiskEntity(
            timestamp = System.currentTimeMillis(),
            diseaseType = type,
            riskLevel = level,
            riskScore = score,
            riskFactorsJson = factorsJson
        )
    }
}
