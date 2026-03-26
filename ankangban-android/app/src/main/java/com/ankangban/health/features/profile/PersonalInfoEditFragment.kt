package com.ankangban.health.features.profile

import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ankangban.health.R
import com.ankangban.health.core.storage.UserManager
import com.ankangban.health.databinding.FragmentPersonalInfoEditBinding

class PersonalInfoEditFragment : Fragment(R.layout.fragment_personal_info_edit) {

    private var binding: FragmentPersonalInfoEditBinding? = null
    private lateinit var userManager: UserManager

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPersonalInfoEditBinding.bind(view)
        userManager = UserManager(requireContext())

        setupUI()
        loadData()
    }

    private fun setupUI() {
        binding?.apply {
            // Age Spinner
            val ages = (18..80).map { "$it 岁" }
            val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, ages)
            spAge.adapter = adapter

            // Enable Save button on changes
            etUserName.doAfterTextChanged { binding?.btnSave?.isEnabled = true }
            etHeight.doAfterTextChanged { binding?.btnSave?.isEnabled = true }
            etWeight.doAfterTextChanged { binding?.btnSave?.isEnabled = true }
            rgGender.setOnCheckedChangeListener { _, _ -> binding?.btnSave?.isEnabled = true }
            
            btnSave.setOnClickListener {
                saveData()
                findNavController().navigateUp()
            }
        }
    }

    private fun loadData() {
        binding?.apply {
            // Avatar
            userManager.avatarUri?.let {
                ivAvatarPreview.setImageURI(Uri.parse(it))
            }

            // Name
            etUserName.setText(userManager.userName)

            // Age
            val ageIndex = userManager.userAge - 18
            if (ageIndex in 0 until spAge.adapter.count) {
                spAge.setSelection(ageIndex)
            }

            // Gender
            when (userManager.userGender) {
                "男" -> rbMale.isChecked = true
                "女" -> rbFemale.isChecked = true
                else -> rbSecret.isChecked = true
            }

            // Height/Weight
            etHeight.setText(userManager.userHeight)
            etWeight.setText(userManager.userWeight)
            
            // Disable button initially
            btnSave.isEnabled = false
        }
    }

    private fun saveData() {
        binding?.apply {
            userManager.userName = etUserName.text.toString()
            val selectedAgeStr = spAge.selectedItem.toString().replace(" 岁", "")
            userManager.userAge = selectedAgeStr.toIntOrNull() ?: 25
            
            userManager.userGender = when (rgGender.checkedRadioButtonId) {
                R.id.rbMale -> "男"
                R.id.rbFemale -> "女"
                else -> "保密"
            }

            userManager.userHeight = etHeight.text.toString()
            userManager.userWeight = etWeight.text.toString()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
