package com.ankangban.health.core.source;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0007\u0018\u0000 \'2\u00020\u0001:\u0001\'B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J6\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00190\u001d2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00190\u001dJ\u0006\u0010\u001f\u001a\u00020\u0019J\u0006\u0010 \u001a\u00020\u0017J\u0006\u0010!\u001a\u00020\u0017J\u0016\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#2\b\b\u0002\u0010%\u001a\u00020&R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006("}, d2 = {"Lcom/ankangban/health/core/source/BleHelper;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "HEART_RATE_MEASUREMENT_CHAR_UUID", "Ljava/util/UUID;", "kotlin.jvm.PlatformType", "HEART_RATE_SERVICE_UUID", "_heartRateFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "", "bluetoothAdapter", "Landroid/bluetooth/BluetoothAdapter;", "bluetoothGatt", "Landroid/bluetooth/BluetoothGatt;", "handler", "Landroid/os/Handler;", "heartRateFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "getHeartRateFlow", "()Lkotlinx/coroutines/flow/SharedFlow;", "isConnected", "", "connect", "", "address", "", "onStateChanged", "Lkotlin/Function1;", "onDataReceived", "disconnect", "isBluetoothEnabled", "isDeviceConnected", "scanDevices", "Lkotlinx/coroutines/flow/Flow;", "Landroid/bluetooth/BluetoothDevice;", "durationMillis", "", "Companion", "app_debug"})
@android.annotation.SuppressLint(value = {"MissingPermission"})
public final class BleHelper {
    @org.jetbrains.annotations.NotNull
    private final android.content.Context context = null;
    @android.annotation.SuppressLint(value = {"StaticFieldLeak"})
    @kotlin.jvm.Volatile
    @org.jetbrains.annotations.Nullable
    private static volatile com.ankangban.health.core.source.BleHelper instance;
    @org.jetbrains.annotations.Nullable
    private final android.bluetooth.BluetoothAdapter bluetoothAdapter = null;
    @org.jetbrains.annotations.NotNull
    private final android.os.Handler handler = null;
    @org.jetbrains.annotations.Nullable
    private android.bluetooth.BluetoothGatt bluetoothGatt;
    private boolean isConnected = false;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableSharedFlow<java.lang.Integer> _heartRateFlow = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.SharedFlow<java.lang.Integer> heartRateFlow = null;
    private final java.util.UUID HEART_RATE_SERVICE_UUID = null;
    private final java.util.UUID HEART_RATE_MEASUREMENT_CHAR_UUID = null;
    @org.jetbrains.annotations.NotNull
    public static final com.ankangban.health.core.source.BleHelper.Companion Companion = null;
    
    private BleHelper(android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.SharedFlow<java.lang.Integer> getHeartRateFlow() {
        return null;
    }
    
    public final boolean isBluetoothEnabled() {
        return false;
    }
    
    public final boolean isDeviceConnected() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<android.bluetooth.BluetoothDevice> scanDevices(long durationMillis) {
        return null;
    }
    
    public final void connect(@org.jetbrains.annotations.NotNull
    java.lang.String address, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onStateChanged, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onDataReceived) {
    }
    
    public final void disconnect() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0083\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/ankangban/health/core/source/BleHelper$Companion;", "", "()V", "instance", "Lcom/ankangban/health/core/source/BleHelper;", "getInstance", "context", "Landroid/content/Context;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.ankangban.health.core.source.BleHelper getInstance(@org.jetbrains.annotations.NotNull
        android.content.Context context) {
            return null;
        }
    }
}