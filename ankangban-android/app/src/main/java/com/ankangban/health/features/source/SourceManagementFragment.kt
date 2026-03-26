package com.ankangban.health.features.source

import android.Manifest
import android.app.Activity
import android.bluetooth.BluetoothDevice
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ankangban.health.R
import com.ankangban.health.ui.viewmodel.HealthViewModel
import com.ankangban.health.core.source.CsvHealthDataParser
import com.ankangban.health.core.source.DataSourceState
import com.ankangban.health.core.source.DataSourceStatusManager
import com.ankangban.health.core.source.DataSourceType
import com.ankangban.health.core.source.SourceStatus
import com.ankangban.health.core.storage.HealthDatabase
import com.ankangban.health.core.storage.UserManager
import com.ankangban.health.databinding.FragmentSourceManagementBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SourceManagementFragment : Fragment() {

    private val healthViewModel: HealthViewModel by activityViewModels()

    private var _binding: FragmentSourceManagementBinding? = null
    private val binding get() = _binding!!

    private lateinit var statusManager: DataSourceStatusManager
    private lateinit var userManager: UserManager
    private lateinit var bleHelper: com.ankangban.health.core.source.BleHelper

    // Selected source to be applied
    private var selectedSource: DataSourceType = DataSourceType.DEVICE_SENSOR
    
    // Currently active source (from storage)
    private var currentActiveSource: DataSourceType = DataSourceType.DEVICE_SENSOR

    // Bluetooth Permission Launcher
    private val requestBluetoothPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
            val allGranted = permissions.entries.all { it.value }
            if (allGranted) {
                showDeviceScanDialog()
            } else {
                Toast.makeText(context, "需要蓝牙权限才能搜索设备", Toast.LENGTH_SHORT).show()
            }
        }

    // Permission Launcher (Sensor)
    private val requestPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
            val allGranted = permissions.entries.all { it.value }
            if (allGranted) {
                Toast.makeText(context, "传感器权限已授予", Toast.LENGTH_SHORT).show()
                lifecycleScope.launch {
                    statusManager.checkStatuses()
                }
            } else {
                 MaterialAlertDialogBuilder(requireContext())
                    .setTitle("权限被拒绝")
                    .setMessage("应用需要传感器权限来采集您的步数和健康数据。请在设置中开启权限。")
                    .setPositiveButton("去设置") { _, _ ->
                        try {
                            val intent = Intent(android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                            intent.data = android.net.Uri.parse("package:${requireContext().packageName}")
                            startActivity(intent)
                        } catch (e: Exception) {
                            e.printStackTrace()
                        }
                    }
                    .setNegativeButton("取消", null)
                    .show()
                
                lifecycleScope.launch {
                    statusManager.checkStatuses()
                }
            }
        }

    // File Picker Launcher
    private val filePickerLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                result.data?.data?.let { uri ->
                    parseCsvFile(uri)
                }
            }
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSourceManagementBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        statusManager = DataSourceStatusManager(requireContext())
        userManager = UserManager(requireContext())
        bleHelper = com.ankangban.health.core.source.BleHelper.getInstance(requireContext())
        
        // Load current setting
        val prefs = requireContext().getSharedPreferences("app_config", android.content.Context.MODE_PRIVATE)
        val typeStr = prefs.getString("data_source_type", DataSourceType.DEVICE_SENSOR.name)
        currentActiveSource = try {
            DataSourceType.valueOf(typeStr ?: DataSourceType.DEVICE_SENSOR.name)
        } catch (e: Exception) {
            DataSourceType.DEVICE_SENSOR
        }

        selectedSource = currentActiveSource

        setupUI()
        observeStatuses()
        
        // Initial check
        lifecycleScope.launch {
            statusManager.checkStatuses()
        }
    }

    private fun setupUI() {
        // Back Button
        binding.btnBack.setOnClickListener {
            findNavController().navigateUp()
        }

        // Refresh Button
        binding.btnRefresh.setOnClickListener {
            lifecycleScope.launch {
                Toast.makeText(context, "正在检测数据源状态...", Toast.LENGTH_SHORT).show()
                statusManager.checkStatuses()
                delay(1000)
                Toast.makeText(context, "状态已更新", Toast.LENGTH_SHORT).show()
            }
        }

        // Switches Logic (Mutually Exclusive)
        binding.switchSensor.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                selectSource(DataSourceType.DEVICE_SENSOR)
            } else if (selectedSource == DataSourceType.DEVICE_SENSOR) {
                // Prevent turning off the only selected one (unless another is clicked)
                // Actually MD3 switches usually allow toggle. But we need one active.
                // Let's enforce re-checking it if user tries to uncheck it directly without picking another.
                binding.switchSensor.isChecked = true
            }
        }

        binding.switchFile.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                selectSource(DataSourceType.LOCAL_FILE)
            } else if (selectedSource == DataSourceType.LOCAL_FILE) {
                binding.switchFile.isChecked = true
            }
        }
        
        // Third party switch
        binding.switchSdk.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                // Only allow switching if SDK is connected
                val sdkState = statusManager.sdkState.value
                if (sdkState.status == SourceStatus.CONNECTED) {
                    selectSource(DataSourceType.THIRD_PARTY_SDK)
                } else {
                    binding.switchSdk.isChecked = false
                    MaterialAlertDialogBuilder(requireContext())
                        .setTitle("未连接设备")
                        .setMessage("请先点击“连接设备”按钮搜索并连接智能手环或血糖仪等外部设备。")
                        .setPositiveButton("去连接") { _, _ ->
                            checkBluetoothPermissions()
                        }
                        .setNegativeButton("取消", null)
                        .show()
                }
            } else if (selectedSource == DataSourceType.THIRD_PARTY_SDK) {
                binding.switchSdk.isChecked = true
            }
        }
        
        binding.btnSdkAction.setOnClickListener {
             checkBluetoothPermissions()
        }

        // Action Buttons
        binding.btnSensorAction.setOnClickListener {
            checkPermissions()
        }

        binding.btnFileAction.setOnClickListener {
            openFilePicker()
        }

        // Apply Button
        binding.btnApply.setOnClickListener {
            applyConfiguration()
        }

        updateSelectionUI()
    }

    private fun selectSource(type: DataSourceType) {
        selectedSource = type
        updateSelectionUI()
        binding.btnApply.isEnabled = selectedSource != currentActiveSource
    }

    private fun updateSelectionUI() {
        // Update Switches
        binding.switchSensor.isChecked = selectedSource == DataSourceType.DEVICE_SENSOR
        binding.switchFile.isChecked = selectedSource == DataSourceType.LOCAL_FILE
        binding.switchSdk.isChecked = selectedSource == DataSourceType.THIRD_PARTY_SDK
        
        // Update Default Tags (Active Source)
        binding.tagSensorDefault.visibility = if (currentActiveSource == DataSourceType.DEVICE_SENSOR) View.VISIBLE else View.GONE
        binding.tagFileDefault.visibility = if (currentActiveSource == DataSourceType.LOCAL_FILE) View.VISIBLE else View.GONE
        binding.tagSdkDefault.visibility = if (currentActiveSource == DataSourceType.THIRD_PARTY_SDK) View.VISIBLE else View.GONE

        // Enable/Disable Actions based on selection? 
        // Requirement says: "Enable local file switch -> file button becomes clickable".
        // Actually button can be always clickable to configure, but let's follow logic.
        binding.btnFileAction.isEnabled = true // Always allow picking file
    }

    private fun observeStatuses() {
        lifecycleScope.launch {
            launch {
                statusManager.sensorState.collect { state ->
                    updateCardStatus(
                        binding.ivSensorStatus, 
                        binding.tvSensorStatus, 
                        state
                    )
                }
            }
            launch {
                statusManager.fileState.collect { state ->
                    updateCardStatus(
                        binding.ivFileStatus, 
                        binding.tvFileStatus, 
                        state
                    )
                }
            }
            launch {
                statusManager.sdkState.collect { state ->
                    updateCardStatus(
                        binding.ivSdkStatus, 
                        binding.tvSdkStatus, 
                        state
                    )
                }
            }
        }
    }

    private fun updateCardStatus(icon: android.widget.ImageView, text: android.widget.TextView, state: DataSourceState) {
        text.text = state.message
        when (state.status) {
            SourceStatus.CONNECTED -> {
                icon.setImageResource(R.drawable.ic_check_circle)
                icon.setColorFilter(android.graphics.Color.parseColor("#4CAF50")) // Green
                text.setTextColor(android.graphics.Color.parseColor("#4CAF50"))
            }
            SourceStatus.NOT_CONNECTED -> {
                icon.setImageResource(R.drawable.ic_error) // Or remove circle
                icon.setColorFilter(android.graphics.Color.parseColor("#F44336")) // Red
                text.setTextColor(android.graphics.Color.parseColor("#F44336"))
            }
            SourceStatus.NO_PERMISSION -> {
                icon.setImageResource(R.drawable.ic_warning) // Warning
                icon.setColorFilter(android.graphics.Color.parseColor("#FF9800")) // Orange
                text.setTextColor(android.graphics.Color.parseColor("#FF9800"))
            }
        }
    }

    private fun checkBluetoothPermissions() {
        val permissions = mutableListOf<String>()
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.S) {
            permissions.add(Manifest.permission.BLUETOOTH_SCAN)
            permissions.add(Manifest.permission.BLUETOOTH_CONNECT)
        } else {
            permissions.add(Manifest.permission.ACCESS_FINE_LOCATION)
            permissions.add(Manifest.permission.BLUETOOTH)
            permissions.add(Manifest.permission.BLUETOOTH_ADMIN)
        }
        
        val missing = permissions.filter {
            ContextCompat.checkSelfPermission(requireContext(), it) != PackageManager.PERMISSION_GRANTED
        }
        
        if (missing.isEmpty()) {
            showDeviceScanDialog()
        } else {
            requestBluetoothPermissionLauncher.launch(missing.toTypedArray())
        }
    }

    private var scanDialog: androidx.appcompat.app.AlertDialog? = null
    private val foundDevices = mutableListOf<BluetoothDevice>()
    private var deviceAdapter: DeviceAdapter? = null
    private var scanJob: kotlinx.coroutines.Job? = null

    @android.annotation.SuppressLint("MissingPermission")
    private fun showDeviceScanDialog() {
        if (!bleHelper.isBluetoothEnabled()) {
             Toast.makeText(context, "请先开启蓝牙", Toast.LENGTH_SHORT).show()
             return
        }

        foundDevices.clear()
        deviceAdapter = DeviceAdapter(foundDevices) { device ->
            scanDialog?.dismiss()
            connectToDevice(device)
        }

        val dialogView = LayoutInflater.from(requireContext()).inflate(R.layout.dialog_device_scan, null)
        val rvList = dialogView.findViewById<RecyclerView>(R.id.rvDeviceList)
        
        rvList.layoutManager = LinearLayoutManager(context)
        rvList.adapter = deviceAdapter

        scanDialog = MaterialAlertDialogBuilder(requireContext())
            .setTitle("搜索设备")
            .setView(dialogView)
            .setNegativeButton("取消") { _, _ -> }
            .setOnDismissListener {
                scanJob?.cancel()
            }
            .show()

        startScanning()
    }

    @android.annotation.SuppressLint("MissingPermission")
    private fun startScanning() {
        scanJob = lifecycleScope.launch {
            bleHelper.scanDevices()
                .collect { device ->
                    if (device.name != null && !foundDevices.any { it.address == device.address }) {
                         foundDevices.add(device)
                         deviceAdapter?.notifyItemInserted(foundDevices.size - 1)
                    }
                }
        }
    }

    @android.annotation.SuppressLint("MissingPermission")
    private fun connectToDevice(device: BluetoothDevice) {
         val progressDialog = MaterialAlertDialogBuilder(requireContext())
            .setTitle("正在连接")
            .setMessage("正在连接 ${device.name ?: "设备"}...")
            .setCancelable(false)
            .show()
            
         bleHelper.connect(device.address, 
            onStateChanged = { state ->
                 lifecycleScope.launch(Dispatchers.Main) {
                     progressDialog.setMessage(state)
                 }
            },
            onDataReceived = { data ->
                 lifecycleScope.launch(Dispatchers.Main) {
                     progressDialog.dismiss()
                     
                     // Only show success dialog once
                     if (statusManager.sdkState.value.status != SourceStatus.CONNECTED) {
                         // Save device info
                         val prefs = requireContext().getSharedPreferences("app_config", android.content.Context.MODE_PRIVATE)
                         prefs.edit().putString("sdk_provider", device.name ?: device.address).apply()
                         
                         statusManager.updateSdkStatus(true, "已连接: ${device.name}\n$data")
                         
                         MaterialAlertDialogBuilder(requireContext())
                            .setTitle("连接成功")
                            .setMessage("已连接到 ${device.name}。\n$data")
                            .setPositiveButton("设为默认") { _, _ ->
                                selectSource(DataSourceType.THIRD_PARTY_SDK)
                            }
                            .setNegativeButton("关闭", null)
                            .show()
                     } else {
                         // Update status text only
                         statusManager.updateSdkStatus(true, "已连接: ${device.name}\n$data")
                     }
                 }
            }
         )
    }

    inner class DeviceAdapter(
        private val devices: List<BluetoothDevice>,
        private val onClick: (BluetoothDevice) -> Unit
    ) : RecyclerView.Adapter<DeviceAdapter.ViewHolder>() {

        inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val tvName: TextView = view.findViewById(R.id.tvDeviceName)
            val tvAddress: TextView = view.findViewById(R.id.tvDeviceAddress)
            val btnConnect: android.widget.Button = view.findViewById(R.id.btnConnect)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_bluetooth_device, parent, false)
            return ViewHolder(view)
        }

        @android.annotation.SuppressLint("MissingPermission")
        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val device = devices[position]
            holder.tvName.text = device.name ?: "未知设备"
            holder.tvAddress.text = device.address
            
            holder.itemView.setOnClickListener { onClick(device) }
            holder.btnConnect.setOnClickListener { onClick(device) }
        }

        override fun getItemCount() = devices.size
    }

    private fun checkPermissions() {
        val permissions = mutableListOf<String>()
        
        // ACTIVITY_RECOGNITION (Android 10+ / API 29+)
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.Q) {
            permissions.add(Manifest.permission.ACTIVITY_RECOGNITION)
        }
        
        // BODY_SENSORS (API 20+)
        // Note: For Android 13+ (Tiramisu), if we needed background access we'd add BODY_SENSORS_BACKGROUND,
        // but that requires BODY_SENSORS to be granted first or concurrently.
        permissions.add(Manifest.permission.BODY_SENSORS)
        
        val missingPermissions = permissions.filter {
            ContextCompat.checkSelfPermission(requireContext(), it) != PackageManager.PERMISSION_GRANTED
        }

        if (missingPermissions.isEmpty()) {
            Toast.makeText(context, "所有必要权限已授予", Toast.LENGTH_SHORT).show()
            lifecycleScope.launch {
                statusManager.checkStatuses()
            }
            return
        }

        // Show rationale if needed
        val shouldShowRationale = missingPermissions.any {
            shouldShowRequestPermissionRationale(it)
        }
        
        if (shouldShowRationale) {
            MaterialAlertDialogBuilder(requireContext())
                .setTitle("需要传感器权限")
                .setMessage("为了检测步数和心率数据，应用需要访问您的运动传感器。")
                .setPositiveButton("授权") { _, _ ->
                    requestPermissionLauncher.launch(missingPermissions.toTypedArray())
                }
                .setNegativeButton("取消", null)
                .show()
        } else {
            requestPermissionLauncher.launch(missingPermissions.toTypedArray())
        }
    }

    private fun openFilePicker() {
        val intent = Intent(Intent.ACTION_GET_CONTENT).apply {
            type = "*/*" // Allow all to ensure CSV is selectable, or "text/comma-separated-values"
            addCategory(Intent.CATEGORY_OPENABLE)
        }
        filePickerLauncher.launch(intent)
    }

    private fun parseCsvFile(uri: android.net.Uri) {
        lifecycleScope.launch(Dispatchers.IO) {
            try {
                val inputStream = requireContext().contentResolver.openInputStream(uri)
                if (inputStream != null) {
                    val parsed = CsvHealthDataParser.parse(inputStream)
                    inputStream.close()

                    val count = parsed.healthData.size + parsed.stepsData.size + parsed.sleepData.size
                    
                    withContext(Dispatchers.Main) {
                        if (count > 0) {
                            statusManager.updateFileStatus(true, "本地CSV文件已导入，共${count}条记录")
                            
                            MaterialAlertDialogBuilder(requireContext())
                                .setTitle("导入成功")
                                .setMessage("已导入近7天健康数据，共${count}条记录")
                                .setPositiveButton("确定") { _, _ -> 
                                    // Save data to DB? For demo, we might want to actually persist it
                                    // so Dashboard sees it when we switch.
                                    saveToDatabase(parsed)
                                }
                                .show()
                        } else {
                            statusManager.updateFileStatus(false, "文件解析为空或格式错误")
                             MaterialAlertDialogBuilder(requireContext())
                                .setTitle("导入失败")
                                .setMessage("CSV格式错误，请按模板导入")
                                .setPositiveButton("确定", null)
                                .show()
                        }
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
                withContext(Dispatchers.Main) {
                     statusManager.updateFileStatus(false, "文件读取失败")
                }
            }
        }
    }
    
    private fun saveToDatabase(parsed: CsvHealthDataParser.ParsedHealthData) {
        lifecycleScope.launch(Dispatchers.IO) {
            val db = HealthDatabase.get(requireContext())
            db.healthDataDao().insertAll(parsed.healthData)
            db.stepsDao().insertAll(parsed.stepsData)
            db.sleepDao().insertAll(parsed.sleepData)
        }
    }

    private fun applyConfiguration() {
        val prefs = requireContext().getSharedPreferences("app_config", android.content.Context.MODE_PRIVATE)
        prefs.edit().putString("data_source_type", selectedSource.name).apply()
        
        currentActiveSource = selectedSource
        updateSelectionUI()
        binding.btnApply.isEnabled = false
        
        // Update shared ViewModel
        healthViewModel.updateDataSource(selectedSource.name)
        
        Snackbar.make(binding.root, "数据源配置已应用", Snackbar.LENGTH_SHORT).show()
        
        // Broadcast change
        val intent = Intent("com.ankangban.health.ACTION_SOURCE_CHANGED")
        intent.putExtra("source_type", selectedSource.name)
        androidx.localbroadcastmanager.content.LocalBroadcastManager.getInstance(requireContext())
            .sendBroadcast(intent)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
