package com.buslaev.myexpensetracker.presentation.root

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.buslaev.myexpensetracker.presentation.main.MainScreen

@Composable
fun RootApplication() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screens.MainScreen.route) {
        composable(Screens.MainScreen.route) {
            MainScreen(navController = navController)
        }
        composable(Screens.StatisticScreen.route) {

        }
        composable(Screens.TransactionScreen.route) {

        }
    }
}