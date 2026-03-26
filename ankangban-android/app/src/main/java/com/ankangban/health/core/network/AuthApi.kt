package com.ankangban.health.core.network

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {
    @POST("auth/login")
    suspend fun login(@Body request: LoginRequest): Response<AuthResponse>

    @POST("auth/register")
    suspend fun register(@Body request: RegisterRequest): Response<AuthResponse>
}

data class LoginRequest(val phone: String, val password: String)
data class RegisterRequest(val phone: String, val password: String)
data class AuthResponse(val code: Int, val message: String, val data: AuthData?)
data class AuthData(val user_id: Int, val token: String?)
