package com.ankangban.health.core.storage;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\rR(\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00068F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r8F\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R$\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00128F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\r8F\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u000fR$\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\r8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u001b\u0010\u000f\"\u0004\b\u001c\u0010\u001dR$\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u001f\u0010\t\"\u0004\b \u0010\u000bR$\u0010!\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\"\u0010\t\"\u0004\b#\u0010\u000bR$\u0010$\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b%\u0010\t\"\u0004\b&\u0010\u000bR$\u0010\'\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b(\u0010\t\"\u0004\b)\u0010\u000b\u00a8\u0006-"}, d2 = {"Lcom/ankangban/health/core/storage/UserManager;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "value", "", "avatarUri", "getAvatarUri", "()Ljava/lang/String;", "setAvatarUri", "(Ljava/lang/String;)V", "healthLevel", "", "getHealthLevel", "()I", "prefs", "Landroid/content/SharedPreferences;", "", "shareData", "getShareData", "()Z", "setShareData", "(Z)V", "trackingDays", "getTrackingDays", "userAge", "getUserAge", "setUserAge", "(I)V", "userGender", "getUserGender", "setUserGender", "userHeight", "getUserHeight", "setUserHeight", "userName", "getUserName", "setUserName", "userWeight", "getUserWeight", "setUserWeight", "updateTrackingDays", "", "days", "app_debug"})
public final class UserManager {
    @org.jetbrains.annotations.NotNull
    private final android.content.SharedPreferences prefs = null;
    
    public UserManager(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getUserName() {
        return null;
    }
    
    public final void setUserName(@org.jetbrains.annotations.NotNull
    java.lang.String value) {
    }
    
    public final int getUserAge() {
        return 0;
    }
    
    public final void setUserAge(int value) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getUserGender() {
        return null;
    }
    
    public final void setUserGender(@org.jetbrains.annotations.NotNull
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getUserHeight() {
        return null;
    }
    
    public final void setUserHeight(@org.jetbrains.annotations.NotNull
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getUserWeight() {
        return null;
    }
    
    public final void setUserWeight(@org.jetbrains.annotations.NotNull
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getAvatarUri() {
        return null;
    }
    
    public final void setAvatarUri(@org.jetbrains.annotations.Nullable
    java.lang.String value) {
    }
    
    public final boolean getShareData() {
        return false;
    }
    
    public final void setShareData(boolean value) {
    }
    
    public final int getHealthLevel() {
        return 0;
    }
    
    public final int getTrackingDays() {
        return 0;
    }
    
    public final void updateTrackingDays(int days) {
    }
}