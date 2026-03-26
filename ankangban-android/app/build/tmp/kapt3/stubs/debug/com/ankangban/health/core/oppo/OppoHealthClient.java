package com.ankangban.health.core.oppo;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\bf\u0018\u00002\u00020\u0001J\u0011\u0010\u0019\u001a\u00020\u001aH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH&J\u0010\u0010 \u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\"H&R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\u0006R\u0018\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\u0006R\u0018\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0006R\u0018\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0006R\u0018\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0006R\u0018\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006#"}, d2 = {"Lcom/ankangban/health/core/oppo/OppoHealthClient;", "", "ecgStream", "Lkotlinx/coroutines/flow/Flow;", "Lcom/ankangban/health/core/oppo/EcgSample;", "getEcgStream", "()Lkotlinx/coroutines/flow/Flow;", "heartRateStream", "Lcom/ankangban/health/core/oppo/HeartRate;", "getHeartRateStream", "respRateStream", "Lcom/ankangban/health/core/oppo/RespRate;", "getRespRateStream", "sleepSummaryStream", "Lcom/ankangban/health/core/oppo/SleepSummary;", "getSleepSummaryStream", "spO2Stream", "Lcom/ankangban/health/core/oppo/SpO2;", "getSpO2Stream", "stepsStream", "Lcom/ankangban/health/core/oppo/Steps;", "getStepsStream", "wristTempStream", "Lcom/ankangban/health/core/oppo/WristTemp;", "getWristTempStream", "initialize", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setInitialSteps", "", "steps", "", "setUpdateInterval", "intervalMs", "", "app_debug"})
public abstract interface OppoHealthClient {
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object initialize(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion);
    
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<com.ankangban.health.core.oppo.HeartRate> getHeartRateStream();
    
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<com.ankangban.health.core.oppo.SpO2> getSpO2Stream();
    
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<com.ankangban.health.core.oppo.WristTemp> getWristTempStream();
    
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<com.ankangban.health.core.oppo.Steps> getStepsStream();
    
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<com.ankangban.health.core.oppo.RespRate> getRespRateStream();
    
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<com.ankangban.health.core.oppo.EcgSample> getEcgStream();
    
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<com.ankangban.health.core.oppo.SleepSummary> getSleepSummaryStream();
    
    public abstract void setUpdateInterval(long intervalMs);
    
    public abstract void setInitialSteps(int steps);
}