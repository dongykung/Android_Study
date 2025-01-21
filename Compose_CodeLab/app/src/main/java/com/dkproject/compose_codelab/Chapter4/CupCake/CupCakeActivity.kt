package com.dkproject.compose_codelab.Chapter4.CupCake

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.dkproject.compose_codelab.Chapter4.CupCake.ui.CupcakeApp
import com.dkproject.compose_codelab.ui.theme.Compose_CodeLabTheme

class CupCakeActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Compose_CodeLabTheme {
                CupcakeApp()
            }
        }
    }
}