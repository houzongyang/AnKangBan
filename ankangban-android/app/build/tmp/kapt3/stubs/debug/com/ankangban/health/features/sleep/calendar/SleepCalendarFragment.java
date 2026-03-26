package com.ankangban.health.features.sleep.calendar;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001 B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0002J$\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u000fH\u0016J\u001a\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u001b\u001a\u00020\u000fH\u0002J\u0016\u0010\u001c\u001a\u00020\u000f2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b\u00a8\u0006!"}, d2 = {"Lcom/ankangban/health/features/sleep/calendar/SleepCalendarFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lcom/ankangban/health/databinding/FragmentSleepCalendarBinding;", "binding", "getBinding", "()Lcom/ankangban/health/databinding/FragmentSleepCalendarBinding;", "viewModel", "Lcom/ankangban/health/ui/viewmodel/SleepImprovementViewModel;", "getViewModel", "()Lcom/ankangban/health/ui/viewmodel/SleepImprovementViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "observeViewModel", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onViewCreated", "view", "setupUI", "updateCheckInButtonState", "history", "", "Lcom/ankangban/health/core/storage/SleepCheckInEntity;", "CheckInAdapter", "app_debug"})
public final class SleepCalendarFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.Nullable
    private com.ankangban.health.databinding.FragmentSleepCalendarBinding _binding;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy viewModel$delegate = null;
    
    public SleepCalendarFragment() {
        super();
    }
    
    private final com.ankangban.health.databinding.FragmentSleepCalendarBinding getBinding() {
        return null;
    }
    
    private final com.ankangban.health.ui.viewmodel.SleepImprovementViewModel getViewModel() {
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
    
    private final void setupUI() {
    }
    
    private final void observeViewModel() {
    }
    
    private final void updateCheckInButtonState(java.util.List<com.ankangban.health.core.storage.SleepCheckInEntity> history) {
    }
    
    @java.lang.Override
    public void onDestroyView() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0013B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\bH\u0016J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\bH\u0016J\u0014\u0010\u0011\u001a\u00020\n2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/ankangban/health/features/sleep/calendar/SleepCalendarFragment$CheckInAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/ankangban/health/features/sleep/calendar/SleepCalendarFragment$CheckInAdapter$ViewHolder;", "()V", "list", "", "Lcom/ankangban/health/core/storage/SleepCheckInEntity;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "submitList", "newList", "ViewHolder", "app_debug"})
    public static final class CheckInAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.ankangban.health.features.sleep.calendar.SleepCalendarFragment.CheckInAdapter.ViewHolder> {
        @org.jetbrains.annotations.NotNull
        private java.util.List<com.ankangban.health.core.storage.SleepCheckInEntity> list;
        
        public CheckInAdapter() {
            super();
        }
        
        public final void submitList(@org.jetbrains.annotations.NotNull
        java.util.List<com.ankangban.health.core.storage.SleepCheckInEntity> newList) {
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public com.ankangban.health.features.sleep.calendar.SleepCalendarFragment.CheckInAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
        android.view.ViewGroup parent, int viewType) {
            return null;
        }
        
        @java.lang.Override
        public void onBindViewHolder(@org.jetbrains.annotations.NotNull
        com.ankangban.health.features.sleep.calendar.SleepCalendarFragment.CheckInAdapter.ViewHolder holder, int position) {
        }
        
        @java.lang.Override
        public int getItemCount() {
            return 0;
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/ankangban/health/features/sleep/calendar/SleepCalendarFragment$CheckInAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "text1", "Landroid/widget/TextView;", "getText1", "()Landroid/widget/TextView;", "text2", "getText2", "app_debug"})
        public static final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
            @org.jetbrains.annotations.NotNull
            private final android.widget.TextView text1 = null;
            @org.jetbrains.annotations.NotNull
            private final android.widget.TextView text2 = null;
            
            public ViewHolder(@org.jetbrains.annotations.NotNull
            android.view.View view) {
                super(null);
            }
            
            @org.jetbrains.annotations.NotNull
            public final android.widget.TextView getText1() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull
            public final android.widget.TextView getText2() {
                return null;
            }
        }
    }
}