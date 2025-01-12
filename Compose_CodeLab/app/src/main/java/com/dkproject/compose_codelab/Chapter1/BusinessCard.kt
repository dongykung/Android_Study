package com.dkproject.compose_codelab.Chapter1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dkproject.compose_codelab.R
import com.dkproject.compose_codelab.ui.theme.Compose_CodeLabTheme

class BusinessCard: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Compose_CodeLabTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    BusinessCardScreen()
                }
            }
        }
    }
}

@Composable
fun BusinessCardScreen() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(R.drawable.android_logo), "",
            modifier = Modifier.size(120.dp))
        Text("Jennifer Doe", style = MaterialTheme.typography.headlineLarge)
        Spacer(modifier = Modifier.padding(bottom = 6.dp))
        Text("Android Developer Extraordinaire", textAlign = TextAlign.Center, color = Color(0xFF3ddc84))
    }

    Column(
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth().padding(bottom = 24.dp)
    ) {
        ContactRow(
            icon = Icons.Default.Call,
            content = "+11 (123) 444 555 666"
        )
        ContactRow(
            icon = Icons.Default.Share,
            content = "@AndroidDev"
        )
        ContactRow(
            icon = Icons.Default.Email,
            content = "jen.doe@android.com"
        )
    }
}

@Composable
fun ContactRow(icon: ImageVector, content: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start, // Row 내부 중앙 정렬
        modifier = Modifier.fillMaxWidth(0.5f)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color(0xFF4CAF50), // 아이콘 색상
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = content,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Composable
@Preview(showBackground = true)
private fun BusinessCardPreview() {
    Compose_CodeLabTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            BusinessCardScreen()
        }
    }
}