package com.dkproject.component.Button

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.dkproject.component.ui.theme.ComponentTheme

@Composable
fun ButtonExample() {
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick =  {}) {
            Text("Filled")
        }

        OutlinedButton(onClick = {}) {
            Text("Outlined")
        }

        ElevatedButton(onClick = {}) {
            Text("Elevated")
        }

        TextButton(onClick = {}) {
            Text("Text Button")
        }
    }
}

@Composable
@Preview(showBackground = true)
private fun ButtonExamplePreview() {
    ComponentTheme {
        ButtonExample()
    }
}