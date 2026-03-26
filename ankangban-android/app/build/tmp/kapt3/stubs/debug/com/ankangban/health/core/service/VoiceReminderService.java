package com.ankangban.health.core.service;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0014\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\"\u0010\u0012\u001a\u00020\u00112\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0011H\u0016J\b\u0010\u0015\u001a\u00020\u000eH\u0002J\u0010\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0005H\u0002J\b\u0010\u0018\u001a\u00020\u000eH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/ankangban/health/core/service/VoiceReminderService;", "Landroid/app/Service;", "Landroid/speech/tts/TextToSpeech$OnInitListener;", "()V", "TAG", "", "messageToSpeak", "tts", "Landroid/speech/tts/TextToSpeech;", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onDestroy", "", "onInit", "status", "", "onStartCommand", "flags", "startId", "setupAndSpeak", "showToast", "msg", "speak", "app_debug"})
public final class VoiceReminderService extends android.app.Service implements android.speech.tts.TextToSpeech.OnInitListener {
    @org.jetbrains.annotations.Nullable
    private android.speech.tts.TextToSpeech tts;
    @org.jetbrains.annotations.Nullable
    private java.lang.String messageToSpeak;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String TAG = "VoiceReminderService";
    
    public VoiceReminderService() {
        super();
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public android.os.IBinder onBind(@org.jetbrains.annotations.Nullable
    android.content.Intent intent) {
        return null;
    }
    
    @java.lang.Override
    public int onStartCommand(@org.jetbrains.annotations.Nullable
    android.content.Intent intent, int flags, int startId) {
        return 0;
    }
    
    @java.lang.Override
    public void onInit(int status) {
    }
    
    private final void setupAndSpeak() {
    }
    
    private final void speak() {
    }
    
    private final void showToast(java.lang.String msg) {
    }
    
    @java.lang.Override
    public void onDestroy() {
    }
}