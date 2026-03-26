package com.ankangban.health.features.consultation

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.ankangban.health.R
import com.ankangban.health.databinding.FragmentConsultationBinding
import com.ankangban.health.ui.viewmodel.ConsultationViewModel
import com.ankangban.health.features.trends.HealthReportDialogFragment
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class ConsultationFragment : Fragment() {

    private var _binding: FragmentConsultationBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ConsultationViewModel by viewModels()
    private val chatAdapter = ChatAdapter()
    private var photoUri: android.net.Uri? = null

    private val requestCameraPermissionLauncher = registerForActivityResult(androidx.activity.result.contract.ActivityResultContracts.RequestPermission()) { isGranted ->
        if (isGranted) {
            launchCamera()
        } else {
            Snackbar.make(binding.root, "需要相机权限才能拍照", Snackbar.LENGTH_SHORT).show()
        }
    }

    private val takePictureLauncher = registerForActivityResult(androidx.activity.result.contract.ActivityResultContracts.TakePicture()) { success ->
        if (success && photoUri != null) {
            viewModel.sendMessage("[图片]", ConsultationViewModel.MessageType.IMAGE, photoUri.toString())
        }
    }

    private val pickImageLauncher = registerForActivityResult(androidx.activity.result.contract.ActivityResultContracts.GetContent()) { uri ->
        if (uri != null) {
            viewModel.sendMessage("[图片]", ConsultationViewModel.MessageType.IMAGE, uri.toString())
        }
    }

    private val pickFileLauncher = registerForActivityResult(androidx.activity.result.contract.ActivityResultContracts.GetContent()) { uri ->
        if (uri != null) {
            viewModel.sendMessage("[文件] ${uri.lastPathSegment ?: "unknown_file"}")
        }
    }

    private fun launchCamera() {
        val photoFile = java.io.File(requireContext().externalCacheDir, "temp_photo_${System.currentTimeMillis()}.jpg")
        photoUri = androidx.core.content.FileProvider.getUriForFile(
            requireContext(),
            "${requireContext().packageName}.fileprovider",
            photoFile
        )
        takePictureLauncher.launch(photoUri)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentConsultationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
        observeViewModel()
    }

    private fun setupUI() {
        // Chat RecyclerView
        binding.rvChat.apply {
            layoutManager = LinearLayoutManager(context).apply {
                stackFromEnd = true // Start from bottom
            }
            adapter = chatAdapter
        }

        // Send Button
        binding.btnSend.setOnClickListener {
            val content = binding.etInput.text.toString().trim()
            if (content.isNotEmpty()) {
                viewModel.sendMessage(content)
                binding.etInput.setText("")
            }
        }

        // Switch Mode
        binding.btnSwitchMode.setOnClickListener {
            val current = viewModel.currentMode.value
            val newMode = if (current == ConsultationViewModel.ConsultationMode.DOCTOR) 
                ConsultationViewModel.ConsultationMode.AI else ConsultationViewModel.ConsultationMode.DOCTOR
            viewModel.switchMode(newMode)
        }

        // Emergency
        binding.btnEmergency.setOnClickListener {
            AlertDialog.Builder(requireContext())
                .setTitle("紧急医疗求助")
                .setMessage("即将拨打120急救电话？")
                .setPositiveButton("拨打") { _, _ -> 
                    try {
                        val intent = android.content.Intent(android.content.Intent.ACTION_DIAL)
                        intent.data = android.net.Uri.parse("tel:120")
                        startActivity(intent)
                    } catch (e: Exception) {
                        Snackbar.make(binding.root, "无法启动拨号界面", Snackbar.LENGTH_SHORT).show()
                        e.printStackTrace()
                    }
                }
                .setNegativeButton("取消", null)
                .show()
        }

        // Night Mode
        binding.btnNightMode.setOnClickListener {
            val isNight = (resources.configuration.uiMode and android.content.res.Configuration.UI_MODE_NIGHT_MASK) == android.content.res.Configuration.UI_MODE_NIGHT_YES
            val newMode = if (isNight) androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_NO else androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_YES
            androidx.appcompat.app.AppCompatDelegate.setDefaultNightMode(newMode)
            Snackbar.make(binding.root, if (isNight) "已切换至日间模式" else "已切换至夜间模式", Snackbar.LENGTH_SHORT).show()
        }

        // Attachment
        binding.btnAttach.setOnClickListener {
            val items = arrayOf("相册", "拍照", "文件")
            AlertDialog.Builder(requireContext())
                .setTitle("上传附件")
                .setItems(items) { _, which ->
                    when (which) {
                        0 -> pickImageLauncher.launch("image/*")
                        1 -> {
                            if (androidx.core.content.ContextCompat.checkSelfPermission(requireContext(), android.Manifest.permission.CAMERA) == android.content.pm.PackageManager.PERMISSION_GRANTED) {
                                launchCamera()
                            } else {
                                requestCameraPermissionLauncher.launch(android.Manifest.permission.CAMERA)
                            }
                        }
                        2 -> pickFileLauncher.launch("*/*")
                    }
                }
                .show()
        }

        // Chips
        binding.chipGroupTags.setOnCheckedStateChangeListener { group, checkedIds ->
             // Handle tag selection (Filter doctors or set AI template)
             if (checkedIds.isNotEmpty()) {
                 // For demo, just toast or log
             }
        }

        // Action Buttons
        binding.btnAction1.setOnClickListener {
            if (viewModel.currentMode.value == ConsultationViewModel.ConsultationMode.DOCTOR) {
                Snackbar.make(binding.root, "已跳转至协和医院挂号小程序", Snackbar.LENGTH_SHORT).show()
            } else {
                HealthReportDialogFragment().show(childFragmentManager, "HealthReport")
            }
        }

        binding.btnAction2.setOnClickListener {
            if (viewModel.currentMode.value == ConsultationViewModel.ConsultationMode.DOCTOR) {
                Snackbar.make(binding.root, "已提交复诊申请，药师审核中", Snackbar.LENGTH_SHORT).show()
            } else {
                Snackbar.make(binding.root, "已为您定制高血压改善计划，并同步至日程", Snackbar.LENGTH_SHORT).show()
            }
        }
    }

    private fun observeViewModel() {
        // Mode
        lifecycleScope.launch {
            viewModel.currentMode.collectLatest { mode ->
                updateModeUI(mode)
            }
        }

        // Messages
        lifecycleScope.launch {
            viewModel.messages.collectLatest { msgs ->
                chatAdapter.submitList(msgs) {
                    if (msgs.isNotEmpty()) {
                        binding.rvChat.scrollToPosition(msgs.size - 1)
                    }
                }
            }
        }

        // Doctor Info
        lifecycleScope.launch {
            viewModel.currentDoctor.collectLatest { doc ->
                if (viewModel.currentMode.value == ConsultationViewModel.ConsultationMode.DOCTOR) {
                    binding.tvName.text = doc.name
                    binding.tvRole.text = "${doc.title} | ${doc.department} | ${doc.hospital}"
                    binding.tvStatus.text = if (doc.isOnline) "● 在线" else "○ 离线"
                    binding.tvStatus.setTextColor(if (doc.isOnline) 0xFF4CAF50.toInt() else 0xFF9E9E9E.toInt())
                }
            }
        }

        // Health Data
        lifecycleScope.launch {
            viewModel.healthData.collectLatest { data ->
                binding.tvHealthData.text = data.ifEmpty { "暂无同步数据" }
            }
        }
    }

    private fun updateModeUI(mode: ConsultationViewModel.ConsultationMode) {
        if (mode == ConsultationViewModel.ConsultationMode.DOCTOR) {
            binding.tvTitle.text = "医院医生咨询"
            binding.ivAvatar.setImageResource(R.drawable.ic_doctor_male)
            binding.ivAvatar.setColorFilter(0xFF1976D2.toInt())
            binding.tvName.text = "李医生" // Default
            binding.btnSwitchMode.text = "切换AI"
            binding.btnSwitchMode.setIconResource(R.drawable.ic_robot)
            
            binding.tvLinkageTitle.text = "就医流程"
            binding.btnAction1.text = "预约挂号"
            binding.btnAction1.setIconResource(R.drawable.ic_calendar_today)
            binding.btnAction2.text = "复诊续方"
            binding.btnAction2.setIconResource(R.drawable.ic_medication)
            binding.btnAction2.visibility = View.VISIBLE
        } else {
            binding.tvTitle.text = "AI全科专家"
            binding.ivAvatar.setImageResource(R.drawable.ic_robot)
            binding.ivAvatar.setColorFilter(0xFF2196F3.toInt())
            binding.tvName.text = "康博士"
            binding.tvRole.text = "AI全科健康顾问 | 混元大模型驱动"
            binding.tvStatus.text = "● 实时响应"
            binding.btnSwitchMode.text = "切换医生"
            binding.btnSwitchMode.setIconResource(R.drawable.ic_doctor_male)

            binding.tvLinkageTitle.text = "健康方案"
            binding.btnAction1.text = "生成报告"
            binding.btnAction1.setIconResource(R.drawable.ic_trending_up)
            binding.btnAction2.visibility = View.GONE
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
