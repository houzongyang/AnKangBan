package com.ankangban.health

import android.app.Application
import android.content.Intent
import android.os.Process
import android.util.Log
import com.ankangban.health.ui.CrashActivity

class HealthApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        
        val defaultHandler = Thread.getDefaultUncaughtExceptionHandler()
        
        Thread.setDefaultUncaughtExceptionHandler { thread, throwable ->
            try {
                Log.e("HealthCrash", "Uncaught exception", throwable)
                val stackTrace = Log.getStackTraceString(throwable)
                
                val intent = Intent(this, CrashActivity::class.java).apply {
                    putExtra("error", stackTrace)
                    flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                }
                startActivity(intent)
                
                Process.killProcess(Process.myPid())
                System.exit(1)
            } catch (e: Exception) {
                e.printStackTrace()
                defaultHandler?.uncaughtException(thread, throwable)
            }
        }
    }
}