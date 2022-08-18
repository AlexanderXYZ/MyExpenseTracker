package com.buslaev.myexpensetracker.presentation.root

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.buslaev.myexpensetracker.presentation.theme.MyExpenseTrackerTheme

@Composable
fun RootApplication() {
    val context = LocalContext.current
    val applicationState = rememberApplicationState(context = context)

    MyExpenseTrackerTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            NavHostApplication(applicationState = applicationState)
        }
    }
}