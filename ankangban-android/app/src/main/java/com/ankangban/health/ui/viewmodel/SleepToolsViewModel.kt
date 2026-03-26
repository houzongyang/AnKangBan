package com.ankangban.health.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.ankangban.health.core.api.HunyuanService
import com.ankangban.health.core.api.SleepAidContentResponse
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

import com.ankangban.health.core.storage.HealthDatabase
import kotlinx.coroutines.flow.collectLatest

import android.speech.tts.TextToSpeech
import android.speech.tts.UtteranceProgressListener
import java.util.Locale

class SleepToolsViewModel(application: Application) : AndroidViewModel(application), TextToSpeech.OnInitListener {

    private val sleepDao = HealthDatabase.get(application).sleepDao()
    private val aiContentDao = HealthDatabase.get(application).aiContentDao()
    
    private var tts: TextToSpeech? = null
    private var isTtsReady = false
    private var ttsErrorMsg: String? = null
    
    // Moved init block to after property initialization to avoid NPE
    
    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            // Try Simplified Chinese first
            val result = tts?.setLanguage(Locale.SIMPLIFIED_CHINESE)
            
            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                // Try falling back to default Chinese or just log error
                val fallbackResult = tts?.setLanguage(Locale.CHINESE)
                if (fallbackResult == TextToSpeech.LANG_MISSING_DATA || fallbackResult == TextToSpeech.LANG_NOT_SUPPORTED) {
                    ttsErrorMsg = "系统缺失中文语音包"
                    viewModelScope.launch { 
                        _toastEvent.emit(ttsErrorMsg!!) 
                    }
                    isTtsReady = false
                    _isSilentMode.value = true
                } else {
                    isTtsReady = true
                    ttsErrorMsg = null
                    _isSilentMode.value = false
                    setupTtsListener()
                }
            } else {
                isTtsReady = true
                ttsErrorMsg = null
                _isSilentMode.value = false
                setupTtsListener()
            }
        } else {
            ttsErrorMsg = "语音引擎初始化失败(代码:$status)"
            viewModelScope.launch { 
                _toastEvent.emit(ttsErrorMsg!!) 
            }
            isTtsReady = false
            _isSilentMode.value = true
        }
    }
    
    private fun setupTtsListener() {
        tts?.setOnUtteranceProgressListener(object : UtteranceProgressListener() {
            override fun onStart(utteranceId: String?) {
                _isPlaying.value = true
            }
            override fun onDone(utteranceId: String?) {
                _isPlaying.value = false
                stopPlaybackSimulation()
            }
            override fun onError(utteranceId: String?) {
                _isPlaying.value = false
                stopPlaybackSimulation()
            }
        })
    }
    
    override fun onCleared() {
        super.onCleared()
        tts?.stop()
        tts?.shutdown()
    }

    // AI History
    val aiHistory = aiContentDao.getAll()

    // Recommendation
    private val _recommendedTool = MutableStateFlow<String?>(null)
    val recommendedTool: StateFlow<String?> = _recommendedTool.asStateFlow()
    
    // User Sleep Stats for AI Context
    private var lastSleepEfficiency = 0
    private var lastDeepSleepMinutes = 0

    // Points System
    private val _userPoints = MutableStateFlow(0)
    val userPoints: StateFlow<Int> = _userPoints.asStateFlow()

    init {
        // Load initial points
        val prefs = application.getSharedPreferences("user_gamification", android.content.Context.MODE_PRIVATE)
        _userPoints.value = prefs.getInt("points", 0)
    }

    fun addPoints(amount: Int) {
        val prefs = getApplication<Application>().getSharedPreferences("user_gamification", android.content.Context.MODE_PRIVATE)
        val current = _userPoints.value
        val newPoints = current + amount
        
        // Save
        prefs.edit().putInt("points", newPoints).apply()
        _userPoints.value = newPoints
        
        // Check Level Up
        val oldLevel = current / 100 + 1
        val newLevel = newPoints / 100 + 1
        
        viewModelScope.launch {
            if (newLevel > oldLevel) {
                _toastEvent.emit("恭喜！升级到 Lv.$newLevel 🎉")
            } else {
                _toastEvent.emit("获得 $amount 积分！")
            }
        }
    }

    private fun monitorSleepData() {
        viewModelScope.launch {
            sleepDao.getLatest().collectLatest { sleep ->
                if (sleep != null) {
                    lastSleepEfficiency = sleep.efficiency.toInt()
                    lastDeepSleepMinutes = sleep.deepMinutes
                    
                    // Simple Logic: 
                    // If efficiency < 85 -> Recommend Meditation
                    // If deep sleep < 60 min -> Recommend Breathing (Deep Sleep helper)
                    // Else -> White Noise
                    if (sleep.efficiency < 85) {
                        _recommendedTool.value = "meditation"
                    } else if (sleep.deepMinutes < 60) {
                        _recommendedTool.value = "breathing"
                    } else {
                        _recommendedTool.value = "white_noise"
                    }
                } else {
                    _recommendedTool.value = "meditation" // Default
                }
            }
        }
    }

    // AI Generation

    // AI Generation
    private val _aiContent = MutableStateFlow<SleepAidContentResponse?>(null)
    val aiContent: StateFlow<SleepAidContentResponse?> = _aiContent.asStateFlow()
    
    private val _toastEvent = MutableSharedFlow<String>()
    val toastEvent: SharedFlow<String> = _toastEvent.asSharedFlow()
    
    private val _isGenerating = MutableStateFlow(false)
    val isGenerating: StateFlow<Boolean> = _isGenerating.asStateFlow()

    // Playback State
    private val _isPlaying = MutableStateFlow(false)
    val isPlaying: StateFlow<Boolean> = _isPlaying.asStateFlow()
    
    private val _currentPlayingTitle = MutableStateFlow("")
    val currentPlayingTitle: StateFlow<String> = _currentPlayingTitle.asStateFlow()
    
    private val _playbackProgress = MutableStateFlow(0)
    val playbackProgress: StateFlow<Int> = _playbackProgress.asStateFlow()
    
    private val _playbackTime = MutableStateFlow("00:00")
    val playbackTime: StateFlow<String> = _playbackTime.asStateFlow()
    
    // Silent Mode (TTS Unavailable)
    private val _isSilentMode = MutableStateFlow(false)
    val isSilentMode: StateFlow<Boolean> = _isSilentMode.asStateFlow()
    
    private var playbackJob: kotlinx.coroutines.Job? = null

    init {
        initTts()
        monitorSleepData()
    }
    
    private fun initTts() {
        try {
            tts = TextToSpeech(getApplication(), this)
        } catch (e: Exception) {
            e.printStackTrace()
            ttsErrorMsg = "TTS初始化崩溃: ${e.message}"
            isTtsReady = false
            // Check if _isSilentMode is initialized before setting
            // Since initTts is called from init block which is now at bottom, 
            // all properties should be initialized.
            _isSilentMode.value = true
        }
    }

    fun generateContent(type: String, tags: List<String>) {
        viewModelScope.launch {
            _isGenerating.value = true
            try {
                // Enhance prompt with user context
                val timestamp = System.currentTimeMillis()
                val userContext = if (lastSleepEfficiency > 0) 
                    "用户近期睡眠效率${lastSleepEfficiency}%，深睡时长${lastDeepSleepMinutes}分钟。请结合当前时间戳${timestamp}生成不重复的内容。" 
                else 
                    "用户暂无详细睡眠数据，请提供通用的助眠内容。请结合当前时间戳${timestamp}生成全新的、不重复的内容。"
                
                // Try API
                val result = HunyuanService.generateSleepAidContent(type, tags, userContext)
                if (result != null) {
                    _aiContent.value = result
                    // Save to DB
                    saveToHistory(result, type, tags)
                    // Auto-play on success
                    playContent(result.title)
                    _toastEvent.emit("已通过腾讯混元大模型生成专属内容")
                }
            } catch (e: Exception) {
                e.printStackTrace()
                // Fallback for demo/offline
                val fallback = SleepAidContentResponse(
                    title = "星空探险 (离线版)",
                    content = "这是一个宁静的夜晚，你躺在柔软的草地上，仰望星空...（网络不可用，已切换至离线模式）",
                    durationMinutes = 15,
                    suggestedBgMusic = "雨声"
                )
                _aiContent.value = fallback
                playContent(fallback.title)
                _toastEvent.emit("网络连接异常，已切换至离线模式")
            } finally {
                _isGenerating.value = false
            }
        }
    }
    
    private suspend fun saveToHistory(response: SleepAidContentResponse, type: String, tags: List<String>) {
        val entity = com.ankangban.health.core.storage.AiContentEntity(
            title = response.title,
            content = response.content,
            type = type,
            tags = tags.joinToString(", "),
            durationMinutes = response.durationMinutes,
            suggestedBgMusic = response.suggestedBgMusic
        )
        aiContentDao.insert(entity)
    }

    fun loadFromHistory(response: SleepAidContentResponse) {
        _aiContent.value = response
        playContent(response.title)
    }

    private fun startPlaybackSimulation(text: String) {
        playbackJob?.cancel()
        playbackJob = viewModelScope.launch {
            // Estimate: 250ms per char (approx 4 chars/sec)
            val durationMs = text.length * 250L
            val startTime = System.currentTimeMillis()
            
            while (true) {
                val elapsed = System.currentTimeMillis() - startTime
                if (elapsed >= durationMs) {
                    _playbackProgress.value = 100
                    _playbackTime.value = formatTime(durationMs)
                    break
                }
                
                val progress = (elapsed * 100 / durationMs).toInt()
                _playbackProgress.value = progress
                _playbackTime.value = formatTime(elapsed)
                
                kotlinx.coroutines.delay(100)
            }
        }
    }
    
    private fun stopPlaybackSimulation() {
        playbackJob?.cancel()
        _playbackProgress.value = 0
        _playbackTime.value = "00:00"
    }
    
    private fun formatTime(ms: Long): String {
        val totalSeconds = ms / 1000
        val minutes = totalSeconds / 60
        val seconds = totalSeconds % 60
        return String.format("%02d:%02d", minutes, seconds)
    }

    fun togglePlay(title: String) {
        if (_currentPlayingTitle.value == title && _isPlaying.value) {
            _isPlaying.value = false
            tts?.stop()
            playbackJob?.cancel() // Pause progress but don't reset
        } else {
            _currentPlayingTitle.value = title
            _isPlaying.value = true
            
            // Speak content
            val content = _aiContent.value?.content
            if (!content.isNullOrEmpty()) {
                if (isTtsReady) {
                    val params = android.os.Bundle()
                    params.putString(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, "ai_content")
                    tts?.speak(content, TextToSpeech.QUEUE_FLUSH, params, "ai_content")
                } else {
                    // Try to re-init if not ready
                    if (ttsErrorMsg != null) {
                         viewModelScope.launch { _toastEvent.emit("无法朗读: $ttsErrorMsg") }
                    } else {
                        // Maybe it wasn't initialized yet or just failed silently? Try re-init
                        initTts()
                        viewModelScope.launch { _toastEvent.emit("正在尝试重启语音服务...") }
                    }
                }
                
                // Always start simulation so UI updates even if TTS is silent/not ready
                startPlaybackSimulation(content)
            }
        }
    }
    
    private fun playContent(title: String) {
        _currentPlayingTitle.value = title
        _isPlaying.value = true
        
        // Speak content
        val content = _aiContent.value?.content
        if (!content.isNullOrEmpty()) {
            if (isTtsReady) {
                val params = android.os.Bundle()
                params.putString(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, "ai_content")
                tts?.speak(content, TextToSpeech.QUEUE_FLUSH, params, "ai_content")
            } else {
                if (ttsErrorMsg != null) {
                     viewModelScope.launch { _toastEvent.emit("无法朗读: $ttsErrorMsg") }
                } else {
                     viewModelScope.launch { _toastEvent.emit("语音服务未就绪，请检查设备设置") }
                }
            }
            // Always start simulation so UI updates even if TTS is silent/not ready
            startPlaybackSimulation(content)
        }
    }
}

