package com.ankangban.health.core.source

import android.annotation.SuppressLint
import android.bluetooth.*
import android.bluetooth.le.ScanCallback
import android.bluetooth.le.ScanResult
import android.content.Context
import android.os.Handler
import android.os.Looper
import android.util.Log
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import java.util.*
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.channels.BufferOverflow

@SuppressLint("MissingPermission")
class BleHelper private constructor(private val context: Context) {

    companion object {
        @SuppressLint("StaticFieldLeak")
        @Volatile private var instance: BleHelper? = null

        fun getInstance(context: Context): BleHelper {
            return instance ?: synchronized(this) {
                instance ?: BleHelper(context.applicationContext).also { instance = it }
            }
        }
    }

    private val bluetoothAdapter: BluetoothAdapter? = BluetoothAdapter.getDefaultAdapter()
    private val handler = Handler(Looper.getMainLooper())
    private var bluetoothGatt: BluetoothGatt? = null
    private var isConnected = false

    // Data Flows
    private val _heartRateFlow = MutableSharedFlow<Int>(
        replay = 1,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )
    val heartRateFlow = _heartRateFlow.asSharedFlow()
    
    // Standard Heart Rate Service UUID
    private val HEART_RATE_SERVICE_UUID = UUID.fromString("0000180d-0000-1000-8000-00805f9b34fb")
    private val HEART_RATE_MEASUREMENT_CHAR_UUID = UUID.fromString("00002a37-0000-1000-8000-00805f9b34fb")

    fun isBluetoothEnabled(): Boolean {
        return bluetoothAdapter?.isEnabled == true
    }

    fun isDeviceConnected(): Boolean {
        return isConnected
    }

    fun scanDevices(durationMillis: Long = 10000): Flow<BluetoothDevice> = callbackFlow {
        val scanner = bluetoothAdapter?.bluetoothLeScanner
        if (scanner == null) {
            close()
            return@callbackFlow
        }

        val scanCallback = object : ScanCallback() {
            override fun onScanResult(callbackType: Int, result: ScanResult?) {
                result?.device?.let { device ->
                    trySend(device)
                }
            }

            override fun onScanFailed(errorCode: Int) {
                super.onScanFailed(errorCode)
                Log.e("BleHelper", "Scan failed: $errorCode")
            }
        }

        Log.d("BleHelper", "Starting scan")
        scanner.startScan(scanCallback)

        handler.postDelayed({
            scanner.stopScan(scanCallback)
            close()
        }, durationMillis)

        awaitClose {
            scanner.stopScan(scanCallback)
        }
    }

    fun connect(address: String, onStateChanged: (String) -> Unit, onDataReceived: (String) -> Unit) {
        val device = bluetoothAdapter?.getRemoteDevice(address) ?: return
        
        onStateChanged("正在连接...")
        
        bluetoothGatt = device.connectGatt(context, false, object : BluetoothGattCallback() {
            override fun onConnectionStateChange(gatt: BluetoothGatt, status: Int, newState: Int) {
                if (newState == BluetoothProfile.STATE_CONNECTED) {
                    isConnected = true
                    onStateChanged("已连接，正在发现服务...")
                    gatt.discoverServices()
                } else if (newState == BluetoothProfile.STATE_DISCONNECTED) {
                    isConnected = false
                    onStateChanged("已断开连接")
                }
            }

            override fun onServicesDiscovered(gatt: BluetoothGatt, status: Int) {
                if (status == BluetoothGatt.GATT_SUCCESS) {
                    onStateChanged("服务已发现")
                    // Try to find Heart Rate Service
                    val hrService = gatt.getService(HEART_RATE_SERVICE_UUID)
                    if (hrService != null) {
                        val hrChar = hrService.getCharacteristic(HEART_RATE_MEASUREMENT_CHAR_UUID)
                        if (hrChar != null) {
                            gatt.setCharacteristicNotification(hrChar, true)
                            val descriptor = hrChar.descriptors.firstOrNull()
                            if (descriptor != null) {
                                descriptor.value = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE
                                gatt.writeDescriptor(descriptor)
                            }
                            onStateChanged("正在监听心率数据...")
                        }
                    } else {
                         onStateChanged("设备已连接 (非标准心率设备)")
                    }
                } else {
                    onStateChanged("服务发现失败: $status")
                }
            }

            override fun onCharacteristicChanged(gatt: BluetoothGatt, characteristic: BluetoothGattCharacteristic) {
                if (characteristic.uuid == HEART_RATE_MEASUREMENT_CHAR_UUID) {
                    val flag = characteristic.properties
                    val format = if ((flag and 0x01) != 0) {
                        BluetoothGattCharacteristic.FORMAT_UINT16
                    } else {
                        BluetoothGattCharacteristic.FORMAT_UINT8
                    }
                    val heartRate = characteristic.getIntValue(format, 1)
                    onDataReceived("心率: $heartRate bpm")
                    _heartRateFlow.tryEmit(heartRate)
                }
            }
        })
    }

    fun disconnect() {
        isConnected = false
        bluetoothGatt?.disconnect()
        bluetoothGatt?.close()
        bluetoothGatt = null
    }
}
