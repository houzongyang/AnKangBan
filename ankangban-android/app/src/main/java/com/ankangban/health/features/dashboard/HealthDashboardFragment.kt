package com.ankangban.health.features.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.ankangban.health.R
import com.ankangban.health.databinding.FragmentHealthDashboardBinding
import com.ankangban.health.ui.viewmodel.HealthViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import androidx.navigation.fragment.findNavController

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import android.os.VibratorManager
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.ankangban.health.core.storage.WarningRule
import com.ankangban.health.core.storage.WarningRuleManager
import com.ankangban.health.features.dashboard.WarningConfigFragment
import com.ankangban.health.ui.MainActivity

class HealthDashboardFragment : Fragment() {

    private var _binding: FragmentHealthDashboardBinding? = null
    private val binding get() = _binding!!
    private val viewModel: HealthViewModel by viewModels()
    private lateinit var ruleManager: WarningRuleManager
    
    // Warning Rules
    private var heartRateRule: WarningRule? = null
    private var spo2Rule: WarningRule? = null
    private var stepsRule: WarningRule? = null
    private var sleepRule: WarningRule? = null

    private val rulesReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            if (intent?.action == WarningRuleManager.ACTION_RULES_CHANGED) {
                loadRules()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ruleManager = WarningRuleManager(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHealthDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadRules()
        setupListeners()
        observeData()
        
        // Initial start
        viewModel.start()
        setupScrollListener()
    }

    private fun setupScrollListener() {
        binding?.let { b ->
            // Root is NestedScrollView
            val scrollView = b.root as? androidx.core.widget.NestedScrollView ?: return
            
            scrollView.setOnScrollChangeListener(androidx.core.widget.NestedScrollView.OnScrollChangeListener { _, _, scrollY, _, oldScrollY ->
                val activity = requireActivity() as? MainActivity ?: return@OnScrollChangeListener
                if (scrollY > oldScrollY + 5) {
                    // Scrolling down - hide
                    activity.setBottomNavVisibility(false)
                } else if (scrollY < oldScrollY - 5) {
                    // Scrolling up - show
                    activity.setBottomNavVisibility(true)
                }
            })
        }
    }

    override fun onResume() {
        super.onResume()
        LocalBroadcastManager.getInstance(requireContext()).registerReceiver(
            rulesReceiver, IntentFilter(WarningRuleManager.ACTION_RULES_CHANGED)
        )
        loadRules() // Ensure rules are up to date
    }

    override fun onPause() {
        super.onPause()
        LocalBroadcastManager.getInstance(requireContext()).unregisterReceiver(rulesReceiver)
    }

    private fun loadRules() {
        heartRateRule = ruleManager.getRule(WarningRuleManager.TYPE_HEART_RATE)
        spo2Rule = ruleManager.getRule(WarningRuleManager.TYPE_SPO2)
        stepsRule = ruleManager.getRule(WarningRuleManager.TYPE_STEPS)
        sleepRule = ruleManager.getRule(WarningRuleManager.TYPE_SLEEP)
        
        updateWarningUI()
    }

    private fun updateWarningUI() {
        // Update Heart Rate Warning Text
        heartRateRule?.let { rule ->
            if (rule.isEnabled) {
                binding.tvHeartRateWarning.text = "预警: ${rule.min.toInt()}-${rule.max.toInt()}"
                binding.tvHeartRateWarning.visibility = View.VISIBLE
            } else {
                binding.tvHeartRateWarning.visibility = View.INVISIBLE
            }
        }
    }

    private fun triggerWarning(rule: WarningRule, title: String, message: String) {
        // Prevent frequent triggering (simple throttle logic could be added here)
        
        if (rule.enableDialog) {
             Snackbar.make(binding.root, "$title: $message", Snackbar.LENGTH_LONG)
                .setBackgroundTint(ContextCompat.getColor(requireContext(), R.color.dashboard_error))
                .setTextColor(ContextCompat.getColor(requireContext(), android.R.color.white))
                .show()
        }
        
        if (rule.enableVibration) {
            val vibrator = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                val vibratorManager = requireContext().getSystemService(Context.VIBRATOR_MANAGER_SERVICE) as VibratorManager
                vibratorManager.defaultVibrator
            } else {
                @Suppress("DEPRECATION")
                requireContext().getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
            }
            if (vibrator.hasVibrator()) {
                vibrator.vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE))
            }
        }
        
        if (rule.enableNotification) {
            // Check permission
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU && 
                ContextCompat.checkSelfPermission(requireContext(), android.Manifest.permission.POST_NOTIFICATIONS) != android.content.pm.PackageManager.PERMISSION_GRANTED) {
                return
            }
            
            // Send notification (Requires Notification Channel setup in Application or MainActivity)
            // For now, skipping full implementation to avoid complexity with Channel creation here
        }
    }

    private fun setupListeners() {
        binding.ivSyncStatus.setOnClickListener {
            viewModel.start()
            Snackbar.make(binding.root, "数据已同步", Snackbar.LENGTH_SHORT).show()
        }

        binding.ivSyncStatus.setOnLongClickListener {
            showIntervalDialog()
            true
        }

        binding.btnTrends.setOnClickListener {
            findNavController().navigate(R.id.action_dashboard_to_trends)
        }

        binding.btnChronic.setOnClickListener {
            findNavController().navigate(R.id.action_dashboard_to_chronic)
        }

        binding.btnSource.setOnClickListener {
            findNavController().navigate(R.id.action_dashboard_to_source)
        }
        
        binding.btnMedication.setOnClickListener {
            findNavController().navigate(R.id.action_dashboard_to_medication)
        }

        // Card Clicks
        val cards = mapOf(
            binding.cardHeartRate to 0, // HEART_RATE
            binding.cardSpo2 to 1,      // SPO2
            binding.cardSteps to 2,     // STEPS
            binding.cardSleep to 3,     // SLEEP
            binding.cardTemp to 4,      // WRIST_TEMP
            binding.cardResp to 5       // RESP_RATE
        )
        
        cards.forEach { (card, typeOrdinal) ->
            card.setOnClickListener {
                 if (typeOrdinal == 3) { // SLEEP
                     findNavController().navigate(R.id.action_dashboard_to_sleep)
                 } else {
                     val bundle = Bundle().apply { putInt("initialType", typeOrdinal) }
                     findNavController().navigate(R.id.action_dashboard_to_trends, bundle)
                 }
            }
            card.setOnLongClickListener {
                findNavController().navigate(R.id.action_dashboard_to_warning_config)
                true
            }
        }
    }

    private fun observeData() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    viewModel.initStatus.collectLatest { success ->
                        if (success) {
                            binding.ivSyncStatus.imageTintList = ContextCompat.getColorStateList(requireContext(), R.color.dashboard_success)
                        } else {
                            binding.ivSyncStatus.imageTintList = ContextCompat.getColorStateList(requireContext(), R.color.dashboard_text_tertiary)
                            Snackbar.make(binding.root, "无法连接健康数据服务，请检查设备或权限", Snackbar.LENGTH_LONG)
                                .setAction("重试") { viewModel.start() }
                                .show()
                        }
                    }
                }

                launch {
                    viewModel.heartRate.collect { hr ->
                        if (hr != null) {
                            binding.tvHeartRateValue.text = hr.bpm.toString()
                            binding.progressHeartRate.progress = hr.bpm
                            
                            // Warning Logic
                            val rule = heartRateRule
                            if (rule != null && rule.isEnabled) {
                                if (hr.bpm > rule.max || hr.bpm < rule.min) {
                                    binding.tvHeartRateValue.setTextColor(ContextCompat.getColor(requireContext(), R.color.dashboard_error))
                                    binding.progressHeartRate.setIndicatorColor(ContextCompat.getColor(requireContext(), R.color.dashboard_error))
                                    triggerWarning(rule, "心率异常", "当前心率 ${hr.bpm}，超出范围 ${rule.min.toInt()}-${rule.max.toInt()}")
                                } else {
                                    binding.tvHeartRateValue.setTextColor(ContextCompat.getColor(requireContext(), R.color.dashboard_success))
                                    binding.progressHeartRate.setIndicatorColor(ContextCompat.getColor(requireContext(), R.color.dashboard_success))
                                }
                            } else {
                                binding.tvHeartRateValue.setTextColor(ContextCompat.getColor(requireContext(), R.color.dashboard_success))
                                binding.progressHeartRate.setIndicatorColor(ContextCompat.getColor(requireContext(), R.color.dashboard_success))
                            }
                            
                            if (hr.isResting) {
                                binding.tvRestingHeartRate.text = "静息: ${hr.bpm}"
                            }
                        }
                    }
                }

                launch {
                    viewModel.spO2.collectLatest { data ->
                        if (data != null) {
                            binding.tvSpo2Value.text = "${data.percent}%"
                            
                            val rule = spo2Rule
                            if (rule != null && rule.isEnabled) {
                                if (data.percent < rule.min) {
                                    binding.tvSpo2Value.setTextColor(ContextCompat.getColor(requireContext(), R.color.dashboard_error))
                                    triggerWarning(rule, "血氧异常", "当前血氧 ${data.percent}%，低于 ${rule.min.toInt()}%")
                                } else {
                                    binding.tvSpo2Value.setTextColor(ContextCompat.getColor(requireContext(), R.color.dashboard_primary))
                                }
                            } else {
                                binding.tvSpo2Value.setTextColor(ContextCompat.getColor(requireContext(), R.color.dashboard_primary))
                            }
                        }
                    }
                }

                launch {
                    viewModel.wristTemp.collectLatest { data ->
                        if (data != null) {
                            binding.tvTempValue.text = String.format("%.1f℃", data.celsius)
                        }
                    }
                }

                launch {
                    viewModel.steps.collectLatest { data ->
                        if (data != null) {
                            binding.tvStepsValue.text = data.count.toString()
                            binding.tvCalories.text = String.format("%.0f kcal", data.calories)
                            binding.progressSteps.progress = (data.count / 10000.0 * 100).toInt().coerceIn(0, 100)
                            
                            val rule = stepsRule
                            if (rule != null && rule.isEnabled) {
                                val hour = java.util.Calendar.getInstance().get(java.util.Calendar.HOUR_OF_DAY)
                                // Check after 20:00
                                if (hour >= 20) {
                                     if (data.count < rule.min) {
                                         triggerWarning(rule, "步数未达标", "今日步数 ${data.count}，目标 ${rule.min.toInt()}")
                                     }
                                }
                            }
                        }
                    }
                }

                launch {
                    viewModel.sleep.collectLatest { data ->
                        if (data != null) {
                            val hours = data.totalMinutes / 60.0
                            binding.tvSleepDuration.text = String.format("%.1f小时", hours)
                            // Handle both ratio (0.85) and legacy percentage (85.0) data
                            val effVal = if (data.efficiency > 1.0) data.efficiency.toInt() else (data.efficiency * 100).toInt()
                            binding.tvSleepEfficiency.text = "效率 $effVal%"
                            
                            val rule = sleepRule
                            if (rule != null && rule.isEnabled) {
                                 if (hours < rule.min) {
                                     triggerWarning(rule, "睡眠不足", "昨日睡眠 %.1f小时，目标 %.1f小时".format(hours, rule.min))
                                 }
                            }
                        }
                    }
                }

                launch {
                    viewModel.respRate.collectLatest { data ->
                        if (data != null) {
                            binding.tvRespValue.text = "${data.rpm}次/分"
                        }
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun showIntervalDialog() {
        val intervals = arrayOf("1分钟", "5分钟", "10分钟 (默认)", "30分钟")
        val values = intArrayOf(1, 5, 10, 30)
        
        androidx.appcompat.app.AlertDialog.Builder(requireContext())
            .setTitle("设置数据刷新频率")
            .setSingleChoiceItems(intervals, 2) { dialog, which ->
                val minutes = values[which]
                viewModel.setUpdateInterval(minutes)
                Snackbar.make(binding.root, "刷新频率已设置为: ${intervals[which]}", Snackbar.LENGTH_SHORT).show()
                dialog.dismiss()
            }
            .setNegativeButton("取消", null)
            .show()
    }
}
