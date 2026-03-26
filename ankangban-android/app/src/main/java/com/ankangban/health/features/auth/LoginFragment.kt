package com.ankangban.health.features.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.ankangban.health.R
import com.ankangban.health.databinding.FragmentLoginBinding
import com.ankangban.health.ui.viewmodel.AuthViewModel
import com.ankangban.health.ui.viewmodel.UiState
import kotlinx.coroutines.launch

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private val viewModel: AuthViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Auto-fill phone
        val savedPhone = viewModel.getSavedPhone()
        if (!savedPhone.isNullOrEmpty()) {
            binding.etPhone.setText(savedPhone)
        }

        setupListeners()
        observeState()
    }

    private fun setupListeners() {
        binding.btnLogin.setOnClickListener {
            val phone = binding.etPhone.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()

            if (phone.isEmpty() || password.isEmpty()) {
                Toast.makeText(context, "请输入手机号和密码", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            viewModel.login(phone, password)
        }

        binding.tvRegister.setOnClickListener {
             val phone = binding.etPhone.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()

            if (phone.isEmpty() || password.isEmpty()) {
                Toast.makeText(context, "注册请输入手机号和密码", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            viewModel.register(phone, password)
        }
    }

    private fun observeState() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.loginState.collect { state ->
                    when (state) {
                        is UiState.Idle -> {
                            binding.progressBar.visibility = View.GONE
                            binding.btnLogin.isEnabled = true
                        }
                        is UiState.Loading -> {
                            binding.progressBar.visibility = View.VISIBLE
                            binding.btnLogin.isEnabled = false
                        }
                        is UiState.Success -> {
                            binding.progressBar.visibility = View.GONE
                            binding.btnLogin.isEnabled = true
                            Toast.makeText(context, "操作成功", Toast.LENGTH_SHORT).show()
                            findNavController().navigate(R.id.action_loginFragment_to_healthDashboardFragment)
                            viewModel.resetState()
                        }
                        is UiState.Error -> {
                            binding.progressBar.visibility = View.GONE
                            binding.btnLogin.isEnabled = true
                            Toast.makeText(context, state.message, Toast.LENGTH_SHORT).show()
                            viewModel.resetState()
                        }
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
