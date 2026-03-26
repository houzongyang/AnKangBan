package com.ankangban.health.core.repo;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u0006\u0010\u000f\u001a\u00020\u0010J%\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u00122\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u000e\u00f8\u0001\u0000J\u0006\u0010\u0017\u001a\u00020\u0014J%\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u00122\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u000e\u00f8\u0001\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0019"}, d2 = {"Lcom/ankangban/health/core/repo/AuthRepository;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "api", "Lcom/ankangban/health/core/network/AuthApi;", "getApi", "()Lcom/ankangban/health/core/network/AuthApi;", "api$delegate", "Lkotlin/Lazy;", "tokenManager", "Lcom/ankangban/health/core/storage/TokenManager;", "getSavedPhone", "", "isLoggedIn", "", "login", "Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Result;", "", "phone", "pass", "logout", "register", "app_debug"})
public final class AuthRepository {
    @org.jetbrains.annotations.NotNull
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy api$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final com.ankangban.health.core.storage.TokenManager tokenManager = null;
    
    public AuthRepository(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super();
    }
    
    private final com.ankangban.health.core.network.AuthApi getApi() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<kotlin.Result<kotlin.Unit>> login(@org.jetbrains.annotations.NotNull
    java.lang.String phone, @org.jetbrains.annotations.NotNull
    java.lang.String pass) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<kotlin.Result<kotlin.Unit>> register(@org.jetbrains.annotations.NotNull
    java.lang.String phone, @org.jetbrains.annotations.NotNull
    java.lang.String pass) {
        return null;
    }
    
    public final boolean isLoggedIn() {
        return false;
    }
    
    public final void logout() {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getSavedPhone() {
        return null;
    }
}