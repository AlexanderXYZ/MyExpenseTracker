package com.buslaev.myexpensetracker.presentation.root

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.CoroutineScope

@Composable
fun rememberApplicationState(
    navController: NavHostController = rememberNavController(),
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    context: Context
) = remember(navController, coroutineScope, context) {
    ApplicationState(navController, coroutineScope, context)
}

class ApplicationState(
    val navController: NavHostController,
    val coroutineScope: CoroutineScope,
    val context: Context
) {

}