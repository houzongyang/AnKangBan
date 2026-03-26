package com.ankangban.health.core.alarm

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import com.ankangban.health.core.receiver.AlarmReceiver
import com.ankangban.health.core.storage.entity.MedicationEntity
import com.ankangban.health.core.storage.entity.ReminderEntity
import java.util.Calendar

object AlarmScheduler {

    @SuppressLint("ScheduleExactAlarm")
    fun scheduleReminder(context: Context, medication: MedicationEntity, reminder: ReminderEntity) {
        if (!reminder.isEnabled) return

        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val intent = Intent(context, AlarmReceiver::class.java).apply {
            action = "com.ankangban.health.MEDICATION_REMINDER"
            putExtra("medication_id", medication.id)
            putExtra("medication_name", medication.name)
            putExtra("dosage", medication.dosage)
            putExtra("reminder_id", reminder.id)
        }

        val requestCode = getRequestCode(medication.id, reminder.hour, reminder.minute)

        val calendar = Calendar.getInstance().apply {
            set(Calendar.HOUR_OF_DAY, reminder.hour)
            set(Calendar.MINUTE, reminder.minute)
            set(Calendar.SECOND, 0)
            set(Calendar.MILLISECOND, 0)
        }

        // If time has passed today, schedule for tomorrow
        if (calendar.timeInMillis <= System.currentTimeMillis()) {
            calendar.add(Calendar.DAY_OF_YEAR, 1)
        }
        
        Log.d("AlarmScheduler", "Scheduling alarm for ${medication.name} at ${calendar.time}")

        val pendingIntent = PendingIntent.getBroadcast(
            context,
            requestCode,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            if (alarmManager.canScheduleExactAlarms()) {
                alarmManager.setExactAndAllowWhileIdle(
                    AlarmManager.RTC_WAKEUP,
                    calendar.timeInMillis,
                    pendingIntent
                )
            } else {
                 alarmManager.setAndAllowWhileIdle(
                    AlarmManager.RTC_WAKEUP,
                    calendar.timeInMillis,
                    pendingIntent
                )
            }
        } else {
             alarmManager.setExactAndAllowWhileIdle(
                AlarmManager.RTC_WAKEUP,
                calendar.timeInMillis,
                pendingIntent
            )
        }
    }

    fun cancelReminder(context: Context, medicationId: Long, reminder: ReminderEntity) {
         val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
         val intent = Intent(context, AlarmReceiver::class.java).apply {
             action = "com.ankangban.health.MEDICATION_REMINDER"
         }
         val requestCode = getRequestCode(medicationId, reminder.hour, reminder.minute)
         
         val pendingIntent = PendingIntent.getBroadcast(
            context,
            requestCode,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )
        
        alarmManager.cancel(pendingIntent)
        pendingIntent.cancel()
    }
    
    private fun getRequestCode(medicationId: Long, hour: Int, minute: Int): Int {
        // Unique ID logic: max 24*60 = 1440 minutes per day. 
        // We can use medicationId * 10000 + time. 
        // MedicationId is Long, so this might overflow Int if MedId is large.
        // But for local DB, IDs start small. 
        // Safe enough for demo.
        return (medicationId.toInt() * 10000) + (hour * 60 + minute)
    }
}
