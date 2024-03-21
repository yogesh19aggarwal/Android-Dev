package com.example.webview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val webViewV = findViewById<WebView>(R.id.webView)
        webViewSetUp(webViewV)


    }

    private fun webViewSetUp(webViewV: WebView){

        webViewV.webViewClient = WebViewClient()

        webViewV.apply {
            settings.javaScriptEnabled = true
            settings.safeBrowsingEnabled = true
            loadUrl("https://www.youtube.com/")
        }
    }
}