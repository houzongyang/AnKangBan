package com.ankangban.health.core.repo;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011J\u001b\u0010\u0012\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0015J\u001b\u0010\u0016\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0015J\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001bJ!\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010!J\'\u0010\"\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\b2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\u0007H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010%R\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006&"}, d2 = {"Lcom/ankangban/health/core/repo/MedicationRepository;", "", "dao", "Lcom/ankangban/health/core/storage/dao/MedicationDao;", "(Lcom/ankangban/health/core/storage/dao/MedicationDao;)V", "allMedications", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/ankangban/health/core/storage/entity/MedicationEntity;", "getAllMedications", "()Lkotlinx/coroutines/flow/Flow;", "medicationsWithReminders", "Lcom/ankangban/health/core/storage/dao/MedicationDao$MedicationWithReminders;", "getMedicationsWithReminders", "deleteMedication", "", "medication", "(Lcom/ankangban/health/core/storage/entity/MedicationEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMedication", "id", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMedicationWithReminders", "parseMedicationFromOcr", "Lcom/ankangban/health/core/api/MedicationParseResponse;", "text", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "recognizeText", "context", "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "(Landroid/content/Context;Landroid/net/Uri;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveMedication", "reminders", "Lcom/ankangban/health/core/storage/entity/ReminderEntity;", "(Lcom/ankangban/health/core/storage/entity/MedicationEntity;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class MedicationRepository {
    @org.jetbrains.annotations.NotNull
    private final com.ankangban.health.core.storage.dao.MedicationDao dao = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.Flow<java.util.List<com.ankangban.health.core.storage.entity.MedicationEntity>> allMedications = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.Flow<java.util.List<com.ankangban.health.core.storage.dao.MedicationDao.MedicationWithReminders>> medicationsWithReminders = null;
    
    public MedicationRepository(@org.jetbrains.annotations.NotNull
    com.ankangban.health.core.storage.dao.MedicationDao dao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.ankangban.health.core.storage.entity.MedicationEntity>> getAllMedications() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.ankangban.health.core.storage.dao.MedicationDao.MedicationWithReminders>> getMedicationsWithReminders() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getMedicationWithReminders(long id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.ankangban.health.core.storage.dao.MedicationDao.MedicationWithReminders> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getMedication(long id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.ankangban.health.core.storage.entity.MedicationEntity> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object saveMedication(@org.jetbrains.annotations.NotNull
    com.ankangban.health.core.storage.entity.MedicationEntity medication, @org.jetbrains.annotations.NotNull
    java.util.List<com.ankangban.health.core.storage.entity.ReminderEntity> reminders, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object deleteMedication(@org.jetbrains.annotations.NotNull
    com.ankangban.health.core.storage.entity.MedicationEntity medication, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object parseMedicationFromOcr(@org.jetbrains.annotations.NotNull
    java.lang.String text, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.ankangban.health.core.api.MedicationParseResponse> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object recognizeText(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    android.net.Uri uri, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.String> $completion) {
        return null;
    }
}