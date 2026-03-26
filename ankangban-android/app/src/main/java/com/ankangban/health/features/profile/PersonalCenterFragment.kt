package com.ankangban.health.features.profile

import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ankangban.health.R
import com.ankangban.health.core.storage.UserManager
import com.ankangban.health.databinding.FragmentPersonalCenterBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar

import com.ankangban.health.ui.MainActivity

class PersonalCenterFragment : Fragment(R.layout.fragment_personal_center) {

    private var binding: FragmentPersonalCenterBinding? = null
    private lateinit var userManager: UserManager

    private val pickImageLauncher = registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
        uri?.let {
            userManager.avatarUri = it.toString()
            binding?.ivAvatar?.setImageURI(it)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPersonalCenterBinding.bind(view)
        userManager = UserManager(requireContext())

        setupUserInfo()
        setupClickListeners()
        setupScrollListener()
    }

    private fun setupScrollListener() {
        binding?.let { b ->
            // Find NestedScrollView inside layout
            val scrollView = b.root.findViewById<androidx.core.widget.NestedScrollView>(R.id.scrollView) ?: return
            
            scrollView.setOnScrollChangeListener(androidx.core.widget.NestedScrollView.OnScrollChangeListener { _, _, scrollY, _, oldScrollY ->
                val activity = requireActivity() as? MainActivity ?: return@OnScrollChangeListener
                if (scrollY > oldScrollY + 5) {
                    // Scrolling down - hide
                    activity.setBottomNavVisibility(false)
                } else if (scrollY < oldScrollY - 5) {
                    // Scrolling up - show
                    activity.setBottomNavVisibility(true)
                }
            })
        }
    }

    private fun setupUserInfo() {
        binding?.apply {
            tvUserName.text = userManager.userName
            tvUserLevel.text = "健康等级 Lv.${userManager.healthLevel} | 累计监测 ${userManager.trackingDays} 天"
            
            userManager.avatarUri?.let {
                ivAvatar.setImageURI(Uri.parse(it))
            }
        }
    }

    private fun setupClickListeners() {
        binding?.apply {
            // Edit Profile
            btnEditProfile.setOnClickListener {
                findNavController().navigate(R.id.action_profile_to_edit)
            }
            ivAvatar.setOnClickListener {
                pickImageLauncher.launch("image/*")
            }

            // Grid Items
            cardPersonalInfo.setOnClickListener {
                findNavController().navigate(R.id.action_profile_to_edit)
            }
            cardWarningConfig.setOnClickListener {
                findNavController().navigate(R.id.action_profile_to_warning)
            }
            cardDataManager.setOnClickListener {
                findNavController().navigate(R.id.action_profile_to_data)
            }
            cardPrivacySettings.setOnClickListener {
                findNavController().navigate(R.id.action_profile_to_privacy)
            }
            cardSystemSettings.setOnClickListener {
                findNavController().navigate(R.id.action_profile_to_system)
            }
            cardHelpFeedback.setOnClickListener {
                findNavController().navigate(R.id.action_profile_to_help)
            }

            // Bottom Actions
            tvAboutUs.setOnClickListener {
                // Simplified: Show dialog
                MaterialAlertDialogBuilder(requireContext())
                    .setTitle("关于我们")
                    .setMessage("安康伴 - AI健康管家\n大学生软件创新大赛参赛项目\nV1.0.0 Beta")
                    .setPositiveButton("确定", null)
                    .show()
            }
            
            btnLogout.setOnClickListener {
                MaterialAlertDialogBuilder(requireContext())
                    .setTitle("退出登录")
                    .setMessage("确认退出当前账号？")
                    .setPositiveButton("退出") { _, _ ->
                        // In a real app, clear auth token. Here just nav to login.
                        findNavController().navigate(R.id.action_profile_to_login)
                    }
                    .setNegativeButton("取消", null)
                    .show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
