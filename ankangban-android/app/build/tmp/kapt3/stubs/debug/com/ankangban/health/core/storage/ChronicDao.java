package com.ankangban.health.core.storage;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\bg\u0018\u00002\u00020\u0001J!\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ\u0018\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n2\u0006\u0010\u0006\u001a\u00020\u0007H\'J\'\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ$\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\n2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\'J\u001f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\u0006\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J\u001f\u0010\u0012\u001a\u00020\u00032\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014J\u0019\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u000bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0017J\u0019\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u000eH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001a\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001b"}, d2 = {"Lcom/ankangban/health/core/storage/ChronicDao;", "", "clearPlans", "", "date", "", "type", "Lcom/ankangban/health/core/storage/ChronicDiseaseType;", "(Ljava/lang/String;Lcom/ankangban/health/core/storage/ChronicDiseaseType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLatestRisk", "Lkotlinx/coroutines/flow/Flow;", "Lcom/ankangban/health/core/storage/ChronicRiskEntity;", "getPlans", "", "Lcom/ankangban/health/core/storage/ChronicPlanEntity;", "getPlansFlow", "getRiskHistory", "(Lcom/ankangban/health/core/storage/ChronicDiseaseType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertPlans", "plans", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertRiskRecord", "record", "(Lcom/ankangban/health/core/storage/ChronicRiskEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updatePlan", "plan", "(Lcom/ankangban/health/core/storage/ChronicPlanEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
@androidx.room.Dao
public abstract interface ChronicDao {
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertRiskRecord(@org.jetbrains.annotations.NotNull
    com.ankangban.health.core.storage.ChronicRiskEntity record, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM chronic_risk_records WHERE diseaseType = :type ORDER BY timestamp DESC LIMIT 1")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<com.ankangban.health.core.storage.ChronicRiskEntity> getLatestRisk(@org.jetbrains.annotations.NotNull
    com.ankangban.health.core.storage.ChronicDiseaseType type);
    
    @androidx.room.Query(value = "SELECT * FROM chronic_risk_records WHERE diseaseType = :type ORDER BY timestamp DESC LIMIT 30")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getRiskHistory(@org.jetbrains.annotations.NotNull
    com.ankangban.health.core.storage.ChronicDiseaseType type, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.ankangban.health.core.storage.ChronicRiskEntity>> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertPlans(@org.jetbrains.annotations.NotNull
    java.util.List<com.ankangban.health.core.storage.ChronicPlanEntity> plans, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM chronic_plans WHERE date = :date AND diseaseType = :type")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.ankangban.health.core.storage.ChronicPlanEntity>> getPlansFlow(@org.jetbrains.annotations.NotNull
    java.lang.String date, @org.jetbrains.annotations.NotNull
    com.ankangban.health.core.storage.ChronicDiseaseType type);
    
    @androidx.room.Query(value = "SELECT * FROM chronic_plans WHERE date = :date AND diseaseType = :type")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getPlans(@org.jetbrains.annotations.NotNull
    java.lang.String date, @org.jetbrains.annotations.NotNull
    com.ankangban.health.core.storage.ChronicDiseaseType type, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.ankangban.health.core.storage.ChronicPlanEntity>> $completion);
    
    @androidx.room.Update
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updatePlan(@org.jetbrains.annotations.NotNull
    com.ankangban.health.core.storage.ChronicPlanEntity plan, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM chronic_plans WHERE date = :date AND diseaseType = :type")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object clearPlans(@org.jetbrains.annotations.NotNull
    java.lang.String date, @org.jetbrains.annotations.NotNull
    com.ankangban.health.core.storage.ChronicDiseaseType type, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}