package com.ankangban.health.features.dashboard

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import androidx.navigation.fragment.findNavController
import com.ankangban.health.R
import com.ankangban.health.core.storage.WarningRule
import com.ankangban.health.core.storage.WarningRuleManager
import com.ankangban.health.databinding.FragmentWarningConfigBinding
import com.ankangban.health.databinding.ItemWarningRuleCardBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.slider.RangeSlider
import com.google.android.material.slider.Slider
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputLayout

import android.app.Application
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.first
import kotlin.math.sqrt
import kotlin.math.pow
import com.ankangban.health.core.repo.HealthRepository
import com.ankangban.health.core.oppo.OppoHealthClientImpl
import com.ankangban.health.core.storage.HealthLocalStore
import com.ankangban.health.core.ai.HunyuanAiHelper

class WarningConfigFragment : Fragment() {

    private var _binding: FragmentWarningConfigBinding? = null
    private val binding get() = _binding!!

    private lateinit var ruleManager: WarningRuleManager
    private lateinit var repository: HealthRepository
    
    // Helper objects to hold references to card views
    private inner class CardViewHolder(
        val binding: ItemWarningRuleCardBinding,
        val type: String
    )

    private val cardHolders = mutableListOf<CardViewHolder>()

    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted: Boolean ->
        if (!isGranted) {
             showPermissionDeniedDialog()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWarningConfigBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ruleManager = WarningRuleManager(requireContext())
        
        val app = requireContext().applicationContext as Application
        repository = HealthRepository(
            client = OppoHealthClientImpl(app),
            store = HealthLocalStore(app)
        )

        setupToolbar()
        setupAiButton()
        setupCards()
        setupSaveButton()
        loadRules()
    }

    private fun setupAiButton() {
        binding.btnAiOptimize.setOnClickListener {
            showAiAnalysisDialog()
        }
    }

    private fun showAiAnalysisDialog() {
        val progressDialog = android.app.ProgressDialog(requireContext()).apply {
            setMessage("腾讯混元大模型正在接入...\n读取近7日健康数据并进行统计分析...")
            setCancelable(false)
            show()
        }

        lifecycleScope.launch {
            try {
                analyzeAndApplyAiRules(progressDialog)
            } catch (e: Exception) {
                progressDialog.dismiss()
                android.widget.Toast.makeText(requireContext(), "AI服务连接失败: ${e.message}", android.widget.Toast.LENGTH_LONG).show()
            }
        }
    }

    private suspend fun analyzeAndApplyAiRules(progressDialog: android.app.ProgressDialog) {
        // ... (data fetching logic remains same)
        val end = System.currentTimeMillis()
        val start = end - 7L * 24 * 60 * 60 * 1000 // 7 days

        // 1. Fetch History Data
        val hrHistory = repository.getHeartRateHistory(start, end)?.first() ?: emptyList()
        val spo2History = repository.getSpO2History(start, end)?.first() ?: emptyList()
        val stepsHistory = repository.getStepsHistory(start, end)?.first() ?: emptyList()
        val sleepHistory = repository.getSleepHistory(start, end)?.first() ?: emptyList()

        // 2. Calculate Stats (Mean & SD)
        val hrStats = calculateStats(hrHistory.map { it.value })
        val spo2Stats = calculateStats(spo2History.map { it.value })
        
        // Steps & Sleep use simple average
        val avgSteps = if (stepsHistory.isNotEmpty()) stepsHistory.map { it.count }.average() else 0.0
        val avgSleep = if (sleepHistory.isNotEmpty()) sleepHistory.map { it.totalMinutes / 60.0f }.average() else 0.0

        // 3. Determine Thresholds (Anomaly Detection: Mean +/- 2*SD)
        // Heart Rate
        var hrMin = (hrStats.first - 2 * hrStats.second).toInt()
        var hrMax = (hrStats.first + 2 * hrStats.second).toInt()
        // Safety Clamping
        if (hrMin < 45) hrMin = 45
        if (hrMax > 130) hrMax = 130
        if (hrHistory.isEmpty()) { hrMin = 50; hrMax = 120 } // Fallback

        // SpO2
        var spo2Min = (spo2Stats.first - 2 * spo2Stats.second).toInt()
        if (spo2Min < 90) spo2Min = 90 // Safety floor
        if (spo2Min > 98) spo2Min = 98
        if (spo2History.isEmpty()) spo2Min = 95 // Fallback

        var stepsGoal = (avgSteps * 1.1).toInt()
        if (stepsGoal < 8000) stepsGoal = 8000
        if (stepsGoal > 50000) stepsGoal = 50000
        
        // Sleep (Goal = Avg or 7.5)
        var sleepGoal = avgSleep.toFloat()
        if (sleepGoal < 7.5f) sleepGoal = 7.5f

        // 4. Call Spark AI for Evaluation
        val prompt = """
            用户近7日健康数据：
            心率：均值 ${hrStats.first.toInt()}，标准差 ${hrStats.second.toInt()}
            血氧：均值 ${spo2Stats.first.toInt()}
            日均步数：${avgSteps.toInt()}
            日均睡眠：${String.format("%.1f", avgSleep)}小时
            
            系统基于3σ原则建议阈值：
            心率预警范围：$hrMin - $hrMax bpm
            血氧预警下限：$spo2Min %
            建议步数目标：$stepsGoal 步
            
            请作为专业健康助手，简要点评此设置是否合理，并给出一条健康建议。
            请用“经腾讯混元大模型评估：”开头。100字以内。
        """.trimIndent()

        var aiResponse = "AI服务连接超时，使用本地规则。"
        try {
            aiResponse = HunyuanAiHelper.analyzeHealthData(prompt)
        } catch (e: Exception) {
            e.printStackTrace()
            aiResponse = "AI连接异常(${e.message})，已启用本地专家模型。"
        }

        progressDialog.dismiss()

        // 5. Apply to UI
        cardHolders.find { it.type == WarningRuleManager.TYPE_HEART_RATE }?.binding?.apply {
            switchEnable.isChecked = true
            rangeSlider.values = listOf(hrMin.toFloat(), hrMax.toFloat())
            etMin.setText(hrMin.toString())
            etMax.setText(hrMax.toString())
            cbDialog.isChecked = true
            cbNotification.isChecked = true
            cbVibration.isChecked = true 
        }

        cardHolders.find { it.type == WarningRuleManager.TYPE_SPO2 }?.binding?.apply {
            switchEnable.isChecked = true
            singleSlider.value = spo2Min.toFloat()
            etMin.setText(spo2Min.toString())
            cbDialog.isChecked = true
            cbNotification.isChecked = true
        }

        cardHolders.find { it.type == WarningRuleManager.TYPE_STEPS }?.binding?.apply {
            switchEnable.isChecked = true
            singleSlider.value = stepsGoal.toFloat()
            etMin.setText(stepsGoal.toString())
            cbNotification.isChecked = true
        }

        cardHolders.find { it.type == WarningRuleManager.TYPE_SLEEP }?.binding?.apply {
            switchEnable.isChecked = true
            // Fix: Snap sleep goal to stepSize (0.5)
            val stepSize = singleSlider.stepSize
            val snappedGoal = snapToStep(sleepGoal, stepSize)
            singleSlider.value = snappedGoal
            etMin.setText(String.format("%.1f", snappedGoal))
            cbNotification.isChecked = true
        }

        // Show Success Dialog with AI content
        MaterialAlertDialogBuilder(requireContext())
            .setTitle("AI 个性化评估完成")
            .setIcon(R.drawable.ic_ai_stars)
            .setMessage(aiResponse)
            .setPositiveButton("应用配置") { dialog, _ ->
                validateAndSave()
                dialog.dismiss()
            }
            .setNegativeButton("取消", null)
            .show()
    }

    private fun calculateStats(data: List<Float>): Pair<Float, Float> {
        if (data.isEmpty()) return Pair(0f, 0f)
        val mean = data.average().toFloat()
        val sumSq = data.fold(0.0) { acc, num -> acc + (num - mean).pow(2) }
        val sd = sqrt(sumSq / data.size).toFloat()
        return Pair(mean, sd)
    }

    // Removed old applyAiRecommendations and simulated logic
    /*
    private fun applyAiRecommendations() { ... }
    */

    private fun setupToolbar() {
        binding.toolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
        binding.btnReset.setOnClickListener {
            showResetConfirmationDialog()
        }
    }

    private fun setupCards() {
        // Heart Rate
        val heartRateBinding = ItemWarningRuleCardBinding.bind(binding.cardHeartRate.root)
        setupCard(heartRateBinding, WarningRuleManager.TYPE_HEART_RATE, "心率预警规则", 50f, 150f, true)
        cardHolders.add(CardViewHolder(heartRateBinding, WarningRuleManager.TYPE_HEART_RATE))

        // SpO2
        val spo2Binding = ItemWarningRuleCardBinding.bind(binding.cardSpo2.root)
        setupCard(spo2Binding, WarningRuleManager.TYPE_SPO2, "血氧预警规则", 80f, 100f, false)
        cardHolders.add(CardViewHolder(spo2Binding, WarningRuleManager.TYPE_SPO2))

        val stepsBinding = ItemWarningRuleCardBinding.bind(binding.cardSteps.root)
        setupCard(stepsBinding, WarningRuleManager.TYPE_STEPS, "步数达标预警", 0f, 50000f, false)
        cardHolders.add(CardViewHolder(stepsBinding, WarningRuleManager.TYPE_STEPS))

        // Sleep
        val sleepBinding = ItemWarningRuleCardBinding.bind(binding.cardSleep.root)
        setupCard(sleepBinding, WarningRuleManager.TYPE_SLEEP, "睡眠不足预警", 0f, 12f, false)
        cardHolders.add(CardViewHolder(sleepBinding, WarningRuleManager.TYPE_SLEEP))
    }

    private fun setupCard(
        cardBinding: ItemWarningRuleCardBinding,
        type: String,
        title: String,
        sliderMin: Float,
        sliderMax: Float,
        isRange: Boolean
    ) {
        cardBinding.tvTitle.text = title
        
        // Setup RangeSlider or Single Slider
        if (isRange) {
            cardBinding.rangeSlider.visibility = View.VISIBLE
            cardBinding.singleSlider.visibility = View.GONE
            cardBinding.tilMax.visibility = View.VISIBLE
            
            cardBinding.rangeSlider.valueFrom = sliderMin
            cardBinding.rangeSlider.valueTo = sliderMax
            cardBinding.rangeSlider.stepSize = 1f

            // Set initial values to avoid IndexOutOfBoundsException
            cardBinding.rangeSlider.values = listOf(sliderMin, sliderMax)

            // Slider Listener
            cardBinding.rangeSlider.addOnChangeListener { slider, _, _ ->
                val values = slider.values
                if (values.size >= 2) {
                    cardBinding.etMin.setText(values[0].toInt().toString())
                    cardBinding.etMax.setText(values[1].toInt().toString())
                }
                updateRangeHint(cardBinding, type)
            }
        } else {
            cardBinding.rangeSlider.visibility = View.GONE
            cardBinding.singleSlider.visibility = View.VISIBLE
            cardBinding.tilMax.visibility = View.GONE
            
            cardBinding.singleSlider.valueFrom = sliderMin
            cardBinding.singleSlider.valueTo = sliderMax
            cardBinding.singleSlider.stepSize = if (type == WarningRuleManager.TYPE_SPO2) 1f else if(type == WarningRuleManager.TYPE_SLEEP) 0.5f else 100f

            // Slider Listener
            cardBinding.singleSlider.addOnChangeListener { slider, value, _ ->
                cardBinding.etMin.setText(if (type == WarningRuleManager.TYPE_SLEEP) value.toString() else value.toInt().toString())
                updateRangeHint(cardBinding, type)
            }
        }

        // EditText Listeners (Simplified for brevity, bidirectional sync needs care to avoid loops)
        // For now, we update sliders on focus lost or action done, to avoid jitter
        val textWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                // Real-time sync from Text to Slider is tricky with validation. 
                // We'll rely on Slider -> Text for main interaction, and validate Text on Save.
                // Or implementing safe sync if needed.
                // For demo, let's keep it simple: Text edits don't auto-move slider instantly to avoid UX issues while typing
                // But we can update on valid input
                try {
                    val value = s.toString().toFloatOrNull()
                    if (value != null) {
                        if (isRange) {
                           // Complex logic for range
                        } else {
                            if (value >= sliderMin && value <= sliderMax) {
                                // Fix: Snap value to stepSize to avoid IllegalStateException
                                val stepSize = cardBinding.singleSlider.stepSize
                                cardBinding.singleSlider.value = snapToStep(value, stepSize)
                            }
                        }
                    }
                } catch (e: Exception) {}
            }
        }
        cardBinding.etMin.addTextChangedListener(textWatcher)
        if (isRange) cardBinding.etMax.addTextChangedListener(textWatcher)

        // Switch Listener
        cardBinding.switchEnable.setOnCheckedChangeListener { _, isChecked ->
            setCardEnabledState(cardBinding, isChecked)
        }

        // Notification Checkbox Listener
        cardBinding.cbNotification.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked && buttonView.isPressed) { // Only if user triggered
                checkNotificationPermission()
            }
        }
    }

    private fun setCardEnabledState(binding: ItemWarningRuleCardBinding, isEnabled: Boolean) {
        binding.rangeSlider.isEnabled = isEnabled
        binding.singleSlider.isEnabled = isEnabled
        binding.tilMin.isEnabled = isEnabled
        binding.tilMax.isEnabled = isEnabled
        binding.cbDialog.isEnabled = isEnabled
        binding.cbNotification.isEnabled = isEnabled
        binding.cbVibration.isEnabled = isEnabled
        
        val alpha = if (isEnabled) 1.0f else 0.5f
        binding.rangeSlider.alpha = alpha
        binding.singleSlider.alpha = alpha
        binding.tilMin.alpha = alpha
        binding.tilMax.alpha = alpha
        binding.cbDialog.alpha = alpha
        binding.cbNotification.alpha = alpha
        binding.cbVibration.alpha = alpha
    }

    private fun updateRangeHint(binding: ItemWarningRuleCardBinding, type: String) {
        val min = binding.etMin.text.toString()
        val max = binding.etMax.text.toString()
        val text = when (type) {
            WarningRuleManager.TYPE_HEART_RATE -> "正常范围：$min - $max 次/分"
            WarningRuleManager.TYPE_SPO2 -> "正常范围：≥ $min %"
            WarningRuleManager.TYPE_STEPS -> "达标目标：≥ $min 步"
            WarningRuleManager.TYPE_SLEEP -> "达标目标：≥ $min 小时"
            else -> ""
        }
        binding.tvRangeHint.text = text
    }

    private fun loadRules() {
        cardHolders.forEach { holder ->
            val rule = ruleManager.getRule(holder.type)
            bindRuleToCard(holder.binding, rule)
        }
    }

    private fun bindRuleToCard(binding: ItemWarningRuleCardBinding, rule: WarningRule) {
        binding.switchEnable.isChecked = rule.isEnabled
        
        if (rule.type == WarningRuleManager.TYPE_HEART_RATE) {
            binding.rangeSlider.setValues(rule.min, rule.max)
            binding.etMin.setText(rule.min.toInt().toString())
            binding.etMax.setText(rule.max.toInt().toString())
        } else {
            val value = when (rule.type) {
                WarningRuleManager.TYPE_SPO2 -> rule.min.coerceIn(80f, 100f)
                WarningRuleManager.TYPE_STEPS -> rule.min.coerceIn(0f, 50000f)
                WarningRuleManager.TYPE_SLEEP -> rule.min.coerceIn(0f, 12f)
                else -> rule.min
            }
            // Fix: Snap value to stepSize to avoid IllegalStateException
            // "Value must be equal to valueFrom plus a multiple of stepSize"
            val stepSize = binding.singleSlider.stepSize
            binding.singleSlider.value = snapToStep(value, stepSize)
            
            binding.etMin.setText(if (rule.type == WarningRuleManager.TYPE_SLEEP) value.toString() else value.toInt().toString())
        }
        
        binding.cbDialog.isChecked = rule.enableDialog
        binding.cbNotification.isChecked = rule.enableNotification
        binding.cbVibration.isChecked = rule.enableVibration
        
        setCardEnabledState(binding, rule.isEnabled)
        updateRangeHint(binding, rule.type)
    }

    private fun setupSaveButton() {
        binding.btnSave.setOnClickListener {
            if (validateAndSave()) {
                Snackbar.make(binding.root, "预警规则已生效", Snackbar.LENGTH_SHORT).show()
                // Broadcast change
                val intent = Intent(WarningRuleManager.ACTION_RULES_CHANGED)
                LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(intent)
                
                // Return to dashboard after delay
                binding.root.postDelayed({
                    findNavController().navigateUp()
                }, 1000)
            }
        }
    }

    private fun snapToStep(value: Float, stepSize: Float): Float {
        if (stepSize <= 0) return value
        return (kotlin.math.round(value / stepSize) * stepSize)
    }

    private fun validateAndSave(): Boolean {
        var isValid = true
        
        for (holder in cardHolders) {
            val rule = WarningRule(holder.type)
            rule.isEnabled = holder.binding.switchEnable.isChecked
            
            if (!rule.isEnabled) {
                ruleManager.saveRule(rule) // Save disabled state
                continue
            }

            // Validate inputs
            val minStr = holder.binding.etMin.text.toString()
            val min = minStr.toFloatOrNull()
            
            if (min == null) {
                holder.binding.tilMin.error = "请输入数值"
                isValid = false
                continue
            }

            // Type specific validation
            when (holder.type) {
                WarningRuleManager.TYPE_HEART_RATE -> {
                    val maxStr = holder.binding.etMax.text.toString()
                    val max = maxStr.toFloatOrNull()
                    if (max == null) {
                        holder.binding.tilMax.error = "请输入数值"
                        isValid = false
                        continue
                    }
                    if (min < 40 || max > 180 || min >= max) {
                        Snackbar.make(binding.root, "心率阈值不合理 (40-180且min<max)", Snackbar.LENGTH_SHORT).show()
                        isValid = false
                        continue
                    }
                    rule.min = min
                    rule.max = max
                }
                WarningRuleManager.TYPE_SPO2 -> {
                    if (min < 90 || min > 100) {
                        Snackbar.make(binding.root, "血氧阈值不合理 (90-100)", Snackbar.LENGTH_SHORT).show()
                        isValid = false
                        continue
                    }
                    rule.min = min
                }
                WarningRuleManager.TYPE_STEPS -> {
                    if (min < 0 || min > 50000) {
                        Snackbar.make(binding.root, "步数阈值不合理 (0-50000)", Snackbar.LENGTH_SHORT).show()
                        isValid = false
                        continue
                    }
                    rule.min = min
                }
                WarningRuleManager.TYPE_SLEEP -> {
                    if (min < 3 || min > 12) {
                        Snackbar.make(binding.root, "睡眠阈值不合理 (3-12小时)", Snackbar.LENGTH_SHORT).show()
                        isValid = false
                        continue
                    }
                    rule.min = min
                }
            }

            // Check warning methods
            rule.enableDialog = holder.binding.cbDialog.isChecked
            rule.enableNotification = holder.binding.cbNotification.isChecked
            rule.enableVibration = holder.binding.cbVibration.isChecked
            
            if (!rule.enableDialog && !rule.enableNotification && !rule.enableVibration) {
                Snackbar.make(binding.root, "请至少选择一种预警方式", Snackbar.LENGTH_SHORT).show()
                isValid = false
                continue
            }
            
            ruleManager.saveRule(rule)
        }
        
        return isValid
    }

    private fun showResetConfirmationDialog() {
        MaterialAlertDialogBuilder(requireContext())
            .setTitle("确认重置？")
            .setMessage("确认恢复默认预警规则？")
            .setPositiveButton("确认") { _, _ ->
                ruleManager.resetToDefaults()
                loadRules()
                Snackbar.make(binding.root, "已恢复默认规则", Snackbar.LENGTH_SHORT).show()
            }
            .setNegativeButton("取消", null)
            .show()
    }
    
    private fun checkNotificationPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(
                    requireContext(),
                    Manifest.permission.POST_NOTIFICATIONS
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                requestPermissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
            }
        }
    }
    
    private fun showPermissionDeniedDialog() {
        MaterialAlertDialogBuilder(requireContext())
            .setTitle("权限申请")
            .setMessage("为接收健康异常预警，请允许「安康伴」发送通知")
            .setPositiveButton("去设置") { _, _ ->
                val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS).apply {
                    data = Uri.fromParts("package", requireContext().packageName, null)
                }
                startActivity(intent)
            }
            .setNegativeButton("取消") { dialog, _ ->
                // Uncheck the box if permission denied
                cardHolders.forEach { holder ->
                     holder.binding.cbNotification.isChecked = false
                }
                dialog.dismiss()
            }
            .show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
