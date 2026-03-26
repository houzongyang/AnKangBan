package com.ankangban.health.core.network;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/ankangban/health/core/network/RetrofitClient;", "", "()V", "BASE_URL", "", "retrofit", "Lretrofit2/Retrofit;", "getClient", "context", "Landroid/content/Context;", "app_debug"})
public final class RetrofitClient {
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String BASE_URL = "http://127.0.0.1:5000/api/";
    @org.jetbrains.annotations.Nullable
    private static retrofit2.Retrofit retrofit;
    @org.jetbrains.annotations.NotNull
    public static final com.ankangban.health.core.network.RetrofitClient INSTANCE = null;
    
    private RetrofitClient() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final retrofit2.Retrofit getClient(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        return null;
    }
}