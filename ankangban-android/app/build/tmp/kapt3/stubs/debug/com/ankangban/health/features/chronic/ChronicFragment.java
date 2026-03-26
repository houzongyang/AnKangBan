package com.ankangban.health.features.chronic;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u001eB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J&\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u001a\u0010\u0016\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0010\u0010\u0017\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\fH\u0002J\b\u0010\u001c\u001a\u00020\fH\u0002J\b\u0010\u001d\u001a\u00020\fH\u0002R\u0012\u0010\u0003\u001a\u00060\u0004R\u00020\u0000X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u001f"}, d2 = {"Lcom/ankangban/health/features/chronic/ChronicFragment;", "Landroidx/fragment/app/Fragment;", "()V", "planAdapter", "Lcom/ankangban/health/features/chronic/ChronicFragment$PlanAdapter;", "viewModel", "Lcom/ankangban/health/ui/viewmodel/ChronicViewModel;", "getViewModel", "()Lcom/ankangban/health/ui/viewmodel/ChronicViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "observeViewModel", "", "view", "Landroid/view/View;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "setupUI", "showPlanEvidenceDialog", "plan", "Lcom/ankangban/health/core/storage/ChronicPlanEntity;", "showRiskDetailDialog", "showTrendDialog", "showTypeDialog", "PlanAdapter", "app_debug"})
public final class ChronicFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy viewModel$delegate = null;
    private com.ankangban.health.features.chronic.ChronicFragment.PlanAdapter planAdapter;
    
    public ChronicFragment() {
        super();
    }
    
    private final com.ankangban.health.ui.viewmodel.ChronicViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
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
    
    private final void setupUI(android.view.View view) {
    }
    
    private final void observeViewModel(android.view.View view) {
    }
    
    private final void showTypeDialog() {
    }
    
    private final void showTrendDialog() {
    }
    
    private final void showRiskDetailDialog() {
    }
    
    private final void showPlanEvidenceDialog(com.ankangban.health.core.storage.ChronicPlanEntity plan) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u0010\u0012\f\u0012\n0\u0002R\u00060\u0000R\u00020\u00030\u0001:\u0001\u0016B\u0019\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u00a2\u0006\u0002\u0010\bJ\b\u0010\u000b\u001a\u00020\fH\u0016J \u0010\r\u001a\u00020\u00072\u000e\u0010\u000e\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\u000f\u001a\u00020\fH\u0016J \u0010\u0010\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\fH\u0016J\u0014\u0010\u0014\u001a\u00020\u00072\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\nR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/ankangban/health/features/chronic/ChronicFragment$PlanAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/ankangban/health/features/chronic/ChronicFragment$PlanAdapter$PlanViewHolder;", "Lcom/ankangban/health/features/chronic/ChronicFragment;", "onClick", "Lkotlin/Function1;", "Lcom/ankangban/health/core/storage/ChronicPlanEntity;", "", "(Lcom/ankangban/health/features/chronic/ChronicFragment;Lkotlin/jvm/functions/Function1;)V", "items", "", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "submitList", "newItems", "PlanViewHolder", "app_debug"})
    public final class PlanAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.ankangban.health.features.chronic.ChronicFragment.PlanAdapter.PlanViewHolder> {
        @org.jetbrains.annotations.NotNull
        private final kotlin.jvm.functions.Function1<com.ankangban.health.core.storage.ChronicPlanEntity, kotlin.Unit> onClick = null;
        @org.jetbrains.annotations.NotNull
        private java.util.List<com.ankangban.health.core.storage.ChronicPlanEntity> items;
        
        public PlanAdapter(@org.jetbrains.annotations.NotNull
        kotlin.jvm.functions.Function1<? super com.ankangban.health.core.storage.ChronicPlanEntity, kotlin.Unit> onClick) {
            super();
        }
        
        public final void submitList(@org.jetbrains.annotations.NotNull
        java.util.List<com.ankangban.health.core.storage.ChronicPlanEntity> newItems) {
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public com.ankangban.health.features.chronic.ChronicFragment.PlanAdapter.PlanViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
        android.view.ViewGroup parent, int viewType) {
            return null;
        }
        
        @java.lang.Override
        public void onBindViewHolder(@org.jetbrains.annotations.NotNull
        com.ankangban.health.features.chronic.ChronicFragment.PlanAdapter.PlanViewHolder holder, int position) {
        }
        
        @java.lang.Override
        public int getItemCount() {
            return 0;
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/ankangban/health/features/chronic/ChronicFragment$PlanAdapter$PlanViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/ankangban/health/features/chronic/ChronicFragment$PlanAdapter;Landroid/view/View;)V", "btnAction", "Lcom/google/android/material/button/MaterialButton;", "ivIcon", "Landroid/widget/ImageView;", "tvDesc", "Landroid/widget/TextView;", "tvStatus", "tvTitle", "bind", "", "item", "Lcom/ankangban/health/core/storage/ChronicPlanEntity;", "app_debug"})
        public final class PlanViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
            @org.jetbrains.annotations.NotNull
            private final android.widget.TextView tvTitle = null;
            @org.jetbrains.annotations.NotNull
            private final android.widget.TextView tvDesc = null;
            @org.jetbrains.annotations.NotNull
            private final android.widget.TextView tvStatus = null;
            @org.jetbrains.annotations.NotNull
            private final android.widget.ImageView ivIcon = null;
            @org.jetbrains.annotations.NotNull
            private final com.google.android.material.button.MaterialButton btnAction = null;
            
            public PlanViewHolder(@org.jetbrains.annotations.NotNull
            android.view.View itemView) {
                super(null);
            }
            
            public final void bind(@org.jetbrains.annotations.NotNull
            com.ankangban.health.core.storage.ChronicPlanEntity item) {
            }
        }
    }
}