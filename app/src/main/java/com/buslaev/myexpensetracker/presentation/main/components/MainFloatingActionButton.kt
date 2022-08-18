package com.buslaev.myexpensetracker.presentation.main.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.buslaev.myexpensetracker.presentation.component.CanvasWhiteCross

@Composable
fun TrackerFloatingActionButton(
    onClick: () -> Unit
) {
    CanvasWhiteCross(
        modifier = Modifier
            .size(84.dp)
            .clickable { onClick.invoke() },
        radiusCircle = 84F
    )
}

@Preview
@Composable
private fun TrackerFloatingActionButtonPrev() {
    TrackerFloatingActionButton {

    }
}