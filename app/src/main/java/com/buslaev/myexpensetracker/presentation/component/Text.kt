package com.buslaev.myexpensetracker.presentation.component

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit

@Composable
fun DefaultText(
    modifier: Modifier = Modifier,
    text: String,
    fontSize: TextUnit,
    color: Color = Color.White,
    fontWeight: FontWeight? = null
) {
    Text(
        modifier = modifier,
        text = text,
        fontSize = fontSize,
        color = color,
        fontFamily = FontFamily.SansSerif,
        fontWeight = fontWeight
    )
}