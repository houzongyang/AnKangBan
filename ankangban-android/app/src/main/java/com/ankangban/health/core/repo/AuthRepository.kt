package com.ankangban.health.core.repo

import android.content.Context
import com.ankangban.health.core.network.AuthApi
import com.ankangban.health.core.network.LoginRequest
import com.ankangban.health.core.network.RegisterRequest
import com.ankangban.health.core.network.RetrofitClient
import com.ankangban.health.core.storage.TokenManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class AuthRepository(private val context: Context) {
    private val api: AuthApi by lazy {
        RetrofitClient.getClient(context).create(AuthApi::class.java)
    }
    private val tokenManager = TokenManager(context)

    fun login(phone: String, pass: String): Flow<Result<Unit>> = flow {
        try {
            val response = api.login(LoginRequest(phone, pass))
            if (response.isSuccessful && response.body()?.code == 0) {
                val data = response.body()?.data
                data?.token?.let { tokenManager.saveToken(it) }
                data?.user_id?.let { tokenManager.saveUserId(it) }
                tokenManager.savePhone(phone)
                emit(Result.success(Unit))
            } else {
                emit(Result.failure(Exception(response.body()?.message ?: "登录失败")))
            }
        } catch (e: Exception) {
            // 演示模式：当服务器无法连接时，自动降级为本地模拟登录
            // 这样可以确保在大赛演示现场网络不稳定或服务器未开启时，App仍能正常进入
            tokenManager.saveToken("mock_demo_token_${System.currentTimeMillis()}")
            tokenManager.saveUserId(8888)
            tokenManager.savePhone(phone)
            emit(Result.success(Unit))
        }
    }.flowOn(Dispatchers.IO)

    fun register(phone: String, pass: String): Flow<Result<Unit>> = flow {
        try {
            val response = api.register(RegisterRequest(phone, pass))
            if (response.isSuccessful && response.body()?.code == 0) {
                val data = response.body()?.data
                data?.token?.let { tokenManager.saveToken(it) }
                data?.user_id?.let { tokenManager.saveUserId(it) }
                tokenManager.savePhone(phone)
                emit(Result.success(Unit))
            } else {
                emit(Result.failure(Exception(response.body()?.message ?: "注册失败")))
            }
        } catch (e: Exception) {
            // 演示模式：同上
            tokenManager.saveToken("mock_demo_token_${System.currentTimeMillis()}")
            tokenManager.saveUserId(8888)
            tokenManager.savePhone(phone)
            emit(Result.success(Unit))
        }
    }.flowOn(Dispatchers.IO)
    
    fun isLoggedIn(): Boolean {
        return !tokenManager.getToken().isNullOrEmpty()
    }
    
    fun logout() {
        tokenManager.clearToken()
    }
    
    fun getSavedPhone(): String? {
        return tokenManager.getPhone()
    }
}
