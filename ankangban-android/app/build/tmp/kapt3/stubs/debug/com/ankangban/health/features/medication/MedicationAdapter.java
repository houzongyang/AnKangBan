package com.ankangban.health.features.medication;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u0010\u0011B\u0019\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\u0007J\u001c\u0010\b\u001a\u00020\u00062\n\u0010\t\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001c\u0010\f\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000bH\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/ankangban/health/features/medication/MedicationAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/ankangban/health/core/storage/dao/MedicationDao$MedicationWithReminders;", "Lcom/ankangban/health/features/medication/MedicationAdapter$ViewHolder;", "onEditClick", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;)V", "onBindViewHolder", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "DiffCallback", "ViewHolder", "app_debug"})
public final class MedicationAdapter extends androidx.recyclerview.widget.ListAdapter<com.ankangban.health.core.storage.dao.MedicationDao.MedicationWithReminders, com.ankangban.health.features.medication.MedicationAdapter.ViewHolder> {
    @org.jetbrains.annotations.NotNull
    private final kotlin.jvm.functions.Function1<com.ankangban.health.core.storage.dao.MedicationDao.MedicationWithReminders, kotlin.Unit> onEditClick = null;
    
    public MedicationAdapter(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super com.ankangban.health.core.storage.dao.MedicationDao.MedicationWithReminders, kotlin.Unit> onEditClick) {
        super(null);
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public com.ankangban.health.features.medication.MedicationAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.ankangban.health.features.medication.MedicationAdapter.ViewHolder holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/ankangban/health/features/medication/MedicationAdapter$DiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/ankangban/health/core/storage/dao/MedicationDao$MedicationWithReminders;", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "app_debug"})
    public static final class DiffCallback extends androidx.recyclerview.widget.DiffUtil.ItemCallback<com.ankangban.health.core.storage.dao.MedicationDao.MedicationWithReminders> {
        @org.jetbrains.annotations.NotNull
        public static final com.ankangban.health.features.medication.MedicationAdapter.DiffCallback INSTANCE = null;
        
        private DiffCallback() {
            super();
        }
        
        @java.lang.Override
        public boolean areItemsTheSame(@org.jetbrains.annotations.NotNull
        com.ankangban.health.core.storage.dao.MedicationDao.MedicationWithReminders oldItem, @org.jetbrains.annotations.NotNull
        com.ankangban.health.core.storage.dao.MedicationDao.MedicationWithReminders newItem) {
            return false;
        }
        
        @java.lang.Override
        public boolean areContentsTheSame(@org.jetbrains.annotations.NotNull
        com.ankangban.health.core.storage.dao.MedicationDao.MedicationWithReminders oldItem, @org.jetbrains.annotations.NotNull
        com.ankangban.health.core.storage.dao.MedicationDao.MedicationWithReminders newItem) {
            return false;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/ankangban/health/features/medication/MedicationAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/ankangban/health/databinding/ItemMedicationBinding;", "(Lcom/ankangban/health/features/medication/MedicationAdapter;Lcom/ankangban/health/databinding/ItemMedicationBinding;)V", "bind", "", "item", "Lcom/ankangban/health/core/storage/dao/MedicationDao$MedicationWithReminders;", "app_debug"})
    public final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull
        private final com.ankangban.health.databinding.ItemMedicationBinding binding = null;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull
        com.ankangban.health.databinding.ItemMedicationBinding binding) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull
        com.ankangban.health.core.storage.dao.MedicationDao.MedicationWithReminders item) {
        }
    }
}