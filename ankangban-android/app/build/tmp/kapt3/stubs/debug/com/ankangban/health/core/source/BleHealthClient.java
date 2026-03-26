package com.ankangban.health.core.source;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0011\u0010\u001e\u001a\u00020\u001fH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010 J\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020\"2\u0006\u0010&\u001a\u00020\'H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\bX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\bX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000bR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\bX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000bR\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\bX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000bR\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\bX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u000bR\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\bX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006("}, d2 = {"Lcom/ankangban/health/core/source/BleHealthClient;", "Lcom/ankangban/health/core/oppo/OppoHealthClient;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "bleHelper", "Lcom/ankangban/health/core/source/BleHelper;", "ecgStream", "Lkotlinx/coroutines/flow/Flow;", "Lcom/ankangban/health/core/oppo/EcgSample;", "getEcgStream", "()Lkotlinx/coroutines/flow/Flow;", "heartRateStream", "Lcom/ankangban/health/core/oppo/HeartRate;", "getHeartRateStream", "respRateStream", "Lcom/ankangban/health/core/oppo/RespRate;", "getRespRateStream", "sleepSummaryStream", "Lcom/ankangban/health/core/oppo/SleepSummary;", "getSleepSummaryStream", "spO2Stream", "Lcom/ankangban/health/core/oppo/SpO2;", "getSpO2Stream", "stepsStream", "Lcom/ankangban/health/core/oppo/Steps;", "getStepsStream", "wristTempStream", "Lcom/ankangban/health/core/oppo/WristTemp;", "getWristTempStream", "initialize", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setInitialSteps", "", "steps", "", "setUpdateInterval", "intervalMs", "", "app_debug"})
public final class BleHealthClient implements com.ankangban.health.core.oppo.OppoHealthClient {
    @org.jetbrains.annotations.NotNull
    private final com.ankangban.health.core.source.BleHelper bleHelper = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.Flow<com.ankangban.health.core.oppo.HeartRate> heartRateStream = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.Flow<com.ankangban.health.core.oppo.SpO2> spO2Stream = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.Flow<com.ankangban.health.core.oppo.WristTemp> wristTempStream = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.Flow<com.ankangban.health.core.oppo.Steps> stepsStream = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.Flow<com.ankangban.health.core.oppo.RespRate> respRateStream = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.Flow<com.ankangban.health.core.oppo.EcgSample> ecgStream = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.Flow<com.ankangban.health.core.oppo.SleepSummary> sleepSummaryStream = null;
    
    public BleHealthClient(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super();
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object initialize(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public kotlinx.coroutines.flow.Flow<com.ankangban.health.core.oppo.HeartRate> getHeartRateStream() {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public kotlinx.coroutines.flow.Flow<com.ankangban.health.core.oppo.SpO2> getSpO2Stream() {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public kotlinx.coroutines.flow.Flow<com.ankangban.health.core.oppo.WristTemp> getWristTempStream() {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public kotlinx.coroutines.flow.Flow<com.ankangban.health.core.oppo.Steps> getStepsStream() {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public kotlinx.coroutines.flow.Flow<com.ankangban.health.core.oppo.RespRate> getRespRateStream() {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public kotlinx.coroutines.flow.Flow<com.ankangban.health.core.oppo.EcgSample> getEcgStream() {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public kotlinx.coroutines.flow.Flow<com.ankangban.health.core.oppo.SleepSummary> getSleepSummaryStream() {
        return null;
    }
    
    @java.lang.Override
    public void setUpdateInterval(long intervalMs) {
    }
    
    @java.lang.Override
    public void setInitialSteps(int steps) {
    }
}