package com.buslaev.myexpensetracker.presentation.main.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.buslaev.myexpensetracker.R


@Composable
fun MainContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        MainTable()

        Row(
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = stringResource(id = R.string.default_transactions_title))
            Text(text = stringResource(id = R.string.default_view_all))
        }
    }
}

@Composable
private fun MainTable() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Total Balance")

        Spacer(modifier = Modifier.height(8.dp))

        Text(text = "$ 4800.00")

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            MainIndicator(
                title = stringResource(id = R.string.indicator_income),
                balance = 2.500F,
                icon = Icons.Default.KeyboardArrowDown
            )
            MainIndicator(
                title = stringResource(id = R.string.indicator_expenses),
                balance = 800F,
                icon = Icons.Default.KeyboardArrowUp
            )
        }
    }
}

@Composable
private fun MainIndicator(
    title: String,
    balance: Float,
    icon: ImageVector
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(imageVector = icon, contentDescription = null)
        Column() {
            Text(text = title)
            Text(text = balance.toString())
        }
    }
}

@Composable
private fun TransactionsLazyColumn() {

}

@Composable
fun TransactionItem(
    icon: ImageVector,
    title: String,
    balance: Float,
    date: String
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

    }
}