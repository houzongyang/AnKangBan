package com.ankangban.health.features.profile

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import com.ankangban.health.R
import com.ankangban.health.databinding.FragmentSystemSettingsBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class SystemSettingsFragment : Fragment(R.layout.fragment_system_settings) {

    private var binding: FragmentSystemSettingsBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSystemSettingsBinding.bind(view)

        setupUI()
    }

    private fun setupUI() {
        binding?.apply {
            // Dark Mode
            val currentNightMode = AppCompatDelegate.getDefaultNightMode()
            switchDarkMode.isChecked = currentNightMode == AppCompatDelegate.MODE_NIGHT_YES
            
            switchDarkMode.setOnCheckedChangeListener { _, isChecked ->
                val mode = if (isChecked) AppCompatDelegate.MODE_NIGHT_YES else AppCompatDelegate.MODE_NIGHT_NO
                AppCompatDelegate.setDefaultNightMode(mode)
            }

            // Language
            val languages = listOf("简体中文", "English")
            val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, languages)
            spLanguage.adapter = adapter
            
            spLanguage.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    if (position == 1) { // English selected
                        Toast.makeText(requireContext(), "Language switch not fully supported in demo", Toast.LENGTH_SHORT).show()
                    }
                }
                override fun onNothingSelected(parent: AdapterView<*>?) {}
            }

            // Update Check
            btnCheckUpdate.setOnClickListener {
                MaterialAlertDialogBuilder(requireContext())
                    .setTitle("检查更新")
                    .setMessage("当前已是最新版本 (V1.0.0)。")
                    .setPositiveButton("确定", null)
                    .show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
