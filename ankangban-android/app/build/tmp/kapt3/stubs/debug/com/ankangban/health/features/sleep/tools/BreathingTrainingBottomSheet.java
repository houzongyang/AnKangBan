package com.ankangban.health.features.sleep.tools;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J$\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010\"\u001a\u00020#H\u0016J\u001a\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u001b2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J)\u0010&\u001a\u00020#2\u0006\u0010\'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u00042\u0006\u0010*\u001a\u00020+H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010,J\b\u0010-\u001a\u00020#H\u0002J\b\u0010.\u001a\u00020#H\u0002J\b\u0010/\u001a\u00020#H\u0002J\u0010\u00100\u001a\u00020#2\u0006\u00101\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\b8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00062"}, d2 = {"Lcom/ankangban/health/features/sleep/tools/BreathingTrainingBottomSheet;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "()V", "DURATION_EXHALE", "", "DURATION_HOLD", "DURATION_INHALE", "_binding", "Lcom/ankangban/health/databinding/FragmentBreathingBottomSheetBinding;", "binding", "getBinding", "()Lcom/ankangban/health/databinding/FragmentBreathingBottomSheetBinding;", "completedCycles", "", "isTraining", "", "trainingJob", "Lkotlinx/coroutines/Job;", "vibrator", "Landroid/os/Vibrator;", "viewModel", "Lcom/ankangban/health/ui/viewmodel/SleepToolsViewModel;", "getViewModel", "()Lcom/ankangban/health/ui/viewmodel/SleepToolsViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "", "onViewCreated", "view", "performPhase", "text", "", "duration", "targetScale", "", "(Ljava/lang/String;JFLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setupClickListeners", "startTraining", "stopTraining", "vibrateOneShot", "millis", "app_debug"})
public final class BreathingTrainingBottomSheet extends com.google.android.material.bottomsheet.BottomSheetDialogFragment {
    @org.jetbrains.annotations.Nullable
    private com.ankangban.health.databinding.FragmentBreathingBottomSheetBinding _binding;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy viewModel$delegate = null;
    @org.jetbrains.annotations.Nullable
    private kotlinx.coroutines.Job trainingJob;
    private boolean isTraining = false;
    private int completedCycles = 0;
    private final long DURATION_INHALE = 4000L;
    private final long DURATION_HOLD = 7000L;
    private final long DURATION_EXHALE = 8000L;
    private android.os.Vibrator vibrator;
    
    public BreathingTrainingBottomSheet() {
        super();
    }
    
    private final com.ankangban.health.databinding.FragmentBreathingBottomSheetBinding getBinding() {
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
    
    private final void startTraining() {
    }
    
    private final java.lang.Object performPhase(java.lang.String text, long duration, float targetScale, kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final void stopTraining() {
    }
    
    private final void vibrateOneShot(long millis) {
    }
    
    @java.lang.Override
    public void onDestroyView() {
    }
}