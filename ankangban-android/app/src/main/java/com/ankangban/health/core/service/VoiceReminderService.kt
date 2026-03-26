package com.ankangban.health.core.service

import android.app.Service
import android.content.Intent
import android.media.AudioAttributes
import android.media.AudioManager
import android.os.Bundle
import android.os.IBinder
import android.speech.tts.TextToSpeech
import android.speech.tts.UtteranceProgressListener
import android.util.Log
import android.widget.Toast
import java.util.Locale
import android.os.Handler
import android.os.Looper

class VoiceReminderService : Service(), TextToSpeech.OnInitListener {

    private var tts: TextToSpeech? = null
    private var messageToSpeak: String? = null
    private val TAG = "VoiceReminderService"

    override fun onBind(intent: Intent?): IBinder? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val name = intent?.getStringExtra("medication_name") ?: ""
        val dosage = intent?.getStringExtra("dosage") ?: ""
        
        Log.d(TAG, "onStartCommand: name=$name, dosage=$dosage")

        if (name.isNotEmpty()) {
            messageToSpeak = "温馨提醒：该吃药了。药品名称：$name，服用剂量：$dosage"
            if (tts == null) {
                Log.d(TAG, "Initializing TTS...")
                tts = TextToSpeech(applicationContext, this)
            } else {
                Log.d(TAG, "TTS already initialized, speaking...")
                speak()
            }
        } else {
            Log.w(TAG, "Empty medication name")
            stopSelf()
        }
        
        return START_NOT_STICKY
    }

    override fun onInit(status: Int) {
        Log.d(TAG, "onInit: status=$status")
        if (status == TextToSpeech.SUCCESS) {
            // Try setting language to China (most specific)
            var result = tts?.setLanguage(Locale.CHINA)
            
            // If failed, try Simplified Chinese
            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                result = tts?.setLanguage(Locale.SIMPLIFIED_CHINESE)
            }
            
            // If still failed, try generic Chinese
            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                result = tts?.setLanguage(Locale.CHINESE)
            }

            Log.d(TAG, "Final setLanguage result: $result")
            
            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                // If explicit language setting fails, try to use the default configuration instead of stopping
                Log.w(TAG, "Explicit Chinese language setting failed. Attempting to use system default.")
                // Removed toast to avoid confusing user when it actually works
                setupAndSpeak()
            } else {
                setupAndSpeak()
            }
        } else {
            Log.e(TAG, "TTS Initialization failed")
            // More generic message for China context
            showToast("语音服务启动失败，请检查手机是否安装了语音引擎（如讯飞语音、小爱同学等）")
            stopSelf()
        }
    }
    
    private fun setupAndSpeak() {
        tts?.setOnUtteranceProgressListener(object : UtteranceProgressListener() {
            override fun onStart(utteranceId: String?) {
                Log.d(TAG, "TTS onStart: $utteranceId")
            }
            override fun onDone(utteranceId: String?) {
                Log.d(TAG, "TTS onDone: $utteranceId")
                stopSelf()
            }
            override fun onError(utteranceId: String?) {
                Log.e(TAG, "TTS onError: $utteranceId")
                stopSelf()
            }
        })
        speak()
    }

    private fun speak() {
        messageToSpeak?.let { msg ->
            Log.d(TAG, "Speaking: $msg")
            val params = Bundle()
            params.putString(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, "MedicationReminder")
            params.putInt(TextToSpeech.Engine.KEY_PARAM_STREAM, AudioManager.STREAM_ALARM) // Use Alarm stream for higher priority
            
            // Set Audio Attributes for newer Android versions
            val audioAttributes = AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_ALARM)
                .setContentType(AudioAttributes.CONTENT_TYPE_SPEECH)
                .build()
            tts?.setAudioAttributes(audioAttributes)
            
            val result = tts?.speak(msg, TextToSpeech.QUEUE_FLUSH, params, "MedicationReminder")
            Log.d(TAG, "speak result: $result")
            if (result == TextToSpeech.ERROR) {
                Log.e(TAG, "Error in calling speak method")
                showToast("语音播放错误")
                stopSelf()
            }
        }
    }

    private fun showToast(msg: String) {
        Handler(Looper.getMainLooper()).post {
            Toast.makeText(applicationContext, msg, Toast.LENGTH_LONG).show()
        }
    }

    override fun onDestroy() {
        Log.d(TAG, "onDestroy")
        tts?.stop()
        tts?.shutdown()
        super.onDestroy()
    }
}
