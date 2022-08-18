package com.buslaev.myexpensetracker.presentation.root

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.buslaev.myexpensetracker.presentation.main.MainScreen
import com.buslaev.myexpensetracker.presentation.transaction.TransactionScreen

sealed class Screens(val route: String) {
    object MainScreen : Screens("main_screen")
    object SettingsScreen : Screens("settings_screen")
    object StatisticScreen : Screens("statistic_screen")
    object TransactionScreen : Screens("transaction_screen")
}

@Composable
fun NavHostApplication(
    applicationState: ApplicationState,
) {
    NavHost(
        navController = applicationState.navController,
        startDestination = Screens.MainScreen.route
    ) {
        composable(Screens.MainScreen.route) {
            MainScreen(navController = applicationState.navController)
        }
        composable(Screens.StatisticScreen.route) {

        }
        composable(Screens.TransactionScreen.route) {
            TransactionScreen(navController = applicationState.navController)
        }
    }
}