package com.dkproject.compose_codelab.Chapter3.Hero

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import com.dkproject.compose_codelab.ui.theme.Compose_CodeLabTheme

class HeroActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Compose_CodeLabTheme {
                val heroList = HerosRepository.heros
                Scaffold(
                    topBar = {
                        CenterAlignedTopAppBar(
                            title = {
                                Text(
                                    "Superheroes",
                                    style = MaterialTheme.typography.displayLarge
                                )
                            }
                        )
                    }
                ) { it ->
                    HeroScreen(
                        modifier = Modifier.fillMaxSize(),
                        contentPadding = it,
                        heroList = heroList
                    )
                }
            }
        }
    }
}