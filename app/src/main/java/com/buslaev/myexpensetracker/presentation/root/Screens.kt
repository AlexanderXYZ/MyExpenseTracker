package com.buslaev.myexpensetracker.presentation.root

sealed class Screens(val route: String) {
    object MainScreen : Screens("main_screen")
    object StatisticScreen : Screens("statistic_screen")
    object TransactionScreen : Screens("transaction_screen")
}
