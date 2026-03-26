package com.ankangban.health.ui.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010#\u001a\u00020$J\u001b\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010\'\u001a\u00020\nH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010(J\b\u0010)\u001a\u00020$H\u0002J\b\u0010*\u001a\u00020$H\u0002J\b\u0010+\u001a\u00020$H\u0002J\u000e\u0010,\u001a\u00020$2\u0006\u0010-\u001a\u00020\u0007J.\u0010.\u001a\u00020$2\u0006\u0010\'\u001a\u00020\n2\u0006\u0010/\u001a\u00020\f2\n\b\u0002\u00100\u001a\u0004\u0018\u00010&2\n\b\u0002\u00101\u001a\u0004\u0018\u00010&R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\f0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u0012R\u000e\u0010!\u001a\u00020\"X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00062"}, d2 = {"Lcom/ankangban/health/ui/viewmodel/ChronicViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "_currentType", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/ankangban/health/core/storage/ChronicDiseaseType;", "_dailyPlans", "", "Lcom/ankangban/health/core/storage/ChronicPlanEntity;", "_loading", "", "_riskState", "Lcom/ankangban/health/core/storage/ChronicRiskEntity;", "currentType", "Lkotlinx/coroutines/flow/StateFlow;", "getCurrentType", "()Lkotlinx/coroutines/flow/StateFlow;", "dailyPlans", "getDailyPlans", "db", "Lcom/ankangban/health/core/storage/HealthDatabase;", "healthRepository", "Lcom/ankangban/health/core/repo/HealthRepository;", "loading", "getLoading", "repository", "Lcom/ankangban/health/core/repo/ChronicRepository;", "riskJob", "Lkotlinx/coroutines/Job;", "riskState", "getRiskState", "userManager", "Lcom/ankangban/health/core/storage/UserManager;", "evaluateRisk", "", "fetchLatestEvidence", "", "plan", "(Lcom/ankangban/health/core/storage/ChronicPlanEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadData", "loadPlans", "observeRisk", "switchType", "type", "updatePlanCompletion", "isCompleted", "evidenceText", "evidenceSource", "app_debug"})
public final class ChronicViewModel extends androidx.lifecycle.AndroidViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.ankangban.health.core.storage.HealthDatabase db = null;
    @org.jetbrains.annotations.NotNull
    private final com.ankangban.health.core.repo.ChronicRepository repository = null;
    @org.jetbrains.annotations.NotNull
    private final com.ankangban.health.core.repo.HealthRepository healthRepository = null;
    @org.jetbrains.annotations.NotNull
    private final com.ankangban.health.core.storage.UserManager userManager = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.ankangban.health.core.storage.ChronicDiseaseType> _currentType = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.ankangban.health.core.storage.ChronicDiseaseType> currentType = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.ankangban.health.core.storage.ChronicRiskEntity> _riskState = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.ankangban.health.core.storage.ChronicRiskEntity> riskState = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.ankangban.health.core.storage.ChronicPlanEntity>> _dailyPlans = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.ankangban.health.core.storage.ChronicPlanEntity>> dailyPlans = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _loading = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> loading = null;
    @org.jetbrains.annotations.Nullable
    private kotlinx.coroutines.Job riskJob;
    
    public ChronicViewModel(@org.jetbrains.annotations.NotNull
    android.app.Application application) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.ankangban.health.core.storage.ChronicDiseaseType> getCurrentType() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.ankangban.health.core.storage.ChronicRiskEntity> getRiskState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.ankangban.health.core.storage.ChronicPlanEntity>> getDailyPlans() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> getLoading() {
        return null;
    }
    
    public final void switchType(@org.jetbrains.annotations.NotNull
    com.ankangban.health.core.storage.ChronicDiseaseType type) {
    }
    
    private final void loadData() {
    }
    
    private final void observeRisk() {
    }
    
    private final void loadPlans() {
    }
    
    public final void evaluateRisk() {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object fetchLatestEvidence(@org.jetbrains.annotations.NotNull
    com.ankangban.health.core.storage.ChronicPlanEntity plan, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.String> $completion) {
        return null;
    }
    
    public final void updatePlanCompletion(@org.jetbrains.annotations.NotNull
    com.ankangban.health.core.storage.ChronicPlanEntity plan, boolean isCompleted, @org.jetbrains.annotations.Nullable
    java.lang.String evidenceText, @org.jetbrains.annotations.Nullable
    java.lang.String evidenceSource) {
    }
}