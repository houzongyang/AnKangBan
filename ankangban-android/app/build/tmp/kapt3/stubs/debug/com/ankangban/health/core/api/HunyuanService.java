package com.ankangban.health.core.api;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010!\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001PB\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J \u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0004H\u0002J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J+\u0010\u001d\u001a\u0004\u0018\u0001H\u001e\"\u0004\b\u0000\u0010\u001e2\u0006\u0010\u001f\u001a\u00020\u00042\f\u0010 \u001a\b\u0012\u0004\u0012\u0002H\u001e0!H\u0002\u00a2\u0006\u0002\u0010\"J\u001f\u0010#\u001a\u00020\u00042\f\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u0010H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010&J#\u0010\'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u0004H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010+J1\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010.\u001a\u00020\u00042\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00040\u00102\u0006\u00100\u001a\u00020\u0004H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u00101Jk\u00102\u001a\u0004\u0018\u0001032\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u0002052\u0006\u00107\u001a\u0002052\u0006\u00108\u001a\u0002052\u0006\u00109\u001a\u0002052\u0006\u0010:\u001a\u00020\u00042\u0006\u0010;\u001a\u00020\u00042\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u0002052\u0006\u0010?\u001a\u0002052\u0006\u0010@\u001a\u00020AH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010BJ)\u0010C\u001a\u0004\u0018\u00010D2\f\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00040\u00102\u0006\u0010)\u001a\u00020\u0004H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010FJ\u0018\u0010G\u001a\u00020\u001c2\u0006\u0010H\u001a\u00020\u001c2\u0006\u0010I\u001a\u00020\u0004H\u0002J\u001b\u0010J\u001a\u0004\u0018\u00010K2\u0006\u0010L\u001a\u00020\u0004H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010MJ\u0010\u0010N\u001a\u00020\u00042\u0006\u0010O\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R2\u0010\f\u001a&\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u000e0\u000e \u000f*\u0012\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u000e0\u000e\u0018\u00010\u00100\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006Q"}, d2 = {"Lcom/ankangban/health/core/api/HunyuanService;", "", "()V", "ACTION", "", "HOST", "REGION", "SECRET_ID", "SECRET_KEY", "SERVICE", "TAG", "VERSION", "callTimestamps", "", "", "kotlin.jvm.PlatformType", "", "client", "Lokhttp3/OkHttpClient;", "gson", "Lcom/google/gson/Gson;", "lastContext", "buildAuthorization", "payload", "timestamp", "date", "bytesToHex", "bytes", "", "callApi", "T", "prompt", "clazz", "Ljava/lang/Class;", "(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;", "chatCompletion", "messages", "Lcom/ankangban/health/core/api/HunyuanService$ChatMessage;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "generateHealthReport", "Lcom/ankangban/health/core/api/HealthReportResponse;", "period", "healthDataSummary", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "generateSleepAidContent", "Lcom/ankangban/health/core/api/SleepAidContentResponse;", "type", "tags", "userContext", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "generateSleepPlan", "Lcom/ankangban/health/core/api/SleepPlanResponse;", "deepSleepRatio", "", "sleepLatency", "awakenTimes", "sleepEfficiency", "age", "sleepTime", "wakeTime", "isSedentary", "", "stepCount", "heartRate", "wristTemp", "", "(IIIIILjava/lang/String;Ljava/lang/String;ZIIFLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "generateTrendAnalysis", "Lcom/ankangban/health/core/api/TrendAnalysisResponse;", "sleepData", "(Ljava/util/List;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hmac256", "key", "msg", "parseMedicationInfo", "Lcom/ankangban/health/core/api/MedicationParseResponse;", "ocrText", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sha256Hex", "s", "ChatMessage", "app_debug"})
public final class HunyuanService {
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String TAG = "HunyuanService";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String SECRET_ID = "AKID7DB3pTvNeiaGjz3uZ2HKAnDRVMzObbOx";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String SECRET_KEY = "QdoqfJo9GBtQlsmU1KSM4bv31nNlwteD";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String HOST = "hunyuan.tencentcloudapi.com";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String SERVICE = "hunyuan";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String ACTION = "ChatCompletions";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String VERSION = "2023-09-01";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String REGION = "ap-guangzhou";
    @org.jetbrains.annotations.NotNull
    private static final com.google.gson.Gson gson = null;
    @org.jetbrains.annotations.NotNull
    private static final okhttp3.OkHttpClient client = null;
    @org.jetbrains.annotations.NotNull
    private static java.lang.String lastContext = "";
    private static final java.util.List<java.lang.Long> callTimestamps = null;
    @org.jetbrains.annotations.NotNull
    public static final com.ankangban.health.core.api.HunyuanService INSTANCE = null;
    
    private HunyuanService() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object chatCompletion(@org.jetbrains.annotations.NotNull
    java.util.List<com.ankangban.health.core.api.HunyuanService.ChatMessage> messages, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.String> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object generateTrendAnalysis(@org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> sleepData, @org.jetbrains.annotations.NotNull
    java.lang.String period, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.ankangban.health.core.api.TrendAnalysisResponse> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object generateSleepAidContent(@org.jetbrains.annotations.NotNull
    java.lang.String type, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> tags, @org.jetbrains.annotations.NotNull
    java.lang.String userContext, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.ankangban.health.core.api.SleepAidContentResponse> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object generateHealthReport(@org.jetbrains.annotations.NotNull
    java.lang.String period, @org.jetbrains.annotations.NotNull
    java.lang.String healthDataSummary, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.ankangban.health.core.api.HealthReportResponse> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object parseMedicationInfo(@org.jetbrains.annotations.NotNull
    java.lang.String ocrText, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.ankangban.health.core.api.MedicationParseResponse> $completion) {
        return null;
    }
    
    private final <T extends java.lang.Object>T callApi(java.lang.String prompt, java.lang.Class<T> clazz) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object generateSleepPlan(int deepSleepRatio, int sleepLatency, int awakenTimes, int sleepEfficiency, int age, @org.jetbrains.annotations.NotNull
    java.lang.String sleepTime, @org.jetbrains.annotations.NotNull
    java.lang.String wakeTime, boolean isSedentary, int stepCount, int heartRate, float wristTemp, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.ankangban.health.core.api.SleepPlanResponse> $completion) {
        return null;
    }
    
    private final java.lang.String buildAuthorization(java.lang.String payload, java.lang.String timestamp, java.lang.String date) {
        return null;
    }
    
    private final byte[] hmac256(byte[] key, java.lang.String msg) {
        return null;
    }
    
    private final java.lang.String sha256Hex(java.lang.String s) {
        return null;
    }
    
    private final java.lang.String bytesToHex(byte[] bytes) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\n\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001J\t\u0010\u0011\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\u0012"}, d2 = {"Lcom/ankangban/health/core/api/HunyuanService$ChatMessage;", "", "role", "", "content", "(Ljava/lang/String;Ljava/lang/String;)V", "getContent", "()Ljava/lang/String;", "getRole", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
    public static final class ChatMessage {
        @org.jetbrains.annotations.NotNull
        private final java.lang.String role = null;
        @org.jetbrains.annotations.NotNull
        private final java.lang.String content = null;
        
        public ChatMessage(@org.jetbrains.annotations.NotNull
        java.lang.String role, @org.jetbrains.annotations.NotNull
        java.lang.String content) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getRole() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getContent() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.ankangban.health.core.api.HunyuanService.ChatMessage copy(@org.jetbrains.annotations.NotNull
        java.lang.String role, @org.jetbrains.annotations.NotNull
        java.lang.String content) {
            return null;
        }
        
        @java.lang.Override
        public boolean equals(@org.jetbrains.annotations.Nullable
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public java.lang.String toString() {
            return null;
        }
    }
}