package com.dkproject.compose_codelab.Chapter3.Woof

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import com.dkproject.compose_codelab.ui.theme.Compose_CodeLabTheme

class WoofActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Compose_CodeLabTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                        .statusBarsPadding()
                ) {
                    WoofApp()
                }
            }
        }
    }
}