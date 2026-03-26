package com.ankangban.health.features.sleep.tools

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.ankangban.health.databinding.FragmentSleepToolsBinding
import com.ankangban.health.ui.viewmodel.SleepToolsViewModel
import com.google.android.material.chip.Chip
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

import com.ankangban.health.core.storage.AiContentEntity
import com.ankangban.health.core.api.SleepAidContentResponse

class SleepToolsFragment : Fragment() {

    private var _binding: FragmentSleepToolsBinding? = null
    private val binding get() = _binding!!
    
    private val viewModel: SleepToolsViewModel by activityViewModels()
    
    private var historyList: List<AiContentEntity> = emptyList()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSleepToolsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        setupClickListeners()
        setupObservers()
    }

    private fun updatePointsDisplay() {
        // Removed: Logic moved to ViewModel and Observer
    }

    private fun setupClickListeners() {
        binding.btnBack.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
        
        binding.btnDarkMode.setOnClickListener {
            // Toggle logic (simulated)
            val isNight = binding.toolbar.tag == "night"
            if (isNight) {
                binding.toolbar.tag = "day"
                binding.btnDarkMode.setImageResource(com.ankangban.health.R.drawable.ic_waves)
                // In real app, change theme or background colors
                Toast.makeText(requireContext(), "已关闭夜间模式", Toast.LENGTH_SHORT).show()
            } else {
                binding.toolbar.tag = "night"
                binding.btnDarkMode.setImageResource(com.ankangban.health.R.drawable.ic_clock) // Assuming icon exists or reuse
                Toast.makeText(requireContext(), "已开启夜间模式", Toast.LENGTH_SHORT).show()
            }
        }

        // Scene Switcher Removed
        
        // AI Generator
        binding.btnGenerate.setOnClickListener {
            val typeId = binding.chipGroupType.checkedChipId
            val type = if (typeId == binding.chipStory.id) "助眠故事" else "冥想引导"
            
            val tags = mutableListOf<String>()
            binding.chipGroupTags.checkedChipIds.forEach { id ->
                val chip = binding.chipGroupTags.findViewById<Chip>(id)
                tags.add(chip.text.toString())
            }
            
            viewModel.generateContent(type, tags)
        }
        
        binding.btnAiHistory.setOnClickListener {
            showHistoryDialog()
        }
        
        binding.btnPlayAi.setOnClickListener {
            val title = binding.tvAiTitle.text.toString()
            viewModel.togglePlay(title)
        }
        
        // Tool Cards
        binding.cardWhiteNoise.setOnClickListener {
            WhiteNoiseBottomSheet().show(childFragmentManager, "WhiteNoise")
        }
        binding.cardBreathing.setOnClickListener {
            BreathingTrainingBottomSheet().show(childFragmentManager, "BreathingTraining")
        }
        binding.cardMeditation.setOnClickListener {
            MeditationBottomSheet().show(childFragmentManager, "MeditationCourse")
        }
    }

    private fun setupObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.aiHistory.collectLatest { list ->
                historyList = list
            }
        }
        
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.toastEvent.collectLatest { message ->
                Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.isGenerating.collectLatest { loading ->
                binding.loadingOverlay.visibility = if (loading) View.VISIBLE else View.GONE
            }
        }
        
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.aiContent.collectLatest { content ->
                if (content != null) {
                    binding.layoutAiResult.visibility = View.VISIBLE
                    binding.tvAiTitle.text = content.title
                    binding.tvAiContent.text = content.content
                    // Auto scroll to result
                    binding.layoutAiResult.parent.requestChildFocus(binding.layoutAiResult, binding.layoutAiResult)
                }
            }
        }
        
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.isPlaying.collectLatest { isPlaying ->
                if (isPlaying) {
                    if (viewModel.isSilentMode.value) {
                         // Silent Mode: Still use pause icon as it indicates "Stop", but user knows it's silent via Toast/Text Color
                         binding.btnPlayAi.setImageResource(android.R.drawable.ic_media_pause)
                    } else {
                        binding.btnPlayAi.setImageResource(android.R.drawable.ic_media_pause)
                    }
                } else {
                    binding.btnPlayAi.setImageResource(android.R.drawable.ic_media_play)
                }
            }
        }
        
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.isSilentMode.collectLatest { isSilent ->
                if (isSilent) {
                    // Update UI to reflect Silent Mode
                    binding.tvAiTimer.setTextColor(0xFF795548.toInt()) // Brownish to indicate reading?
                    
                    // Show Actionable Snackbar to fix TTS
                    com.google.android.material.snackbar.Snackbar.make(
                        binding.root,
                        "检测到语音组件缺失，建议前往设置修复",
                        com.google.android.material.snackbar.Snackbar.LENGTH_LONG
                    ).setAction("去设置") {
                        try {
                            val intent = android.content.Intent()
                            intent.action = "com.android.settings.TTS_SETTINGS"
                            intent.flags = android.content.Intent.FLAG_ACTIVITY_NEW_TASK
                            startActivity(intent)
                        } catch (e: Exception) {
                            Toast.makeText(requireContext(), "无法打开系统TTS设置页面", Toast.LENGTH_SHORT).show()
                        }
                    }.show()
                }
            }
        }
        
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.playbackProgress.collectLatest { progress ->
                binding.seekBarAi.progress = progress
            }
        }
        
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.playbackTime.collectLatest { time ->
                binding.tvAiTimer.text = time
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.recommendedTool.collectLatest { tool ->
                binding.badgeMeditation.visibility = View.GONE
                binding.badgeBreathing.visibility = View.GONE
                binding.badgeWhiteNoise.visibility = View.GONE
                
                when(tool) {
                    "meditation" -> binding.badgeMeditation.visibility = View.VISIBLE
                    "breathing" -> binding.badgeBreathing.visibility = View.VISIBLE
                    "white_noise" -> binding.badgeWhiteNoise.visibility = View.VISIBLE
                }
            }
        }
        
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.userPoints.collectLatest { points ->
                // Simple Level Logic: Level = Points / 100 + 1
                val level = points / 100 + 1
                binding.tvUserPoints.text = "Lv.$level 🏆 $points"
            }
        }
    }

    private fun showHistoryDialog() {
        if (historyList.isEmpty()) {
            Toast.makeText(requireContext(), "暂无历史记录", Toast.LENGTH_SHORT).show()
            return
        }

        val items = historyList.map { "${it.title} (${it.type})" }.toTypedArray()
        
        androidx.appcompat.app.AlertDialog.Builder(requireContext())
            .setTitle("AI 生成记录")
            .setItems(items) { _, which ->
                val selected = historyList[which]
                val response = SleepAidContentResponse(
                    title = selected.title,
                    content = selected.content,
                    durationMinutes = selected.durationMinutes,
                    suggestedBgMusic = selected.suggestedBgMusic
                )
                viewModel.loadFromHistory(response)
            }
            .setPositiveButton("关闭", null)
            .show()
    }
    
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
