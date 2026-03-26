package com.ankangban.health.features.profile

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.ankangban.health.R
import com.ankangban.health.databinding.FragmentHelpFeedbackBinding

class HelpFeedbackFragment : Fragment(R.layout.fragment_help_feedback) {

    private var binding: FragmentHelpFeedbackBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHelpFeedbackBinding.bind(view)

        setupUI()
    }

    private fun setupUI() {
        binding?.apply {
            // Submit Feedback
            btnSubmitFeedback.setOnClickListener {
                val content = etFeedback.text.toString()
                if (content.isBlank()) {
                    Toast.makeText(requireContext(), "请输入反馈内容", Toast.LENGTH_SHORT).show()
                } else {
                    etFeedback.setText("")
                    Toast.makeText(requireContext(), "反馈已收到，感谢支持", Toast.LENGTH_SHORT).show()
                }
            }

            // Copy Email
            tvContactEmail.setOnClickListener {
                val clipboard = requireContext().getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                val clip = ClipData.newPlainText("Email", tvContactEmail.text)
                clipboard.setPrimaryClip(clip)
                Toast.makeText(requireContext(), "邮箱地址已复制", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
