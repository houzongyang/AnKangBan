package com.ankangban.health.features.profile

import android.os.Bundle
import android.os.Environment
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.ankangban.health.R
import com.ankangban.health.core.oppo.OppoHealthClientImpl
import com.ankangban.health.core.repo.HealthRepository
import com.ankangban.health.core.storage.HealthLocalStore
import com.ankangban.health.databinding.FragmentDataManagerBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.coroutines.flow.firstOrNull
import java.io.File
import java.io.FileWriter

class DataManagerFragment : Fragment(R.layout.fragment_data_manager) {

    private var binding: FragmentDataManagerBinding? = null
    private lateinit var store: HealthLocalStore
    private lateinit var repository: HealthRepository

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDataManagerBinding.bind(view)
        
        // Init Repository
        val context = requireContext()
        store = HealthLocalStore(context)
        val client = OppoHealthClientImpl(context)
        repository = HealthRepository(client, lifecycleScope, store)

        setupUI()
    }

    private fun setupUI() {
        binding?.apply {
            btnExport.setOnClickListener {
                exportData()
            }

            btnClearCache.setOnClickListener {
                // Mock clear cache
                Snackbar.make(root, "缓存清理完成", Snackbar.LENGTH_SHORT).show()
                tvStorageUsage.text = "健康数据：2.3MB  缓存：0.0MB"
            }

            btnDeleteAll.setOnClickListener {
                showDeleteConfirmation()
            }
        }
    }

    private fun exportData() {
        lifecycleScope.launch {
            try {
                // Export real data from database
                withContext(Dispatchers.IO) {
                    val filename = "health_data_export_${System.currentTimeMillis()}.csv"
                    val file = File(requireContext().getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS), filename)
                    
                    // Fetch data
                    val end = System.currentTimeMillis()
                    val start = 0L // All history
                    
                    val stepsList = store.getStepsHistory(start, end).firstOrNull() ?: emptyList()
                    val hrList = store.getMetricHistory("HEART_RATE", start, end).firstOrNull() ?: emptyList()
                    val sleepList = store.getSleepHistory(start, end).firstOrNull() ?: emptyList()

                    FileWriter(file).use { writer ->
                        writer.append("Date,Type,Value,Note\n")
                        
                        // Write Steps
                        val dateFormat = java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss", java.util.Locale.getDefault())
                        stepsList.forEach {
                            writer.append("${dateFormat.format(it.timestamp)},Steps,${it.count},Calories:${it.calories}\n")
                        }
                        
                        // Write Heart Rate
                        hrList.forEach {
                            writer.append("${dateFormat.format(it.timestamp)},HeartRate,${it.value.toInt()},-\n")
                        }
                        
                        // Write Sleep
                        sleepList.forEach {
                            writer.append("${dateFormat.format(it.startTime)},Sleep,${it.totalMinutes}min,Efficiency:${it.efficiency}%\n")
                        }
                    }
                }
                Toast.makeText(requireContext(), "数据已导出至文档目录 (包含步数/心率/睡眠)", Toast.LENGTH_LONG).show()
            } catch (e: Exception) {
                e.printStackTrace()
                Toast.makeText(requireContext(), "导出失败: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun showDeleteConfirmation() {
        MaterialAlertDialogBuilder(requireContext())
            .setTitle("确认删除全部数据？")
            .setMessage("此操作将永久删除本地存储的所有健康监测数据，且无法恢复。")
            .setPositiveButton("删除") { _, _ ->
                performDelete()
            }
            .setNegativeButton("取消", null)
            .show()
    }

    private fun performDelete() {
        lifecycleScope.launch {
            try {
                repository.clearAllData()
                binding?.tvStorageUsage?.text = "健康数据：0.0MB  缓存：0.0MB"
                Snackbar.make(requireView(), "全部数据已删除", Snackbar.LENGTH_LONG).show()
            } catch (e: Exception) {
                Toast.makeText(requireContext(), "删除失败: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
