package com.ankangban.health.core.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.ankangban.health.ui.MainActivity

import com.ankangban.health.core.alarm.NotificationHelper
import com.ankangban.health.core.service.VoiceReminderService

class AlarmReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val medicationName = intent.getStringExtra("medication_name") ?: "药品"
        val dosage = intent.getStringExtra("dosage") ?: ""
        val medicationId = intent.getLongExtra("medication_id", 0L)
        
        // 1. Show Notification
        NotificationHelper.createNotificationChannel(context)
        NotificationHelper.showMedicationNotification(context, medicationName, dosage, medicationId)
        
        // 2. Start Voice Reminder Service
        val serviceIntent = Intent(context, VoiceReminderService::class.java).apply {
            putExtra("medication_name", medicationName)
            putExtra("dosage", dosage)
        }
        context.startService(serviceIntent)
    }
}
