package com.ankangban.health.features.consultation;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u001aH\u0002J$\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010$\u001a\u00020\u001aH\u0016J\u001a\u0010%\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020\u001d2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010\'\u001a\u00020\u001aH\u0002J\u0010\u0010(\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020*H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0010\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u000e0\u000e0\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0010\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u000e0\u000e0\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0010\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u000e0\u000e0\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u0010\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u000b0\u000b0\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006+"}, d2 = {"Lcom/ankangban/health/features/consultation/ConsultationFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lcom/ankangban/health/databinding/FragmentConsultationBinding;", "binding", "getBinding", "()Lcom/ankangban/health/databinding/FragmentConsultationBinding;", "chatAdapter", "Lcom/ankangban/health/features/consultation/ChatAdapter;", "photoUri", "Landroid/net/Uri;", "pickFileLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "kotlin.jvm.PlatformType", "pickImageLauncher", "requestCameraPermissionLauncher", "takePictureLauncher", "viewModel", "Lcom/ankangban/health/ui/viewmodel/ConsultationViewModel;", "getViewModel", "()Lcom/ankangban/health/ui/viewmodel/ConsultationViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "launchCamera", "", "observeViewModel", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onViewCreated", "view", "setupUI", "updateModeUI", "mode", "Lcom/ankangban/health/ui/viewmodel/ConsultationViewModel$ConsultationMode;", "app_debug"})
public final class ConsultationFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.Nullable
    private com.ankangban.health.databinding.FragmentConsultationBinding _binding;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy viewModel$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final com.ankangban.health.features.consultation.ChatAdapter chatAdapter = null;
    @org.jetbrains.annotations.Nullable
    private android.net.Uri photoUri;
    @org.jetbrains.annotations.NotNull
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String> requestCameraPermissionLauncher = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.activity.result.ActivityResultLauncher<android.net.Uri> takePictureLauncher = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String> pickImageLauncher = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String> pickFileLauncher = null;
    
    public ConsultationFragment() {
        super();
    }
    
    private final com.ankangban.health.databinding.FragmentConsultationBinding getBinding() {
        return null;
    }
    
    private final com.ankangban.health.ui.viewmodel.ConsultationViewModel getViewModel() {
        return null;
    }
    
    private final void launchCamera() {
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
    
    private final void setupUI() {
    }
    
    private final void observeViewModel() {
    }
    
    private final void updateModeUI(com.ankangban.health.ui.viewmodel.ConsultationViewModel.ConsultationMode mode) {
    }
    
    @java.lang.Override
    public void onDestroyView() {
    }
}