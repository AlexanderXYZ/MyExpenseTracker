package com.buslaev.myexpensetracker.presentation.main.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.buslaev.myexpensetracker.R

@Composable
fun TrackerTopAppBar() {
    Row(horizontalArrangement = Arrangement.SpaceBetween) {
        PersonTitle()
    }
}

@Composable
fun PersonTitle() {
    Row() {
        Icon(imageVector = Icons.Default.Edit, contentDescription = null)
        Spacer(modifier = Modifier.width(4.dp))
        Column(verticalArrangement = Arrangement.SpaceBetween) {
            Text(text = stringResource(id = R.string.default_welcome))
            Text(text = "John Doe", fontWeight = FontWeight.Bold)
        }
    }
}