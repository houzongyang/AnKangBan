package com.ankangban.health.core.storage

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

enum class ChronicDiseaseType {
    HYPERTENSION, // 高血压
    DIABETES,     // 糖尿病
    HYPERLIPIDEMIA // 高血脂 (Reserved)
}

enum class RiskLevel {
    LOW,
    MEDIUM,
    HIGH
}

@Entity(tableName = "chronic_risk_records")
data class ChronicRiskEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val timestamp: Long,
    val diseaseType: ChronicDiseaseType,
    val riskLevel: RiskLevel,
    val riskScore: Int, // 0-100
    val riskFactorsJson: String // JSON list of strings
)

@Entity(tableName = "chronic_plans")
data class ChronicPlanEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val date: String, // YYYY-MM-DD
    val diseaseType: ChronicDiseaseType,
    val type: PlanType, // MEDICATION, MONITORING, LIFESTYLE
    val title: String,
    val description: String,
    val targetValue: String? = null, // e.g., "140/90"
    var isCompleted: Boolean = false,
    val completedTime: Long? = null,
    val evidenceText: String? = null,
    val evidenceSource: String? = null
)

enum class PlanType {
    MEDICATION,
    MONITORING,
    LIFESTYLE
}

class ChronicTypeConverters {
    @TypeConverter
    fun fromDiseaseType(value: ChronicDiseaseType): String = value.name
    @TypeConverter
    fun toDiseaseType(value: String): ChronicDiseaseType = ChronicDiseaseType.valueOf(value)

    @TypeConverter
    fun fromRiskLevel(value: RiskLevel): String = value.name
    @TypeConverter
    fun toRiskLevel(value: String): RiskLevel = RiskLevel.valueOf(value)

    @TypeConverter
    fun fromPlanType(value: PlanType): String = value.name
    @TypeConverter
    fun toPlanType(value: String): PlanType = PlanType.valueOf(value)
}
