package com.ankangban.health.features.sleep.tools;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u000fH\u0002J$\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010$\u001a\u00020\u0019H\u0016J\u001a\u0010%\u001a\u00020\u00192\u0006\u0010&\u001a\u00020\u001d2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J \u0010\'\u001a\u00020\u00192\u0006\u0010(\u001a\u00020\t2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0002J\b\u0010-\u001a\u00020\u0019H\u0002J\b\u0010.\u001a\u00020\u0019H\u0002J\u0010\u0010/\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u000fH\u0002J\b\u00100\u001a\u00020\u0019H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015\u00a8\u00061"}, d2 = {"Lcom/ankangban/health/features/sleep/tools/WhiteNoiseBottomSheet;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "()V", "_binding", "Lcom/ankangban/health/databinding/FragmentWhiteNoiseBottomSheetBinding;", "binding", "getBinding", "()Lcom/ankangban/health/databinding/FragmentWhiteNoiseBottomSheetBinding;", "currentSound", "", "isPlaying", "", "player", "Lcom/ankangban/health/features/sleep/tools/WhiteNoisePlayer;", "remainingTimeMillis", "", "timer", "Landroid/os/CountDownTimer;", "viewModel", "Lcom/ankangban/health/ui/viewmodel/SleepToolsViewModel;", "getViewModel", "()Lcom/ankangban/health/ui/viewmodel/SleepToolsViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "cancelTimer", "", "formatTime", "millis", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onViewCreated", "view", "playSound", "name", "iconRes", "", "type", "Lcom/ankangban/health/features/sleep/tools/WhiteNoisePlayer$NoiseType;", "setupClickListeners", "showTimerDialog", "startTimer", "togglePlay", "app_debug"})
public final class WhiteNoiseBottomSheet extends com.google.android.material.bottomsheet.BottomSheetDialogFragment {
    @org.jetbrains.annotations.Nullable
    private com.ankangban.health.databinding.FragmentWhiteNoiseBottomSheetBinding _binding;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy viewModel$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final com.ankangban.health.features.sleep.tools.WhiteNoisePlayer player = null;
    private boolean isPlaying = false;
    @org.jetbrains.annotations.NotNull
    private java.lang.String currentSound = "";
    @org.jetbrains.annotations.Nullable
    private android.os.CountDownTimer timer;
    private long remainingTimeMillis = 0L;
    
    public WhiteNoiseBottomSheet() {
        super();
    }
    
    private final com.ankangban.health.databinding.FragmentWhiteNoiseBottomSheetBinding getBinding() {
        return null;
    }
    
    private final com.ankangban.health.ui.viewmodel.SleepToolsViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override
    public void onViewCreated(@org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupClickListeners() {
    }
    
    private final void playSound(java.lang.String name, int iconRes, com.ankangban.health.features.sleep.tools.WhiteNoisePlayer.NoiseType type) {
    }
    
    private final void togglePlay() {
    }
    
    private final void showTimerDialog() {
    }
    
    private final void startTimer(long millis) {
    }
    
    private final void cancelTimer() {
    }
    
    private final java.lang.String formatTime(long millis) {
        return null;
    }
    
    @java.lang.Override
    public void onDestroyView() {
    }
}