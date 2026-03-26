package com.heytap.health.sdk;

/**
 * 模拟 OPPO Health SDK 的核心入口类 (Stub)
 * 实际项目中请替换为官方 SDK jar/aar
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0003\u001e\u001f B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J&\u0010\u0011\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0004J\u000e\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u0006J\u000e\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\nJ\u0010\u0010\u001c\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0004H\u0002J\u000e\u0010\u001d\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2 = {"Lcom/heytap/health/sdk/HealthAgent;", "", "()V", "activeListener", "Lcom/heytap/health/sdk/HealthAgent$HealthDataListener;", "currentSteps", "", "timer", "Ljava/util/Timer;", "updateInterval", "", "checkAuth", "", "context", "Landroid/content/Context;", "callback", "Lcom/heytap/health/sdk/HealthAgent$AuthCallback;", "init", "appId", "", "appSecret", "Lcom/heytap/health/sdk/HealthAgent$InitCallback;", "registerDataListener", "listener", "setInitialSteps", "steps", "setUpdateInterval", "interval", "startTimer", "unregisterDataListener", "AuthCallback", "HealthDataListener", "InitCallback", "app_debug"})
public final class HealthAgent {
    @org.jetbrains.annotations.Nullable
    private static java.util.Timer timer;
    private static int currentSteps = 0;
    private static long updateInterval = 600000L;
    @org.jetbrains.annotations.Nullable
    private static com.heytap.health.sdk.HealthAgent.HealthDataListener activeListener;
    @org.jetbrains.annotations.NotNull
    public static final com.heytap.health.sdk.HealthAgent INSTANCE = null;
    
    private HealthAgent() {
        super();
    }
    
    public final void setInitialSteps(int steps) {
    }
    
    public final void init(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    java.lang.String appId, @org.jetbrains.annotations.NotNull
    java.lang.String appSecret, @org.jetbrains.annotations.NotNull
    com.heytap.health.sdk.HealthAgent.InitCallback callback) {
    }
    
    public final void checkAuth(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    com.heytap.health.sdk.HealthAgent.AuthCallback callback) {
    }
    
    public final void setUpdateInterval(long interval) {
    }
    
    public final void registerDataListener(@org.jetbrains.annotations.NotNull
    com.heytap.health.sdk.HealthAgent.HealthDataListener listener) {
    }
    
    private final void startTimer(com.heytap.health.sdk.HealthAgent.HealthDataListener listener) {
    }
    
    public final void unregisterDataListener(@org.jetbrains.annotations.NotNull
    com.heytap.health.sdk.HealthAgent.HealthDataListener listener) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&\u00a8\u0006\u0007"}, d2 = {"Lcom/heytap/health/sdk/HealthAgent$AuthCallback;", "", "onAuthFailed", "", "code", "", "onAuthSuccess", "app_debug"})
    public static abstract interface AuthCallback {
        
        public abstract void onAuthSuccess();
        
        public abstract void onAuthFailed(int code);
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0007H&J0\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0007H&J \u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\u0019"}, d2 = {"Lcom/heytap/health/sdk/HealthAgent$HealthDataListener;", "", "onEcgChanged", "", "voltage", "", "timestamp", "", "onHeartRateChanged", "bpm", "", "onRespRateChanged", "rpm", "onSleepChanged", "totalMin", "deepMin", "lightMin", "remMin", "onSpO2Changed", "percent", "onStepsChanged", "steps", "calories", "onWristTempChanged", "celsius", "app_debug"})
    public static abstract interface HealthDataListener {
        
        public abstract void onHeartRateChanged(int bpm, long timestamp);
        
        public abstract void onSpO2Changed(int percent, long timestamp);
        
        public abstract void onStepsChanged(int steps, float calories, long timestamp);
        
        public abstract void onSleepChanged(int totalMin, int deepMin, int lightMin, int remMin, long timestamp);
        
        public abstract void onWristTempChanged(float celsius, long timestamp);
        
        public abstract void onRespRateChanged(int rpm, long timestamp);
        
        public abstract void onEcgChanged(float voltage, long timestamp);
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0003H&\u00a8\u0006\t"}, d2 = {"Lcom/heytap/health/sdk/HealthAgent$InitCallback;", "", "onFailure", "", "code", "", "msg", "", "onSuccess", "app_debug"})
    public static abstract interface InitCallback {
        
        public abstract void onSuccess();
        
        public abstract void onFailure(int code, @org.jetbrains.annotations.NotNull
        java.lang.String msg);
    }
}