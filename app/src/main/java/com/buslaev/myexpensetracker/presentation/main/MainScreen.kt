package com.buslaev.myexpensetracker.presentation.main

import android.annotation.SuppressLint
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.navigation.NavController
import com.buslaev.myexpensetracker.presentation.main.components.MainContent
import com.buslaev.myexpensetracker.presentation.main.components.TrackerBottomAppBar
import com.buslaev.myexpensetracker.presentation.main.components.TrackerFloatingActionButton
import com.buslaev.myexpensetracker.presentation.main.components.TrackerTopAppBar
import com.buslaev.myexpensetracker.presentation.root.Screens

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen(
    navController: NavController
) {
    Scaffold(
        topBar = {
            TopAppBar {
                TrackerTopAppBar()
            }
        },
        floatingActionButton = {
            TrackerFloatingActionButton(
                onClick = {
                    navController.navigate(Screens.TransactionScreen.route)
                }
            )
        },
        floatingActionButtonPosition = FabPosition.Center,
        bottomBar = {
            BottomAppBar {
                TrackerBottomAppBar()
            }
        }
    ) {
        MainContent()
    }
}