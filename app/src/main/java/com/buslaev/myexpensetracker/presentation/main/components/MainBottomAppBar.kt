package com.buslaev.myexpensetracker.presentation.main.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.buslaev.myexpensetracker.presentation.component.CanvasButtonAllTransactions
import com.buslaev.myexpensetracker.presentation.component.CanvasButtonStatistic

@Composable
fun TrackerBottomAppBar(
    navController: NavController
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        CanvasButtonAllTransactions(
            modifier = Modifier
                .size(32.dp)
                .clickable { }
        )
        CanvasButtonStatistic(
            modifier = Modifier
                .size(32.dp)
                .clickable { }
        )
    }
}