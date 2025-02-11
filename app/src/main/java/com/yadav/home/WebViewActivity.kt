package com.yadav.home

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.ComponentActivity

class WebViewActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val webView = WebView(this)
        webView.settings.javaScriptEnabled = true // Enable JavaScript if needed
        webView.webViewClient = WebViewClient()

        val url = intent.getStringExtra("URL") ?: "https://cropai-bb7m.onrender.com"
        webView.loadUrl(url)

        setContentView(webView)
    }
}
