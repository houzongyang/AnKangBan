package com.ankangban.health.core.alarm;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ&\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/ankangban/health/core/alarm/NotificationHelper;", "", "()V", "CHANNEL_ID", "", "CHANNEL_NAME", "createNotificationChannel", "", "context", "Landroid/content/Context;", "showMedicationNotification", "medicationName", "dosage", "medicationId", "", "app_debug"})
public final class NotificationHelper {
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String CHANNEL_ID = "medication_channel";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String CHANNEL_NAME = "\u7528\u836f\u63d0\u9192";
    @org.jetbrains.annotations.NotNull
    public static final com.ankangban.health.core.alarm.NotificationHelper INSTANCE = null;
    
    private NotificationHelper() {
        super();
    }
    
    public final void createNotificationChannel(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
    }
    
    public final void showMedicationNotification(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    java.lang.String medicationName, @org.jetbrains.annotations.NotNull
    java.lang.String dosage, long medicationId) {
    }
}