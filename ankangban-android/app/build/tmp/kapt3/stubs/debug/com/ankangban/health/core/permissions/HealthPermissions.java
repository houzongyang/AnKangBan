package com.ankangban.health.core.permissions;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eR\u0019\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000f"}, d2 = {"Lcom/ankangban/health/core/permissions/HealthPermissions;", "", "()V", "REQUIRED", "", "", "getREQUIRED", "()[Ljava/lang/String;", "[Ljava/lang/String;", "ensure", "", "activity", "Landroid/app/Activity;", "requestCode", "", "app_debug"})
public final class HealthPermissions {
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String[] REQUIRED = {"android.permission.BODY_SENSORS", "android.permission.ACTIVITY_RECOGNITION", "android.permission.BLUETOOTH", "android.permission.BLUETOOTH_ADMIN", "android.permission.BLUETOOTH_CONNECT", "android.permission.BLUETOOTH_SCAN", "android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.RECORD_AUDIO", "com.heytap.health.permission.READ_HEALTH_DATA", "com.heytap.health.permission.READ_SLEEP_DATA"};
    @org.jetbrains.annotations.NotNull
    public static final com.ankangban.health.core.permissions.HealthPermissions INSTANCE = null;
    
    private HealthPermissions() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String[] getREQUIRED() {
        return null;
    }
    
    public final void ensure(@org.jetbrains.annotations.NotNull
    android.app.Activity activity, int requestCode) {
    }
}