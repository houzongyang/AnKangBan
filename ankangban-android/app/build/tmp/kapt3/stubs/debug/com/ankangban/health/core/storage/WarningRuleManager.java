package com.ankangban.health.core.storage;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u000e\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\nR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/ankangban/health/core/storage/WarningRuleManager;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "gson", "Lcom/google/gson/Gson;", "prefs", "Landroid/content/SharedPreferences;", "createDefaultRule", "Lcom/ankangban/health/core/storage/WarningRule;", "type", "", "getRule", "resetToDefaults", "", "saveRule", "rule", "Companion", "app_debug"})
public final class WarningRuleManager {
    @org.jetbrains.annotations.NotNull
    private final android.content.SharedPreferences prefs = null;
    @org.jetbrains.annotations.NotNull
    private final com.google.gson.Gson gson = null;
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String TYPE_HEART_RATE = "HEART_RATE";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String TYPE_SPO2 = "SPO2";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String TYPE_STEPS = "STEPS";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String TYPE_SLEEP = "SLEEP";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ACTION_RULES_CHANGED = "com.ankangban.health.ACTION_RULES_CHANGED";
    @org.jetbrains.annotations.NotNull
    public static final com.ankangban.health.core.storage.WarningRuleManager.Companion Companion = null;
    
    public WarningRuleManager(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.ankangban.health.core.storage.WarningRule getRule(@org.jetbrains.annotations.NotNull
    java.lang.String type) {
        return null;
    }
    
    public final void saveRule(@org.jetbrains.annotations.NotNull
    com.ankangban.health.core.storage.WarningRule rule) {
    }
    
    public final void resetToDefaults() {
    }
    
    private final com.ankangban.health.core.storage.WarningRule createDefaultRule(java.lang.String type) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/ankangban/health/core/storage/WarningRuleManager$Companion;", "", "()V", "ACTION_RULES_CHANGED", "", "TYPE_HEART_RATE", "TYPE_SLEEP", "TYPE_SPO2", "TYPE_STEPS", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}