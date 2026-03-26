package com.ankangban.health.features.sleep.logic;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0005H\u00c6\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u00c6\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0005H\u00c6\u0003JQ\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010 \u001a\u00020\u0005H\u00d6\u0001J\t\u0010!\u001a\u00020\bH\u00d6\u0001R\u0011\u0010\u000b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\n\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000e\u00a8\u0006\""}, d2 = {"Lcom/ankangban/health/features/sleep/logic/SleepQualityResult;", "", "level", "Lcom/ankangban/health/features/sleep/logic/SleepQualityLevel;", "score", "", "reasons", "", "", "improvements", "latencyMinutes", "awakeCount", "(Lcom/ankangban/health/features/sleep/logic/SleepQualityLevel;ILjava/util/List;Ljava/util/List;II)V", "getAwakeCount", "()I", "getImprovements", "()Ljava/util/List;", "getLatencyMinutes", "getLevel", "()Lcom/ankangban/health/features/sleep/logic/SleepQualityLevel;", "getReasons", "getScore", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "app_debug"})
public final class SleepQualityResult {
    @org.jetbrains.annotations.NotNull
    private final com.ankangban.health.features.sleep.logic.SleepQualityLevel level = null;
    private final int score = 0;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<java.lang.String> reasons = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<java.lang.String> improvements = null;
    private final int latencyMinutes = 0;
    private final int awakeCount = 0;
    
    public SleepQualityResult(@org.jetbrains.annotations.NotNull
    com.ankangban.health.features.sleep.logic.SleepQualityLevel level, int score, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> reasons, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> improvements, int latencyMinutes, int awakeCount) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.ankangban.health.features.sleep.logic.SleepQualityLevel getLevel() {
        return null;
    }
    
    public final int getScore() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.String> getReasons() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.String> getImprovements() {
        return null;
    }
    
    public final int getLatencyMinutes() {
        return 0;
    }
    
    public final int getAwakeCount() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.ankangban.health.features.sleep.logic.SleepQualityLevel component1() {
        return null;
    }
    
    public final int component2() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.String> component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.String> component4() {
        return null;
    }
    
    public final int component5() {
        return 0;
    }
    
    public final int component6() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.ankangban.health.features.sleep.logic.SleepQualityResult copy(@org.jetbrains.annotations.NotNull
    com.ankangban.health.features.sleep.logic.SleepQualityLevel level, int score, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> reasons, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> improvements, int latencyMinutes, int awakeCount) {
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