package com.ankangban.health.features.sleep.tools;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001:\u0002/0B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000fH\u0002J$\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010#\u001a\u00020$H\u0016J\u001a\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\u001c2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010\'\u001a\u00020$H\u0002J\u0010\u0010(\u001a\u00020$2\u0006\u0010)\u001a\u00020\nH\u0002J\b\u0010*\u001a\u00020$H\u0002J\b\u0010+\u001a\u00020$H\u0002J\b\u0010,\u001a\u00020$H\u0002J\b\u0010-\u001a\u00020$H\u0002J\b\u0010.\u001a\u00020$H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015\u00a8\u00061"}, d2 = {"Lcom/ankangban/health/features/sleep/tools/MeditationBottomSheet;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "()V", "_binding", "Lcom/ankangban/health/databinding/FragmentMeditationBottomSheetBinding;", "binding", "getBinding", "()Lcom/ankangban/health/databinding/FragmentMeditationBottomSheetBinding;", "courses", "", "Lcom/ankangban/health/features/sleep/tools/MeditationBottomSheet$Course;", "currentCourse", "isPlaying", "", "remainingMillis", "", "timer", "Landroid/os/CountDownTimer;", "viewModel", "Lcom/ankangban/health/ui/viewmodel/SleepToolsViewModel;", "getViewModel", "()Lcom/ankangban/health/ui/viewmodel/SleepToolsViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "formatTime", "", "millis", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "", "onViewCreated", "view", "pausePlayback", "playCourse", "course", "setupClickListeners", "setupRecyclerView", "startPlayback", "togglePlay", "updateStatus", "Course", "CourseAdapter", "app_debug"})
public final class MeditationBottomSheet extends com.google.android.material.bottomsheet.BottomSheetDialogFragment {
    @org.jetbrains.annotations.Nullable
    private com.ankangban.health.databinding.FragmentMeditationBottomSheetBinding _binding;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy viewModel$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.ankangban.health.features.sleep.tools.MeditationBottomSheet.Course> courses = null;
    @org.jetbrains.annotations.Nullable
    private com.ankangban.health.features.sleep.tools.MeditationBottomSheet.Course currentCourse;
    private boolean isPlaying = false;
    @org.jetbrains.annotations.Nullable
    private android.os.CountDownTimer timer;
    private long remainingMillis = 0L;
    
    public MeditationBottomSheet() {
        super();
    }
    
    private final com.ankangban.health.databinding.FragmentMeditationBottomSheetBinding getBinding() {
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
    
    private final void setupRecyclerView() {
    }
    
    private final void setupClickListeners() {
    }
    
    private final void playCourse(com.ankangban.health.features.sleep.tools.MeditationBottomSheet.Course course) {
    }
    
    private final void togglePlay() {
    }
    
    private final void startPlayback() {
    }
    
    private final void pausePlayback() {
    }
    
    private final void updateStatus() {
    }
    
    private final java.lang.String formatTime(long millis) {
        return null;
    }
    
    @java.lang.Override
    public void onDestroyView() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0006H\u00c6\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u00c6\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0017\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\u0018\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n\u00a8\u0006\u0019"}, d2 = {"Lcom/ankangban/health/features/sleep/tools/MeditationBottomSheet$Course;", "", "name", "", "description", "durationMinutes", "", "iconRes", "(Ljava/lang/String;Ljava/lang/String;II)V", "getDescription", "()Ljava/lang/String;", "getDurationMinutes", "()I", "getIconRes", "getName", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "app_debug"})
    public static final class Course {
        @org.jetbrains.annotations.NotNull
        private final java.lang.String name = null;
        @org.jetbrains.annotations.NotNull
        private final java.lang.String description = null;
        private final int durationMinutes = 0;
        private final int iconRes = 0;
        
        public Course(@org.jetbrains.annotations.NotNull
        java.lang.String name, @org.jetbrains.annotations.NotNull
        java.lang.String description, int durationMinutes, int iconRes) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getName() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getDescription() {
            return null;
        }
        
        public final int getDurationMinutes() {
            return 0;
        }
        
        public final int getIconRes() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component2() {
            return null;
        }
        
        public final int component3() {
            return 0;
        }
        
        public final int component4() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.ankangban.health.features.sleep.tools.MeditationBottomSheet.Course copy(@org.jetbrains.annotations.NotNull
        java.lang.String name, @org.jetbrains.annotations.NotNull
        java.lang.String description, int durationMinutes, int iconRes) {
            return null;
        }
        
        @java.lang.Override
        public boolean equals(@org.jetbrains.annotations.Nullable
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public java.lang.String toString() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u0010\u0012\f\u0012\n0\u0002R\u00060\u0000R\u00020\u00030\u0001:\u0001\u0014B\'\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\fH\u0016J \u0010\r\u001a\u00020\t2\u000e\u0010\u000e\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\u000f\u001a\u00020\fH\u0016J \u0010\u0010\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\fH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/ankangban/health/features/sleep/tools/MeditationBottomSheet$CourseAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/ankangban/health/features/sleep/tools/MeditationBottomSheet$CourseAdapter$ViewHolder;", "Lcom/ankangban/health/features/sleep/tools/MeditationBottomSheet;", "list", "", "Lcom/ankangban/health/features/sleep/tools/MeditationBottomSheet$Course;", "onItemClick", "Lkotlin/Function1;", "", "(Lcom/ankangban/health/features/sleep/tools/MeditationBottomSheet;Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_debug"})
    public final class CourseAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.ankangban.health.features.sleep.tools.MeditationBottomSheet.CourseAdapter.ViewHolder> {
        @org.jetbrains.annotations.NotNull
        private final java.util.List<com.ankangban.health.features.sleep.tools.MeditationBottomSheet.Course> list = null;
        @org.jetbrains.annotations.NotNull
        private final kotlin.jvm.functions.Function1<com.ankangban.health.features.sleep.tools.MeditationBottomSheet.Course, kotlin.Unit> onItemClick = null;
        
        public CourseAdapter(@org.jetbrains.annotations.NotNull
        java.util.List<com.ankangban.health.features.sleep.tools.MeditationBottomSheet.Course> list, @org.jetbrains.annotations.NotNull
        kotlin.jvm.functions.Function1<? super com.ankangban.health.features.sleep.tools.MeditationBottomSheet.Course, kotlin.Unit> onItemClick) {
            super();
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public com.ankangban.health.features.sleep.tools.MeditationBottomSheet.CourseAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
        android.view.ViewGroup parent, int viewType) {
            return null;
        }
        
        @java.lang.Override
        public void onBindViewHolder(@org.jetbrains.annotations.NotNull
        com.ankangban.health.features.sleep.tools.MeditationBottomSheet.CourseAdapter.ViewHolder holder, int position) {
        }
        
        @java.lang.Override
        public int getItemCount() {
            return 0;
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u000f\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\f\u00a8\u0006\u0015"}, d2 = {"Lcom/ankangban/health/features/sleep/tools/MeditationBottomSheet$CourseAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/ankangban/health/features/sleep/tools/MeditationBottomSheet$CourseAdapter;Landroid/view/View;)V", "ivIcon", "Landroid/widget/ImageView;", "getIvIcon", "()Landroid/widget/ImageView;", "tvDesc", "Landroid/widget/TextView;", "getTvDesc", "()Landroid/widget/TextView;", "tvDuration", "getTvDuration", "tvName", "getTvName", "bind", "", "course", "Lcom/ankangban/health/features/sleep/tools/MeditationBottomSheet$Course;", "app_debug"})
        public final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
            @org.jetbrains.annotations.NotNull
            private final android.widget.TextView tvName = null;
            @org.jetbrains.annotations.NotNull
            private final android.widget.TextView tvDesc = null;
            @org.jetbrains.annotations.NotNull
            private final android.widget.TextView tvDuration = null;
            @org.jetbrains.annotations.NotNull
            private final android.widget.ImageView ivIcon = null;
            
            public ViewHolder(@org.jetbrains.annotations.NotNull
            android.view.View view) {
                super(null);
            }
            
            @org.jetbrains.annotations.NotNull
            public final android.widget.TextView getTvName() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull
            public final android.widget.TextView getTvDesc() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull
            public final android.widget.TextView getTvDuration() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull
            public final android.widget.ImageView getIvIcon() {
                return null;
            }
            
            public final void bind(@org.jetbrains.annotations.NotNull
            com.ankangban.health.features.sleep.tools.MeditationBottomSheet.Course course) {
            }
        }
    }
}