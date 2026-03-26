package com.ankangban.health.ui.view;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u000e\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\rJ\b\u0010\u0018\u001a\u00020\u000eH\u0003R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R(\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/ankangban/health/ui/view/HealthChartView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isLoaded", "", "onChartClickListener", "Lkotlin/Function1;", "", "", "getOnChartClickListener", "()Lkotlin/jvm/functions/Function1;", "setOnChartClickListener", "(Lkotlin/jvm/functions/Function1;)V", "pendingOption", "webView", "Landroid/webkit/WebView;", "setOption", "jsonOption", "setupWebView", "app_debug"})
public final class HealthChartView extends android.widget.FrameLayout {
    @org.jetbrains.annotations.NotNull
    private final android.webkit.WebView webView = null;
    private boolean isLoaded = false;
    @org.jetbrains.annotations.Nullable
    private java.lang.String pendingOption;
    @org.jetbrains.annotations.Nullable
    private kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onChartClickListener;
    
    @kotlin.jvm.JvmOverloads
    public HealthChartView(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.Nullable
    android.util.AttributeSet attrs, int defStyleAttr) {
        super(null);
    }
    
    @org.jetbrains.annotations.Nullable
    public final kotlin.jvm.functions.Function1<java.lang.String, kotlin.Unit> getOnChartClickListener() {
        return null;
    }
    
    public final void setOnChartClickListener(@org.jetbrains.annotations.Nullable
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> p0) {
    }
    
    @android.annotation.SuppressLint(value = {"SetJavaScriptEnabled"})
    private final void setupWebView() {
    }
    
    public final void setOption(@org.jetbrains.annotations.NotNull
    java.lang.String jsonOption) {
    }
    
    @kotlin.jvm.JvmOverloads
    public HealthChartView(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super(null);
    }
    
    @kotlin.jvm.JvmOverloads
    public HealthChartView(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.Nullable
    android.util.AttributeSet attrs) {
        super(null);
    }
}