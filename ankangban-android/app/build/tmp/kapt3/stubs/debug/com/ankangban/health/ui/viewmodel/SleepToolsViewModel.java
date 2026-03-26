package com.ankangban.health.ui.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0014\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u000e\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020\u0010J\u0010\u0010@\u001a\u00020\n2\u0006\u0010A\u001a\u00020BH\u0002J\u001c\u0010C\u001a\u00020>2\u0006\u0010D\u001a\u00020\n2\f\u0010E\u001a\b\u0012\u0004\u0012\u00020\n0\u001eJ\b\u0010F\u001a\u00020>H\u0002J\u000e\u0010G\u001a\u00020>2\u0006\u0010H\u001a\u00020\bJ\b\u0010I\u001a\u00020>H\u0002J\b\u0010J\u001a\u00020>H\u0014J\u0010\u0010K\u001a\u00020>2\u0006\u0010L\u001a\u00020\u0010H\u0016J\u0010\u0010M\u001a\u00020>2\u0006\u0010N\u001a\u00020\nH\u0002J/\u0010O\u001a\u00020>2\u0006\u0010H\u001a\u00020\b2\u0006\u0010D\u001a\u00020\n2\f\u0010E\u001a\b\u0012\u0004\u0012\u00020\n0\u001eH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010PJ\b\u0010Q\u001a\u00020>H\u0002J\u0010\u0010R\u001a\u00020>2\u0006\u0010S\u001a\u00020\nH\u0002J\b\u0010T\u001a\u00020>H\u0002J\u000e\u0010U\u001a\u00020>2\u0006\u0010N\u001a\u00020\nR\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001e0\u001d\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020\n0\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0019R\u0017\u0010$\u001a\b\u0012\u0004\u0012\u00020\f0\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0019R\u0017\u0010%\u001a\b\u0012\u0004\u0012\u00020\f0\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0019R\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020\f0\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0019R\u000e\u0010\'\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0017\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00100\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010\u0019R\u0017\u0010.\u001a\b\u0012\u0004\u0012\u00020\n0\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u0010\u0019R\u0019\u00100\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b1\u0010\u0019R\u000e\u00102\u001a\u000203X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u00104\u001a\b\u0012\u0004\u0012\u00020\n05\u00a2\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0010\u00108\u001a\u0004\u0018\u000109X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0017\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00100\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b<\u0010\u0019\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006V"}, d2 = {"Lcom/ankangban/health/ui/viewmodel/SleepToolsViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "Landroid/speech/tts/TextToSpeech$OnInitListener;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "_aiContent", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/ankangban/health/core/api/SleepAidContentResponse;", "_currentPlayingTitle", "", "_isGenerating", "", "_isPlaying", "_isSilentMode", "_playbackProgress", "", "_playbackTime", "_recommendedTool", "_toastEvent", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "_userPoints", "aiContent", "Lkotlinx/coroutines/flow/StateFlow;", "getAiContent", "()Lkotlinx/coroutines/flow/StateFlow;", "aiContentDao", "Lcom/ankangban/health/core/storage/AiContentDao;", "aiHistory", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/ankangban/health/core/storage/AiContentEntity;", "getAiHistory", "()Lkotlinx/coroutines/flow/Flow;", "currentPlayingTitle", "getCurrentPlayingTitle", "isGenerating", "isPlaying", "isSilentMode", "isTtsReady", "lastDeepSleepMinutes", "lastSleepEfficiency", "playbackJob", "Lkotlinx/coroutines/Job;", "playbackProgress", "getPlaybackProgress", "playbackTime", "getPlaybackTime", "recommendedTool", "getRecommendedTool", "sleepDao", "Lcom/ankangban/health/core/storage/SleepDao;", "toastEvent", "Lkotlinx/coroutines/flow/SharedFlow;", "getToastEvent", "()Lkotlinx/coroutines/flow/SharedFlow;", "tts", "Landroid/speech/tts/TextToSpeech;", "ttsErrorMsg", "userPoints", "getUserPoints", "addPoints", "", "amount", "formatTime", "ms", "", "generateContent", "type", "tags", "initTts", "loadFromHistory", "response", "monitorSleepData", "onCleared", "onInit", "status", "playContent", "title", "saveToHistory", "(Lcom/ankangban/health/core/api/SleepAidContentResponse;Ljava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setupTtsListener", "startPlaybackSimulation", "text", "stopPlaybackSimulation", "togglePlay", "app_debug"})
public final class SleepToolsViewModel extends androidx.lifecycle.AndroidViewModel implements android.speech.tts.TextToSpeech.OnInitListener {
    @org.jetbrains.annotations.NotNull
    private final com.ankangban.health.core.storage.SleepDao sleepDao = null;
    @org.jetbrains.annotations.NotNull
    private final com.ankangban.health.core.storage.AiContentDao aiContentDao = null;
    @org.jetbrains.annotations.Nullable
    private android.speech.tts.TextToSpeech tts;
    private boolean isTtsReady = false;
    @org.jetbrains.annotations.Nullable
    private java.lang.String ttsErrorMsg;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.Flow<java.util.List<com.ankangban.health.core.storage.AiContentEntity>> aiHistory = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _recommendedTool = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> recommendedTool = null;
    private int lastSleepEfficiency = 0;
    private int lastDeepSleepMinutes = 0;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Integer> _userPoints = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> userPoints = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.ankangban.health.core.api.SleepAidContentResponse> _aiContent = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.ankangban.health.core.api.SleepAidContentResponse> aiContent = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableSharedFlow<java.lang.String> _toastEvent = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.SharedFlow<java.lang.String> toastEvent = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isGenerating = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isGenerating = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isPlaying = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isPlaying = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _currentPlayingTitle = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> currentPlayingTitle = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Integer> _playbackProgress = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> playbackProgress = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _playbackTime = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> playbackTime = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isSilentMode = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isSilentMode = null;
    @org.jetbrains.annotations.Nullable
    private kotlinx.coroutines.Job playbackJob;
    
    public SleepToolsViewModel(@org.jetbrains.annotations.NotNull
    android.app.Application application) {
        super(null);
    }
    
    @java.lang.Override
    public void onInit(int status) {
    }
    
    private final void setupTtsListener() {
    }
    
    @java.lang.Override
    protected void onCleared() {
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.ankangban.health.core.storage.AiContentEntity>> getAiHistory() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getRecommendedTool() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> getUserPoints() {
        return null;
    }
    
    public final void addPoints(int amount) {
    }
    
    private final void monitorSleepData() {
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.ankangban.health.core.api.SleepAidContentResponse> getAiContent() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.SharedFlow<java.lang.String> getToastEvent() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isGenerating() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isPlaying() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getCurrentPlayingTitle() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> getPlaybackProgress() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getPlaybackTime() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isSilentMode() {
        return null;
    }
    
    private final void initTts() {
    }
    
    public final void generateContent(@org.jetbrains.annotations.NotNull
    java.lang.String type, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> tags) {
    }
    
    private final java.lang.Object saveToHistory(com.ankangban.health.core.api.SleepAidContentResponse response, java.lang.String type, java.util.List<java.lang.String> tags, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    public final void loadFromHistory(@org.jetbrains.annotations.NotNull
    com.ankangban.health.core.api.SleepAidContentResponse response) {
    }
    
    private final void startPlaybackSimulation(java.lang.String text) {
    }
    
    private final void stopPlaybackSimulation() {
    }
    
    private final java.lang.String formatTime(long ms) {
        return null;
    }
    
    public final void togglePlay(@org.jetbrains.annotations.NotNull
    java.lang.String title) {
    }
    
    private final void playContent(java.lang.String title) {
    }
}