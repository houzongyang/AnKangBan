package com.ankangban.health.core.network

import android.content.Context
import com.ankangban.health.core.storage.TokenManager
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClient {
    // IMPORTANT: Change this IP to your computer's IP address if running on real device!
    // For Emulator, use "http://10.0.2.2:5000/api/"
    // For Real Device with ADB Reverse (Recommended), use "http://127.0.0.1:5000/api/"
    // For Real Device via WiFi, use "http://192.168.x.x:5000/api/"
    private const val BASE_URL = "http://127.0.0.1:5000/api/" 

    private var retrofit: Retrofit? = null

    fun getClient(context: Context): Retrofit {
        if (retrofit == null) {
            val tokenManager = TokenManager(context)
            
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY

            val client = OkHttpClient.Builder()
                .addInterceptor(logging)
                .addInterceptor { chain ->
                    val original = chain.request()
                    val token = tokenManager.getToken()
                    val requestBuilder = original.newBuilder()
                    if (!token.isNullOrEmpty()) {
                        requestBuilder.header("Authorization", "Bearer $token")
                    }
                    val request = requestBuilder.build()
                    chain.proceed(request)
                }
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build()

            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
        }
        return retrofit!!
    }
}
