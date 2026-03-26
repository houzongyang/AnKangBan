package com.ankangban.health.core.api

import android.util.Log
import com.ankangban.health.BuildConfig
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.JsonArray
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.logging.HttpLoggingInterceptor
import java.nio.charset.StandardCharsets
import java.text.SimpleDateFormat
import java.util.Collections
import java.util.Date
import java.util.Locale
import java.util.TimeZone
import java.util.concurrent.TimeUnit
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec

object HunyuanService {
    private const val TAG = "HunyuanService"
    
    // Tencent Cloud Hunyuan Keys (From HunyuanAiHelper)
    private const val SECRET_ID = "AKID7DB3pTvNeiaGjz3uZ2HKAnDRVMzObbOx"
    private const val SECRET_KEY = "QdoqfJo9GBtQlsmU1KSM4bv31nNlwteD"

    private const val HOST = "hunyuan.tencentcloudapi.com"
    private const val SERVICE = "hunyuan"
    private const val ACTION = "ChatCompletions"
    private const val VERSION = "2023-09-01"
    private const val REGION = "ap-guangzhou"

    private val gson = Gson()

    private val client = OkHttpClient.Builder()
        .connectTimeout(60, TimeUnit.SECONDS) // Goal is fast response but AI can be slow
        .readTimeout(60, TimeUnit.SECONDS)
        .build()

    private var lastContext: String = ""
    private val callTimestamps = Collections.synchronizedList(mutableListOf<Long>())

    data class ChatMessage(val role: String, val content: String)

    suspend fun chatCompletion(messages: List<ChatMessage>): String = kotlinx.coroutines.withContext(kotlinx.coroutines.Dispatchers.IO) {
        try {
            val jsonBody = JsonObject()
            jsonBody.addProperty("Model", "hunyuan-pro")
            jsonBody.addProperty("Temperature", 0.7)
            jsonBody.addProperty("TopP", 0.9)

            val messageArray = JsonArray()
            messages.forEach { msg ->
                val messageObj = JsonObject()
                messageObj.addProperty("Role", msg.role)
                messageObj.addProperty("Content", msg.content)
                messageArray.add(messageObj)
            }
            jsonBody.add("Messages", messageArray)

            val payload = jsonBody.toString()
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
                Log.e(TAG, "API Error: ${response.code} $respBody")
                throw IllegalStateException("HTTP_${response.code}")
            }

            val respJson = gson.fromJson(respBody, JsonObject::class.java)
            if (respJson.has("Response")) {
                val responseObj = respJson.getAsJsonObject("Response")
                if (responseObj.has("Error")) {
                    throw IllegalStateException("API_ERROR: ${responseObj.getAsJsonObject("Error").get("Message").asString}")
                }
                if (responseObj.has("Choices")) {
                    val choices = responseObj.getAsJsonArray("Choices")
                    if (choices.size() > 0) {
                        return@withContext choices.get(0).asJsonObject.getAsJsonObject("Message").get("Content").asString
                    }
                }
            }
            throw IllegalStateException("INVALID_RESPONSE")
        } catch (e: Exception) {
            Log.e(TAG, "Chat Completion Error: ${e.message}")
            throw e
        }
    }

    suspend fun generateTrendAnalysis(
        sleepData: List<String>, // format: "date: total=Xh, deep=Y%, eff=Z%"
        period: String // "近7天" or "近30天"
    ): TrendAnalysisResponse? = kotlinx.coroutines.withContext(kotlinx.coroutines.Dispatchers.IO) {
        val prompt = """
        你是专业睡眠数据分析师。请分析用户$period 的睡眠趋势数据。
        数据如下：
        ${sleepData.joinToString("\n")}
        
        输出格式要求：必须仅返回JSON，无任何多余文本。
        JSON字段定义：
        {
          "summary": "字符串，整体趋势总结，如‘睡眠时长波动较大，深睡占比呈上升趋势’",
          "abnormalities": ["字符串数组", "发现的异常点，如‘10-24入睡过晚’"],
          "suggestions": ["字符串数组", "针对性的改善建议，2-3条"]
        }
        """.trimIndent()

        callApi(prompt, TrendAnalysisResponse::class.java)
    }

    suspend fun generateSleepAidContent(
        type: String, // "story", "meditation"
        tags: List<String>,
        userContext: String
    ): SleepAidContentResponse? = kotlinx.coroutines.withContext(kotlinx.coroutines.Dispatchers.IO) {
        val prompt = """
            你是专业的睡眠疗愈师。请为用户生成一段${type}类型的助眠内容。
            用户偏好标签：${tags.joinToString(", ")}。
            用户睡眠状况：$userContext
            请根据用户的睡眠状况在内容中进行针对性的引导（例如睡眠效率低则侧重放松，深睡少则侧重安抚）。
            
            输出格式要求：必须仅返回JSON，无任何多余文本。
            JSON字段定义：
            {
              "title": "字符串，标题，如‘森林奇遇’",
              "content": "字符串，详细的脚本内容（故事全文或冥想引导语），300字左右",
              "durationMinutes": 整数，预估时长（分钟），
              "suggestedBgMusic": "字符串，建议背景音，如‘雨声’、‘海浪’"
            }
        """.trimIndent()
        
        callApi(prompt, SleepAidContentResponse::class.java)
    }

    suspend fun generateHealthReport(
        period: String, // "本周" or "本月"
        healthDataSummary: String
    ): HealthReportResponse? = kotlinx.coroutines.withContext(kotlinx.coroutines.Dispatchers.IO) {
        val prompt = """
            你是专业的健康顾问。请根据用户${period}的健康监测数据生成一份个性化健康报告。
            数据摘要：
            $healthDataSummary
            
            输出格式要求：必须仅返回JSON，无任何多余文本。
            JSON字段定义：
            {
              "score": 整数，0-100，根据数据打分（正常范围：心率60-100，空腹血糖3.9-6.1，睡眠7-9小时），
              "summary": "字符串，整体健康状况总结，200字以内",
              "heartRateAnalysis": "字符串，心率数据分析与评价",
              "bloodGlucoseAnalysis": "字符串，血糖数据分析（若无数据则提示建议监测）",
              "sleepAnalysis": "字符串，睡眠质量分析",
              "suggestions": ["字符串数组", "3-5条具体的改善建议"]
            }
        """.trimIndent()
        
        callApi(prompt, HealthReportResponse::class.java)
    }

    suspend fun parseMedicationInfo(ocrText: String): MedicationParseResponse? = kotlinx.coroutines.withContext(kotlinx.coroutines.Dispatchers.IO) {
        val prompt = """
            你是专业的药剂师。请根据提供的药盒OCR识别文本，智能分析并补全用药信息。
            OCR文本内容：
            $ocrText
            
            重要指示：
            1. 优先从OCR文本中提取准确信息。
            2. 如果OCR文本仅包含药品名称或品牌（如信息不全），请**必须**基于你的医学知识库，补充该药品的常用用法用量（dosage）、服用频率（frequency）和常见包装规格（totalStock/unit）。
            3. 这一点非常关键：用户希望你能通过药名自动推断出如何服用，而不是仅仅依赖OCR提取。
            
            输出格式要求：必须仅返回JSON，无任何多余文本。
            JSON字段定义：
            {
              "name": "字符串，药品通用名称（尽量补全通用名）",
              "dosage": "字符串，单次用量（包含单位），如'1粒'、'10ml'、'0.5g'（基于常识推断）",
              "frequency": "字符串，服用频率描述，如'一日三次'、'每8小时一次'（基于常识推断）",
              "totalStock": 整数，包装总规格数量（估算），如24，若无法判断可填默认值如24,
              "unit": "字符串，单位，如'粒'、'袋'、'瓶'、'ml'"
            }
        """.trimIndent()
        
        callApi(prompt, MedicationParseResponse::class.java)
    }

    private fun <T> callApi(prompt: String, clazz: Class<T>): T? {
        try {
            Log.d(TAG, "Starting Hunyuan API call (Model: hunyuan-pro)...")
            val jsonBody = JsonObject()
            jsonBody.addProperty("Model", "hunyuan-pro")
            jsonBody.addProperty("Temperature", 0.7)
            jsonBody.addProperty("TopP", 0.9)
            
            val messageArray = JsonArray()
            val messageObj = JsonObject()
            messageObj.addProperty("Role", "user")
            messageObj.addProperty("Content", prompt)
            messageArray.add(messageObj)
            
            jsonBody.add("Messages", messageArray)

            val payload = jsonBody.toString()
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
                Log.e(TAG, "API Error: ${response.code} $respBody")
                throw IllegalStateException("HTTP_${response.code}")
            }

            val respJson = gson.fromJson(respBody, JsonObject::class.java)
            if (respJson.has("Response")) {
                val responseObj = respJson.getAsJsonObject("Response")
                if (responseObj.has("Error")) {
                     throw IllegalStateException("API_ERROR: ${responseObj.getAsJsonObject("Error").get("Message").asString}")
                }
                if (responseObj.has("Choices")) {
                    val choices = responseObj.getAsJsonArray("Choices")
                    if (choices.size() > 0) {
                        val content = choices.get(0).asJsonObject.getAsJsonObject("Message").get("Content").asString
                        val jsonStr = content.replace("```json", "").replace("```", "").trim()
                        return gson.fromJson(jsonStr, clazz)
                    }
                }
            }
            throw IllegalStateException("INVALID_RESPONSE")
        } catch (e: Exception) {
            Log.e(TAG, "API Call Error: ${e.message}")
            throw e
        }
    }

    suspend fun generateSleepPlan(
        deepSleepRatio: Int,
        sleepLatency: Int,
        awakenTimes: Int,
        sleepEfficiency: Int,
        age: Int,
        sleepTime: String,
        wakeTime: String,
        isSedentary: Boolean,
        stepCount: Int,
        heartRate: Int,
        wristTemp: Float
    ): SleepPlanResponse? = kotlinx.coroutines.withContext(kotlinx.coroutines.Dispatchers.IO) {
        // Rate Limiting: Max 5 calls per minute
        val now = System.currentTimeMillis()
        synchronized(callTimestamps) {
            callTimestamps.removeAll { it < now - 60000 }
            if (callTimestamps.size >= 5) {
                Log.w(TAG, "Rate limit exceeded (5 calls/min). Switching to local fallback.")
                throw IllegalStateException("RATE_LIMIT_EXCEEDED")
            }
            callTimestamps.add(now)
        }

        val contextStr = if (lastContext.isNotEmpty()) "历史上下文：$lastContext；" else ""

        val prompt = """
        你是专业睡眠健康顾问，精通CBT-I认知行为疗法，为用户生成个性化睡前1小时助眠方案。
        输出格式要求：必须仅返回JSON，无任何多余文本、注释、解释，字段缺失或格式错误视为无效输出。
        JSON字段定义：
        {
          "generateReason": "字符串，生成依据，关联用户具体数据，1-2行通俗描述",
          "plans": [
            {
              "dimension": "字符串，必为行为准备/放松训练/环境调优之一",
              "steps": [
                {
                  "content": "字符串，步骤内容，通俗易执行，1-2分钟可完成",
                  "duration": "字符串，预估时长，如1分钟/5分钟",
                  "iconType": "字符串，图标类型，对应dimension：行为准备=DEVICE/DRINK，放松训练=BREATHE/STRETCH，环境调优=LIGHT/TEMPERATURE"
                }
              ],
              "finishCount": 0, // 整数，初始完成数，固定为0
              "totalCount": "整数，该维度步骤总数"
            }
          ],
          "corePoint": "字符串，1个核心改善点，如提升深睡占比/缩短入睡时长"
        }
        用户数据：
        睡眠数据：深睡占比${deepSleepRatio}%，入睡时长${sleepLatency}分钟，觉醒次数${awakenTimes}次，睡眠效率${sleepEfficiency}%；
        个人特征：年龄${age}岁，作息${sleepTime}-${wakeTime}，是否久坐${isSedentary}；
        日常指标：今日步数${stepCount}步，静息心率均值${heartRate}次/分，腕温${wristTemp}℃；
        $contextStr
        需求：生成3-5条步骤，累计时长≤60分钟，贴合用户数据异常点，步骤可落地，避免专业术语。
        """.trimIndent()

        try {
            // Build Request Body for Tencent Cloud API
            val jsonBody = JsonObject()
            jsonBody.addProperty("Model", "hunyuan-pro")
            jsonBody.addProperty("Temperature", 0.6)
            jsonBody.addProperty("TopP", 0.8)
            
            val messageArray = JsonArray()
            val messageObj = JsonObject()
            messageObj.addProperty("Role", "user")
            messageObj.addProperty("Content", prompt)
            messageArray.add(messageObj)
            
            jsonBody.add("Messages", messageArray)

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
                Log.e(TAG, "API Error: ${response.code} $respBody")
                throw IllegalStateException("HTTP_${response.code}: $respBody")
            }

            // Parse Tencent Cloud Response
            val respJson = gson.fromJson(respBody, JsonObject::class.java)
            if (respJson.has("Response")) {
                val responseObj = respJson.getAsJsonObject("Response")
                if (responseObj.has("Error")) {
                     val errorObj = responseObj.getAsJsonObject("Error")
                     val errorMsg = errorObj.get("Message").asString
                     Log.e(TAG, "Hunyuan API Error: $errorMsg")
                     throw IllegalStateException("API_ERROR: $errorMsg")
                }
                if (responseObj.has("Choices")) {
                    val choices = responseObj.getAsJsonArray("Choices")
                    if (choices.size() > 0) {
                        val choice = choices.get(0).asJsonObject
                        if (choice.has("Message")) {
                             val content = choice.getAsJsonObject("Message").get("Content").asString
                             // Clean up markdown code blocks if present
                             val jsonStr = content.replace("```json", "").replace("```", "").trim()
                             Log.d(TAG, "Generated JSON: $jsonStr")
                             try {
                                 val plan = gson.fromJson(jsonStr, SleepPlanResponse::class.java)
                                 lastContext = "用户已生成方案，核心点：${plan.corePoint}"
                                 return@withContext plan
                             } catch (e: Exception) {
                                 Log.e(TAG, "JSON Parse Error: ${e.message}")
                                 throw IllegalStateException("JSON_PARSE_ERROR: 格式解析失败")
                             }
                        }
                    }
                }
            }
            Log.e(TAG, "Failed to parse response structure: $respBody")
            throw IllegalStateException("INVALID_RESPONSE: 响应结构异常")

        } catch (e: Exception) {
            Log.e(TAG, "Exception: ${e.message}")
            e.printStackTrace()
            throw e
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
