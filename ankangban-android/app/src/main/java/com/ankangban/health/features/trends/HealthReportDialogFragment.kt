package com.ankangban.health.features.trends

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.ankangban.health.R
import com.ankangban.health.core.api.HealthReportResponse
import com.ankangban.health.ui.viewmodel.HealthViewModel
import com.google.android.material.button.MaterialButton
import com.google.android.material.button.MaterialButtonToggleGroup
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class HealthReportDialogFragment : DialogFragment() {

    private val viewModel: HealthViewModel by activityViewModels()

    // UI Components
    private lateinit var contentLayout: LinearLayout
    private lateinit var loadingLayout: LinearLayout
    private lateinit var scoreView: TextView
    private lateinit var summaryView: TextView
    private lateinit var analysisView: TextView
    private lateinit var suggestionLayout: LinearLayout
    private lateinit var toggleGroupPeriod: MaterialButtonToggleGroup

    override fun onStart() {
        super.onStart()
        dialog?.window?.apply {
            setLayout(
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT
            )
            setBackgroundDrawableResource(android.R.color.transparent)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.dialog_health_report, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        // Bind Views
        contentLayout = view.findViewById(R.id.contentLayout)
        loadingLayout = view.findViewById(R.id.loadingLayout)
        scoreView = view.findViewById(R.id.tvScoreValue)
        summaryView = view.findViewById(R.id.tvSummary)
        analysisView = view.findViewById(R.id.tvAnalysis)
        suggestionLayout = view.findViewById(R.id.layoutSuggestions)
        toggleGroupPeriod = view.findViewById(R.id.toggleGroupPeriod)

        // Setup Buttons
        toggleGroupPeriod.addOnButtonCheckedListener { _, checkedId, isChecked ->
            if (isChecked) {
                when (checkedId) {
                    R.id.btnWeek -> generate("本周")
                    R.id.btnMonth -> generate("本月")
                }
            }
        }

        view.findViewById<MaterialButton>(R.id.btnClose).setOnClickListener {
            dismiss()
        }

        // Observe Data
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.healthReport.collectLatest { report ->
                displayReport(report)
            }
        }
        
        // Initial State (Select Week by default to prompt user or just wait?)
        // Let's select 'Week' initially to auto-generate if desired, 
        // or just let user click. User click is better for "Generation" action.
        // But the toggle button state needs to be managed. 
        // We can just leave it unselected initially or select one.
        // If we select one, the listener fires.
        // Let's NOT select initially to avoid auto-trigger, or auto-trigger week.
        // Given user context "Generate this week report", auto-trigger is nice.
        // But listener fires immediately on check.
        // Let's manually trigger week generation if data is empty?
        // For now, let user click.
    }

    private fun generate(period: String) {
        loadingLayout.isVisible = true
        // Keep content visible but overlaid? Or hide? 
        // Since we have a full screen loading overlay in XML (background #80FFFFFF),
        // we can keep content visible behind it.
        // But if content is empty initially, it looks weird.
        // Let's keep content visible if it has data, otherwise maybe hide.
        // For simplicity, just show loading overlay.
        
        Toast.makeText(context, "正在分析数据并生成报告...", Toast.LENGTH_SHORT).show()
        viewModel.generateHealthReport(period)
    }

    private fun displayReport(report: HealthReportResponse) {
        loadingLayout.isVisible = false
        contentLayout.isVisible = true // Ensure content is visible
        
        scoreView.text = report.score.toString()
        summaryView.text = report.summary
        
        val analysis = StringBuilder()
        analysis.append("【心率】${report.heartRateAnalysis}\n\n")
        analysis.append("【血糖】${report.bloodGlucoseAnalysis}\n\n")
        analysis.append("【睡眠】${report.sleepAnalysis}")
        analysisView.text = analysis.toString()
        
        suggestionLayout.removeAllViews()
        report.suggestions.forEachIndexed { index, s ->
            val itemLayout = LinearLayout(context).apply {
                orientation = LinearLayout.HORIZONTAL
                setPadding(0, 8, 0, 8)
            }
            
            // Icon/Bullet
            val icon = TextView(context).apply {
                text = "✓"
                textSize = 14f
                setTextColor(resources.getColor(android.R.color.holo_green_dark, null))
                setPadding(0, 2, 8, 0)
            }
            
            val content = TextView(context).apply {
                text = s
                textSize = 14f
                setTextColor(android.graphics.Color.parseColor("#616161"))
                setLineSpacing(0f, 1.2f)
            }
            
            itemLayout.addView(icon)
            itemLayout.addView(content)
            suggestionLayout.addView(itemLayout)
        }
    }
}
