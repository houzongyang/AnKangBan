package com.ankangban.health.features.sleep.tools;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0010B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\fR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/ankangban/health/features/sleep/tools/WhiteNoisePlayer;", "", "()V", "audioTrack", "Landroid/media/AudioTrack;", "isPlaying", "", "job", "Lkotlinx/coroutines/Job;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "play", "", "type", "Lcom/ankangban/health/features/sleep/tools/WhiteNoisePlayer$NoiseType;", "stop", "NoiseType", "app_debug"})
public final class WhiteNoisePlayer {
    @org.jetbrains.annotations.Nullable
    private android.media.AudioTrack audioTrack;
    private boolean isPlaying = false;
    @org.jetbrains.annotations.Nullable
    private kotlinx.coroutines.Job job;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.CoroutineScope scope = null;
    
    public WhiteNoisePlayer() {
        super();
    }
    
    public final void play(@org.jetbrains.annotations.NotNull
    com.ankangban.health.features.sleep.tools.WhiteNoisePlayer.NoiseType type) {
    }
    
    public final void stop() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/ankangban/health/features/sleep/tools/WhiteNoisePlayer$NoiseType;", "", "(Ljava/lang/String;I)V", "WHITE", "PINK", "BROWN", "app_debug"})
    public static enum NoiseType {
        /*public static final*/ WHITE /* = new WHITE() */,
        /*public static final*/ PINK /* = new PINK() */,
        /*public static final*/ BROWN /* = new BROWN() */;
        
        NoiseType() {
        }
        
        @org.jetbrains.annotations.NotNull
        public static kotlin.enums.EnumEntries<com.ankangban.health.features.sleep.tools.WhiteNoisePlayer.NoiseType> getEntries() {
            return null;
        }
    }
}