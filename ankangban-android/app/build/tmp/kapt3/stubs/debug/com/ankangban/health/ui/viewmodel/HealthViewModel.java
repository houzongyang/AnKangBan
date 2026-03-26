package com.ankangban.health.ui.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\rJ\u000e\u00102\u001a\u0002002\u0006\u00103\u001a\u000204J\u000e\u00105\u001a\u0002002\u0006\u00106\u001a\u000207J\u0006\u00108\u001a\u000200J\u000e\u00109\u001a\u0002002\u0006\u0010:\u001a\u00020\rR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\t0\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u0012R#\u0010!\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b0\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0016R\u0019\u0010#\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010$0\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0012R\u0019\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\'0\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0012R\u0019\u0010)\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010*0\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0012R\u0019\u0010,\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010-0\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010\u0012\u00a8\u0006;"}, d2 = {"Lcom/ankangban/health/ui/viewmodel/HealthViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "app", "Landroid/app/Application;", "(Landroid/app/Application;)V", "_healthReport", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/ankangban/health/core/api/HealthReportResponse;", "_initStatus", "", "_riskResult", "Lkotlin/Pair;", "", "", "ecg", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/ankangban/health/core/oppo/EcgSample;", "getEcg", "()Lkotlinx/coroutines/flow/StateFlow;", "healthReport", "Lkotlinx/coroutines/flow/SharedFlow;", "getHealthReport", "()Lkotlinx/coroutines/flow/SharedFlow;", "heartRate", "Lcom/ankangban/health/core/oppo/HeartRate;", "getHeartRate", "initStatus", "getInitStatus", "repo", "Lcom/ankangban/health/core/repo/HealthRepository;", "respRate", "Lcom/ankangban/health/core/oppo/RespRate;", "getRespRate", "riskResult", "getRiskResult", "sleep", "Lcom/ankangban/health/core/oppo/SleepSummary;", "getSleep", "spO2", "Lcom/ankangban/health/core/oppo/SpO2;", "getSpO2", "steps", "Lcom/ankangban/health/core/oppo/Steps;", "getSteps", "wristTemp", "Lcom/ankangban/health/core/oppo/WristTemp;", "getWristTemp", "generateHealthReport", "", "period", "performRiskAssessment", "riskInference", "Lcom/ankangban/health/core/risk/RiskInference;", "setUpdateInterval", "minutes", "", "start", "updateDataSource", "type", "app_debug"})
public final class HealthViewModel extends androidx.lifecycle.AndroidViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.ankangban.health.core.repo.HealthRepository repo = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableSharedFlow<java.lang.Boolean> _initStatus = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.SharedFlow<java.lang.Boolean> initStatus = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableSharedFlow<kotlin.Pair<java.lang.Double, java.lang.String>> _riskResult = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.SharedFlow<kotlin.Pair<java.lang.Double, java.lang.String>> riskResult = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableSharedFlow<com.ankangban.health.core.api.HealthReportResponse> _healthReport = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.SharedFlow<com.ankangban.health.core.api.HealthReportResponse> healthReport = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.ankangban.health.core.oppo.HeartRate> heartRate = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.ankangban.health.core.oppo.SpO2> spO2 = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.ankangban.health.core.oppo.WristTemp> wristTemp = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.ankangban.health.core.oppo.Steps> steps = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.ankangban.health.core.oppo.RespRate> respRate = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.ankangban.health.core.oppo.EcgSample> ecg = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.ankangban.health.core.oppo.SleepSummary> sleep = null;
    
    public HealthViewModel(@org.jetbrains.annotations.NotNull
    android.app.Application app) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.SharedFlow<java.lang.Boolean> getInitStatus() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.SharedFlow<kotlin.Pair<java.lang.Double, java.lang.String>> getRiskResult() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.SharedFlow<com.ankangban.health.core.api.HealthReportResponse> getHealthReport() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.ankangban.health.core.oppo.HeartRate> getHeartRate() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.ankangban.health.core.oppo.SpO2> getSpO2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.ankangban.health.core.oppo.WristTemp> getWristTemp() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.ankangban.health.core.oppo.Steps> getSteps() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.ankangban.health.core.oppo.RespRate> getRespRate() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.ankangban.health.core.oppo.EcgSample> getEcg() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.ankangban.health.core.oppo.SleepSummary> getSleep() {
        return null;
    }
    
    public final void start() {
    }
    
    public final void updateDataSource(@org.jetbrains.annotations.NotNull
    java.lang.String type) {
    }
    
    public final void setUpdateInterval(int minutes) {
    }
    
    public final void performRiskAssessment(@org.jetbrains.annotations.NotNull
    com.ankangban.health.core.risk.RiskInference riskInference) {
    }
    
    public final void generateHealthReport(@org.jetbrains.annotations.NotNull
    java.lang.String period) {
    }
}