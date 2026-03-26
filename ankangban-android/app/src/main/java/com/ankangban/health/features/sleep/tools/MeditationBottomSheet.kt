package com.ankangban.health.features.sleep.tools

import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ankangban.health.R
import com.ankangban.health.databinding.FragmentMeditationBottomSheetBinding
import com.ankangban.health.ui.viewmodel.SleepToolsViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class MeditationBottomSheet : BottomSheetDialogFragment() {

    private var _binding: FragmentMeditationBottomSheetBinding? = null
    private val binding get() = _binding!!
    
    private val viewModel: SleepToolsViewModel by activityViewModels()

    data class Course(
        val name: String,
        val description: String,
        val durationMinutes: Int,
        val iconRes: Int
    )

    private val courses = listOf(
        Course("身体扫描", "从头到脚放松每一块肌肉，缓解身体紧张。", 10, R.drawable.ic_spa),
        Course("观呼吸", "专注呼吸进出，培养当下的觉察力。", 5, R.drawable.ic_forest),
        Course("渐进式放松", "通过收紧和放松肌肉群来深度减压。", 15, R.drawable.ic_waves),
        Course("慈心冥想", "向自己和他人发送善意的祝福。", 10, R.drawable.ic_heart)
    )

    private var currentCourse: Course? = null
    private var isPlaying = false
    private var timer: CountDownTimer? = null
    private var remainingMillis = 0L

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMeditationBottomSheetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        setupRecyclerView()
        setupClickListeners()
    }

    private fun setupRecyclerView() {
        binding.rvCourses.layoutManager = LinearLayoutManager(context)
        binding.rvCourses.adapter = CourseAdapter(courses) { course ->
            playCourse(course)
        }
    }

    private fun setupClickListeners() {
        binding.btnClose.setOnClickListener { dismiss() }
        
        binding.btnPlayPause.setOnClickListener {
            togglePlay()
        }
    }

    private fun playCourse(course: Course) {
        if (currentCourse == course && isPlaying) return
        
        currentCourse = course
        remainingMillis = course.durationMinutes * 60 * 1000L
        
        binding.playerContainer.visibility = View.VISIBLE
        binding.tvCourseName.text = course.name
        binding.ivCourseIcon.setImageResource(course.iconRes)
        
        startPlayback()
    }

    private fun togglePlay() {
        if (currentCourse == null) return
        
        if (isPlaying) {
            pausePlayback()
        } else {
            startPlayback()
        }
    }

    private fun startPlayback() {
        isPlaying = true
        binding.btnPlayPause.setImageResource(R.drawable.ic_stop)
        
        timer?.cancel()
        timer = object : CountDownTimer(remainingMillis, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                remainingMillis = millisUntilFinished
                updateStatus()
            }

            override fun onFinish() {
                remainingMillis = 0
                isPlaying = false
                binding.btnPlayPause.setImageResource(R.drawable.ic_play_arrow)
                updateStatus()
                
                // Award points
                viewModel.addPoints(30)
                Toast.makeText(context, "${currentCourse?.name} 完成 (+30积分)", Toast.LENGTH_SHORT).show()
            }
        }.start()
    }

    private fun pausePlayback() {
        isPlaying = false
        binding.btnPlayPause.setImageResource(R.drawable.ic_play_arrow)
        timer?.cancel()
        updateStatus()
    }

    private fun updateStatus() {
        val totalMillis = (currentCourse?.durationMinutes ?: 0) * 60 * 1000L
        val currentMillis = totalMillis - remainingMillis
        
        binding.tvCourseStatus.text = "${formatTime(currentMillis)} / ${formatTime(totalMillis)}"
    }

    private fun formatTime(millis: Long): String {
        val minutes = millis / 1000 / 60
        val seconds = (millis / 1000) % 60
        return String.format("%02d:%02d", minutes, seconds)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        timer?.cancel()
        _binding = null
    }

    inner class CourseAdapter(
        private val list: List<Course>,
        private val onItemClick: (Course) -> Unit
    ) : RecyclerView.Adapter<CourseAdapter.ViewHolder>() {

        inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val tvName: TextView = view.findViewById(R.id.tvName)
            val tvDesc: TextView = view.findViewById(R.id.tvDescription)
            val tvDuration: TextView = view.findViewById(R.id.tvDuration)
            val ivIcon: android.widget.ImageView = view.findViewById(R.id.ivIcon)
            
            fun bind(course: Course) {
                tvName.text = course.name
                tvDesc.text = course.description
                tvDuration.text = "${course.durationMinutes} min"
                ivIcon.setImageResource(course.iconRes)
                
                itemView.setOnClickListener { onItemClick(course) }
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_meditation_course, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.bind(list[position])
        }

        override fun getItemCount() = list.size
    }
}