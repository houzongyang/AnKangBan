package com.ankangban.health.core.risk;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0013\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fJ\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\f0\u000e2\u0006\u0010\u000f\u001a\u00020\u0006R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/ankangban/health/core/risk/RiskInference;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "coef", "", "intercept", "", "loadFromAssets", "", "filename", "", "predict", "Lkotlin/Pair;", "features", "app_debug"})
public final class RiskInference {
    @org.jetbrains.annotations.NotNull
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull
    private double[] coef = {};
    private double intercept = 0.0;
    
    public RiskInference(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super();
    }
    
    public final void loadFromAssets(@org.jetbrains.annotations.NotNull
    java.lang.String filename) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlin.Pair<java.lang.Double, java.lang.String> predict(@org.jetbrains.annotations.NotNull
    double[] features) {
        return null;
    }
}