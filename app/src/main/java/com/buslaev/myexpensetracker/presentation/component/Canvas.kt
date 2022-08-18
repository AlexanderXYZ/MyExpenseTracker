package com.buslaev.myexpensetracker.presentation.component

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.buslaev.myexpensetracker.presentation.theme.BackgroundArrowColor
import com.buslaev.myexpensetracker.presentation.theme.BackgroundColor
import com.buslaev.myexpensetracker.presentation.theme.ButtonHintColor
import com.buslaev.myexpensetracker.presentation.theme.mainGradient

@Composable
fun CanvasWhiteCross(
    modifier: Modifier = Modifier,
    radiusCircle: Float
) {
    Canvas(modifier = modifier) {
        val halfHeight = this.size.height / 2
        val halfWidth = this.size.width / 2

        drawCircle(
            brush = mainGradient(endPosition = Offset(x = this.size.width, y = this.size.height)),
            radius = radiusCircle
        )
        drawLine(
            start = Offset(x = halfWidth - 25, y = halfHeight),
            end = Offset(x = halfWidth + 25, y = halfHeight),
            strokeWidth = 8F,
            color = Color.White,
            cap = StrokeCap.Round
        )
        drawLine(
            start = Offset(x = halfWidth, y = halfHeight - 25),
            end = Offset(x = halfWidth, y = halfHeight + 25),
            strokeWidth = 8F,
            color = Color.White,
            cap = StrokeCap.Round
        )
    }
}

@Composable
fun CanvasMainTableArrow(
    modifier: Modifier = Modifier,
    isUpperArrow: Boolean
) {
    Canvas(modifier = modifier) {
        val halfHeight = this.size.height / 2
        val halfWidth = this.size.width / 2
        val startDrawLineY = if (isUpperArrow) -15 else 15
        val endDrawLineY = if (isUpperArrow) -5 else 5
        val color = if (isUpperArrow) Color.Green else Color.Red

        drawCircle(
            color = BackgroundArrowColor,
            radius = 32F
        )

        drawLine(
            color = color,
            start = Offset(x = halfWidth, y = halfHeight - 15),
            end = Offset(x = halfWidth, y = halfHeight + 15),
            strokeWidth = 3F,
            cap = StrokeCap.Round
        )
        drawLine(
            color = color,
            start = Offset(x = halfWidth, y = halfHeight + startDrawLineY),
            end = Offset(x = halfWidth - 8, y = halfHeight + endDrawLineY),
            strokeWidth = 3F,
            cap = StrokeCap.Round
        )
        drawLine(
            color = color,
            start = Offset(x = halfWidth, y = halfHeight + startDrawLineY),
            end = Offset(x = halfWidth + 8, y = halfHeight + endDrawLineY),
            strokeWidth = 3F,
            cap = StrokeCap.Round
        )
    }
}

@Composable
fun CanvasButtonAllTransactions(
    modifier: Modifier = Modifier
) {
    Canvas(modifier = modifier) {
        val halfHeight = this.size.height / 2
        val halfWidth = this.size.width / 2

        drawCircle(
            color = ButtonHintColor,
            center = Offset(x = halfWidth - 12, y = halfHeight - 12),
            radius = 8F
        )
        drawCircle(
            color = ButtonHintColor,
            center = Offset(x = halfWidth + 12, y = halfHeight - 12),
            radius = 8F
        )
        drawCircle(
            color = ButtonHintColor,
            center = Offset(x = halfWidth + 12, y = halfHeight + 12),
            radius = 8F
        )
        drawCircle(
            color = ButtonHintColor,
            center = Offset(x = halfWidth - 12, y = halfHeight + 12),
            radius = 8F
        )
    }
}

@Composable
fun CanvasButtonStatistic(
    modifier: Modifier = Modifier
) {
    Canvas(modifier = modifier) {
        val halfHeight = this.size.height / 2
        val halfWidth = this.size.width / 2

        drawCircle(
            color = ButtonHintColor,
            radius = 32F
        )

        drawLine(
            color = Color.White,
            start = Offset(x = halfWidth - 8, y = halfHeight - 8),
            end = Offset(x = halfWidth - 8, y = halfHeight + 6),
            strokeWidth = 3F,
            cap = StrokeCap.Round
        )
        drawLine(
            color = Color.White,
            start = Offset(x = halfWidth, y = halfHeight - 12),
            end = Offset(x = halfWidth, y = halfHeight + 2),
            strokeWidth = 3F,
            cap = StrokeCap.Round
        )
        drawLine(
            color = Color.White,
            start = Offset(x = halfWidth + 8, y = halfHeight - 4),
            end = Offset(x = halfWidth + 8, y = halfHeight + 4),
            strokeWidth = 3F,
            cap = StrokeCap.Round
        )
    }
}

@Preview(name = "Button all transaction")
@Composable
private fun CanvasButtonAllTransactionsPrev() {
    CanvasButtonAllTransactions(modifier = Modifier.size(32.dp))
}

@Preview(name = "Button statistic")
@Composable
private fun CanvasButtonStatisticPrev() {
    CanvasButtonStatistic(modifier = Modifier.size(32.dp))
}

@Preview(name = "Upper arrow")
@Composable
private fun CanvasMainTableUpperArrowPrev() {
    CanvasMainTableArrow(modifier = Modifier.size(32.dp), isUpperArrow = true)
}

@Preview(name = "Down arrow")
@Composable
private fun CanvasMainTableDownArrowPrev() {
    CanvasMainTableArrow(modifier = Modifier.size(32.dp), isUpperArrow = false)
}