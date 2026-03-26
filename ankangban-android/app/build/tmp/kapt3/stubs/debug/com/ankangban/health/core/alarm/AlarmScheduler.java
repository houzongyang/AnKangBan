package com.ankangban.health.core.alarm;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ \u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0002J \u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\nH\u0007\u00a8\u0006\u0012"}, d2 = {"Lcom/ankangban/health/core/alarm/AlarmScheduler;", "", "()V", "cancelReminder", "", "context", "Landroid/content/Context;", "medicationId", "", "reminder", "Lcom/ankangban/health/core/storage/entity/ReminderEntity;", "getRequestCode", "", "hour", "minute", "scheduleReminder", "medication", "Lcom/ankangban/health/core/storage/entity/MedicationEntity;", "app_debug"})
public final class AlarmScheduler {
    @org.jetbrains.annotations.NotNull
    public static final com.ankangban.health.core.alarm.AlarmScheduler INSTANCE = null;
    
    private AlarmScheduler() {
        super();
    }
    
    @android.annotation.SuppressLint(value = {"ScheduleExactAlarm"})
    public final void scheduleReminder(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    com.ankangban.health.core.storage.entity.MedicationEntity medication, @org.jetbrains.annotations.NotNull
    com.ankangban.health.core.storage.entity.ReminderEntity reminder) {
    }
    
    public final void cancelReminder(@org.jetbrains.annotations.NotNull
    android.content.Context context, long medicationId, @org.jetbrains.annotations.NotNull
    com.ankangban.health.core.storage.entity.ReminderEntity reminder) {
    }
    
    private final int getRequestCode(long medicationId, int hour, int minute) {
        return 0;
    }
}