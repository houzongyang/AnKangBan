package com.ankangban.health.features.sleep

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ankangban.health.databinding.FragmentSleepBinding
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.ankangban.health.ui.viewmodel.HealthViewModel
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class SleepFragment : Fragment() {

    private var _binding: FragmentSleepBinding? = null
    private val binding: FragmentSleepBinding
        get() = _binding!!
    private val vm: HealthViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSleepBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvTitle.text = "睡眠改善"

        vm.start()
        vm.sleep
            .filterNotNull()
            .onEach { s ->
                binding.tvSleepTotal.text = "总睡眠时长：${s.totalMinutes} 分钟"
                // Handle both ratio (0.85) and legacy percentage (85.0) data
                val eff = if (s.efficiency > 1.0) s.efficiency.toInt() else (s.efficiency * 100).toInt()
                binding.tvSleepEfficiency.text = "睡眠效率：$eff %"
                binding.tvSleepStages.text =
                    "深睡/浅睡/REM：${s.deepMinutes} / ${s.lightMinutes} / ${s.remMinutes} 分钟"
            }
            .launchIn(viewLifecycleOwner.lifecycleScope)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
