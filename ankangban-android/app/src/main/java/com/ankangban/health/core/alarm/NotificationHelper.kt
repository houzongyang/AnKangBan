package com.ankangban.health.core.alarm

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import com.ankangban.health.ui.MainActivity
import com.ankangban.health.R

object NotificationHelper {

    const val CHANNEL_ID = "medication_channel"
    private const val CHANNEL_NAME = "用药提醒"

    fun createNotificationChannel(context: Context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val importance = NotificationManager.IMPORTANCE_HIGH
            val channel = NotificationChannel(CHANNEL_ID, CHANNEL_NAME, importance).apply {
                description = "用于发送用药提醒通知"
                enableVibration(true)
            }
            val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    fun showMedicationNotification(context: Context, medicationName: String, dosage: String, medicationId: Long) {
        val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        val intent = Intent(context, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            putExtra("medication_id", medicationId)
            putExtra("medication_name", medicationName)
            putExtra("dosage", dosage)
            putExtra("show_medication_reminder", true)
        }
        
        val pendingIntent = PendingIntent.getActivity(
            context, 
            medicationId.toInt(), 
            intent, 
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        val builder = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_medication_24)
            .setContentTitle("用药提醒：$medicationName")
            .setContentText("该吃药了：$dosage")
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setCategory(NotificationCompat.CATEGORY_ALARM)
            .setAutoCancel(true)
            .setContentIntent(pendingIntent)
            .setVibrate(longArrayOf(0, 500, 200, 500))

        notificationManager.notify(medicationId.toInt(), builder.build())
    }
}
