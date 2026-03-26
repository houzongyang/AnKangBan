package com.ankangban.health.core.ai

import android.util.Log
import com.google.gson.Gson
import com.google.gson.JsonObject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import java.nio.charset.StandardCharsets
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone
import java.util.concurrent.TimeUnit
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec

object HunyuanAiHelper {
    private const val TAG = "HunyuanAiHelper"

    // Tencent Cloud Hunyuan Keys
    private const val SECRET_ID = "AKID7DB3pTvNeiaGjz3uZ2HKAnDRVMzObbOx"
    private const val SECRET_KEY = "QdoqfJo9GBtQlsmU1KSM4bv31nNlwteD"

    private const val HOST = "hunyuan.tencentcloudapi.com"
    private const val SERVICE = "hunyuan"
    private const val ACTION = "ChatCompletions"
    private const val VERSION = "2023-09-01"
    private const val REGION = "ap-guangzhou" 

    private val client = OkHttpClient.Builder()
        .connectTimeout(60, TimeUnit.SECONDS)
        .readTimeout(60, TimeUnit.SECONDS)
        .build()

    private val gson = Gson()

    suspend fun analyzeHealthData(prompt: String): String = withContext(Dispatchers.IO) {
        try {
            // Request Body
            val jsonBody = JsonObject()
            jsonBody.addProperty("Model", "hunyuan-standard") 
            
            val messageArray = com.google.gson.JsonArray()
            val messageObj = JsonObject()
            messageObj.addProperty("Role", "user")
            messageObj.addProperty("Content", prompt)
            messageArray.add(messageObj)
            
            jsonBody.add("Messages", messageArray)
            jsonBody.addProperty("Temperature", 0.7)

            val payload = jsonBody.toString()
            
            // Signature V3
            val timestamp = (System.currentTimeMillis() / 1000).toString()
            val date = SimpleDateFormat("yyyy-MM-dd", Locale.US).apply {
                timeZone = TimeZone.getTimeZone("UTC")
            }.format(Date(timestamp.toLong() * 1000))

            val authorization = buildAuthorization(payload, timestamp, date)

            val requestBody = payload.toRequestBody("application/json; charset=utf-8".toMediaType())
            
            val request = Request.Builder()
                .url("https://$HOST")
                .post(requestBody)
                .addHeader("Authorization", authorization)
                .addHeader("Content-Type", "application/json; charset=utf-8")
                .addHeader("Host", HOST)
                .addHeader("X-TC-Action", ACTION)
                .addHeader("X-TC-Version", VERSION)
                .addHeader("X-TC-Timestamp", timestamp)
                .addHeader("X-TC-Region", REGION)
                .build()

            val response = client.newCall(request).execute()
            val respBody = response.body?.string()

            if (!response.isSuccessful || respBody == null) {
                return@withContext "请求失败: ${response.code} $respBody"
            }

            val respJson = gson.fromJson(respBody, JsonObject::class.java)
            if (respJson.has("Response")) {
                val responseObj = respJson.getAsJsonObject("Response")
                if (responseObj.has("Error")) {
                     val errorObj = responseObj.getAsJsonObject("Error")
                     return@withContext "API错误: ${errorObj.get("Message").asString}"
                }
                if (responseObj.has("Choices")) {
                    val choices = responseObj.getAsJsonArray("Choices")
                    if (choices.size() > 0) {
                        val choice = choices.get(0).asJsonObject
                        if (choice.has("Message")) {
                             return@withContext choice.getAsJsonObject("Message").get("Content").asString
                        }
                    }
                }
            }
            
            return@withContext "无法解析响应: $respBody"

        } catch (e: Exception) {
            Log.e(TAG, "Hunyuan Error", e)
            return@withContext "AI连接异常: ${e.message}"
        }
    }

    private fun buildAuthorization(payload: String, timestamp: String, date: String): String {
        // 1. Canonical Request
        val httpRequestMethod = "POST"
        val canonicalUri = "/"
        val canonicalQueryString = ""
        val canonicalHeaders = "content-type:application/json; charset=utf-8\nhost:$HOST\n"
        val signedHeaders = "content-type;host"
        val hashedRequestPayload = sha256Hex(payload)
        val canonicalRequest = "$httpRequestMethod\n$canonicalUri\n$canonicalQueryString\n$canonicalHeaders\n$signedHeaders\n$hashedRequestPayload"

        // 2. String to Sign
        val algorithm = "TC3-HMAC-SHA256"
        val credentialScope = "$date/$SERVICE/tc3_request"
        val hashedCanonicalRequest = sha256Hex(canonicalRequest)
        val stringToSign = "$algorithm\n$timestamp\n$credentialScope\n$hashedCanonicalRequest"

        // 3. Calculate Signature
        val secretDate = hmac256(("TC3" + SECRET_KEY).toByteArray(StandardCharsets.UTF_8), date)
        val secretService = hmac256(secretDate, SERVICE)
        val secretSigning = hmac256(secretService, "tc3_request")
        val signature = bytesToHex(hmac256(secretSigning, stringToSign))

        // 4. Authorization
        return "$algorithm Credential=$SECRET_ID/$credentialScope, SignedHeaders=$signedHeaders, Signature=$signature"
    }

    private fun hmac256(key: ByteArray, msg: String): ByteArray {
        val mac = Mac.getInstance("HmacSHA256")
        val secretKeySpec = SecretKeySpec(key, "HmacSHA256")
        mac.init(secretKeySpec)
        return mac.doFinal(msg.toByteArray(StandardCharsets.UTF_8))
    }

    private fun sha256Hex(s: String): String {
        val md = java.security.MessageDigest.getInstance("SHA-256")
        val d = md.digest(s.toByteArray(StandardCharsets.UTF_8))
        return bytesToHex(d)
    }

    private fun bytesToHex(bytes: ByteArray): String {
        val sb = StringBuilder()
        for (b in bytes) {
            sb.append(String.format("%02x", b))
        }
        return sb.toString()
    }
}
