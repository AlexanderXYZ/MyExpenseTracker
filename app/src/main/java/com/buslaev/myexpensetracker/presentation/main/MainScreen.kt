package com.buslaev.myexpensetracker.presentation.main

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.buslaev.myexpensetracker.presentation.main.components.MainContent
import com.buslaev.myexpensetracker.presentation.main.components.TrackerBottomAppBar
import com.buslaev.myexpensetracker.presentation.main.components.TrackerFloatingActionButton
import com.buslaev.myexpensetracker.presentation.main.components.MainTopAppBar
import com.buslaev.myexpensetracker.presentation.root.Screens

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen(
    navController: NavController,
    viewModel: MainViewModel = hiltViewModel()
) {
    val state = viewModel.state

    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.padding(horizontal = 16.dp),
                backgroundColor = MaterialTheme.colors.background,
                elevation = 0.dp
            ) {
                MainTopAppBar(modifier = Modifier.fillMaxWidth(), navController = navController)
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
        isFloatingActionButtonDocked = true,
        bottomBar = {
            BottomAppBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(topStart = 36.dp, topEnd = 36.dp)),
                backgroundColor = Color.White
            ) {
                TrackerBottomAppBar(navController = navController)
            }
        }
    ) {
        MainContent(list = state.list)
    }
}