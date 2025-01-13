package com.dkproject.compose_codelab.Chapter2.DiceRoller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.dkproject.compose_codelab.ui.theme.Compose_CodeLabTheme

class DiceRollerActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Compose_CodeLabTheme {
                DiceRollerApp()
            }
        }
    }
}