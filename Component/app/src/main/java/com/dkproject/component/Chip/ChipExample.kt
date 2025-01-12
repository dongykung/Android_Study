package com.dkproject.component.Chip

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dkproject.component.ui.theme.ComponentTheme

@Composable
fun ChipExample() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        var selected by remember { mutableStateOf(false) }
        AssistChip(onClick = {}, label = { Text("Assist chip") },
            leadingIcon = {
                Icon(
                    Icons.Filled.Settings,
                    "",
                    modifier = Modifier.size(AssistChipDefaults.IconSize)
                )
            })

        FilterChip(selected = selected,
            onClick = { selected = !selected},
            label = {Text("Filter chip")},
            leadingIcon = {
                if (selected) {
                    Icon(Icons.Filled.Done, "")
                }
            })
    }
}

@Composable
@Preview(showBackground = true)
private fun ChipExamplePreview() {
    ComponentTheme {
        ChipExample()
    }
}