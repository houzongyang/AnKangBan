package com.ankangban.health.features.chronic.logic;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J>\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\b\u00a8\u0006\u000f"}, d2 = {"Lcom/ankangban/health/features/chronic/logic/ChronicDiseaseRiskEvaluator;", "", "()V", "evaluate", "Lcom/ankangban/health/core/storage/ChronicRiskEntity;", "type", "Lcom/ankangban/health/core/storage/ChronicDiseaseType;", "age", "", "bmi", "", "avgSystolic", "avgDiastolic", "avgHeartRate", "avgSteps", "app_debug"})
public final class ChronicDiseaseRiskEvaluator {
    @org.jetbrains.annotations.NotNull
    public static final com.ankangban.health.features.chronic.logic.ChronicDiseaseRiskEvaluator INSTANCE = null;
    
    private ChronicDiseaseRiskEvaluator() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.ankangban.health.core.storage.ChronicRiskEntity evaluate(@org.jetbrains.annotations.NotNull
    com.ankangban.health.core.storage.ChronicDiseaseType type, int age, float bmi, int avgSystolic, int avgDiastolic, int avgHeartRate, int avgSteps) {
        return null;
    }
}