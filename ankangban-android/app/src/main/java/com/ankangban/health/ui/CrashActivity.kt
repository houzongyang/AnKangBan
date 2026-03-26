package com.ankangban.health.ui

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.system.exitProcess

class CrashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        val error = intent.getStringExtra("error") ?: "未知错误"
        
        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(32, 64, 32, 32)
        }
        
        val title = TextView(this).apply {
            text = "应用发生崩溃"
            textSize = 24f
            setTypeface(null, android.graphics.Typeface.BOLD)
            setPadding(0, 0, 0, 32)
        }
        layout.addView(title)

        val btnCopy = Button(this).apply {
            text = "复制错误信息"
            setOnClickListener {
                val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                val clip = ClipData.newPlainText("Crash Log", error)
                clipboard.setPrimaryClip(clip)
                Toast.makeText(this@CrashActivity, "已复制到剪贴板", Toast.LENGTH_SHORT).show()
            }
        }
        layout.addView(btnCopy)

        val btnRestart = Button(this).apply {
            text = "重启应用"
            setOnClickListener {
                val i = baseContext.packageManager.getLaunchIntentForPackage(baseContext.packageName)
                i?.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(i)
                finish()
                exitProcess(0)
            }
        }
        layout.addView(btnRestart)
        
        val scrollView = ScrollView(this)
        val message = TextView(this).apply {
            text = error
            textSize = 12f
            setPadding(0, 16, 0, 0)
        }
        scrollView.addView(message)
        layout.addView(scrollView)
        
        setContentView(layout)
    }
}