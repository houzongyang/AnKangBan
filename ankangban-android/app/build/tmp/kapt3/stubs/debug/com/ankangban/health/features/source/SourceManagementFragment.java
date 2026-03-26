package com.ankangban.health.features.source;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u00b0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001NB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010(\u001a\u00020)H\u0002J\b\u0010*\u001a\u00020)H\u0002J\b\u0010+\u001a\u00020)H\u0002J\u0010\u0010,\u001a\u00020)2\u0006\u0010-\u001a\u00020\u0014H\u0003J\b\u0010.\u001a\u00020)H\u0002J$\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u0001042\b\u00105\u001a\u0004\u0018\u000106H\u0016J\b\u00107\u001a\u00020)H\u0016J\u001a\u00108\u001a\u00020)2\u0006\u00109\u001a\u0002002\b\u00105\u001a\u0004\u0018\u000106H\u0016J\b\u0010:\u001a\u00020)H\u0002J\u0010\u0010;\u001a\u00020)2\u0006\u0010<\u001a\u00020=H\u0002J\u0010\u0010>\u001a\u00020)2\u0006\u0010?\u001a\u00020@H\u0002J\u0010\u0010A\u001a\u00020)2\u0006\u0010B\u001a\u00020\u000bH\u0002J\b\u0010C\u001a\u00020)H\u0002J\b\u0010D\u001a\u00020)H\u0003J\b\u0010E\u001a\u00020)H\u0003J \u0010F\u001a\u00020)2\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020LH\u0002J\b\u0010M\u001a\u00020)H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0018\u00010\rR\u00020\u0000X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0010\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00100\u00100\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\'X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006O"}, d2 = {"Lcom/ankangban/health/features/source/SourceManagementFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lcom/ankangban/health/databinding/FragmentSourceManagementBinding;", "binding", "getBinding", "()Lcom/ankangban/health/databinding/FragmentSourceManagementBinding;", "bleHelper", "Lcom/ankangban/health/core/source/BleHelper;", "currentActiveSource", "Lcom/ankangban/health/core/source/DataSourceType;", "deviceAdapter", "Lcom/ankangban/health/features/source/SourceManagementFragment$DeviceAdapter;", "filePickerLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "foundDevices", "", "Landroid/bluetooth/BluetoothDevice;", "healthViewModel", "Lcom/ankangban/health/ui/viewmodel/HealthViewModel;", "getHealthViewModel", "()Lcom/ankangban/health/ui/viewmodel/HealthViewModel;", "healthViewModel$delegate", "Lkotlin/Lazy;", "requestBluetoothPermissionLauncher", "", "", "requestPermissionLauncher", "scanDialog", "Landroidx/appcompat/app/AlertDialog;", "scanJob", "Lkotlinx/coroutines/Job;", "selectedSource", "statusManager", "Lcom/ankangban/health/core/source/DataSourceStatusManager;", "userManager", "Lcom/ankangban/health/core/storage/UserManager;", "applyConfiguration", "", "checkBluetoothPermissions", "checkPermissions", "connectToDevice", "device", "observeStatuses", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onViewCreated", "view", "openFilePicker", "parseCsvFile", "uri", "Landroid/net/Uri;", "saveToDatabase", "parsed", "Lcom/ankangban/health/core/source/CsvHealthDataParser$ParsedHealthData;", "selectSource", "type", "setupUI", "showDeviceScanDialog", "startScanning", "updateCardStatus", "icon", "Landroid/widget/ImageView;", "text", "Landroid/widget/TextView;", "state", "Lcom/ankangban/health/core/source/DataSourceState;", "updateSelectionUI", "DeviceAdapter", "app_debug"})
public final class SourceManagementFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy healthViewModel$delegate = null;
    @org.jetbrains.annotations.Nullable
    private com.ankangban.health.databinding.FragmentSourceManagementBinding _binding;
    private com.ankangban.health.core.source.DataSourceStatusManager statusManager;
    private com.ankangban.health.core.storage.UserManager userManager;
    private com.ankangban.health.core.source.BleHelper bleHelper;
    @org.jetbrains.annotations.NotNull
    private com.ankangban.health.core.source.DataSourceType selectedSource = com.ankangban.health.core.source.DataSourceType.DEVICE_SENSOR;
    @org.jetbrains.annotations.NotNull
    private com.ankangban.health.core.source.DataSourceType currentActiveSource = com.ankangban.health.core.source.DataSourceType.DEVICE_SENSOR;
    @org.jetbrains.annotations.NotNull
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String[]> requestBluetoothPermissionLauncher = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String[]> requestPermissionLauncher = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.activity.result.ActivityResultLauncher<android.content.Intent> filePickerLauncher = null;
    @org.jetbrains.annotations.Nullable
    private androidx.appcompat.app.AlertDialog scanDialog;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<android.bluetooth.BluetoothDevice> foundDevices = null;
    @org.jetbrains.annotations.Nullable
    private com.ankangban.health.features.source.SourceManagementFragment.DeviceAdapter deviceAdapter;
    @org.jetbrains.annotations.Nullable
    private kotlinx.coroutines.Job scanJob;
    
    public SourceManagementFragment() {
        super();
    }
    
    private final com.ankangban.health.ui.viewmodel.HealthViewModel getHealthViewModel() {
        return null;
    }
    
    private final com.ankangban.health.databinding.FragmentSourceManagementBinding getBinding() {
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
    
    private final void selectSource(com.ankangban.health.core.source.DataSourceType type) {
    }
    
    private final void updateSelectionUI() {
    }
    
    private final void observeStatuses() {
    }
    
    private final void updateCardStatus(android.widget.ImageView icon, android.widget.TextView text, com.ankangban.health.core.source.DataSourceState state) {
    }
    
    private final void checkBluetoothPermissions() {
    }
    
    @android.annotation.SuppressLint(value = {"MissingPermission"})
    private final void showDeviceScanDialog() {
    }
    
    @android.annotation.SuppressLint(value = {"MissingPermission"})
    private final void startScanning() {
    }
    
    @android.annotation.SuppressLint(value = {"MissingPermission"})
    private final void connectToDevice(android.bluetooth.BluetoothDevice device) {
    }
    
    private final void checkPermissions() {
    }
    
    private final void openFilePicker() {
    }
    
    private final void parseCsvFile(android.net.Uri uri) {
    }
    
    private final void saveToDatabase(com.ankangban.health.core.source.CsvHealthDataParser.ParsedHealthData parsed) {
    }
    
    private final void applyConfiguration() {
    }
    
    @java.lang.Override
    public void onDestroyView() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u0010\u0012\f\u0012\n0\u0002R\u00060\u0000R\u00020\u00030\u0001:\u0001\u0014B\'\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\fH\u0016J \u0010\r\u001a\u00020\t2\u000e\u0010\u000e\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\u000f\u001a\u00020\fH\u0017J \u0010\u0010\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\fH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/ankangban/health/features/source/SourceManagementFragment$DeviceAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/ankangban/health/features/source/SourceManagementFragment$DeviceAdapter$ViewHolder;", "Lcom/ankangban/health/features/source/SourceManagementFragment;", "devices", "", "Landroid/bluetooth/BluetoothDevice;", "onClick", "Lkotlin/Function1;", "", "(Lcom/ankangban/health/features/source/SourceManagementFragment;Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_debug"})
    public final class DeviceAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.ankangban.health.features.source.SourceManagementFragment.DeviceAdapter.ViewHolder> {
        @org.jetbrains.annotations.NotNull
        private final java.util.List<android.bluetooth.BluetoothDevice> devices = null;
        @org.jetbrains.annotations.NotNull
        private final kotlin.jvm.functions.Function1<android.bluetooth.BluetoothDevice, kotlin.Unit> onClick = null;
        
        public DeviceAdapter(@org.jetbrains.annotations.NotNull
        java.util.List<android.bluetooth.BluetoothDevice> devices, @org.jetbrains.annotations.NotNull
        kotlin.jvm.functions.Function1<? super android.bluetooth.BluetoothDevice, kotlin.Unit> onClick) {
            super();
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public com.ankangban.health.features.source.SourceManagementFragment.DeviceAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
        android.view.ViewGroup parent, int viewType) {
            return null;
        }
        
        @java.lang.Override
        @android.annotation.SuppressLint(value = {"MissingPermission"})
        public void onBindViewHolder(@org.jetbrains.annotations.NotNull
        com.ankangban.health.features.source.SourceManagementFragment.DeviceAdapter.ViewHolder holder, int position) {
        }
        
        @java.lang.Override
        public int getItemCount() {
            return 0;
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/ankangban/health/features/source/SourceManagementFragment$DeviceAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/ankangban/health/features/source/SourceManagementFragment$DeviceAdapter;Landroid/view/View;)V", "btnConnect", "Landroid/widget/Button;", "getBtnConnect", "()Landroid/widget/Button;", "tvAddress", "Landroid/widget/TextView;", "getTvAddress", "()Landroid/widget/TextView;", "tvName", "getTvName", "app_debug"})
        public final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
            @org.jetbrains.annotations.NotNull
            private final android.widget.TextView tvName = null;
            @org.jetbrains.annotations.NotNull
            private final android.widget.TextView tvAddress = null;
            @org.jetbrains.annotations.NotNull
            private final android.widget.Button btnConnect = null;
            
            public ViewHolder(@org.jetbrains.annotations.NotNull
            android.view.View view) {
                super(null);
            }
            
            @org.jetbrains.annotations.NotNull
            public final android.widget.TextView getTvName() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull
            public final android.widget.TextView getTvAddress() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull
            public final android.widget.Button getBtnConnect() {
                return null;
            }
        }
    }
}