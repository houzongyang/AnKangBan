package com.ankangban.health.features.sleep.tools

import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.ankangban.health.R
import com.ankangban.health.databinding.FragmentWhiteNoiseBottomSheetBinding
import com.ankangban.health.ui.viewmodel.SleepToolsViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class WhiteNoiseBottomSheet : BottomSheetDialogFragment() {

    private var _binding: FragmentWhiteNoiseBottomSheetBinding? = null
    private val binding get() = _binding!!
    
    private val viewModel: SleepToolsViewModel by activityViewModels()

    private val player = WhiteNoisePlayer()
    private var isPlaying = false
    private var currentSound = ""
    private var timer: CountDownTimer? = null
    private var remainingTimeMillis = 0L

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWhiteNoiseBottomSheetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupClickListeners()
    }

    private fun setupClickListeners() {
        binding.itemRain.setOnClickListener { playSound("雨声", R.drawable.ic_water_drop, WhiteNoisePlayer.NoiseType.PINK) }
        binding.itemOcean.setOnClickListener { playSound("海浪", R.drawable.ic_waves, WhiteNoisePlayer.NoiseType.BROWN) }
        binding.itemForest.setOnClickListener { playSound("森林", R.drawable.ic_forest, WhiteNoisePlayer.NoiseType.PINK) }
        binding.itemAsmr.setOnClickListener { playSound("ASMR", R.drawable.ic_spa, WhiteNoisePlayer.NoiseType.WHITE) }

        binding.btnPlayPause.setOnClickListener {
            togglePlay()
        }

        binding.btnTimer.setOnClickListener {
            showTimerDialog()
        }
    }

    private fun playSound(name: String, iconRes: Int, type: WhiteNoisePlayer.NoiseType) {
        if (currentSound == name && isPlaying) {
            return
        }

        currentSound = name
        isPlaying = true
        
        binding.cardPlayer.visibility = View.VISIBLE
        binding.tvCurrentName.text = "正在播放: $name"
        binding.ivCurrentIcon.setImageResource(iconRes)
        binding.btnPlayPause.setImageResource(R.drawable.ic_stop)
        
        player.play(type)
    }

    private fun togglePlay() {
        if (currentSound.isEmpty()) return

        isPlaying = !isPlaying
        if (isPlaying) {
            binding.btnPlayPause.setImageResource(R.drawable.ic_stop)
            // Resume with last type if possible, but here we just simplify
            // Re-trigger play based on name (simple mapping)
            val type = when(currentSound) {
                "海浪" -> WhiteNoisePlayer.NoiseType.BROWN
                "ASMR" -> WhiteNoisePlayer.NoiseType.WHITE
                else -> WhiteNoisePlayer.NoiseType.PINK
            }
            player.play(type)
            binding.tvTimerStatus.text = if (remainingTimeMillis > 0) formatTime(remainingTimeMillis) else "正在播放"
            
            if (remainingTimeMillis > 0) startTimer(remainingTimeMillis)
        } else {
            binding.btnPlayPause.setImageResource(R.drawable.ic_play_arrow)
            binding.tvTimerStatus.text = "已暂停"
            player.stop()
            timer?.cancel()
        }
    }

    private fun showTimerDialog() {
        val options = arrayOf("15分钟", "30分钟", "45分钟", "60分钟", "关闭定时")
        com.google.android.material.dialog.MaterialAlertDialogBuilder(requireContext())
            .setTitle("设置定时关闭")
            .setItems(options) { _, which ->
                when (which) {
                    0 -> startTimer(15 * 60 * 1000L)
                    1 -> startTimer(30 * 60 * 1000L)
                    2 -> startTimer(45 * 60 * 1000L)
                    3 -> startTimer(60 * 60 * 1000L)
                    4 -> cancelTimer()
                }
            }
            .show()
    }

    private fun startTimer(millis: Long) {
        timer?.cancel()
        remainingTimeMillis = millis
        
        timer = object : CountDownTimer(millis, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                remainingTimeMillis = millisUntilFinished
                binding.tvTimerStatus.text = "定时: ${formatTime(millisUntilFinished)}"
            }

            override fun onFinish() {
                remainingTimeMillis = 0
                if (isPlaying) {
                    togglePlay() // Stop
                    viewModel.addPoints(10) // Award points
                    Toast.makeText(context, "定时结束，停止播放 (+10积分)", Toast.LENGTH_LONG).show()
                }
                binding.tvTimerStatus.text = "定时结束"
                binding.btnTimer.setColorFilter(android.graphics.Color.parseColor("#757575"))
            }
        }.start()
        
        binding.btnTimer.setColorFilter(android.graphics.Color.parseColor("#673AB7"))
        binding.tvTimerStatus.text = "定时: ${formatTime(millis)}"
        Toast.makeText(context, "定时已开启", Toast.LENGTH_SHORT).show()
    }

    private fun cancelTimer() {
        timer?.cancel()
        remainingTimeMillis = 0
        binding.tvTimerStatus.text = if (isPlaying) "正在播放" else "点击图标选择声音"
        binding.btnTimer.setColorFilter(android.graphics.Color.parseColor("#757575"))
        Toast.makeText(context, "定时已关闭", Toast.LENGTH_SHORT).show()
    }

    private fun formatTime(millis: Long): String {
        val minutes = millis / 1000 / 60
        val seconds = (millis / 1000) % 60
        return String.format("%02d:%02d", minutes, seconds)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        player.stop()
        timer?.cancel()
        _binding = null
    }
}