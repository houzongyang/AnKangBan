package com.ankangban.health.core.repo;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u00b4\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\tJ\u0011\u0010\'\u001a\u00020(H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010)J\u0011\u0010*\u001a\u00020(H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010)J\"\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.2\b\b\u0002\u00100\u001a\u00020\u000bH\u0002Ji\u00101\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.2\u0006\u00102\u001a\u00020.2\u0006\u00103\u001a\u00020.2\u0006\u00104\u001a\u00020.2\u0006\u00105\u001a\u00020\u000b2\u0006\u00106\u001a\u00020\u000b2\u0006\u00107\u001a\u00020\u00172\u0006\u00108\u001a\u00020.2\u0006\u0010\u0013\u001a\u00020.2\u0006\u0010$\u001a\u000209H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010:J\u0019\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\u000bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010>J\b\u0010?\u001a\u00020\u0003H\u0002J\u0019\u0010@\u001a\u00020\u000b2\u0006\u0010=\u001a\u00020\u000bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010>J$\u0010A\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020C0B\u0018\u00010\u000f2\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020EJ\u001b\u0010G\u001a\u0004\u0018\u00010C2\u0006\u0010H\u001a\u00020\u000bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010>J$\u0010I\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020C0B\u0018\u00010\u000f2\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020EJ$\u0010J\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020K0B\u0018\u00010\u000f2\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020EJ$\u0010L\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020C0B\u0018\u00010\u000f2\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020EJ$\u0010M\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020N0B\u0018\u00010\u000f2\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020EJ$\u0010O\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020C0B\u0018\u00010\u000f2\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020EJ\u000e\u0010P\u001a\u00020(2\u0006\u0010Q\u001a\u00020\u000bJ\u000e\u0010R\u001a\u00020(2\u0006\u0010S\u001a\u00020EJ\u0011\u0010D\u001a\u00020\u0017H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010)J\b\u0010T\u001a\u00020(H\u0002J\b\u0010U\u001a\u00020(H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0012R\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u0012R\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0012R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0012\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006V"}, d2 = {"Lcom/ankangban/health/core/repo/HealthRepository;", "", "client", "Lcom/ankangban/health/core/oppo/OppoHealthClient;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "store", "Lcom/ankangban/health/core/storage/HealthLocalStore;", "bleClient", "(Lcom/ankangban/health/core/oppo/OppoHealthClient;Lkotlinx/coroutines/CoroutineScope;Lcom/ankangban/health/core/storage/HealthLocalStore;Lcom/ankangban/health/core/oppo/OppoHealthClient;)V", "activeSource", "", "collectionJob", "Lkotlinx/coroutines/Job;", "ecg", "Lkotlinx/coroutines/flow/Flow;", "Lcom/ankangban/health/core/oppo/EcgSample;", "getEcg", "()Lkotlinx/coroutines/flow/Flow;", "heartRate", "Lcom/ankangban/health/core/oppo/HeartRate;", "getHeartRate", "isMonitoring", "", "respRate", "Lcom/ankangban/health/core/oppo/RespRate;", "getRespRate", "sleepSummary", "Lcom/ankangban/health/core/oppo/SleepSummary;", "getSleepSummary", "spO2", "Lcom/ankangban/health/core/oppo/SpO2;", "getSpO2", "steps", "Lcom/ankangban/health/core/oppo/Steps;", "getSteps", "wristTemp", "Lcom/ankangban/health/core/oppo/WristTemp;", "getWristTemp", "checkAndSeedData", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearAllData", "generateLocalFallbackPlan", "Lcom/ankangban/health/core/api/SleepPlanResponse;", "deepSleepRatio", "", "sleepLatency", "reasonPrefix", "generateOneHourPlan", "awakenTimes", "sleepEfficiency", "age", "sleepTime", "wakeTime", "isSedentary", "stepCount", "", "(IIIIILjava/lang/String;Ljava/lang/String;ZIIFLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "generateTrendAnalysis", "Lcom/ankangban/health/core/api/TrendAnalysisResponse;", "period", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getActiveClient", "getHealthReportDataSummary", "getHeartRateHistory", "", "Lcom/ankangban/health/core/storage/HealthDataEntity;", "start", "", "end", "getLatestMetric", "type", "getRespRateHistory", "getSleepHistory", "Lcom/ankangban/health/core/storage/SleepDataEntity;", "getSpO2History", "getStepsHistory", "Lcom/ankangban/health/core/storage/StepsEntity;", "getWristTempHistory", "setDataSource", "sourceType", "setUpdateInterval", "intervalMs", "startCollection", "stopCollection", "app_debug"})
public final class HealthRepository {
    @org.jetbrains.annotations.NotNull
    private final com.ankangban.health.core.oppo.OppoHealthClient client = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.CoroutineScope scope = null;
    @org.jetbrains.annotations.Nullable
    private final com.ankangban.health.core.storage.HealthLocalStore store = null;
    @org.jetbrains.annotations.Nullable
    private final com.ankangban.health.core.oppo.OppoHealthClient bleClient = null;
    private boolean isMonitoring = false;
    @org.jetbrains.annotations.Nullable
    private kotlinx.coroutines.Job collectionJob;
    @org.jetbrains.annotations.NotNull
    private java.lang.String activeSource = "DEVICE_SENSOR";
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.Flow<com.ankangban.health.core.oppo.Steps> steps = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.Flow<com.ankangban.health.core.oppo.HeartRate> heartRate = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.Flow<com.ankangban.health.core.oppo.SpO2> spO2 = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.Flow<com.ankangban.health.core.oppo.WristTemp> wristTemp = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.Flow<com.ankangban.health.core.oppo.RespRate> respRate = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.Flow<com.ankangban.health.core.oppo.SleepSummary> sleepSummary = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.Flow<com.ankangban.health.core.oppo.EcgSample> ecg = null;
    
    public HealthRepository(@org.jetbrains.annotations.NotNull
    com.ankangban.health.core.oppo.OppoHealthClient client, @org.jetbrains.annotations.NotNull
    kotlinx.coroutines.CoroutineScope scope, @org.jetbrains.annotations.Nullable
    com.ankangban.health.core.storage.HealthLocalStore store, @org.jetbrains.annotations.Nullable
    com.ankangban.health.core.oppo.OppoHealthClient bleClient) {
        super();
    }
    
    private final com.ankangban.health.core.oppo.OppoHealthClient getActiveClient() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object start(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    public final void setDataSource(@org.jetbrains.annotations.NotNull
    java.lang.String sourceType) {
    }
    
    private final void startCollection() {
    }
    
    private final void stopCollection() {
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<com.ankangban.health.core.oppo.Steps> getSteps() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<com.ankangban.health.core.oppo.HeartRate> getHeartRate() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<com.ankangban.health.core.oppo.SpO2> getSpO2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<com.ankangban.health.core.oppo.WristTemp> getWristTemp() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<com.ankangban.health.core.oppo.RespRate> getRespRate() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<com.ankangban.health.core.oppo.SleepSummary> getSleepSummary() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<com.ankangban.health.core.oppo.EcgSample> getEcg() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.ankangban.health.core.storage.HealthDataEntity>> getHeartRateHistory(long start, long end) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.ankangban.health.core.storage.HealthDataEntity>> getSpO2History(long start, long end) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.ankangban.health.core.storage.HealthDataEntity>> getWristTempHistory(long start, long end) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.ankangban.health.core.storage.HealthDataEntity>> getRespRateHistory(long start, long end) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.ankangban.health.core.storage.StepsEntity>> getStepsHistory(long start, long end) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.ankangban.health.core.storage.SleepDataEntity>> getSleepHistory(long start, long end) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getLatestMetric(@org.jetbrains.annotations.NotNull
    java.lang.String type, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.ankangban.health.core.storage.HealthDataEntity> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object clearAllData(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    public final void setUpdateInterval(long intervalMs) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object checkAndSeedData(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object generateOneHourPlan(int deepSleepRatio, int sleepLatency, int awakenTimes, int sleepEfficiency, int age, @org.jetbrains.annotations.NotNull
    java.lang.String sleepTime, @org.jetbrains.annotations.NotNull
    java.lang.String wakeTime, boolean isSedentary, int stepCount, int heartRate, float wristTemp, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.ankangban.health.core.api.SleepPlanResponse> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object generateTrendAnalysis(@org.jetbrains.annotations.NotNull
    java.lang.String period, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.ankangban.health.core.api.TrendAnalysisResponse> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getHealthReportDataSummary(@org.jetbrains.annotations.NotNull
    java.lang.String period, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.String> $completion) {
        return null;
    }
    
    private final com.ankangban.health.core.api.SleepPlanResponse generateLocalFallbackPlan(int deepSleepRatio, int sleepLatency, java.lang.String reasonPrefix) {
        return null;
    }
}