package com.ankangban.health.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.ankangban.health.core.repo.AuthRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AuthViewModel(application: Application) : AndroidViewModel(application) {
    private val repo = AuthRepository(application)

    private val _loginState = MutableStateFlow<UiState>(UiState.Idle)
    val loginState: StateFlow<UiState> = _loginState.asStateFlow()

    fun login(phone: String, pass: String) {
        _loginState.value = UiState.Loading
        viewModelScope.launch {
            repo.login(phone, pass).collect { result ->
                if (result.isSuccess) {
                    _loginState.value = UiState.Success
                } else {
                    _loginState.value = UiState.Error(result.exceptionOrNull()?.message ?: "未知错误")
                }
            }
        }
    }

    fun register(phone: String, pass: String) {
        _loginState.value = UiState.Loading
        viewModelScope.launch {
            repo.register(phone, pass).collect { result ->
                if (result.isSuccess) {
                    _loginState.value = UiState.Success
                } else {
                    _loginState.value = UiState.Error(result.exceptionOrNull()?.message ?: "未知错误")
                }
            }
        }
    }
    
    fun resetState() {
        _loginState.value = UiState.Idle
    }

    fun getSavedPhone(): String? {
        return repo.getSavedPhone()
    }
}

sealed class UiState {
    object Idle : UiState()
    object Loading : UiState()
    object Success : UiState()
    data class Error(val message: String) : UiState()
}
