package com.ankangban.health.features.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.ankangban.health.R
import com.ankangban.health.core.storage.HealthDatabase
import com.ankangban.health.core.storage.ChronicRiskEntity
import com.ankangban.health.databinding.FragmentDashboardBinding
import com.ankangban.health.ui.viewmodel.DashboardViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!
    private val viewModel: DashboardViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        setupClickListeners()
        setupObservers()
    }

    private fun setupClickListeners() {
        binding.cardSleep.setOnClickListener {
            findNavController().navigate(R.id.action_dashboard_to_sleep)
        }

        binding.btnChronic.setOnClickListener {
            findNavController().navigate(R.id.action_dashboard_to_chronic)
        }

        // Navigate to ConsultationFragment
        binding.btnConsultation.setOnClickListener {
             findNavController().navigate(R.id.consultFragment)
        }

        binding.btnTrends.setOnClickListener {
            findNavController().navigate(R.id.action_dashboard_to_trends)
        }
        
        // Navigate to MedicationListFragment
        binding.btnMedication.setOnClickListener {
             findNavController().navigate(R.id.action_dashboard_to_medication)
        }

        binding.btnWarningConfig.setOnClickListener {
            findNavController().navigate(R.id.action_dashboard_to_warning_config)
        }

        binding.btnSource.setOnClickListener {
            findNavController().navigate(R.id.action_dashboard_to_source)
        }
    }

    private fun setupObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    viewModel.todaySteps.collectLatest { steps ->
                        binding.tvStepsValue.text = steps.toString()
                    }
                }
                
                launch {
                    viewModel.latestHealthData.collectLatest { data ->
                        if (data != null) {
                            binding.tvHeartRateValue.text = "${data.heartRate} bpm"
                            binding.tvBloodOxygenValue.text = "${data.bloodOxygen}%"
                            binding.tvStressValue.text = data.stressLevel.toString()
                        }
                    }
                }

                launch {
                    viewModel.latestSleepData.collectLatest { data ->
                            if (data != null) {
                                // Use SleepQualityEvaluator for consistent scoring
                                val result = com.ankangban.health.features.sleep.logic.SleepQualityEvaluator.evaluate(data)
                                binding.tvSleepScoreValue.text = result.score.toString()
                                binding.tvSleepDuration.text = formatDuration(data.totalMinutes)
                            }
                        }
                }
            }
        }
    }

    private fun formatDuration(minutes: Int): String {
        val h = minutes / 60
        val m = minutes % 60
        return "${h}小时 ${m}分"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
