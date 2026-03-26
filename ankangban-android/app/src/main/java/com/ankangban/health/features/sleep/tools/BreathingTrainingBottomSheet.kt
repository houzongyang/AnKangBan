package com.ankangban.health.features.sleep.tools

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.LinearInterpolator
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.ankangban.health.databinding.FragmentBreathingBottomSheetBinding
import com.ankangban.health.ui.viewmodel.SleepToolsViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlin.coroutines.coroutineContext

class BreathingTrainingBottomSheet : BottomSheetDialogFragment() {

    private var _binding: FragmentBreathingBottomSheetBinding? = null
    private val binding get() = _binding!!
    
    private val viewModel: SleepToolsViewModel by activityViewModels()
    
    private var trainingJob: Job? = null
    private var isTraining = false
    private var completedCycles = 0
    
    // 4-7-8 constants (in millis)
    private val DURATION_INHALE = 4000L
    private val DURATION_HOLD = 7000L
    private val DURATION_EXHALE = 8000L
    
    private lateinit var vibrator: Vibrator

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBreathingBottomSheetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vibrator = requireContext().getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        
        setupClickListeners()
    }
    
    private fun setupClickListeners() {
        binding.btnClose.setOnClickListener { dismiss() }
        
        binding.btnAction.setOnClickListener {
            if (isTraining) {
                stopTraining()
            } else {
                startTraining()
            }
        }
    }
    
    private fun startTraining() {
        isTraining = true
        completedCycles = 0
        binding.btnAction.text = "停止训练"
        binding.btnAction.setBackgroundColor(android.graphics.Color.parseColor("#FF5252")) // Red for stop
        
        trainingJob = lifecycleScope.launch {
            binding.tvInstruction.text = "准备"
            binding.tvTimer.text = "3"
            delay(1000)
            binding.tvTimer.text = "2"
            delay(1000)
            binding.tvTimer.text = "1"
            delay(1000)
            
            while (isActive && isTraining) {
                // Inhale (4s)
                performPhase("吸气", DURATION_INHALE, 1.0f)
                
                // Hold (7s)
                performPhase("屏气", DURATION_HOLD, 1.0f)
                
                // Exhale (8s)
                performPhase("呼气", DURATION_EXHALE, 0.5f)
                
                completedCycles++
            }
        }
    }
    
    private suspend fun performPhase(text: String, duration: Long, targetScale: Float) {
        if (!coroutineContext.isActive || !isTraining) return
        
        binding.tvInstruction.text = text
        vibrateOneShot(100)
        
        // Animation
        binding.viewBreathingCircle.animate()
            .scaleX(targetScale)
            .scaleY(targetScale)
            .setDuration(duration)
            .setInterpolator(LinearInterpolator())
            .start()
            
        // Timer countdown
        val seconds = duration / 1000
        for (i in seconds downTo 1) {
            if (!coroutineContext.isActive || !isTraining) break
            binding.tvTimer.text = "${i}s"
            delay(1000)
        }
    }
    
    private fun stopTraining() {
        isTraining = false
        trainingJob?.cancel()
        binding.viewBreathingCircle.animate().cancel()
        
        // Award points if trained
        if (completedCycles > 0) {
            val points = completedCycles * 5
            viewModel.addPoints(points)
            Toast.makeText(requireContext(), "训练完成！获得 $points 积分", Toast.LENGTH_SHORT).show()
            completedCycles = 0
        }
        
        // Reset UI
        binding.viewBreathingCircle.scaleX = 0.5f
        binding.viewBreathingCircle.scaleY = 0.5f
        binding.tvInstruction.text = "准备"
        binding.tvTimer.text = "0s"
        binding.btnAction.text = "开始训练"
        binding.btnAction.setBackgroundColor(android.graphics.Color.parseColor("#673AB7")) // Original Purple
    }
    
    private fun vibrateOneShot(millis: Long) {
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                vibrator.vibrate(VibrationEffect.createOneShot(millis, VibrationEffect.DEFAULT_AMPLITUDE))
            } else {
                vibrator.vibrate(millis)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        stopTraining()
        _binding = null
    }
}