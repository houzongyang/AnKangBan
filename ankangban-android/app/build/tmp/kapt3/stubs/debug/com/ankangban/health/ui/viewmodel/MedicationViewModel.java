package com.ankangban.health.ui.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001,B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017J\u000e\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001bJ\u0016\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u000f2\u0006\u0010\u001d\u001a\u00020\u001eJ\u0006\u0010\u001f\u001a\u00020\u0015JX\u0010 \u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020&2\u0006\u0010\'\u001a\u00020\"2\b\u0010(\u001a\u0004\u0018\u00010\"2\b\u0010)\u001a\u0004\u0018\u00010\"2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020+0\nR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006-"}, d2 = {"Lcom/ankangban/health/ui/viewmodel/MedicationViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "_parseState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/ankangban/health/ui/viewmodel/MedicationViewModel$ParseState;", "medications", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/ankangban/health/core/storage/dao/MedicationDao$MedicationWithReminders;", "getMedications", "()Lkotlinx/coroutines/flow/Flow;", "parseState", "Lkotlinx/coroutines/flow/StateFlow;", "getParseState", "()Lkotlinx/coroutines/flow/StateFlow;", "repository", "Lcom/ankangban/health/core/repo/MedicationRepository;", "analyzeImages", "", "frontUri", "Landroid/net/Uri;", "sideUri", "deleteMedication", "medication", "Lcom/ankangban/health/core/storage/entity/MedicationEntity;", "getMedication", "id", "", "resetParseState", "saveMedication", "name", "", "dosage", "frequency", "stock", "", "unit", "imageUri", "sideImageUri", "reminders", "Lcom/ankangban/health/core/storage/entity/ReminderEntity;", "ParseState", "app_debug"})
public final class MedicationViewModel extends androidx.lifecycle.AndroidViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.ankangban.health.core.repo.MedicationRepository repository = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.Flow<java.util.List<com.ankangban.health.core.storage.dao.MedicationDao.MedicationWithReminders>> medications = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.ankangban.health.ui.viewmodel.MedicationViewModel.ParseState> _parseState = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.ankangban.health.ui.viewmodel.MedicationViewModel.ParseState> parseState = null;
    
    public MedicationViewModel(@org.jetbrains.annotations.NotNull
    android.app.Application application) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.ankangban.health.core.storage.dao.MedicationDao.MedicationWithReminders>> getMedications() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.ankangban.health.ui.viewmodel.MedicationViewModel.ParseState> getParseState() {
        return null;
    }
    
    public final void analyzeImages(@org.jetbrains.annotations.NotNull
    android.net.Uri frontUri, @org.jetbrains.annotations.Nullable
    android.net.Uri sideUri) {
    }
    
    public final void resetParseState() {
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.ankangban.health.core.storage.dao.MedicationDao.MedicationWithReminders> getMedication(long id) {
        return null;
    }
    
    public final void saveMedication(long id, @org.jetbrains.annotations.NotNull
    java.lang.String name, @org.jetbrains.annotations.NotNull
    java.lang.String dosage, @org.jetbrains.annotations.NotNull
    java.lang.String frequency, int stock, @org.jetbrains.annotations.NotNull
    java.lang.String unit, @org.jetbrains.annotations.Nullable
    java.lang.String imageUri, @org.jetbrains.annotations.Nullable
    java.lang.String sideImageUri, @org.jetbrains.annotations.NotNull
    java.util.List<com.ankangban.health.core.storage.entity.ReminderEntity> reminders) {
    }
    
    public final void deleteMedication(@org.jetbrains.annotations.NotNull
    com.ankangban.health.core.storage.entity.MedicationEntity medication) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0003\u0004\u0005\u0006\u0007B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0005\b\t\n\u000b\f\u00a8\u0006\r"}, d2 = {"Lcom/ankangban/health/ui/viewmodel/MedicationViewModel$ParseState;", "", "()V", "Analyzing", "Error", "Idle", "Scanning", "Success", "Lcom/ankangban/health/ui/viewmodel/MedicationViewModel$ParseState$Analyzing;", "Lcom/ankangban/health/ui/viewmodel/MedicationViewModel$ParseState$Error;", "Lcom/ankangban/health/ui/viewmodel/MedicationViewModel$ParseState$Idle;", "Lcom/ankangban/health/ui/viewmodel/MedicationViewModel$ParseState$Scanning;", "Lcom/ankangban/health/ui/viewmodel/MedicationViewModel$ParseState$Success;", "app_debug"})
    public static abstract class ParseState {
        
        private ParseState() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/ankangban/health/ui/viewmodel/MedicationViewModel$ParseState$Analyzing;", "Lcom/ankangban/health/ui/viewmodel/MedicationViewModel$ParseState;", "()V", "app_debug"})
        public static final class Analyzing extends com.ankangban.health.ui.viewmodel.MedicationViewModel.ParseState {
            @org.jetbrains.annotations.NotNull
            public static final com.ankangban.health.ui.viewmodel.MedicationViewModel.ParseState.Analyzing INSTANCE = null;
            
            private Analyzing() {
            }
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/ankangban/health/ui/viewmodel/MedicationViewModel$ParseState$Error;", "Lcom/ankangban/health/ui/viewmodel/MedicationViewModel$ParseState;", "message", "", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_debug"})
        public static final class Error extends com.ankangban.health.ui.viewmodel.MedicationViewModel.ParseState {
            @org.jetbrains.annotations.NotNull
            private final java.lang.String message = null;
            
            public Error(@org.jetbrains.annotations.NotNull
            java.lang.String message) {
            }
            
            @org.jetbrains.annotations.NotNull
            public final java.lang.String getMessage() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull
            public final java.lang.String component1() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull
            public final com.ankangban.health.ui.viewmodel.MedicationViewModel.ParseState.Error copy(@org.jetbrains.annotations.NotNull
            java.lang.String message) {
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
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/ankangban/health/ui/viewmodel/MedicationViewModel$ParseState$Idle;", "Lcom/ankangban/health/ui/viewmodel/MedicationViewModel$ParseState;", "()V", "app_debug"})
        public static final class Idle extends com.ankangban.health.ui.viewmodel.MedicationViewModel.ParseState {
            @org.jetbrains.annotations.NotNull
            public static final com.ankangban.health.ui.viewmodel.MedicationViewModel.ParseState.Idle INSTANCE = null;
            
            private Idle() {
            }
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/ankangban/health/ui/viewmodel/MedicationViewModel$ParseState$Scanning;", "Lcom/ankangban/health/ui/viewmodel/MedicationViewModel$ParseState;", "()V", "app_debug"})
        public static final class Scanning extends com.ankangban.health.ui.viewmodel.MedicationViewModel.ParseState {
            @org.jetbrains.annotations.NotNull
            public static final com.ankangban.health.ui.viewmodel.MedicationViewModel.ParseState.Scanning INSTANCE = null;
            
            private Scanning() {
            }
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/ankangban/health/ui/viewmodel/MedicationViewModel$ParseState$Success;", "Lcom/ankangban/health/ui/viewmodel/MedicationViewModel$ParseState;", "result", "Lcom/ankangban/health/core/api/MedicationParseResponse;", "(Lcom/ankangban/health/core/api/MedicationParseResponse;)V", "getResult", "()Lcom/ankangban/health/core/api/MedicationParseResponse;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_debug"})
        public static final class Success extends com.ankangban.health.ui.viewmodel.MedicationViewModel.ParseState {
            @org.jetbrains.annotations.NotNull
            private final com.ankangban.health.core.api.MedicationParseResponse result = null;
            
            public Success(@org.jetbrains.annotations.NotNull
            com.ankangban.health.core.api.MedicationParseResponse result) {
            }
            
            @org.jetbrains.annotations.NotNull
            public final com.ankangban.health.core.api.MedicationParseResponse getResult() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull
            public final com.ankangban.health.core.api.MedicationParseResponse component1() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull
            public final com.ankangban.health.ui.viewmodel.MedicationViewModel.ParseState.Success copy(@org.jetbrains.annotations.NotNull
            com.ankangban.health.core.api.MedicationParseResponse result) {
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
    }
}