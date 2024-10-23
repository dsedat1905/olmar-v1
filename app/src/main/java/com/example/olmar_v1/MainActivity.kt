package com.example.olmar_v1

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import com.example.olmar_v1.ui.theme.Olmarv1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Olmarv1Theme {
                // WebView bileşenini oluştur
                WebViewScreen()
            }
        }
    }
}

@Composable
fun WebViewScreen(modifier: Modifier = Modifier) {
    val context = LocalContext.current

    AndroidView(
        factory = {
            WebView(context).apply {
                settings.javaScriptEnabled = true // JavaScript'i etkinleştir
                webViewClient = WebViewClient() // Linklerin WebView içinde açılmasını sağlar
                loadUrl("https://olmargida.com.tr") // Web adresini burada belirtiyoruz
            }
        },
        modifier = modifier.fillMaxSize()
    )
}
