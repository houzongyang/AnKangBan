package com.ankangban.health.features.family

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ankangban.health.databinding.FragmentFamilyBinding

class FamilyFragment : Fragment() {

    private var _binding: FragmentFamilyBinding? = null
    private val binding: FragmentFamilyBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFamilyBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvTitle.text = "家庭共享"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

