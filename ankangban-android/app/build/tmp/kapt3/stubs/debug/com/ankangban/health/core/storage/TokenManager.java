package com.ankangban.health.core.storage;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0007\u001a\u00020\bJ\b\u0010\t\u001a\u0004\u0018\u00010\nJ\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\nJ\u000e\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\nJ\u000e\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\rR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/ankangban/health/core/storage/TokenManager;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "prefs", "Landroid/content/SharedPreferences;", "clearToken", "", "getPhone", "", "getToken", "getUserId", "", "savePhone", "phone", "saveToken", "token", "saveUserId", "userId", "app_debug"})
public final class TokenManager {
    @org.jetbrains.annotations.NotNull
    private final android.content.SharedPreferences prefs = null;
    
    public TokenManager(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super();
    }
    
    public final void saveToken(@org.jetbrains.annotations.NotNull
    java.lang.String token) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getToken() {
        return null;
    }
    
    public final void clearToken() {
    }
    
    public final void saveUserId(int userId) {
    }
    
    public final int getUserId() {
        return 0;
    }
    
    public final void savePhone(@org.jetbrains.annotations.NotNull
    java.lang.String phone) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getPhone() {
        return null;
    }
}