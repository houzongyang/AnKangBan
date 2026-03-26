package com.ankangban.health.core.storage;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\u000eH&J\b\u0010\u000f\u001a\u00020\u0010H&J\b\u0010\u0011\u001a\u00020\u0012H&\u00a8\u0006\u0014"}, d2 = {"Lcom/ankangban/health/core/storage/HealthDatabase;", "Landroidx/room/RoomDatabase;", "()V", "aiContentDao", "Lcom/ankangban/health/core/storage/AiContentDao;", "chronicDao", "Lcom/ankangban/health/core/storage/ChronicDao;", "healthDataDao", "Lcom/ankangban/health/core/storage/HealthDataDao;", "medicationDao", "Lcom/ankangban/health/core/storage/dao/MedicationDao;", "sleepCheckInDao", "Lcom/ankangban/health/core/storage/SleepCheckInDao;", "sleepDao", "Lcom/ankangban/health/core/storage/SleepDao;", "sleepPlanDao", "Lcom/ankangban/health/core/storage/SleepPlanDao;", "stepsDao", "Lcom/ankangban/health/core/storage/StepsDao;", "Companion", "app_debug"})
@androidx.room.Database(entities = {com.ankangban.health.core.storage.StepsEntity.class, com.ankangban.health.core.storage.HealthDataEntity.class, com.ankangban.health.core.storage.SleepDataEntity.class, com.ankangban.health.core.storage.ChronicRiskEntity.class, com.ankangban.health.core.storage.ChronicPlanEntity.class, com.ankangban.health.core.storage.SleepPlanEntity.class, com.ankangban.health.core.storage.SleepCheckInEntity.class, com.ankangban.health.core.storage.AiContentEntity.class, com.ankangban.health.core.storage.entity.MedicationEntity.class, com.ankangban.health.core.storage.entity.ReminderEntity.class}, version = 8, exportSchema = false)
@androidx.room.TypeConverters(value = {com.ankangban.health.core.storage.ChronicTypeConverters.class, com.ankangban.health.core.storage.SleepTypeConverters.class})
public abstract class HealthDatabase extends androidx.room.RoomDatabase {
    @kotlin.jvm.Volatile
    @org.jetbrains.annotations.Nullable
    private static volatile com.ankangban.health.core.storage.HealthDatabase INSTANCE;
    @org.jetbrains.annotations.NotNull
    public static final com.ankangban.health.core.storage.HealthDatabase.Companion Companion = null;
    
    public HealthDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public abstract com.ankangban.health.core.storage.StepsDao stepsDao();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.ankangban.health.core.storage.HealthDataDao healthDataDao();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.ankangban.health.core.storage.SleepDao sleepDao();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.ankangban.health.core.storage.ChronicDao chronicDao();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.ankangban.health.core.storage.SleepPlanDao sleepPlanDao();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.ankangban.health.core.storage.SleepCheckInDao sleepCheckInDao();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.ankangban.health.core.storage.AiContentDao aiContentDao();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.ankangban.health.core.storage.dao.MedicationDao medicationDao();
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/ankangban/health/core/storage/HealthDatabase$Companion;", "", "()V", "INSTANCE", "Lcom/ankangban/health/core/storage/HealthDatabase;", "get", "context", "Landroid/content/Context;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.ankangban.health.core.storage.HealthDatabase get(@org.jetbrains.annotations.NotNull
        android.content.Context context) {
            return null;
        }
    }
}