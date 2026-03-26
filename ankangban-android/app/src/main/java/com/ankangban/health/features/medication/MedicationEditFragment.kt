package com.ankangban.health.features.medication

import android.app.TimePickerDialog
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.FileProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.ankangban.health.R
import com.ankangban.health.core.storage.entity.ReminderEntity
import com.ankangban.health.databinding.FragmentMedicationEditBinding
import com.ankangban.health.ui.viewmodel.MedicationViewModel
import com.google.android.material.chip.Chip
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.io.File

class MedicationEditFragment : Fragment() {

    private var _binding: FragmentMedicationEditBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MedicationViewModel by viewModels()
    private var medicationId: Long = 0L
    private var frontImageUri: Uri? = null
    private var sideImageUri: Uri? = null
    private var isPickingFront = true
    
    // Reminders List (InMemory)
    private val reminders = mutableListOf<ReminderEntity>()

    // Camera/Gallery Launchers
    private val takePicture = registerForActivityResult(ActivityResultContracts.TakePicture()) { success ->
        if (success) {
            val uri = if (isPickingFront) frontImageUri else sideImageUri
            if (uri != null) {
                handleImageSelected(uri)
            }
        }
    }

    private val pickImage = registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
        uri?.let { handleImageSelected(it) }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMedicationEditBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        medicationId = arguments?.getLong("medicationId") ?: 0L
        
        setupToolbar()
        setupListeners()
        setupObservers()
        
        if (medicationId != 0L) {
            loadMedication(medicationId)
        }
    }

    private fun setupToolbar() {
        binding.toolbar.title = if (medicationId == 0L) "添加用药" else "编辑用药"
        binding.toolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
        
        if (medicationId != 0L) {
            binding.btnDelete.visibility = View.VISIBLE
            binding.btnConsult.visibility = View.VISIBLE
            
            binding.btnDelete.setOnClickListener {
                // Delete logic
                 MaterialAlertDialogBuilder(requireContext())
                    .setTitle("确认删除")
                    .setMessage("确定要删除此用药计划吗？")
                    .setPositiveButton("删除") { _, _ ->
                        val med = viewModel.getMedication(medicationId).value?.medication
                        if (med != null) {
                            viewModel.deleteMedication(med)
                        }
                        Toast.makeText(requireContext(), "已删除", Toast.LENGTH_SHORT).show()
                        findNavController().navigateUp()
                    }
                    .setNegativeButton("取消", null)
                    .show()
            }
            
            binding.btnConsult.setOnClickListener {
                findNavController().navigate(R.id.action_edit_to_consult)
            }
        }
    }

    private fun setupListeners() {
        // Scan / Photo - Front
        val pickFront = View.OnClickListener {
            isPickingFront = true
            showImagePicker()
        }
        binding.layoutScanHint.setOnClickListener(pickFront)
        binding.ivMedicationPhoto.setOnClickListener(pickFront)
        
        // Scan / Photo - Side
        val pickSide = View.OnClickListener {
            isPickingFront = false
            showImagePicker()
        }
        binding.layoutSideHint.setOnClickListener(pickSide)
        binding.ivSidePhoto.setOnClickListener(pickSide)

        // Add Reminder
        binding.chipAddReminder.setOnClickListener {
            showTimePicker()
        }

        // Save
        binding.btnSave.setOnClickListener {
            saveMedication()
        }
        
        // Test Voice
        binding.btnTestVoice.setOnClickListener {
            val name = binding.etName.text.toString().ifBlank { "测试药品" }
            val dosage = binding.etDosage.text.toString().ifBlank { "1片" }
            val intent = android.content.Intent(requireContext(), com.ankangban.health.core.service.VoiceReminderService::class.java).apply {
                putExtra("medication_name", name)
                putExtra("dosage", dosage)
            }
            requireContext().startService(intent)
            Toast.makeText(requireContext(), "正在播放语音...", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setupObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.parseState.collectLatest { state ->
                when (state) {
                    is MedicationViewModel.ParseState.Idle -> {
                        binding.pbScanning.visibility = View.GONE
                        binding.pbSideScanning.visibility = View.GONE
                        binding.tvScanningHint.visibility = View.GONE
                        binding.layoutScanHint.visibility = if (frontImageUri == null) View.VISIBLE else View.GONE
                        binding.layoutSideHint.visibility = if (sideImageUri == null) View.VISIBLE else View.GONE
                    }
                    is MedicationViewModel.ParseState.Scanning -> {
                        binding.pbScanning.visibility = View.VISIBLE
                        binding.pbSideScanning.visibility = View.VISIBLE
                        binding.tvScanningHint.visibility = View.VISIBLE
                        binding.tvScanningHint.text = "正在扫描..."
                        binding.layoutScanHint.visibility = View.GONE
                        binding.layoutSideHint.visibility = View.GONE
                    }
                    is MedicationViewModel.ParseState.Analyzing -> {
                        binding.pbScanning.visibility = View.VISIBLE
                        binding.pbSideScanning.visibility = View.VISIBLE
                        binding.tvScanningHint.text = "AI智能解析中..."
                    }
                    is MedicationViewModel.ParseState.Success -> {
                        binding.pbScanning.visibility = View.GONE
                        binding.pbSideScanning.visibility = View.GONE
                        binding.tvScanningHint.visibility = View.GONE
                        
                        val result = state.result
                        binding.etName.setText(result.name)
                        binding.etDosage.setText(result.dosage)
                        binding.etFrequency.setText(result.frequency)
                        // Stock is manually entered by user
                        // binding.etStock.setText(result.totalStock.toString())
                        binding.etUnit.setText(result.unit)
                        
                        Toast.makeText(requireContext(), "识别成功！", Toast.LENGTH_SHORT).show()
                        
                        // Auto add reminders based on frequency
                        if (reminders.isEmpty()) {
                            val freq = result.frequency
                            if (freq.contains("3") || freq.contains("三") || freq.contains("tid", true)) {
                                addReminder(8, 0, "早")
                                addReminder(12, 0, "中")
                                addReminder(18, 0, "晚")
                            } else if (freq.contains("2") || freq.contains("二") || freq.contains("两") || freq.contains("bid", true)) {
                                addReminder(8, 0, "早")
                                addReminder(18, 0, "晚")
                            } else if (freq.contains("4") || freq.contains("四") || freq.contains("qid", true)) {
                                addReminder(8, 0, "早")
                                addReminder(12, 0, "中")
                                addReminder(16, 0, "下午")
                                addReminder(20, 0, "晚")
                            } else {
                                // Default or 1 time (qd)
                                addReminder(9, 0, "每日")
                            }
                        }
                        
                        viewModel.resetParseState()
                    }
                    is MedicationViewModel.ParseState.Error -> {
                        binding.pbScanning.visibility = View.GONE
                        binding.pbSideScanning.visibility = View.GONE
                        binding.tvScanningHint.visibility = View.GONE
                        Toast.makeText(requireContext(), state.message, Toast.LENGTH_SHORT).show()
                        viewModel.resetParseState()
                    }
                }
            }
        }
    }

    private fun loadMedication(id: Long) {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.getMedication(id).collectLatest { data ->
                if (data != null) {
                    val med = data.medication
                    binding.etName.setText(med.name)
                    binding.etDosage.setText(med.dosage)
                    binding.etFrequency.setText(med.frequency)
                    binding.etStock.setText(med.totalStock.toString())
                    binding.etUnit.setText(med.unit)
                    
                    if (med.imageUri != null) {
                        try {
                            val uri = Uri.parse(med.imageUri)
                            frontImageUri = uri
                            binding.ivMedicationPhoto.setImageURI(uri)
                            binding.layoutScanHint.visibility = View.GONE
                        } catch (e: Exception) {
                            // ignore
                        }
                    }
                    
                    if (med.sideImageUri != null) {
                        try {
                            val uri = Uri.parse(med.sideImageUri)
                            sideImageUri = uri
                            binding.ivSidePhoto.setImageURI(uri)
                            binding.layoutSideHint.visibility = View.GONE
                        } catch (e: Exception) {
                            // ignore
                        }
                    }
                    
                    reminders.clear()
                    reminders.addAll(data.reminders)
                    refreshReminderChips()
                }
            }
        }
    }

    private fun showImagePicker() {
        val title = if (isPickingFront) "上传药盒正面" else "上传侧面/说明书"
        val options = arrayOf("拍照", "从相册选择")
        MaterialAlertDialogBuilder(requireContext())
            .setTitle(title)
            .setItems(options) { _, which ->
                when (which) {
                    0 -> launchCamera()
                    1 -> pickImage.launch("image/*")
                }
            }
            .show()
    }

    private fun launchCamera() {
        val type = if (isPickingFront) "front" else "side"
        val photoFile = File(requireContext().externalCacheDir, "medication_${type}_${System.currentTimeMillis()}.jpg")
        val uri = FileProvider.getUriForFile(
            requireContext(),
            "${requireContext().packageName}.fileprovider",
            photoFile
        )
        if (isPickingFront) {
            frontImageUri = uri
        } else {
            sideImageUri = uri
        }
        takePicture.launch(uri)
    }

    private fun handleImageSelected(uri: Uri) {
        if (isPickingFront) {
            frontImageUri = uri
            binding.ivMedicationPhoto.setImageURI(uri)
            binding.layoutScanHint.visibility = View.GONE
        } else {
            sideImageUri = uri
            binding.ivSidePhoto.setImageURI(uri)
            binding.layoutSideHint.visibility = View.GONE
        }
        
        // Start Analysis if Front is available
        if (frontImageUri != null) {
            viewModel.analyzeImages(frontImageUri!!, sideImageUri)
        }
    }

    private fun showTimePicker() {
        val picker = TimePickerDialog(
            requireContext(),
            { _, hourOfDay, minute ->
                addReminder(hourOfDay, minute)
            },
            8, 0, true
        )
        picker.show()
    }

    private fun addReminder(hour: Int, minute: Int, label: String? = null) {
        val reminder = ReminderEntity(
            medicationId = medicationId,
            hour = hour,
            minute = minute,
            label = label ?: getTypeLabel(hour)
        )
        reminders.add(reminder)
        refreshReminderChips()
    }
    
    private fun getTypeLabel(hour: Int): String {
        return when(hour) {
            in 5..10 -> "早餐后"
            in 11..14 -> "午餐后"
            in 17..20 -> "晚餐后"
            in 21..23 -> "睡前"
            else -> "定时"
        }
    }

    private fun refreshReminderChips() {
        binding.chipGroupReminders.removeAllViews()
        binding.chipGroupReminders.addView(binding.chipAddReminder)
        
        reminders.sortedBy { it.hour * 60 + it.minute }.forEach { reminder ->
            val chip = Chip(requireContext()).apply {
                text = String.format("%02d:%02d %s", reminder.hour, reminder.minute, reminder.label ?: "")
                isCloseIconVisible = true
                setOnCloseIconClickListener {
                    reminders.remove(reminder)
                    refreshReminderChips()
                }
            }
            binding.chipGroupReminders.addView(chip, binding.chipGroupReminders.childCount - 1)
        }
    }

    private fun saveMedication() {
        val name = binding.etName.text.toString()
        if (name.isBlank()) {
            binding.etName.error = "请输入药品名称"
            return
        }
        
        val dosage = binding.etDosage.text.toString()
        val frequency = binding.etFrequency.text.toString()
        val stock = binding.etStock.text.toString().toIntOrNull() ?: 0
        val unit = binding.etUnit.text.toString()

        viewModel.saveMedication(
            id = medicationId,
            name = name,
            dosage = dosage,
            frequency = frequency,
            stock = stock,
            unit = unit,
            imageUri = frontImageUri?.toString(),
            sideImageUri = sideImageUri?.toString(),
            reminders = reminders
        )
        
        Toast.makeText(requireContext(), "保存成功", Toast.LENGTH_SHORT).show()
        findNavController().navigateUp()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
