package com.ankangban.health.ui.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u001dH\u0002J\b\u0010\u001f\u001a\u00020\u001dH\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013\u00a8\u0006 "}, d2 = {"Lcom/ankangban/health/ui/viewmodel/DashboardViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "_latestHealthData", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/ankangban/health/ui/viewmodel/HealthSummary;", "_latestSleepData", "Lcom/ankangban/health/core/storage/SleepDataEntity;", "_todaySteps", "", "db", "Lcom/ankangban/health/core/storage/HealthDatabase;", "healthDao", "Lcom/ankangban/health/core/storage/HealthDataDao;", "latestHealthData", "Lkotlinx/coroutines/flow/StateFlow;", "getLatestHealthData", "()Lkotlinx/coroutines/flow/StateFlow;", "latestSleepData", "getLatestSleepData", "sleepDao", "Lcom/ankangban/health/core/storage/SleepDao;", "stepsDao", "Lcom/ankangban/health/core/storage/StepsDao;", "todaySteps", "getTodaySteps", "loadLatestHealthData", "", "loadLatestSleepData", "loadTodaySteps", "app_debug"})
public final class DashboardViewModel extends androidx.lifecycle.AndroidViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.ankangban.health.core.storage.HealthDatabase db = null;
    @org.jetbrains.annotations.NotNull
    private final com.ankangban.health.core.storage.StepsDao stepsDao = null;
    @org.jetbrains.annotations.NotNull
    private final com.ankangban.health.core.storage.HealthDataDao healthDao = null;
    @org.jetbrains.annotations.NotNull
    private final com.ankangban.health.core.storage.SleepDao sleepDao = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Integer> _todaySteps = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> todaySteps = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.ankangban.health.ui.viewmodel.HealthSummary> _latestHealthData = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.ankangban.health.ui.viewmodel.HealthSummary> latestHealthData = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.ankangban.health.core.storage.SleepDataEntity> _latestSleepData = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.ankangban.health.core.storage.SleepDataEntity> latestSleepData = null;
    
    public DashboardViewModel(@org.jetbrains.annotations.NotNull
    android.app.Application application) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> getTodaySteps() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.ankangban.health.ui.viewmodel.HealthSummary> getLatestHealthData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.ankangban.health.core.storage.SleepDataEntity> getLatestSleepData() {
        return null;
    }
    
    private final void loadTodaySteps() {
    }
    
    private final void loadLatestHealthData() {
    }
    
    private final void loadLatestSleepData() {
    }
}