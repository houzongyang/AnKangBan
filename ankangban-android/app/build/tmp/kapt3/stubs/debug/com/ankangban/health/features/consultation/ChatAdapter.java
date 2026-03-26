package com.ankangban.health.features.consultation;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u000f\u0010B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006H\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/ankangban/health/features/consultation/ChatAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/ankangban/health/ui/viewmodel/ConsultationViewModel$UiMessage;", "Lcom/ankangban/health/features/consultation/ChatAdapter$MessageViewHolder;", "()V", "getItemViewType", "", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "MessageDiffCallback", "MessageViewHolder", "app_debug"})
public final class ChatAdapter extends androidx.recyclerview.widget.ListAdapter<com.ankangban.health.ui.viewmodel.ConsultationViewModel.UiMessage, com.ankangban.health.features.consultation.ChatAdapter.MessageViewHolder> {
    
    public ChatAdapter() {
        super(null);
    }
    
    @java.lang.Override
    public int getItemViewType(int position) {
        return 0;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public com.ankangban.health.features.consultation.ChatAdapter.MessageViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.ankangban.health.features.consultation.ChatAdapter.MessageViewHolder holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/ankangban/health/features/consultation/ChatAdapter$MessageDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/ankangban/health/ui/viewmodel/ConsultationViewModel$UiMessage;", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "app_debug"})
    public static final class MessageDiffCallback extends androidx.recyclerview.widget.DiffUtil.ItemCallback<com.ankangban.health.ui.viewmodel.ConsultationViewModel.UiMessage> {
        
        public MessageDiffCallback() {
            super();
        }
        
        @java.lang.Override
        public boolean areItemsTheSame(@org.jetbrains.annotations.NotNull
        com.ankangban.health.ui.viewmodel.ConsultationViewModel.UiMessage oldItem, @org.jetbrains.annotations.NotNull
        com.ankangban.health.ui.viewmodel.ConsultationViewModel.UiMessage newItem) {
            return false;
        }
        
        @java.lang.Override
        public boolean areContentsTheSame(@org.jetbrains.annotations.NotNull
        com.ankangban.health.ui.viewmodel.ConsultationViewModel.UiMessage oldItem, @org.jetbrains.annotations.NotNull
        com.ankangban.health.ui.viewmodel.ConsultationViewModel.UiMessage newItem) {
            return false;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/ankangban/health/features/consultation/ChatAdapter$MessageViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "ivAvatar", "Landroid/widget/ImageView;", "ivImage", "tvContent", "Landroid/widget/TextView;", "tvSender", "bind", "", "message", "Lcom/ankangban/health/ui/viewmodel/ConsultationViewModel$UiMessage;", "app_debug"})
    public static final class MessageViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull
        private final android.widget.TextView tvContent = null;
        @org.jetbrains.annotations.Nullable
        private final android.widget.ImageView ivAvatar = null;
        @org.jetbrains.annotations.Nullable
        private final android.widget.TextView tvSender = null;
        @org.jetbrains.annotations.Nullable
        private final android.widget.ImageView ivImage = null;
        
        public MessageViewHolder(@org.jetbrains.annotations.NotNull
        android.view.View itemView) {
            super(null);
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull
        com.ankangban.health.ui.viewmodel.ConsultationViewModel.UiMessage message) {
        }
    }
}