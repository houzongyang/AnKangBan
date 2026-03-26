package com.ankangban.health.core.storage.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\bg\u0018\u00002\u00020\u0001:\u0001\u001cJ\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ\u0014\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\f0\u0010H\'J\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0012\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0012\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u0014\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\f0\u0010H\'J\u001c\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u00102\u0006\u0010\b\u001a\u00020\tH\'J\u0019\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u001f\u0010\u0018\u001a\u00020\u00032\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001aJ\u0019\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/ankangban/health/core/storage/dao/MedicationDao;", "", "deleteMedication", "", "medication", "Lcom/ankangban/health/core/storage/entity/MedicationEntity;", "(Lcom/ankangban/health/core/storage/entity/MedicationEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteRemindersByMedicationId", "medicationId", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllActiveReminders", "", "Lcom/ankangban/health/core/storage/entity/ReminderEntity;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllMedications", "Lkotlinx/coroutines/flow/Flow;", "getMedicationById", "id", "getMedicationWithRemindersById", "Lcom/ankangban/health/core/storage/dao/MedicationDao$MedicationWithReminders;", "getMedicationsWithReminders", "getRemindersForMedication", "insertMedication", "insertReminders", "reminders", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateMedication", "MedicationWithReminders", "app_debug"})
@androidx.room.Dao
public abstract interface MedicationDao {
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertMedication(@org.jetbrains.annotations.NotNull
    com.ankangban.health.core.storage.entity.MedicationEntity medication, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Update
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateMedication(@org.jetbrains.annotations.NotNull
    com.ankangban.health.core.storage.entity.MedicationEntity medication, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteMedication(@org.jetbrains.annotations.NotNull
    com.ankangban.health.core.storage.entity.MedicationEntity medication, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM medications ORDER BY create_time DESC")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.ankangban.health.core.storage.entity.MedicationEntity>> getAllMedications();
    
    @androidx.room.Query(value = "SELECT * FROM medications WHERE id = :id")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getMedicationById(long id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.ankangban.health.core.storage.entity.MedicationEntity> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertReminders(@org.jetbrains.annotations.NotNull
    java.util.List<com.ankangban.health.core.storage.entity.ReminderEntity> reminders, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM reminders WHERE medication_id = :medicationId")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.ankangban.health.core.storage.entity.ReminderEntity>> getRemindersForMedication(long medicationId);
    
    @androidx.room.Query(value = "DELETE FROM reminders WHERE medication_id = :medicationId")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteRemindersByMedicationId(long medicationId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM reminders WHERE is_enabled = 1")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getAllActiveReminders(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.ankangban.health.core.storage.entity.ReminderEntity>> $completion);
    
    @androidx.room.Transaction
    @androidx.room.Query(value = "SELECT * FROM medications ORDER BY create_time DESC")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.ankangban.health.core.storage.dao.MedicationDao.MedicationWithReminders>> getMedicationsWithReminders();
    
    @androidx.room.Transaction
    @androidx.room.Query(value = "SELECT * FROM medications WHERE id = :id")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getMedicationWithRemindersById(long id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.ankangban.health.core.storage.dao.MedicationDao.MedicationWithReminders> $completion);
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u00c6\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u00c6\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0016"}, d2 = {"Lcom/ankangban/health/core/storage/dao/MedicationDao$MedicationWithReminders;", "", "medication", "Lcom/ankangban/health/core/storage/entity/MedicationEntity;", "reminders", "", "Lcom/ankangban/health/core/storage/entity/ReminderEntity;", "(Lcom/ankangban/health/core/storage/entity/MedicationEntity;Ljava/util/List;)V", "getMedication", "()Lcom/ankangban/health/core/storage/entity/MedicationEntity;", "getReminders", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_debug"})
    public static final class MedicationWithReminders {
        @androidx.room.Embedded
        @org.jetbrains.annotations.NotNull
        private final com.ankangban.health.core.storage.entity.MedicationEntity medication = null;
        @androidx.room.Relation(parentColumn = "id", entityColumn = "medication_id")
        @org.jetbrains.annotations.NotNull
        private final java.util.List<com.ankangban.health.core.storage.entity.ReminderEntity> reminders = null;
        
        public MedicationWithReminders(@org.jetbrains.annotations.NotNull
        com.ankangban.health.core.storage.entity.MedicationEntity medication, @org.jetbrains.annotations.NotNull
        java.util.List<com.ankangban.health.core.storage.entity.ReminderEntity> reminders) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.ankangban.health.core.storage.entity.MedicationEntity getMedication() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.util.List<com.ankangban.health.core.storage.entity.ReminderEntity> getReminders() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.ankangban.health.core.storage.entity.MedicationEntity component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.util.List<com.ankangban.health.core.storage.entity.ReminderEntity> component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.ankangban.health.core.storage.dao.MedicationDao.MedicationWithReminders copy(@org.jetbrains.annotations.NotNull
        com.ankangban.health.core.storage.entity.MedicationEntity medication, @org.jetbrains.annotations.NotNull
        java.util.List<com.ankangban.health.core.storage.entity.ReminderEntity> reminders) {
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