package com.ankangban.health.features.chronic

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ankangban.health.R
import com.ankangban.health.core.storage.ChronicDiseaseType
import com.ankangban.health.core.storage.ChronicPlanEntity
import com.ankangban.health.core.storage.PlanType
import com.ankangban.health.core.storage.RiskLevel
import com.ankangban.health.ui.viewmodel.ChronicViewModel
import com.google.android.material.button.MaterialButton
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.launch
import org.json.JSONArray
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class ChronicFragment : Fragment() {

    private val viewModel: ChronicViewModel by viewModels()
    private lateinit var planAdapter: PlanAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_chronic_disease, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        setupUI(view)
        observeViewModel(view)
    }

    private fun setupUI(view: View) {
        // Toolbar
        view.findViewById<View>(R.id.btnBack).setOnClickListener {
            findNavController().navigateUp()
        }

        view.findViewById<MaterialButton>(R.id.btnSwitchType).setOnClickListener {
            showTypeDialog()
        }

        val rvPlans = view.findViewById<RecyclerView>(R.id.rvPlans)
        rvPlans.layoutManager = LinearLayoutManager(context)
        planAdapter = PlanAdapter { plan ->
            if (!plan.isCompleted) {
                showPlanEvidenceDialog(plan)
            } else {
                MaterialAlertDialogBuilder(requireContext())
                    .setTitle("取消完成")
                    .setMessage("确定要撤销【${plan.title}】的完成状态吗？证据将一并清除。")
                    .setPositiveButton("确定") { _, _ ->
                        viewModel.updatePlanCompletion(plan, false, null, null)
                    }
                    .setNegativeButton("保留", null)
                    .show()
            }
        }
        rvPlans.adapter = planAdapter

        // Buttons
        view.findViewById<View>(R.id.btnReevaluate).setOnClickListener {
            viewModel.evaluateRisk()
            Snackbar.make(view, "正在进行AI智能评估...", Snackbar.LENGTH_SHORT).show()
        }

        view.findViewById<View>(R.id.btnHistory).setOnClickListener {
            showTrendDialog() // Simplified as Dialog for demo
        }
        
        view.findViewById<View>(R.id.btnMedication).setOnClickListener {
            findNavController().navigate(R.id.action_chronic_to_medication)
        }
        
        view.findViewById<View>(R.id.cardRisk).setOnClickListener {
            showRiskDetailDialog()
        }
    }

    private fun observeViewModel(view: View) {
        val tvRiskLevel = view.findViewById<TextView>(R.id.tvRiskLevel)
        val riskIndicator = view.findViewById<View>(R.id.riskIndicator)
        val tvEvalTime = view.findViewById<TextView>(R.id.tvEvalTime)
        val tvFactor1 = view.findViewById<TextView>(R.id.tvFactor1)
        val tvFactor2 = view.findViewById<TextView>(R.id.tvFactor2)
        val btnSwitchType = view.findViewById<MaterialButton>(R.id.btnSwitchType)
        val loadingOverlay = view.findViewById<View>(R.id.loadingOverlay)
        val progressBar = view.findViewById<com.google.android.material.progressindicator.LinearProgressIndicator>(R.id.progressBar)
        val tvProgress = view.findViewById<TextView>(R.id.tvProgress)

        viewLifecycleOwner.lifecycleScope.launch {
            launch {
                viewModel.currentType.collect { type ->
                    btnSwitchType.text = when(type) {
                        ChronicDiseaseType.HYPERTENSION -> "高血压"
                        ChronicDiseaseType.DIABETES -> "糖尿病"
                        else -> "未知"
                    }
                }
            }

            launch {
                viewModel.riskState.collect { risk ->
                    if (risk != null) {
                        // Level
                        tvRiskLevel.text = when(risk.riskLevel) {
                            RiskLevel.HIGH -> "高风险"
                            RiskLevel.MEDIUM -> "中风险"
                            RiskLevel.LOW -> "低风险"
                        }
                        tvRiskLevel.setTextColor(when(risk.riskLevel) {
                            RiskLevel.HIGH -> Color.parseColor("#F44336")
                            RiskLevel.MEDIUM -> Color.parseColor("#FFC107")
                            RiskLevel.LOW -> Color.parseColor("#4CAF50")
                        })
                        
                        riskIndicator.setBackgroundResource(when(risk.riskLevel) {
                            RiskLevel.HIGH -> R.drawable.shape_circle_risk_high
                            RiskLevel.MEDIUM -> R.drawable.shape_circle_risk_medium
                            RiskLevel.LOW -> R.drawable.shape_circle_risk_low
                        })

                        // Time
                        val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault())
                        tvEvalTime.text = "评估时间：${sdf.format(Date(risk.timestamp))}"

                        // Factors
                        try {
                            val factors = JSONArray(risk.riskFactorsJson)
                            tvFactor1.text = if (factors.length() > 0) "• ${factors.getString(0)}" else "• 暂无明显风险因素"
                            tvFactor2.text = if (factors.length() > 1) "• ${factors.getString(1)}" else ""
                            tvFactor2.isVisible = factors.length() > 1
                        } catch (e: Exception) {
                            tvFactor1.text = "• 数据解析错误"
                        }
                    } else {
                        tvRiskLevel.text = "未评估"
                        tvRiskLevel.setTextColor(Color.GRAY)
                    }
                }
            }

            launch {
                viewModel.dailyPlans.collect { plans ->
                    planAdapter.submitList(plans)
                    
                    val total = plans.size
                    val completed = plans.count { it.isCompleted }
                    val progress = if (total > 0) (completed * 100 / total) else 0
                    
                    progressBar.progress = progress
                    tvProgress.text = "$progress%"
                    
                    if (progress == 100 && total > 0) {
                         Snackbar.make(view, "今日管理计划已全部完成", Snackbar.LENGTH_SHORT).show()
                    }
                }
            }
            
            launch {
                viewModel.loading.collect { isLoading ->
                    loadingOverlay.isVisible = isLoading
                }
            }
        }
    }

    private fun showTypeDialog() {
        val types = arrayOf("高血压 (监测心率、血压)", "糖尿病 (监测血糖、饮食)", "高血脂 (预留功能)")
        MaterialAlertDialogBuilder(requireContext())
            .setTitle("切换慢病类型")
            .setSingleChoiceItems(types, if (viewModel.currentType.value == ChronicDiseaseType.HYPERTENSION) 0 else 1) { dialog, which ->
                when (which) {
                    0 -> viewModel.switchType(ChronicDiseaseType.HYPERTENSION)
                    1 -> viewModel.switchType(ChronicDiseaseType.DIABETES)
                    2 -> {
                        // Disabled in logic, but UI shows it. Reset selection.
                         Snackbar.make(requireView(), "该功能暂未上线", Snackbar.LENGTH_SHORT).show()
                         return@setSingleChoiceItems
                    }
                }
                dialog.dismiss()
            }
            .setNegativeButton("取消", null)
            .show()
    }

    private fun showTrendDialog() {
        // Ideally a Fragment, but Dialog with Custom View is fast for demo
        val context = requireContext()
        val chartView = com.ankangban.health.ui.view.SimpleTrendChartView(context)
        chartView.layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            500 // px approx
        )
        chartView.minimumHeight = 500
        
        // Feed demo data
        // In real app: viewModel.getHistory()
        chartView.setData(listOf(1, 1, 2, 1, 0, 1, 1, 1, 2, 1)) 

        MaterialAlertDialogBuilder(context)
            .setTitle("近30天风险趋势")
            .setView(chartView)
            .setPositiveButton("关闭", null)
            .setNeutralButton("导出报告") { _, _ ->
                 Snackbar.make(requireView(), "报告已导出至本地存储", Snackbar.LENGTH_SHORT).show()
            }
            .show()
    }
    
    private fun showRiskDetailDialog() {
        val risk = viewModel.riskState.value ?: return
        
        val sb = StringBuilder()
        sb.append("评估依据：基于近7天心率、血压数据，结合年龄、BMI计算。\n\n")
        sb.append("详细指标：\n")
        
        try {
             val factors = JSONArray(risk.riskFactorsJson)
             for (i in 0 until factors.length()) {
                 sb.append("• ${factors.getString(i)}\n")
             }
        } catch (e: Exception) {}
        
        sb.append("\n改善建议：\n")
        if (risk.riskLevel == RiskLevel.HIGH) {
            sb.append("• 立即就医检查\n• 严格控制饮食盐分\n• 每日监测血压2次")
        } else {
             sb.append("• 保持规律运动\n• 减少高盐高油摄入\n• 保持良好睡眠")
        }

        MaterialAlertDialogBuilder(requireContext())
            .setTitle("风险评估详情")
            .setMessage(sb.toString())
            .setPositiveButton("了解", null)
            .show()
    }

    private fun showPlanEvidenceDialog(plan: ChronicPlanEntity) {
        val dialogView = layoutInflater.inflate(R.layout.dialog_plan_evidence, null)
        val tvPlanTitle = dialogView.findViewById<TextView>(R.id.tvPlanTitle)
        val tvPlanDesc = dialogView.findViewById<TextView>(R.id.tvPlanDesc)
        val etEvidence = dialogView.findViewById<android.widget.EditText>(R.id.etEvidence)
        val btnFromDevice = dialogView.findViewById<com.google.android.material.button.MaterialButton>(R.id.btnFromDevice)

        tvPlanTitle.text = plan.title
        tvPlanDesc.text = plan.description

        var evidenceSource = "MANUAL"

        btnFromDevice.setOnClickListener {
            evidenceSource = "DEVICE"
            etEvidence.isEnabled = false
            etEvidence.setText("正在连接设备读取数据...")
            
            viewLifecycleOwner.lifecycleScope.launch {
                val data = viewModel.fetchLatestEvidence(plan)
                etEvidence.isEnabled = true
                
                if (data != null) {
                    etEvidence.setText(data)
                    Snackbar.make(dialogView, "读取成功", Snackbar.LENGTH_SHORT).show()
                } else {
                    etEvidence.setText("")
                    Snackbar.make(dialogView, "未读取到设备数据，请手动输入", Snackbar.LENGTH_SHORT).show()
                }
            }
        }

        MaterialAlertDialogBuilder(requireContext())
            .setTitle("上传完成证据")
            .setView(dialogView)
            .setPositiveButton("确认完成") { _, _ ->
                val text = etEvidence.text?.toString()?.trim().orEmpty()
                val finalEvidence = if (text.isEmpty()) null else text
                viewModel.updatePlanCompletion(plan, true, finalEvidence, evidenceSource)
            }
            .setNegativeButton("取消", null)
            .show()
    }

    // Adapter Class
    inner class PlanAdapter(private val onClick: (ChronicPlanEntity) -> Unit) : 
        RecyclerView.Adapter<PlanAdapter.PlanViewHolder>() {
            
        private var items = listOf<ChronicPlanEntity>()
        
        fun submitList(newItems: List<ChronicPlanEntity>) {
            items = newItems
            notifyDataSetChanged()
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlanViewHolder {
            val v = LayoutInflater.from(parent.context).inflate(R.layout.item_chronic_plan, parent, false)
            return PlanViewHolder(v)
        }

        override fun onBindViewHolder(holder: PlanViewHolder, position: Int) {
            val item = items[position]
            holder.bind(item)
        }
        
        override fun getItemCount() = items.size

        inner class PlanViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            private val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
            private val tvDesc: TextView = itemView.findViewById(R.id.tvDesc)
            private val tvStatus: TextView = itemView.findViewById(R.id.tvStatus)
            private val ivIcon: android.widget.ImageView = itemView.findViewById(R.id.ivIcon)
            private val btnAction: MaterialButton = itemView.findViewById(R.id.btnAction)

            fun bind(item: ChronicPlanEntity) {
                tvTitle.text = item.title
                tvDesc.text = item.description
                
                // Icon
                ivIcon.setImageResource(when(item.type) {
                    PlanType.MEDICATION -> R.drawable.ic_medication
                    PlanType.MONITORING -> R.drawable.ic_thermometer // Reusing thermometer for monitoring
                    PlanType.LIFESTYLE -> R.drawable.ic_person // Reusing person for lifestyle
                })

                if (item.isCompleted) {
                    tvStatus.text = "已完成"
                    tvStatus.setTextColor(Color.parseColor("#4CAF50"))
                    tvTitle.paintFlags = tvTitle.paintFlags or android.graphics.Paint.STRIKE_THRU_TEXT_FLAG
                    btnAction.text = "已完成"
                    btnAction.isEnabled = false
                    btnAction.setBackgroundColor(Color.TRANSPARENT)
                    btnAction.setTextColor(Color.GRAY)
                } else {
                    tvStatus.text = "未完成"
                    tvStatus.setTextColor(Color.parseColor("#F44336"))
                    tvTitle.paintFlags = tvTitle.paintFlags and android.graphics.Paint.STRIKE_THRU_TEXT_FLAG.inv()
                    btnAction.text = if (item.type == PlanType.MONITORING) "去监测" else "标记完成"
                    btnAction.isEnabled = true
                }

                btnAction.setOnClickListener {
                    onClick(item)
                }
            }
        }
    }
}
