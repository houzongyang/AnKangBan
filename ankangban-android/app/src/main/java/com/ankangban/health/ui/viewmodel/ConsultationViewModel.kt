package com.ankangban.health.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.ankangban.health.core.api.HunyuanService
import com.ankangban.health.core.repo.HealthRepository
import com.ankangban.health.core.oppo.OppoHealthClientImpl
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.util.UUID

class ConsultationViewModel(application: Application) : AndroidViewModel(application) {

    private val repo = HealthRepository(
        client = OppoHealthClientImpl(application),
        store = com.ankangban.health.core.storage.HealthLocalStore(application)
    )

    // Modes
    enum class ConsultationMode { DOCTOR, AI }
    private val _currentMode = MutableStateFlow(ConsultationMode.DOCTOR)
    val currentMode = _currentMode.asStateFlow()

    // Messages
    data class UiMessage(
        val id: String = UUID.randomUUID().toString(),
        val content: String,
        val isUser: Boolean,
        val timestamp: Long = System.currentTimeMillis(),
        val senderName: String = "", // "李医生" or "康博士"
        val senderRole: String = "", // "心内科主任" or "全科AI顾问"
        val type: MessageType = MessageType.TEXT,
        val status: MessageStatus = MessageStatus.SENT,
        val attachmentUri: String? = null
    )
    
    enum class MessageType { TEXT, IMAGE, REPORT_CARD }
    enum class MessageStatus { SENDING, SENT, ERROR }

    private val _messages = MutableStateFlow<List<UiMessage>>(emptyList())
    val messages = _messages.asStateFlow()

    // Doctor Info (Mock)
    data class DoctorInfo(
        val name: String,
        val title: String,
        val department: String,
        val hospital: String,
        val rating: Double,
        val count: Int,
        val isOnline: Boolean
    )
    
    private val _currentDoctor = MutableStateFlow(
        DoctorInfo("李医生", "主任医师", "心内科", "协和医院", 4.9, 2341, true)
    )
    val currentDoctor = _currentDoctor.asStateFlow()

    // Health Data Context
    val healthData = combine(
        repo.heartRate,
        repo.sleepSummary,
        repo.steps
    ) { hr, sleep, steps ->
        val sleepHours = if (sleep != null) String.format("%.1f", sleep.totalMinutes / 60f) else "--"
        "心率: ${hr?.bpm ?: "--"}bpm, 睡眠: ${sleepHours}h, 步数: ${steps?.count ?: 0}"
    }.stateIn(viewModelScope, SharingStarted.Lazily, "")

    // AI Context History
    private val aiContext = mutableListOf<HunyuanService.ChatMessage>()

    fun switchMode(mode: ConsultationMode) {
        _currentMode.value = mode
        if (mode == ConsultationMode.DOCTOR) {
            loadDoctorDemoMessages()
        } else {
            loadAiDemoMessages()
        }
    }

    private fun loadDoctorDemoMessages() {
         _messages.value = listOf(
             UiMessage(content = "李医生，最近我总是感觉头晕，尤其是早上起床的时候。", isUser = true),
             UiMessage(content = "你好，请问这种症状持续多久了？有没有测量过血压？", isUser = false, senderName = "李医生", senderRole = "主任医师")
         )
    }

    private fun loadAiDemoMessages() {
        _messages.value = listOf(
            UiMessage(content = "你好，我是康博士。作为你的AI全科健康顾问，我可以为你提供初步的健康咨询。请告诉我哪里不舒服？", isUser = false, senderName = "康博士", senderRole = "AI顾问")
        )
        // Init AI context
        aiContext.clear()
        aiContext.add(HunyuanService.ChatMessage("system", "你是专业的全科医生AI助手‘康博士’。请基于用户描述进行初步诊断建议，语气亲切专业。回答请简练，关键信息可加粗。"))
        aiContext.add(HunyuanService.ChatMessage("assistant", "你好，我是康博士。作为你的AI全科健康顾问，我可以为你提供初步的健康咨询。请告诉我哪里不舒服？"))
    }

    fun sendMessage(content: String, type: MessageType = MessageType.TEXT, uri: String? = null) {
        val userMsg = UiMessage(content = content, isUser = true, type = type, attachmentUri = uri)
        _messages.value = _messages.value + userMsg

        if (_currentMode.value == ConsultationMode.DOCTOR) {
            simulateDoctorReply(content)
        } else {
            generateAiReply(content)
        }
    }

    private fun simulateDoctorReply(userContent: String) {
        viewModelScope.launch {
            kotlinx.coroutines.delay(1000) // Simulate typing
            val reply = when {
                userContent.contains("血压") -> "收缩压140确实偏高了。建议这两天早晚各测量一次，并记录下来。饮食上注意少盐。"
                userContent.contains("头痛") -> "头痛的位置是哪里？是胀痛还是刺痛？伴有恶心吗？"
                userContent.contains("谢谢") -> "不客气，按时服药，有情况随时联系。"
                else -> "收到您的信息。建议您上传一下最近的体检报告，方便我更准确判断。"
            }
            val docMsg = UiMessage(content = reply, isUser = false, senderName = "李医生", senderRole = "主任医师")
            _messages.value = _messages.value + docMsg
        }
    }

    private fun generateAiReply(userContent: String) {
        viewModelScope.launch {
            // Add user message to context
            val contextData = healthData.value
            aiContext.add(HunyuanService.ChatMessage("user", "$userContent\n(参考用户数据: $contextData)"))
            
            try {
                val replyContent = HunyuanService.chatCompletion(aiContext)
                val aiMsg = UiMessage(content = replyContent, isUser = false, senderName = "康博士", senderRole = "AI顾问")
                _messages.value = _messages.value + aiMsg
                
                // Add AI reply to context
                aiContext.add(HunyuanService.ChatMessage("assistant", replyContent))
            } catch (e: Exception) {
                val errorMsg = UiMessage(content = "抱歉，网络连接异常，请稍后再试。", isUser = false, senderName = "康博士", senderRole = "AI顾问", status = MessageStatus.ERROR)
                _messages.value = _messages.value + errorMsg
            }
        }
    }
    
    init {
        switchMode(ConsultationMode.DOCTOR)
    }
}
