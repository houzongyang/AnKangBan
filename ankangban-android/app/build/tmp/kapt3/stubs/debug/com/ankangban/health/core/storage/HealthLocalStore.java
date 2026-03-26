package com.ankangban.health.core.storage;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0011\u0010\r\u001a\u00020\u000eH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ\u0011\u0010\u0010\u001a\u00020\u0011H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ\u0011\u0010\u0012\u001a\u00020\u0011H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ\u0016\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u00162\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0016J\u0012\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u001d0\u0016J*\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u001d0\u00162\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 J\"\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001d0\u00162\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 J\u0011\u0010#\u001a\u00020\u0011H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ\"\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u001d0\u00162\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 J)\u0010%\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010&\u001a\u00020\'2\u0006\u0010(\u001a\u00020 H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010)J\u001f\u0010*\u001a\u00020\u000e2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00170\u001dH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010,J\u0019\u0010-\u001a\u00020\u000e2\u0006\u0010.\u001a\u00020/H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00100J\u001f\u00101\u001a\u00020\u000e2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001dH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010,J)\u00102\u001a\u00020\u000e2\u0006\u0010(\u001a\u00020 2\u0006\u00103\u001a\u00020\u00112\u0006\u00104\u001a\u00020\'H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00105J\u001f\u00106\u001a\u00020\u000e2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00140\u001dH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010,R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00067"}, d2 = {"Lcom/ankangban/health/core/storage/HealthLocalStore;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "db", "Lcom/ankangban/health/core/storage/HealthDatabase;", "healthDao", "Lcom/ankangban/health/core/storage/HealthDataDao;", "sleepDao", "Lcom/ankangban/health/core/storage/SleepDao;", "stepsDao", "Lcom/ankangban/health/core/storage/StepsDao;", "clearAll", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getHealthDataCount", "", "getLastSteps", "getLastStepsEntity", "Lcom/ankangban/health/core/storage/StepsEntity;", "getLatestMetricFlow", "Lkotlinx/coroutines/flow/Flow;", "Lcom/ankangban/health/core/storage/HealthDataEntity;", "type", "", "getLatestSleepFlow", "Lcom/ankangban/health/core/storage/SleepDataEntity;", "getLatestStepsFlow", "", "getMetricHistory", "start", "", "end", "getSleepHistory", "getStepsCount", "getStepsHistory", "saveMetric", "value", "", "timestamp", "(Ljava/lang/String;FJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveMetrics", "list", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveSleep", "data", "Lcom/ankangban/health/core/oppo/SleepSummary;", "(Lcom/ankangban/health/core/oppo/SleepSummary;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveSleepList", "saveSteps", "count", "calories", "(JIFLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveStepsList", "app_debug"})
public final class HealthLocalStore {
    @org.jetbrains.annotations.NotNull
    private final com.ankangban.health.core.storage.HealthDatabase db = null;
    @org.jetbrains.annotations.NotNull
    private final com.ankangban.health.core.storage.StepsDao stepsDao = null;
    @org.jetbrains.annotations.NotNull
    private final com.ankangban.health.core.storage.HealthDataDao healthDao = null;
    @org.jetbrains.annotations.NotNull
    private final com.ankangban.health.core.storage.SleepDao sleepDao = null;
    
    public HealthLocalStore(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object saveSteps(long timestamp, int count, float calories, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object saveStepsList(@org.jetbrains.annotations.NotNull
    java.util.List<com.ankangban.health.core.storage.StepsEntity> list, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getStepsCount(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getLastSteps(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getLastStepsEntity(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.ankangban.health.core.storage.StepsEntity> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object saveMetric(@org.jetbrains.annotations.NotNull
    java.lang.String type, float value, long timestamp, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object saveMetrics(@org.jetbrains.annotations.NotNull
    java.util.List<com.ankangban.health.core.storage.HealthDataEntity> list, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getHealthDataCount(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object saveSleep(@org.jetbrains.annotations.NotNull
    com.ankangban.health.core.oppo.SleepSummary data, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object saveSleepList(@org.jetbrains.annotations.NotNull
    java.util.List<com.ankangban.health.core.storage.SleepDataEntity> list, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.ankangban.health.core.storage.HealthDataEntity>> getMetricHistory(@org.jetbrains.annotations.NotNull
    java.lang.String type, long start, long end) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.ankangban.health.core.storage.StepsEntity>> getStepsHistory(long start, long end) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.ankangban.health.core.storage.SleepDataEntity>> getSleepHistory(long start, long end) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.ankangban.health.core.storage.StepsEntity>> getLatestStepsFlow() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<com.ankangban.health.core.storage.HealthDataEntity> getLatestMetricFlow(@org.jetbrains.annotations.NotNull
    java.lang.String type) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<com.ankangban.health.core.storage.SleepDataEntity> getLatestSleepFlow() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object clearAll(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}