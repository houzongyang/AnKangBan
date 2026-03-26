package com.ankangban.health.ui.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020\u000bH\u0002J\u000e\u0010K\u001a\u00020I2\u0006\u0010L\u001a\u00020\u0017J\u0010\u0010M\u001a\u00020I2\b\b\u0002\u0010N\u001a\u00020\u0011J\u0018\u0010O\u001a\u00020\u00112\u0006\u0010P\u001a\u00020\u00152\u0006\u0010Q\u001a\u00020\u0015H\u0002J\b\u0010R\u001a\u00020IH\u0002J\u0006\u0010S\u001a\u00020IJ\b\u0010T\u001a\u00020IH\u0002J\u000e\u0010U\u001a\u00020I2\u0006\u0010V\u001a\u00020WJ\u0018\u0010X\u001a\u00020I2\u0006\u0010Y\u001a\u00020\t2\b\u0010@\u001a\u0004\u0018\u00010\u001bR\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\r0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u0018\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u00190\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u001f\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0019\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u001f\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010!R\u0017\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001f\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010!R\u001d\u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u001f\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010!R\u000e\u0010(\u001a\u00020)X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\r0\u001f\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u0010!R\u0017\u00100\u001a\b\u0012\u0004\u0012\u00020\u00110\u001f\u00a2\u0006\b\n\u0000\u001a\u0004\b1\u0010!R\u0016\u00102\u001a\n 4*\u0004\u0018\u00010303X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u00105\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u001f\u00a2\u0006\b\n\u0000\u001a\u0004\b6\u0010!R\u0017\u00107\u001a\b\u0012\u0004\u0012\u00020\u00150\u001f\u00a2\u0006\b\n\u0000\u001a\u0004\b8\u0010!R\u0019\u00109\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u001f\u00a2\u0006\b\n\u0000\u001a\u0004\b:\u0010!R#\u0010;\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u00190\u001f\u00a2\u0006\b\n\u0000\u001a\u0004\b<\u0010!R\u0016\u0010=\u001a\n 4*\u0004\u0018\u00010303X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020?X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010@\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u001f\u00a2\u0006\b\n\u0000\u001a\u0004\bA\u0010!R\u000e\u0010B\u001a\u00020CX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010D\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001f\u00a2\u0006\b\n\u0000\u001a\u0004\bE\u0010!R\u0017\u0010F\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001f\u00a2\u0006\b\n\u0000\u001a\u0004\bG\u0010!\u00a8\u0006Z"}, d2 = {"Lcom/ankangban/health/ui/viewmodel/SleepImprovementViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "_aiPlan", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/ankangban/health/core/api/SleepPlanResponse;", "_checkInAiResult", "", "_checkInStreak", "", "_checkIns", "", "Lcom/ankangban/health/core/storage/SleepCheckInEntity;", "_immediatePlan", "_loading", "", "_qualityResult", "Lcom/ankangban/health/features/sleep/logic/SleepQualityResult;", "_selectedDate", "Ljava/util/Date;", "_sevenDayPlan", "Lcom/ankangban/health/core/storage/SleepPlanEntity;", "_sevenDayProgress", "Lkotlin/Pair;", "_sleepData", "Lcom/ankangban/health/core/storage/SleepDataEntity;", "_userLevel", "_userPoints", "aiPlan", "Lkotlinx/coroutines/flow/StateFlow;", "getAiPlan", "()Lkotlinx/coroutines/flow/StateFlow;", "checkInAiResult", "getCheckInAiResult", "checkInStreak", "getCheckInStreak", "checkIns", "getCheckIns", "db", "Lcom/ankangban/health/core/storage/HealthDatabase;", "gson", "Lcom/google/gson/Gson;", "healthRepository", "Lcom/ankangban/health/core/repo/HealthRepository;", "immediatePlan", "getImmediatePlan", "loading", "getLoading", "pointPrefs", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "qualityResult", "getQualityResult", "selectedDate", "getSelectedDate", "sevenDayPlan", "getSevenDayPlan", "sevenDayProgress", "getSevenDayProgress", "sharedPrefs", "sleepCheckInDao", "Lcom/ankangban/health/core/storage/SleepCheckInDao;", "sleepData", "getSleepData", "sleepPlanDao", "Lcom/ankangban/health/core/storage/SleepPlanDao;", "userLevel", "getUserLevel", "userPoints", "getUserPoints", "addPoints", "", "amount", "completeDailyPlan", "plan", "generateAiPlan", "forceRefresh", "isSameDay", "d1", "d2", "loadCheckIns", "loadData", "loadGamification", "setDate", "timestamp", "", "submitCheckIn", "mood", "app_debug"})
public final class SleepImprovementViewModel extends androidx.lifecycle.AndroidViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.ankangban.health.core.storage.HealthDatabase db = null;
    @org.jetbrains.annotations.NotNull
    private final com.ankangban.health.core.storage.SleepPlanDao sleepPlanDao = null;
    @org.jetbrains.annotations.NotNull
    private final com.ankangban.health.core.storage.SleepCheckInDao sleepCheckInDao = null;
    @org.jetbrains.annotations.NotNull
    private final com.ankangban.health.core.repo.HealthRepository healthRepository = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.ankangban.health.core.storage.SleepDataEntity> _sleepData = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.ankangban.health.core.storage.SleepDataEntity> sleepData = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.ankangban.health.features.sleep.logic.SleepQualityResult> _qualityResult = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.ankangban.health.features.sleep.logic.SleepQualityResult> qualityResult = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<java.lang.String>> _immediatePlan = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<java.lang.String>> immediatePlan = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.ankangban.health.core.storage.SleepPlanEntity> _sevenDayPlan = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.ankangban.health.core.storage.SleepPlanEntity> sevenDayPlan = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<kotlin.Pair<java.lang.Integer, java.lang.Integer>> _sevenDayProgress = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<kotlin.Pair<java.lang.Integer, java.lang.Integer>> sevenDayProgress = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.ankangban.health.core.storage.SleepCheckInEntity>> _checkIns = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.ankangban.health.core.storage.SleepCheckInEntity>> checkIns = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.ankangban.health.core.api.SleepPlanResponse> _aiPlan = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.ankangban.health.core.api.SleepPlanResponse> aiPlan = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _loading = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> loading = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.Date> _selectedDate = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.util.Date> selectedDate = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Integer> _userPoints = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> userPoints = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Integer> _userLevel = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> userLevel = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Integer> _checkInStreak = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> checkInStreak = null;
    @org.jetbrains.annotations.NotNull
    private final com.google.gson.Gson gson = null;
    private final android.content.SharedPreferences sharedPrefs = null;
    private final android.content.SharedPreferences pointPrefs = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _checkInAiResult = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> checkInAiResult = null;
    
    public SleepImprovementViewModel(@org.jetbrains.annotations.NotNull
    android.app.Application application) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.ankangban.health.core.storage.SleepDataEntity> getSleepData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.ankangban.health.features.sleep.logic.SleepQualityResult> getQualityResult() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<java.lang.String>> getImmediatePlan() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.ankangban.health.core.storage.SleepPlanEntity> getSevenDayPlan() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<kotlin.Pair<java.lang.Integer, java.lang.Integer>> getSevenDayProgress() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.ankangban.health.core.storage.SleepCheckInEntity>> getCheckIns() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.ankangban.health.core.api.SleepPlanResponse> getAiPlan() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> getLoading() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.Date> getSelectedDate() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> getUserPoints() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> getUserLevel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> getCheckInStreak() {
        return null;
    }
    
    private final void loadGamification() {
    }
    
    private final void addPoints(int amount) {
    }
    
    private final void loadCheckIns() {
    }
    
    public final void setDate(long timestamp) {
    }
    
    public final void loadData() {
    }
    
    public final void generateAiPlan(boolean forceRefresh) {
    }
    
    private final boolean isSameDay(java.util.Date d1, java.util.Date d2) {
        return false;
    }
    
    public final void completeDailyPlan(@org.jetbrains.annotations.NotNull
    com.ankangban.health.core.storage.SleepPlanEntity plan) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getCheckInAiResult() {
        return null;
    }
    
    public final void submitCheckIn(@org.jetbrains.annotations.NotNull
    java.lang.String mood, @org.jetbrains.annotations.Nullable
    com.ankangban.health.core.storage.SleepDataEntity sleepData) {
    }
}