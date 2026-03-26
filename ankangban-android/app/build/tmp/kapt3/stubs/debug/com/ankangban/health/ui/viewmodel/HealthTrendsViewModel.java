package com.ankangban.health.ui.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001:\u0002MNB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J4\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00072\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00070\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020$0\"2\u0006\u0010%\u001a\u00020\u0007H\u0002J\u0016\u0010&\u001a\u00020\u00072\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\'0\"H\u0002JD\u0010(\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00072\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00070\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020)0\"2\u0006\u0010%\u001a\u00020\u00072\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020)H\u0002J2\u0010,\u001a\u00020\u00072\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00070\"2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020)0\"2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020)0\"H\u0002J\u0018\u0010/\u001a\u00020\u00072\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u0011H\u0002J\u001e\u00103\u001a\b\u0012\u0004\u0012\u0002040\"2\u0006\u00105\u001a\u0002012\u0006\u00106\u001a\u000201H\u0002J\u001e\u00107\u001a\b\u0012\u0004\u0012\u00020\'0\"2\u0006\u00105\u001a\u0002012\u0006\u00106\u001a\u000201H\u0002J\u001e\u00108\u001a\b\u0012\u0004\u0012\u0002040\"2\u0006\u00105\u001a\u0002012\u0006\u00106\u001a\u000201H\u0002J\u001e\u00109\u001a\b\u0012\u0004\u0012\u00020:0\"2\u0006\u00105\u001a\u0002012\u0006\u00106\u001a\u000201H\u0002J\u0014\u0010;\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070<H\u0002J\u001c\u0010=\u001a\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u0002010<2\u0006\u00102\u001a\u00020\u0011H\u0002J\b\u0010>\u001a\u00020?H\u0002J!\u0010@\u001a\u00020A2\u0006\u00105\u001a\u0002012\u0006\u00106\u001a\u000201H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010BJ!\u0010C\u001a\u00020A2\u0006\u00105\u001a\u0002012\u0006\u00106\u001a\u000201H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010BJ!\u0010D\u001a\u00020A2\u0006\u00105\u001a\u0002012\u0006\u00106\u001a\u000201H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010BJ!\u0010E\u001a\u00020A2\u0006\u00105\u001a\u0002012\u0006\u00106\u001a\u000201H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010BJ!\u0010F\u001a\u00020A2\u0006\u00105\u001a\u0002012\u0006\u00106\u001a\u000201H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010BJ\u0006\u0010G\u001a\u00020AJ!\u0010H\u001a\u00020A2\u0006\u00105\u001a\u0002012\u0006\u00106\u001a\u000201H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010BJ\u0006\u0010I\u001a\u00020AJ\u000e\u0010J\u001a\u00020A2\u0006\u0010K\u001a\u00020\u0015J\u000e\u0010L\u001a\u00020A2\u0006\u00102\u001a\u00020\u0011R\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u0015@BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004\u00a2\u0006\u0002\n\u0000R#\u0010\u001b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\t0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u000fR\u0019\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u000f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006O"}, d2 = {"Lcom/ankangban/health/ui/viewmodel/HealthTrendsViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "_chartOption", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_stats", "", "_trendInsight", "Lcom/ankangban/health/core/api/TrendAnalysisResponse;", "chartOption", "Lkotlinx/coroutines/flow/StateFlow;", "getChartOption", "()Lkotlinx/coroutines/flow/StateFlow;", "<set-?>", "Lcom/ankangban/health/ui/viewmodel/HealthTrendsViewModel$TimeDimension;", "currentDimension", "getCurrentDimension", "()Lcom/ankangban/health/ui/viewmodel/HealthTrendsViewModel$TimeDimension;", "Lcom/ankangban/health/ui/viewmodel/HealthTrendsViewModel$DataType;", "currentType", "getCurrentType", "()Lcom/ankangban/health/ui/viewmodel/HealthTrendsViewModel$DataType;", "repository", "Lcom/ankangban/health/core/repo/HealthRepository;", "stats", "getStats", "trendInsight", "getTrendInsight", "buildBarChartOption", "name", "xAxis", "", "data", "", "color", "buildHeatmapChartOption", "Lcom/ankangban/health/core/storage/SleepDataEntity;", "buildLineChartOption", "", "maxMark", "minMark", "buildStackedBarChartOption", "deep", "light", "formatTime", "ts", "", "dim", "generateMockHeartRate", "Lcom/ankangban/health/core/storage/HealthDataEntity;", "start", "end", "generateMockSleep", "generateMockSpO2", "generateMockSteps", "Lcom/ankangban/health/core/storage/StepsEntity;", "getChartColors", "Lkotlin/Pair;", "getTimeRange", "isDarkMode", "", "loadHeartRate", "", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadRespRate", "loadSleep", "loadSpO2", "loadSteps", "loadTrendAnalysis", "loadWristTemp", "refreshData", "setDataType", "type", "setDimension", "DataType", "TimeDimension", "app_debug"})
public final class HealthTrendsViewModel extends androidx.lifecycle.AndroidViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.ankangban.health.core.repo.HealthRepository repository = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _chartOption = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> chartOption = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.Map<java.lang.String, java.lang.String>> _stats = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.util.Map<java.lang.String, java.lang.String>> stats = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.ankangban.health.core.api.TrendAnalysisResponse> _trendInsight = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.ankangban.health.core.api.TrendAnalysisResponse> trendInsight = null;
    @org.jetbrains.annotations.NotNull
    private com.ankangban.health.ui.viewmodel.HealthTrendsViewModel.TimeDimension currentDimension = com.ankangban.health.ui.viewmodel.HealthTrendsViewModel.TimeDimension.DAY;
    @org.jetbrains.annotations.NotNull
    private com.ankangban.health.ui.viewmodel.HealthTrendsViewModel.DataType currentType = com.ankangban.health.ui.viewmodel.HealthTrendsViewModel.DataType.HEART_RATE;
    
    public HealthTrendsViewModel(@org.jetbrains.annotations.NotNull
    android.app.Application application) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getChartOption() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.Map<java.lang.String, java.lang.String>> getStats() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.ankangban.health.core.api.TrendAnalysisResponse> getTrendInsight() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.ankangban.health.ui.viewmodel.HealthTrendsViewModel.TimeDimension getCurrentDimension() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.ankangban.health.ui.viewmodel.HealthTrendsViewModel.DataType getCurrentType() {
        return null;
    }
    
    private final boolean isDarkMode() {
        return false;
    }
    
    private final kotlin.Pair<java.lang.String, java.lang.String> getChartColors() {
        return null;
    }
    
    public final void setDimension(@org.jetbrains.annotations.NotNull
    com.ankangban.health.ui.viewmodel.HealthTrendsViewModel.TimeDimension dim) {
    }
    
    public final void setDataType(@org.jetbrains.annotations.NotNull
    com.ankangban.health.ui.viewmodel.HealthTrendsViewModel.DataType type) {
    }
    
    public final void refreshData() {
    }
    
    public final void loadTrendAnalysis() {
    }
    
    private final kotlin.Pair<java.lang.Long, java.lang.Long> getTimeRange(com.ankangban.health.ui.viewmodel.HealthTrendsViewModel.TimeDimension dim) {
        return null;
    }
    
    private final java.lang.Object loadHeartRate(long start, long end, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final java.lang.Object loadSpO2(long start, long end, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final java.lang.Object loadSteps(long start, long end, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final java.lang.Object loadSleep(long start, long end, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final java.lang.String buildHeatmapChartOption(java.util.List<com.ankangban.health.core.storage.SleepDataEntity> data) {
        return null;
    }
    
    private final java.lang.Object loadWristTemp(long start, long end, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final java.lang.Object loadRespRate(long start, long end, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final java.util.List<com.ankangban.health.core.storage.HealthDataEntity> generateMockHeartRate(long start, long end) {
        return null;
    }
    
    private final java.util.List<com.ankangban.health.core.storage.HealthDataEntity> generateMockSpO2(long start, long end) {
        return null;
    }
    
    private final java.util.List<com.ankangban.health.core.storage.StepsEntity> generateMockSteps(long start, long end) {
        return null;
    }
    
    private final java.util.List<com.ankangban.health.core.storage.SleepDataEntity> generateMockSleep(long start, long end) {
        return null;
    }
    
    private final java.lang.String formatTime(long ts, com.ankangban.health.ui.viewmodel.HealthTrendsViewModel.TimeDimension dim) {
        return null;
    }
    
    private final java.lang.String buildLineChartOption(java.lang.String name, java.util.List<java.lang.String> xAxis, java.util.List<java.lang.Float> data, java.lang.String color, float maxMark, float minMark) {
        return null;
    }
    
    private final java.lang.String buildBarChartOption(java.lang.String name, java.util.List<java.lang.String> xAxis, java.util.List<java.lang.Integer> data, java.lang.String color) {
        return null;
    }
    
    private final java.lang.String buildStackedBarChartOption(java.util.List<java.lang.String> xAxis, java.util.List<java.lang.Float> deep, java.util.List<java.lang.Float> light) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b\u00a8\u0006\t"}, d2 = {"Lcom/ankangban/health/ui/viewmodel/HealthTrendsViewModel$DataType;", "", "(Ljava/lang/String;I)V", "HEART_RATE", "SPO2", "STEPS", "SLEEP", "WRIST_TEMP", "RESP_RATE", "app_debug"})
    public static enum DataType {
        /*public static final*/ HEART_RATE /* = new HEART_RATE() */,
        /*public static final*/ SPO2 /* = new SPO2() */,
        /*public static final*/ STEPS /* = new STEPS() */,
        /*public static final*/ SLEEP /* = new SLEEP() */,
        /*public static final*/ WRIST_TEMP /* = new WRIST_TEMP() */,
        /*public static final*/ RESP_RATE /* = new RESP_RATE() */;
        
        DataType() {
        }
        
        @org.jetbrains.annotations.NotNull
        public static kotlin.enums.EnumEntries<com.ankangban.health.ui.viewmodel.HealthTrendsViewModel.DataType> getEntries() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/ankangban/health/ui/viewmodel/HealthTrendsViewModel$TimeDimension;", "", "(Ljava/lang/String;I)V", "DAY", "WEEK", "MONTH", "app_debug"})
    public static enum TimeDimension {
        /*public static final*/ DAY /* = new DAY() */,
        /*public static final*/ WEEK /* = new WEEK() */,
        /*public static final*/ MONTH /* = new MONTH() */;
        
        TimeDimension() {
        }
        
        @org.jetbrains.annotations.NotNull
        public static kotlin.enums.EnumEntries<com.ankangban.health.ui.viewmodel.HealthTrendsViewModel.TimeDimension> getEntries() {
            return null;
        }
    }
}