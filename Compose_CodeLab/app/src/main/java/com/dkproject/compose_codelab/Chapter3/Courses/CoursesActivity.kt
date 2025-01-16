package com.dkproject.compose_codelab.Chapter3.Courses

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.dkproject.compose_codelab.ui.theme.Compose_CodeLabTheme

class CoursesActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Compose_CodeLabTheme {
                CoursesApp()
            }
        }
    }
}