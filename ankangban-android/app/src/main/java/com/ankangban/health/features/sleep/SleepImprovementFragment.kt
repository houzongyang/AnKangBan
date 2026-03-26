package com.ankangban.health.features.sleep

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.ankangban.health.R
import com.ankangban.health.databinding.FragmentSleepImprovementBinding
import com.ankangban.health.features.sleep.logic.SleepQualityLevel
import com.ankangban.health.ui.viewmodel.SleepImprovementViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Locale
import androidx.navigation.fragment.findNavController

class SleepImprovementFragment : Fragment() {

    private var _binding: FragmentSleepImprovementBinding? = null
    private val binding get() = _binding!!
    private val viewModel: SleepImprovementViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSleepImprovementBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        setupListeners()
        observeViewModel()
        
        // Trigger AI plan generation
        viewModel.generateAiPlan()
    }

    private fun setupListeners() {
        binding.btnBack.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        binding.btnRegenerateAi.setOnClickListener {
            viewModel.generateAiPlan(true)
        }
        
        // Auto-sync notification
        Snackbar.make(binding.root, "已自动同步最新睡眠监测数据", Snackbar.LENGTH_SHORT).show()

        binding.switchMonitoring.setOnCheckedChangeListener { _, isChecked ->
            val msg = if (isChecked) "睡眠监测已开启" else "睡眠监测已暂停"
            Snackbar.make(binding.root, msg, Snackbar.LENGTH_SHORT).show()
        }
        
        binding.spinnerPeriod.setOnClickListener {
            val constraintsBuilder = com.google.android.material.datepicker.CalendarConstraints.Builder()
                .setValidator(com.google.android.material.datepicker.DateValidatorPointBackward.now())

            val datePicker = com.google.android.material.datepicker.MaterialDatePicker.Builder.datePicker()
                .setTitleText("选择日期")
                .setSelection(com.google.android.material.datepicker.MaterialDatePicker.todayInUtcMilliseconds())
                .setCalendarConstraints(constraintsBuilder.build())
                .build()

            datePicker.addOnPositiveButtonClickListener { selection ->
                // Adjust for timezone offset if needed, or just use as is if logic handles it
                // MaterialDatePicker returns UTC start of day. 
                // Our system usually works with local time. 
                // Simple fix: Add timezone offset or use Calendar
                val calendar = java.util.Calendar.getInstance(java.util.TimeZone.getTimeZone("UTC"))
                calendar.timeInMillis = selection
                // Convert to local 
                val localCalendar = java.util.Calendar.getInstance()
                localCalendar.set(calendar.get(java.util.Calendar.YEAR), calendar.get(java.util.Calendar.MONTH), calendar.get(java.util.Calendar.DAY_OF_MONTH))
                
                viewModel.setDate(localCalendar.timeInMillis)
            }
            datePicker.show(parentFragmentManager, "date_picker")
        }

        binding.btnDailyCheckIn.setOnClickListener {
            val plan = viewModel.sevenDayPlan.value
            if (plan != null && !plan.isCompleted) {
                viewModel.completeDailyPlan(plan)
                showCheckInSuccessDialog()
            } else {
                Snackbar.make(binding.root, "今日已打卡", Snackbar.LENGTH_SHORT).show()
            }
        }

        binding.btnTrends.setOnClickListener {
            val bundle = android.os.Bundle().apply {
                putInt("initialType", 3) // 3 = Sleep
            }
            findNavController().navigate(R.id.action_sleep_to_trends, bundle)
        }
        
        binding.btnTools.setOnClickListener {
            findNavController().navigate(R.id.action_sleep_to_tools)
        }

        binding.btnCalendar.setOnClickListener {
            findNavController().navigate(R.id.action_sleep_to_calendar)
        }
    }

    private fun showCheckInSuccessDialog() {
        val dialog = com.google.android.material.dialog.MaterialAlertDialogBuilder(requireContext())
            .setTitle("打卡成功！")
            .setMessage("恭喜完成今日助眠计划！\n\n获得积分：+10\n当前连胜：${viewModel.checkInStreak.value + 1}天")
            .setPositiveButton("太棒了") { d, _ -> d.dismiss() }
            .create()
        dialog.show()
    }

    private fun observeViewModel() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.selectedDate.collectLatest { date ->
                val calendar = java.util.Calendar.getInstance()
                calendar.time = date
                val today = java.util.Calendar.getInstance()
                
                val isToday = calendar.get(java.util.Calendar.YEAR) == today.get(java.util.Calendar.YEAR) &&
                              calendar.get(java.util.Calendar.DAY_OF_YEAR) == today.get(java.util.Calendar.DAY_OF_YEAR)
                
                val yesterday = java.util.Calendar.getInstance()
                yesterday.add(java.util.Calendar.DAY_OF_YEAR, -1)
                val isYesterday = calendar.get(java.util.Calendar.YEAR) == yesterday.get(java.util.Calendar.YEAR) &&
                                  calendar.get(java.util.Calendar.DAY_OF_YEAR) == yesterday.get(java.util.Calendar.DAY_OF_YEAR)

                binding.spinnerPeriod.text = when {
                    isToday -> "今日"
                    isYesterday -> "昨日"
                    else -> SimpleDateFormat("MM月dd日", Locale.getDefault()).format(date)
                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.loading.collectLatest { isLoading ->
                binding.loadingOverlay.visibility = if (isLoading) View.VISIBLE else View.GONE
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.sleepData.collectLatest { data ->
                if (data != null) {
                    val percent = if (data.totalMinutes > 0) 
                        (data.deepMinutes.toFloat() / data.totalMinutes * 100).toInt() else 0
                    
                    binding.progressDeepSleep.progress = percent
                    binding.tvDeepSleepPercent.text = "$percent%"
                    
                    val hours = data.totalMinutes / 60.0
                    binding.tvDuration.text = String.format("时长: %.1fh", hours)
                    
                    // Handle both ratio (0.85) and legacy percentage (85.0) data
                    val efficiencyVal = if (data.efficiency > 1.0) data.efficiency.toInt() else (data.efficiency * 100).toInt()
                    binding.tvEfficiency.text = "效率: $efficiencyVal%"
                    
                    binding.tvLightSleep.text = "浅睡: ${(data.lightMinutes.toFloat() / data.totalMinutes * 100).toInt()}%"
                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.qualityResult.collectLatest { result ->
                if (result != null) {
                    // Update Grid Extra Metrics from result (simulated)
                    binding.tvLatency.text = "入睡: ${result.latencyMinutes}min"
                    binding.tvAwake.text = "觉醒: ${result.awakeCount}次"
                    
                    // Update Quality Card
                    val color = when (result.level) {
                        SleepQualityLevel.EXCELLENT -> 0xFF4CAF50.toInt() // Green
                        SleepQualityLevel.GOOD -> 0xFF2196F3.toInt() // Blue
                        SleepQualityLevel.FAIR -> 0xFFFFC107.toInt() // Amber
                        SleepQualityLevel.POOR -> 0xFFF44336.toInt() // Red
                    }
                    
                    binding.ivQualityIcon.setColorFilter(color)
                    binding.tvQualityLevel.text = "睡眠质量：${
                        when(result.level) {
                            SleepQualityLevel.EXCELLENT -> "优质"
                            SleepQualityLevel.GOOD -> "良好"
                            SleepQualityLevel.FAIR -> "一般"
                            SleepQualityLevel.POOR -> "较差"
                        }
                    }"
                    binding.tvQualityLevel.setTextColor(color)
                    
                    binding.tvQualityReason.text = if (result.reasons.isNotEmpty()) 
                        result.reasons.joinToString("；") else "各项指标表现良好"
                        
                    binding.tvQualityImprovement.text = if (result.improvements.isNotEmpty()) 
                        "建议：" + result.improvements.joinToString("；") else "继续保持！"
                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.aiPlan.collectLatest { plan ->
                if (plan == null) {
                    binding.pbAiLoading.visibility = View.VISIBLE
                    binding.btnRegenerateAi.visibility = View.GONE
                } else {
                    binding.pbAiLoading.visibility = View.GONE
                    binding.btnRegenerateAi.visibility = View.VISIBLE
                    
                    // Display Plans
                    binding.llPlanStepsContainer.removeAllViews()
                    plan.plans.forEach { dim ->
                        dim.steps.forEach { step ->
                            // Step Item
                            val stepView = android.widget.LinearLayout(requireContext()).apply {
                                orientation = android.widget.LinearLayout.HORIZONTAL
                                layoutParams = android.widget.LinearLayout.LayoutParams(
                                    android.widget.LinearLayout.LayoutParams.MATCH_PARENT,
                                    android.widget.LinearLayout.LayoutParams.WRAP_CONTENT
                                ).apply {
                                    setMargins(0, 8, 0, 8)
                                }
                                setPadding(24, 24, 24, 24)
                                background = android.graphics.drawable.GradientDrawable().apply {
                                    setColor(android.graphics.Color.parseColor("#FFFFFF"))
                                    cornerRadius = 16f
                                    setStroke(2, android.graphics.Color.parseColor("#E0E0E0"))
                                }
                                gravity = android.view.Gravity.CENTER_VERTICAL
                            }

                            // Checkbox
                            val checkBox = com.google.android.material.checkbox.MaterialCheckBox(requireContext()).apply {
                                setOnCheckedChangeListener { _, isChecked ->
                                    stepView.alpha = if (isChecked) 0.5f else 1.0f
                                }
                            }
                            stepView.addView(checkBox)

                            // Text Content
                            val contentLayout = android.widget.LinearLayout(requireContext()).apply {
                                orientation = android.widget.LinearLayout.VERTICAL
                                layoutParams = android.widget.LinearLayout.LayoutParams(
                                    0,
                                    android.widget.LinearLayout.LayoutParams.WRAP_CONTENT,
                                    1f
                                ).apply {
                                    marginStart = 16
                                }
                            }

                            val tvContent = android.widget.TextView(requireContext()).apply {
                                text = step.content
                                setTextColor(android.graphics.Color.parseColor("#333333"))
                                textSize = 14f
                            }
                            
                            val tvDuration = android.widget.TextView(requireContext()).apply {
                                text = step.duration
                                setTextColor(android.graphics.Color.parseColor("#757575"))
                                textSize = 12f
                                setPadding(0, 4, 0, 0)
                            }
                            
                            contentLayout.addView(tvContent)
                            contentLayout.addView(tvDuration)
                            stepView.addView(contentLayout)
                            
                            // Icon (Optional, simple text or emoji based on type)
                            val iconText = when(step.iconType) {
                                "DEVICE" -> "📱"
                                "DRINK" -> "🥛"
                                "BREATHE" -> "🌬️"
                                "STRETCH" -> "🧘"
                                "LIGHT" -> "💡"
                                "TEMPERATURE" -> "🌡️"
                                else -> "💤"
                            }
                            val tvIcon = android.widget.TextView(requireContext()).apply {
                                text = iconText
                                textSize = 20f
                                setPadding(16, 0, 0, 0)
                            }
                            stepView.addView(tvIcon)

                            binding.llPlanStepsContainer.addView(stepView)
                        }
                    }
                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.sevenDayPlan.collectLatest { plan ->
                if (plan != null) {
                    binding.tvDailyPlanTitle.text = plan.title
                    
                    // Parse simplified JSON or just use text if simple
                    // Assuming itemsJson is "[\"Item 1\"]"
                    val content = plan.itemsJson.replace("[\"", "").replace("\"]", "").replace("\",\"", "\n")
                    binding.tvDailyPlanContent.text = content
                    
                    if (plan.isCompleted) {
                        binding.btnDailyCheckIn.text = "已打卡"
                        binding.btnDailyCheckIn.setIconResource(R.drawable.ic_check_circle)
                        binding.btnDailyCheckIn.isEnabled = false
                    } else {
                        binding.btnDailyCheckIn.text = "今日打卡"
                        binding.btnDailyCheckIn.setIconResource(R.drawable.ic_check)
                        binding.btnDailyCheckIn.isEnabled = true
                    }
                }
            }
        }
        
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.sevenDayProgress.collectLatest { (current, total) ->
                binding.tvPlanProgress.text = "进度 $current/$total"
                binding.progress7Day.max = total
                binding.progress7Day.progress = current
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.userPoints.collectLatest { points ->
                binding.tvPoints.text = "🏆 $points"
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
