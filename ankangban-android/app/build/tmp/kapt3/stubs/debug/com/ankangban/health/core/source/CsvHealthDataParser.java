package com.ankangban.health.core.source;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0007B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\b"}, d2 = {"Lcom/ankangban/health/core/source/CsvHealthDataParser;", "", "()V", "parse", "Lcom/ankangban/health/core/source/CsvHealthDataParser$ParsedHealthData;", "inputStream", "Ljava/io/InputStream;", "ParsedHealthData", "app_debug"})
public final class CsvHealthDataParser {
    @org.jetbrains.annotations.NotNull
    public static final com.ankangban.health.core.source.CsvHealthDataParser INSTANCE = null;
    
    private CsvHealthDataParser() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.ankangban.health.core.source.CsvHealthDataParser.ParsedHealthData parse(@org.jetbrains.annotations.NotNull
    java.io.InputStream inputStream) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003\u00a2\u0006\u0002\u0010\tJ\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003H\u00c6\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u0003H\u00c6\u0003J9\u0010\u0011\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003H\u00c6\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0015\u001a\u00020\u0016H\u00d6\u0001J\t\u0010\u0017\u001a\u00020\u0018H\u00d6\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b\u00a8\u0006\u0019"}, d2 = {"Lcom/ankangban/health/core/source/CsvHealthDataParser$ParsedHealthData;", "", "healthData", "", "Lcom/ankangban/health/core/storage/HealthDataEntity;", "stepsData", "Lcom/ankangban/health/core/storage/StepsEntity;", "sleepData", "Lcom/ankangban/health/core/storage/SleepDataEntity;", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getHealthData", "()Ljava/util/List;", "getSleepData", "getStepsData", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_debug"})
    public static final class ParsedHealthData {
        @org.jetbrains.annotations.NotNull
        private final java.util.List<com.ankangban.health.core.storage.HealthDataEntity> healthData = null;
        @org.jetbrains.annotations.NotNull
        private final java.util.List<com.ankangban.health.core.storage.StepsEntity> stepsData = null;
        @org.jetbrains.annotations.NotNull
        private final java.util.List<com.ankangban.health.core.storage.SleepDataEntity> sleepData = null;
        
        public ParsedHealthData(@org.jetbrains.annotations.NotNull
        java.util.List<com.ankangban.health.core.storage.HealthDataEntity> healthData, @org.jetbrains.annotations.NotNull
        java.util.List<com.ankangban.health.core.storage.StepsEntity> stepsData, @org.jetbrains.annotations.NotNull
        java.util.List<com.ankangban.health.core.storage.SleepDataEntity> sleepData) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.util.List<com.ankangban.health.core.storage.HealthDataEntity> getHealthData() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.util.List<com.ankangban.health.core.storage.StepsEntity> getStepsData() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.util.List<com.ankangban.health.core.storage.SleepDataEntity> getSleepData() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.util.List<com.ankangban.health.core.storage.HealthDataEntity> component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.util.List<com.ankangban.health.core.storage.StepsEntity> component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.util.List<com.ankangban.health.core.storage.SleepDataEntity> component3() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.ankangban.health.core.source.CsvHealthDataParser.ParsedHealthData copy(@org.jetbrains.annotations.NotNull
        java.util.List<com.ankangban.health.core.storage.HealthDataEntity> healthData, @org.jetbrains.annotations.NotNull
        java.util.List<com.ankangban.health.core.storage.StepsEntity> stepsData, @org.jetbrains.annotations.NotNull
        java.util.List<com.ankangban.health.core.storage.SleepDataEntity> sleepData) {
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