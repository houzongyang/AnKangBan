package com.ankangban.health.core.repo;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J!\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\'\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\"\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u00122\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u00122\u0006\u0010\u000b\u001a\u00020\fJ\u001f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u000f2\u0006\u0010\u000b\u001a\u00020\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016J\u001f\u0010\u0017\u001a\u00020\b2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0019J\u0019\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u0014H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001cJ\u0019\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u0010H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006 "}, d2 = {"Lcom/ankangban/health/core/repo/ChronicRepository;", "", "db", "Lcom/ankangban/health/core/storage/HealthDatabase;", "(Lcom/ankangban/health/core/storage/HealthDatabase;)V", "dao", "Lcom/ankangban/health/core/storage/ChronicDao;", "clearPlans", "", "date", "", "type", "Lcom/ankangban/health/core/storage/ChronicDiseaseType;", "(Ljava/lang/String;Lcom/ankangban/health/core/storage/ChronicDiseaseType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDailyPlans", "", "Lcom/ankangban/health/core/storage/ChronicPlanEntity;", "getDailyPlansFlow", "Lkotlinx/coroutines/flow/Flow;", "getLatestRisk", "Lcom/ankangban/health/core/storage/ChronicRiskEntity;", "getRiskHistory", "(Lcom/ankangban/health/core/storage/ChronicDiseaseType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "savePlans", "plans", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveRiskRecord", "record", "(Lcom/ankangban/health/core/storage/ChronicRiskEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updatePlan", "plan", "(Lcom/ankangban/health/core/storage/ChronicPlanEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class ChronicRepository {
    @org.jetbrains.annotations.NotNull
    private final com.ankangban.health.core.storage.HealthDatabase db = null;
    @org.jetbrains.annotations.NotNull
    private final com.ankangban.health.core.storage.ChronicDao dao = null;
    
    public ChronicRepository(@org.jetbrains.annotations.NotNull
    com.ankangban.health.core.storage.HealthDatabase db) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<com.ankangban.health.core.storage.ChronicRiskEntity> getLatestRisk(@org.jetbrains.annotations.NotNull
    com.ankangban.health.core.storage.ChronicDiseaseType type) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object saveRiskRecord(@org.jetbrains.annotations.NotNull
    com.ankangban.health.core.storage.ChronicRiskEntity record, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getRiskHistory(@org.jetbrains.annotations.NotNull
    com.ankangban.health.core.storage.ChronicDiseaseType type, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.ankangban.health.core.storage.ChronicRiskEntity>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.ankangban.health.core.storage.ChronicPlanEntity>> getDailyPlansFlow(@org.jetbrains.annotations.NotNull
    java.lang.String date, @org.jetbrains.annotations.NotNull
    com.ankangban.health.core.storage.ChronicDiseaseType type) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getDailyPlans(@org.jetbrains.annotations.NotNull
    java.lang.String date, @org.jetbrains.annotations.NotNull
    com.ankangban.health.core.storage.ChronicDiseaseType type, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.ankangban.health.core.storage.ChronicPlanEntity>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object savePlans(@org.jetbrains.annotations.NotNull
    java.util.List<com.ankangban.health.core.storage.ChronicPlanEntity> plans, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object updatePlan(@org.jetbrains.annotations.NotNull
    com.ankangban.health.core.storage.ChronicPlanEntity plan, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object clearPlans(@org.jetbrains.annotations.NotNull
    java.lang.String date, @org.jetbrains.annotations.NotNull
    com.ankangban.health.core.storage.ChronicDiseaseType type, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}