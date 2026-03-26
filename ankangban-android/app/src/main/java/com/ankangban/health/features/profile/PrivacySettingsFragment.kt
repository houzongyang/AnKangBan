package com.ankangban.health.features.profile

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.view.View
import androidx.fragment.app.Fragment
import com.ankangban.health.R
import com.ankangban.health.core.storage.UserManager
import com.ankangban.health.databinding.FragmentPrivacySettingsBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class PrivacySettingsFragment : Fragment(R.layout.fragment_privacy_settings) {

    private var binding: FragmentPrivacySettingsBinding? = null
    private lateinit var userManager: UserManager

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPrivacySettingsBinding.bind(view)
        userManager = UserManager(requireContext())

        setupUI()
    }

    private fun setupUI() {
        binding?.apply {
            // Share Data Switch
            switchShareData.isChecked = userManager.shareData
            switchShareData.setOnCheckedChangeListener { _, isChecked ->
                userManager.shareData = isChecked
            }

            // Notification Permission
            btnNotificationPermission.setOnClickListener {
                val intent = Intent().apply {
                    action = Settings.ACTION_APP_NOTIFICATION_SETTINGS
                    putExtra(Settings.EXTRA_APP_PACKAGE, requireContext().packageName)
                }
                startActivity(intent)
            }

            // Permission Manager
            btnPermissionManager.setOnClickListener {
                val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS).apply {
                    data = Uri.fromParts("package", requireContext().packageName, null)
                }
                startActivity(intent)
            }

            // Privacy Policy
            btnPrivacyPolicy.setOnClickListener {
                showPrivacyPolicy()
            }
        }
    }

    private fun showPrivacyPolicy() {
        MaterialAlertDialogBuilder(requireContext())
            .setTitle("隐私政策摘要")
            .setMessage("""
                1. 数据存储：您的健康数据（心率、血氧等）均经过AES-256加密后存储在本地设备中。
                2. 数据使用：我们不会将您的个人敏感信息上传至云端，除非您明确授权。
                3. 第三方共享：未经您的同意，我们不会与任何第三方共享您的数据。
                4. 数据控制：您拥有完全的数据控制权，可以随时导出或删除您的所有数据。
            """.trimIndent())
            .setPositiveButton("了解", null)
            .show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
