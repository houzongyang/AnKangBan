package com.ankangban.health.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ankangban.health.R

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        try {
            // 临时测试：直接使用简单的 TextView，排除布局文件问题
            val tv = android.widget.TextView(this)
            tv.text = "正在启动安康伴..."
            tv.gravity = android.view.Gravity.CENTER
            tv.textSize = 24f
            setContentView(tv)

            // 延时跳转
            tv.postDelayed({
                try {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                } catch (e: Exception) {
                    tv.text = "启动主页失败:\n${e.message}"
                    android.util.Log.e("Splash", "Error", e)
                }
            }, 1000L)
            
        } catch (e: Exception) {
            e.printStackTrace()
            // 尝试显示错误
            try {
                val tv = android.widget.TextView(this)
                tv.text = "启动错误:\n${e.message}"
                setContentView(tv)
            } catch (ignored: Exception) {}
        }
    }
}
