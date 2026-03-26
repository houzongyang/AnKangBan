package com.ankangban.health.features.sleep.calendar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.ankangban.health.R
import com.ankangban.health.core.storage.SleepCheckInEntity
import com.ankangban.health.databinding.FragmentSleepCalendarBinding
import com.ankangban.health.ui.viewmodel.SleepImprovementViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class SleepCalendarFragment : Fragment() {

    private var _binding: FragmentSleepCalendarBinding? = null
    private val binding get() = _binding!!
    private val viewModel: SleepImprovementViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSleepCalendarBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        setupUI()
        observeViewModel()
    }

    private fun setupUI() {
        binding.btnBack.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        binding.btnSubmitCheckIn.setOnClickListener {
            val mood = when (binding.rgMood.checkedRadioButtonId) {
                R.id.rbGreat -> "精神饱满"
                R.id.rbNormal -> "平平淡淡"
                R.id.rbTired -> "有点疲惫"
                else -> "未选择"
            }
            
            if (mood == "未选择") {
                com.google.android.material.snackbar.Snackbar.make(binding.root, "请选择当前心情", com.google.android.material.snackbar.Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            viewModel.submitCheckIn(mood, viewModel.sleepData.value)
            
            binding.btnSubmitCheckIn.isEnabled = false
            binding.btnSubmitCheckIn.text = "打卡成功"
        }
        
        val adapter = CheckInAdapter()
        binding.rvHistory.adapter = adapter
    }

    private fun observeViewModel() {
        // Sleep Data for Auto-Sync UI
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.sleepData.collectLatest { data ->
                if (data != null) {
                    val durationHours = data.totalMinutes / 60.0
                    binding.tvDuration.text = String.format("%.1fh", durationHours)
                    
                    val sdf = SimpleDateFormat("HH:mm", Locale.getDefault())
                    binding.tvStartTime.text = sdf.format(Date(data.startTime))
                    binding.tvEndTime.text = sdf.format(Date(data.endTime))
                } else {
                    binding.tvDuration.text = "--"
                    binding.tvStartTime.text = "--:--"
                    binding.tvEndTime.text = "--:--"
                }
            }
        }

        // Check-in History
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.checkIns.collectLatest { list ->
                (binding.rvHistory.adapter as? CheckInAdapter)?.submitList(list)
                updateCheckInButtonState(list)
                
                // Show AI result if checked in today
                val today = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())
                if (list.any { it.date == today }) {
                     // If we have a local record, we might want to show it.
                     // Currently viewModel.checkInAiResult is used for immediate feedback.
                     // If user comes back later, we might not have the AI text in viewModel.checkInAiResult (it's in memory).
                     // Ideally we should save the AI text in DB. 
                     // But for now, let's at least show a "Completed" state in the card.
                     binding.cardAiResult.visibility = View.VISIBLE
                     binding.tvAiResultContent.text = "您今天已经完成打卡！保持好心情哦～"
                }
            }
        }
        
        // AI Feedback
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.checkInAiResult.collectLatest { result ->
                if (result != null) {
                    binding.cardAiResult.visibility = View.VISIBLE
                    binding.tvAiResultContent.text = result
                }
            }
        }
    }

    private fun updateCheckInButtonState(history: List<SleepCheckInEntity>) {
        val today = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())
        val hasCheckedIn = history.any { it.date == today }
        
        if (hasCheckedIn) {
            // Hide input form, show completion message
            binding.rgMood.visibility = View.GONE
            binding.btnSubmitCheckIn.visibility = View.GONE
            return
        }

        val calendar = java.util.Calendar.getInstance()
        val hour = calendar.get(java.util.Calendar.HOUR_OF_DAY)
        
        // Allowed time: 04:00 - 12:00
        if (hour < 4 || hour >= 12) {
            binding.btnSubmitCheckIn.isEnabled = false
            binding.btnSubmitCheckIn.text = "请在早上打卡 (04:00-12:00)"
            binding.btnSubmitCheckIn.alpha = 0.6f
            binding.rgMood.visibility = View.GONE
            
            // Show a reminder card instead of just disabled button
            binding.cardAiResult.visibility = View.VISIBLE
            binding.tvAiResultContent.text = "早安！睡眠打卡仅在每天 04:00 - 12:00 开放。\n请在明早起床后记得来打卡哦！🌙"
            binding.btnSubmitCheckIn.visibility = View.GONE
        } else {
            binding.btnSubmitCheckIn.isEnabled = true
            binding.btnSubmitCheckIn.text = "生成 AI 睡眠日报 (+20积分)"
            binding.btnSubmitCheckIn.alpha = 1.0f
            binding.rgMood.visibility = View.VISIBLE
            binding.btnSubmitCheckIn.visibility = View.VISIBLE
            binding.cardAiResult.visibility = View.GONE
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    class CheckInAdapter : RecyclerView.Adapter<CheckInAdapter.ViewHolder>() {
        private var list = listOf<SleepCheckInEntity>()

        fun submitList(newList: List<SleepCheckInEntity>) {
            list = newList.sortedByDescending { it.date }
            notifyDataSetChanged()
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(com.ankangban.health.R.layout.item_sleep_check_in, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val item = list[position]
            val timeStr = SimpleDateFormat("HH:mm", Locale.getDefault()).format(Date(item.timestamp))
            holder.text1.text = "${item.date}  $timeStr"
            holder.text2.text = "状态: ${item.qualityLevel}"
        }

        override fun getItemCount() = list.size

        class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val text1: TextView = view.findViewById(com.ankangban.health.R.id.tvTime)
            val text2: TextView = view.findViewById(com.ankangban.health.R.id.tvStatus)
        }
    }
}