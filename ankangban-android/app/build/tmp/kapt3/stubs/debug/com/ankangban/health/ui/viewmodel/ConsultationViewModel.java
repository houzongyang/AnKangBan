package com.ankangban.health.ui.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0005*+,-.B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0017H\u0002J\b\u0010 \u001a\u00020\u001eH\u0002J\b\u0010!\u001a\u00020\u001eH\u0002J$\u0010\"\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\u00172\b\b\u0002\u0010$\u001a\u00020%2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0017J\u0010\u0010\'\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0017H\u0002J\u000e\u0010(\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020\tR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u001d\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006/"}, d2 = {"Lcom/ankangban/health/ui/viewmodel/ConsultationViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "_currentDoctor", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/ankangban/health/ui/viewmodel/ConsultationViewModel$DoctorInfo;", "_currentMode", "Lcom/ankangban/health/ui/viewmodel/ConsultationViewModel$ConsultationMode;", "_messages", "", "Lcom/ankangban/health/ui/viewmodel/ConsultationViewModel$UiMessage;", "aiContext", "", "Lcom/ankangban/health/core/api/HunyuanService$ChatMessage;", "currentDoctor", "Lkotlinx/coroutines/flow/StateFlow;", "getCurrentDoctor", "()Lkotlinx/coroutines/flow/StateFlow;", "currentMode", "getCurrentMode", "healthData", "", "getHealthData", "messages", "getMessages", "repo", "Lcom/ankangban/health/core/repo/HealthRepository;", "generateAiReply", "", "userContent", "loadAiDemoMessages", "loadDoctorDemoMessages", "sendMessage", "content", "type", "Lcom/ankangban/health/ui/viewmodel/ConsultationViewModel$MessageType;", "uri", "simulateDoctorReply", "switchMode", "mode", "ConsultationMode", "DoctorInfo", "MessageStatus", "MessageType", "UiMessage", "app_debug"})
public final class ConsultationViewModel extends androidx.lifecycle.AndroidViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.ankangban.health.core.repo.HealthRepository repo = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.ankangban.health.ui.viewmodel.ConsultationViewModel.ConsultationMode> _currentMode = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.ankangban.health.ui.viewmodel.ConsultationViewModel.ConsultationMode> currentMode = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.ankangban.health.ui.viewmodel.ConsultationViewModel.UiMessage>> _messages = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.ankangban.health.ui.viewmodel.ConsultationViewModel.UiMessage>> messages = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<com.ankangban.health.ui.viewmodel.ConsultationViewModel.DoctorInfo> _currentDoctor = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.ankangban.health.ui.viewmodel.ConsultationViewModel.DoctorInfo> currentDoctor = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> healthData = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.ankangban.health.core.api.HunyuanService.ChatMessage> aiContext = null;
    
    public ConsultationViewModel(@org.jetbrains.annotations.NotNull
    android.app.Application application) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.ankangban.health.ui.viewmodel.ConsultationViewModel.ConsultationMode> getCurrentMode() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.ankangban.health.ui.viewmodel.ConsultationViewModel.UiMessage>> getMessages() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.ankangban.health.ui.viewmodel.ConsultationViewModel.DoctorInfo> getCurrentDoctor() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getHealthData() {
        return null;
    }
    
    public final void switchMode(@org.jetbrains.annotations.NotNull
    com.ankangban.health.ui.viewmodel.ConsultationViewModel.ConsultationMode mode) {
    }
    
    private final void loadDoctorDemoMessages() {
    }
    
    private final void loadAiDemoMessages() {
    }
    
    public final void sendMessage(@org.jetbrains.annotations.NotNull
    java.lang.String content, @org.jetbrains.annotations.NotNull
    com.ankangban.health.ui.viewmodel.ConsultationViewModel.MessageType type, @org.jetbrains.annotations.Nullable
    java.lang.String uri) {
    }
    
    private final void simulateDoctorReply(java.lang.String userContent) {
    }
    
    private final void generateAiReply(java.lang.String userContent) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/ankangban/health/ui/viewmodel/ConsultationViewModel$ConsultationMode;", "", "(Ljava/lang/String;I)V", "DOCTOR", "AI", "app_debug"})
    public static enum ConsultationMode {
        /*public static final*/ DOCTOR /* = new DOCTOR() */,
        /*public static final*/ AI /* = new AI() */;
        
        ConsultationMode() {
        }
        
        @org.jetbrains.annotations.NotNull
        public static kotlin.enums.EnumEntries<com.ankangban.health.ui.viewmodel.ConsultationViewModel.ConsultationMode> getEntries() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0018\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u00a2\u0006\u0002\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\bH\u00c6\u0003J\t\u0010\u001d\u001a\u00020\nH\u00c6\u0003J\t\u0010\u001e\u001a\u00020\fH\u00c6\u0003JO\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u00c6\u0001J\u0013\u0010 \u001a\u00020\f2\b\u0010!\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\"\u001a\u00020\nH\u00d6\u0001J\t\u0010#\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011\u00a8\u0006$"}, d2 = {"Lcom/ankangban/health/ui/viewmodel/ConsultationViewModel$DoctorInfo;", "", "name", "", "title", "department", "hospital", "rating", "", "count", "", "isOnline", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;DIZ)V", "getCount", "()I", "getDepartment", "()Ljava/lang/String;", "getHospital", "()Z", "getName", "getRating", "()D", "getTitle", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "app_debug"})
    public static final class DoctorInfo {
        @org.jetbrains.annotations.NotNull
        private final java.lang.String name = null;
        @org.jetbrains.annotations.NotNull
        private final java.lang.String title = null;
        @org.jetbrains.annotations.NotNull
        private final java.lang.String department = null;
        @org.jetbrains.annotations.NotNull
        private final java.lang.String hospital = null;
        private final double rating = 0.0;
        private final int count = 0;
        private final boolean isOnline = false;
        
        public DoctorInfo(@org.jetbrains.annotations.NotNull
        java.lang.String name, @org.jetbrains.annotations.NotNull
        java.lang.String title, @org.jetbrains.annotations.NotNull
        java.lang.String department, @org.jetbrains.annotations.NotNull
        java.lang.String hospital, double rating, int count, boolean isOnline) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getName() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getTitle() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getDepartment() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getHospital() {
            return null;
        }
        
        public final double getRating() {
            return 0.0;
        }
        
        public final int getCount() {
            return 0;
        }
        
        public final boolean isOnline() {
            return false;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component2() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component3() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component4() {
            return null;
        }
        
        public final double component5() {
            return 0.0;
        }
        
        public final int component6() {
            return 0;
        }
        
        public final boolean component7() {
            return false;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.ankangban.health.ui.viewmodel.ConsultationViewModel.DoctorInfo copy(@org.jetbrains.annotations.NotNull
        java.lang.String name, @org.jetbrains.annotations.NotNull
        java.lang.String title, @org.jetbrains.annotations.NotNull
        java.lang.String department, @org.jetbrains.annotations.NotNull
        java.lang.String hospital, double rating, int count, boolean isOnline) {
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/ankangban/health/ui/viewmodel/ConsultationViewModel$MessageStatus;", "", "(Ljava/lang/String;I)V", "SENDING", "SENT", "ERROR", "app_debug"})
    public static enum MessageStatus {
        /*public static final*/ SENDING /* = new SENDING() */,
        /*public static final*/ SENT /* = new SENT() */,
        /*public static final*/ ERROR /* = new ERROR() */;
        
        MessageStatus() {
        }
        
        @org.jetbrains.annotations.NotNull
        public static kotlin.enums.EnumEntries<com.ankangban.health.ui.viewmodel.ConsultationViewModel.MessageStatus> getEntries() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/ankangban/health/ui/viewmodel/ConsultationViewModel$MessageType;", "", "(Ljava/lang/String;I)V", "TEXT", "IMAGE", "REPORT_CARD", "app_debug"})
    public static enum MessageType {
        /*public static final*/ TEXT /* = new TEXT() */,
        /*public static final*/ IMAGE /* = new IMAGE() */,
        /*public static final*/ REPORT_CARD /* = new REPORT_CARD() */;
        
        MessageType() {
        }
        
        @org.jetbrains.annotations.NotNull
        public static kotlin.enums.EnumEntries<com.ankangban.health.ui.viewmodel.ConsultationViewModel.MessageType> getEntries() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B]\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0010J\t\u0010\u001e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010 \u001a\u00020\u0006H\u00c6\u0003J\t\u0010!\u001a\u00020\bH\u00c6\u0003J\t\u0010\"\u001a\u00020\u0003H\u00c6\u0003J\t\u0010#\u001a\u00020\u0003H\u00c6\u0003J\t\u0010$\u001a\u00020\fH\u00c6\u0003J\t\u0010%\u001a\u00020\u000eH\u00c6\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003Je\u0010\'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0013\u0010(\u001a\u00020\u00062\b\u0010)\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010*\u001a\u00020+H\u00d6\u0001J\t\u0010,\u001a\u00020\u0003H\u00d6\u0001R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0015R\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\n\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d\u00a8\u0006-"}, d2 = {"Lcom/ankangban/health/ui/viewmodel/ConsultationViewModel$UiMessage;", "", "id", "", "content", "isUser", "", "timestamp", "", "senderName", "senderRole", "type", "Lcom/ankangban/health/ui/viewmodel/ConsultationViewModel$MessageType;", "status", "Lcom/ankangban/health/ui/viewmodel/ConsultationViewModel$MessageStatus;", "attachmentUri", "(Ljava/lang/String;Ljava/lang/String;ZJLjava/lang/String;Ljava/lang/String;Lcom/ankangban/health/ui/viewmodel/ConsultationViewModel$MessageType;Lcom/ankangban/health/ui/viewmodel/ConsultationViewModel$MessageStatus;Ljava/lang/String;)V", "getAttachmentUri", "()Ljava/lang/String;", "getContent", "getId", "()Z", "getSenderName", "getSenderRole", "getStatus", "()Lcom/ankangban/health/ui/viewmodel/ConsultationViewModel$MessageStatus;", "getTimestamp", "()J", "getType", "()Lcom/ankangban/health/ui/viewmodel/ConsultationViewModel$MessageType;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "app_debug"})
    public static final class UiMessage {
        @org.jetbrains.annotations.NotNull
        private final java.lang.String id = null;
        @org.jetbrains.annotations.NotNull
        private final java.lang.String content = null;
        private final boolean isUser = false;
        private final long timestamp = 0L;
        @org.jetbrains.annotations.NotNull
        private final java.lang.String senderName = null;
        @org.jetbrains.annotations.NotNull
        private final java.lang.String senderRole = null;
        @org.jetbrains.annotations.NotNull
        private final com.ankangban.health.ui.viewmodel.ConsultationViewModel.MessageType type = null;
        @org.jetbrains.annotations.NotNull
        private final com.ankangban.health.ui.viewmodel.ConsultationViewModel.MessageStatus status = null;
        @org.jetbrains.annotations.Nullable
        private final java.lang.String attachmentUri = null;
        
        public UiMessage(@org.jetbrains.annotations.NotNull
        java.lang.String id, @org.jetbrains.annotations.NotNull
        java.lang.String content, boolean isUser, long timestamp, @org.jetbrains.annotations.NotNull
        java.lang.String senderName, @org.jetbrains.annotations.NotNull
        java.lang.String senderRole, @org.jetbrains.annotations.NotNull
        com.ankangban.health.ui.viewmodel.ConsultationViewModel.MessageType type, @org.jetbrains.annotations.NotNull
        com.ankangban.health.ui.viewmodel.ConsultationViewModel.MessageStatus status, @org.jetbrains.annotations.Nullable
        java.lang.String attachmentUri) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getId() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getContent() {
            return null;
        }
        
        public final boolean isUser() {
            return false;
        }
        
        public final long getTimestamp() {
            return 0L;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getSenderName() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getSenderRole() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.ankangban.health.ui.viewmodel.ConsultationViewModel.MessageType getType() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.ankangban.health.ui.viewmodel.ConsultationViewModel.MessageStatus getStatus() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.String getAttachmentUri() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component2() {
            return null;
        }
        
        public final boolean component3() {
            return false;
        }
        
        public final long component4() {
            return 0L;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component5() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component6() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.ankangban.health.ui.viewmodel.ConsultationViewModel.MessageType component7() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.ankangban.health.ui.viewmodel.ConsultationViewModel.MessageStatus component8() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final java.lang.String component9() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.ankangban.health.ui.viewmodel.ConsultationViewModel.UiMessage copy(@org.jetbrains.annotations.NotNull
        java.lang.String id, @org.jetbrains.annotations.NotNull
        java.lang.String content, boolean isUser, long timestamp, @org.jetbrains.annotations.NotNull
        java.lang.String senderName, @org.jetbrains.annotations.NotNull
        java.lang.String senderRole, @org.jetbrains.annotations.NotNull
        com.ankangban.health.ui.viewmodel.ConsultationViewModel.MessageType type, @org.jetbrains.annotations.NotNull
        com.ankangban.health.ui.viewmodel.ConsultationViewModel.MessageStatus status, @org.jetbrains.annotations.Nullable
        java.lang.String attachmentUri) {
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