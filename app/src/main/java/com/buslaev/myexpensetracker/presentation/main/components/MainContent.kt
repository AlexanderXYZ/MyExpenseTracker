package com.buslaev.myexpensetracker.presentation.main.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.buslaev.myexpensetracker.R
import com.buslaev.myexpensetracker.data.entities.TransactionAndCategory
import com.buslaev.myexpensetracker.presentation.component.CanvasMainTableArrow
import com.buslaev.myexpensetracker.presentation.component.DefaultText
import com.buslaev.myexpensetracker.presentation.theme.ButtonHintColor
import com.buslaev.myexpensetracker.presentation.theme.mainGradient

@Composable
fun MainContent(
    list: List<TransactionAndCategory>
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        MainTable(modifier = Modifier.fillMaxWidth())

        Spacer(modifier = Modifier.height(16.dp))

        MainTransactions(modifier = Modifier.fillMaxWidth(), list = list)
    }
}

@Composable
private fun MainTable(
    modifier: Modifier = Modifier
) {
    var size by remember {
        mutableStateOf(IntSize(0, 0))
    }
    Column(
        modifier = modifier
            .onGloballyPositioned {
                size = it.size
            }
            .clip(RoundedCornerShape(16.dp))
            .background(
                brush = mainGradient(
                    Offset(
                        x = size.width.toFloat(),
                        y = size.height.toFloat()
                    )
                )
            )
            .padding(horizontal = 16.dp, vertical = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        DefaultText(
            text = stringResource(id = R.string.default_title_total_balance),
            fontSize = 18.sp
        )

        Spacer(modifier = Modifier.height(8.dp))

        DefaultText(text = "$ 4800.00", fontSize = 42.sp, fontWeight = FontWeight.SemiBold)

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            MainIndicator(
                title = stringResource(id = R.string.indicator_income),
                balance = 2500F,
                isIncome = true
            )
            MainIndicator(
                title = stringResource(id = R.string.indicator_expenses),
                balance = 800F,
                isIncome = false
            )
        }
    }
}

@Composable
private fun MainIndicator(
    title: String,
    balance: Float,
    isIncome: Boolean
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        CanvasMainTableArrow(modifier = Modifier.size(32.dp), isUpperArrow = isIncome)

        Spacer(modifier = Modifier.width(4.dp))

        Column {
            DefaultText(text = title, fontSize = 12.sp)
            DefaultText(text = balance.toString(), fontSize = 12.sp)
        }
    }
}

@Composable
private fun MainTransactions(
    modifier: Modifier = Modifier,
    list: List<TransactionAndCategory>
) {
    Column(modifier = modifier) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            DefaultText(
                text = stringResource(id = R.string.default_transactions_title),
                fontSize = 16.sp,
                color = Color.Black,
                fontWeight = FontWeight.SemiBold
            )
            DefaultText(
                modifier = Modifier
                    .clickable { },
                text = stringResource(id = R.string.default_view_all),
                fontSize = 16.sp,
                color = Color.Black
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 36.dp)
        ) {
            items(list) {
                TransactionItem(item = it)
            }
        }
    }
}

@Composable
fun TransactionItem(
    item: TransactionAndCategory
) {
    Row(
        modifier = Modifier
            .padding(vertical = 8.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(Color.White)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier
                .size(48.dp)
                .clip(RoundedCornerShape(32.dp))
                .background(Color.Cyan),
            imageVector = Icons.Default.Add,
            contentDescription = null,
            tint = Color.White
        )

        Spacer(modifier = Modifier.width(8.dp))

        DefaultText(
            modifier = Modifier.weight(1F),
            text = item.category.title,
            fontSize = 18.sp,
            color = Color.Black,
            fontWeight = FontWeight.Medium
        )

        Spacer(modifier = Modifier.width(8.dp))

        Column(
            horizontalAlignment = Alignment.End
        ) {
            DefaultText(
                text = item.transaction.value.toString(),
                fontSize = 14.sp,
                color = Color.Black
            )
            DefaultText(
                text = item.transaction.date.toString(),
                fontSize = 14.sp,
                color = ButtonHintColor
            )
        }
    }
}