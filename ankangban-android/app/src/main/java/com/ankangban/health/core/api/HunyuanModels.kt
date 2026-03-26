package com.ankangban.health.core.api

data class SleepPlanResponse(
    val generateReason: String,
    val plans: List<PlanDimension>,
    val corePoint: String
)

data class PlanDimension(
    val dimension: String,
    val steps: List<PlanStep>,
    val finishCount: Int = 0,
    val totalCount: Int
)

data class PlanStep(
    val content: String,
    val duration: String,
    val iconType: String
)

data class TrendAnalysisResponse(
    val summary: String,
    val abnormalities: List<String>,
    val suggestions: List<String>
)

data class HealthReportResponse(
    val score: Int,
    val summary: String,
    val heartRateAnalysis: String,
    val bloodGlucoseAnalysis: String,
    val sleepAnalysis: String,
    val suggestions: List<String>
)

data class SleepAidContentResponse(
    val title: String,
    val content: String,
    val durationMinutes: Int,
    val suggestedBgMusic: String
)

data class MedicationParseResponse(
    val name: String,
    val dosage: String,
    val frequency: String,
    val totalStock: Int,
    val unit: String
)
