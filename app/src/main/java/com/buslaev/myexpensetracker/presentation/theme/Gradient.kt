package com.buslaev.myexpensetracker.presentation.theme

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush

fun mainGradient(endPosition: Offset) = Brush.linearGradient(
    colors = listOf(
        GradientFirstColor,
        GradientSecondColor,
        GradientThirdColor
    ),
    start = Offset(0F, 0F),
    end = endPosition
)

val TextGradient = Brush.verticalGradient(
    colors = listOf(
        GradientFirstColor,
        GradientSecondColor,
        GradientThirdColor
    )
)