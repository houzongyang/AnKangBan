package com.ankangban.health.ui.view

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.webkit.JavascriptInterface
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.FrameLayout

class HealthChartView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private val webView: WebView
    private var isLoaded = false
    private var pendingOption: String? = null
    var onChartClickListener: ((String) -> Unit)? = null

    init {
        webView = WebView(context)
        addView(webView, LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT))
        setupWebView()
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun setupWebView() {
        webView.settings.apply {
            javaScriptEnabled = true
            domStorageEnabled = true
            loadWithOverviewMode = true
            useWideViewPort = true
            textZoom = 100
            // Enable transparent background
            mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
        }
        
        webView.setBackgroundColor(0) // Transparent
        
        webView.addJavascriptInterface(object {
            @JavascriptInterface
            fun onChartClick(json: String) {
                post { onChartClickListener?.invoke(json) }
            }
        }, "Android")

        webView.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                isLoaded = true
                pendingOption?.let {
                    setOption(it)
                    pendingOption = null
                }
            }
        }

        webView.loadUrl("file:///android_asset/chart_template.html")
    }

    fun setOption(jsonOption: String) {
        if (isLoaded) {
            // Remove newlines to ensure valid JS string literal
            // Also escape single quotes if any (though JSON usually uses double quotes)
            val sanitizedOption = jsonOption.replace("\n", " ").replace("\r", "")
            val script = "setOption('$sanitizedOption')"
            webView.evaluateJavascript(script, null)
        } else {
            pendingOption = jsonOption
        }
    }
}