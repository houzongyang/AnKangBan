package com.ankangban.health.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.ankangban.health.R
import com.ankangban.health.core.permissions.HealthPermissions
import com.ankangban.health.databinding.ActivityMainBinding

import android.speech.tts.TextToSpeech
import android.content.Intent
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var tts: TextToSpeech? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Init TTS
        tts = TextToSpeech(this) { status ->
            if (status == TextToSpeech.SUCCESS) {
                tts?.setLanguage(Locale.CHINESE)
            }
        }

        try {
            HealthPermissions.ensure(this)
        } catch (e: Exception) {
            e.printStackTrace()
        }

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as? NavHostFragment
        
        if (navHostFragment != null) {
            val navController = navHostFragment.navController
            binding.bottomNavigation.setupWithNavController(navController)
            
            // Handle Hide Button click
            binding.btnHideNav.setOnClickListener {
                setBottomNavVisibility(false)
            }

            navController.addOnDestinationChangedListener { _, destination, _ ->
                if (destination.id == R.id.loginFragment) {
                    binding.bottomContainer.visibility = View.GONE
                } else {
                    binding.bottomContainer.visibility = View.VISIBLE
                    binding.bottomContainer.translationY = 0f
                }
            }
            
            if (intent.getBooleanExtra("require_login", false)) {
                navController.navigate(R.id.loginFragment)
            }
        }
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        setIntent(intent)
        handleReminderIntent(intent)
    }

    private fun handleReminderIntent(intent: Intent?) {
        if (intent?.getBooleanExtra("show_medication_reminder", false) == true) {
            val name = intent.getStringExtra("medication_name") ?: ""
            val dosage = intent.getStringExtra("dosage") ?: ""
            
            showReminderDialog(name, dosage)
            
            // Clear the extra so it doesn't trigger again on rotation if we rely on intent
            intent.removeExtra("show_medication_reminder")
        }
    }

    private fun showReminderDialog(name: String, dosage: String) {
        val text = "用药提醒：该吃${name}了，用量：${dosage}"
        
        // Speak
        tts?.speak(text, TextToSpeech.QUEUE_FLUSH, null, "reminder")
        
        // Show Dialog
        MaterialAlertDialogBuilder(this)
            .setTitle("⏰ 用药提醒")
            .setMessage("现在是服药时间\n\n药品：$name\n用量：$dosage")
            .setPositiveButton("我知道了") { dialog, _ ->
                tts?.stop()
                dialog.dismiss()
            }
            .setCancelable(false)
            .show()
    }
    
    override fun onDestroy() {
        tts?.stop()
        tts?.shutdown()
        super.onDestroy()
    }

    fun setBottomNavVisibility(visible: Boolean) {
        val navContainer = binding.bottomContainer
        navContainer.animate().cancel()
        
        if (visible) {
            if (navContainer.visibility != View.VISIBLE) {
                navContainer.visibility = View.VISIBLE
                navContainer.translationY = navContainer.height.toFloat().takeIf { it > 0 } ?: 200f // Fallback offset
            }
            navContainer.animate()
                .translationY(0f)
                .setDuration(200)
                .start()
        } else {
            if (navContainer.visibility == View.VISIBLE) {
                val height = navContainer.height.toFloat().takeIf { it > 0 } ?: 200f
                navContainer.animate()
                    .translationY(height)
                    .setDuration(200)
                    .withEndAction { 
                        if (navContainer.translationY == height) { // Double check
                             // Keep visibility VISIBLE but translated off-screen to maintain height for next show
                        }
                    }
                    .start()
            }
        }
    }
}
