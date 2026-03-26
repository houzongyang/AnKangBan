package com.ankangban.health.features.medication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.ankangban.health.R
import com.ankangban.health.databinding.FragmentMedicationListBinding
import com.ankangban.health.ui.viewmodel.MedicationViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MedicationListFragment : Fragment() {

    private var _binding: FragmentMedicationListBinding? = null
    private val binding get() = _binding!!
    
    private val viewModel: MedicationViewModel by viewModels()
    private lateinit var adapter: MedicationAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMedicationListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        setupRecyclerView()
        setupListeners()
        observeData()
    }

    private fun setupRecyclerView() {
        adapter = MedicationAdapter { item ->
            // Navigate to Edit with ID
            val bundle = Bundle().apply { putLong("medicationId", item.medication.id) }
            findNavController().navigate(R.id.action_list_to_edit, bundle)
        }
        binding.rvMedications.adapter = adapter
        binding.rvMedications.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun setupListeners() {
        binding.toolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
        
        binding.fabAdd.setOnClickListener {
            // Navigate to Add (ID = 0)
            findNavController().navigate(R.id.action_list_to_edit)
        }
    }

    private fun observeData() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.medications.collectLatest { list ->
                adapter.submitList(list)
                binding.tvEmpty.visibility = if (list.isEmpty()) View.VISIBLE else View.GONE
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
