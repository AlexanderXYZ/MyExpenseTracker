package com.buslaev.myexpensetracker.presentation.main.components

import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*

@Composable
fun TrackerFloatingActionButton(
    onClick: () -> Unit
) {
    FloatingActionButton(onClick = {
        onClick.invoke()
    }) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = "navigate to transaction screen"
        )
    }
}