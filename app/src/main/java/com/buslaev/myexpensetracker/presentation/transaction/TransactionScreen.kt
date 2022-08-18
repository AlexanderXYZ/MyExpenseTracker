package com.buslaev.myexpensetracker.presentation.transaction

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Icon
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.buslaev.myexpensetracker.R
import com.buslaev.myexpensetracker.presentation.component.DefaultText
import com.buslaev.myexpensetracker.presentation.theme.GrayTextColor
import com.buslaev.myexpensetracker.presentation.theme.TextGradient
import com.buslaev.myexpensetracker.presentation.theme.mainGradient

@Composable
fun TransactionScreen(
    navController: NavController,
    viewModel: TransactionViewModel = hiltViewModel()
) {
    val state = viewModel.state
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        TransactionTopBar(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
        TransactionMainContent(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .weight(1F)
        )
        TransactionButtonSave(
            onClick = {}
        )
    }
}

@Composable
fun TransactionTopBar(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
    ) {
        Icon(
            modifier = Modifier.align(Alignment.CenterEnd),
            imageVector = Icons.Default.Close,
            contentDescription = null
        )
    }
}

@OptIn(ExperimentalTextApi::class)
@Composable
fun TransactionMainContent(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        var value by remember { mutableStateOf("") }
        var categoryId by remember { mutableStateOf("") }
        var noteText by remember { mutableStateOf("") }
        var date by remember { mutableStateOf("") }

        DefaultText(text = stringResource(id = R.string.transaction_title), fontSize = 18.sp)

        Spacer(modifier = Modifier.height(16.dp))

        BasicTextField(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(32.dp))
                .background(Color.White)
                .padding(16.dp),
            value = value,
            visualTransformation = {
                TransformedText(
                    AnnotatedString("\$ ${it.text}"),
                    offsetMapping = object : OffsetMapping {
                        override fun originalToTransformed(offset: Int): Int {
                            return offset + 2
                        }

                        override fun transformedToOriginal(offset: Int): Int {
                            return offset
                        }
                    }
                )
            },
            onValueChange = { value = it },
            maxLines = 1,
            textStyle = LocalTextStyle.current.copy(
                textAlign = TextAlign.Center,
                fontSize = 32.sp,
                brush = TextGradient
            ),
            cursorBrush = TextGradient
        )

        Spacer(modifier = Modifier.height(16.dp))

        BasicTextField(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp))
                .background(Color.White)
                .padding(16.dp),
            value = noteText,
            onValueChange = { noteText = it },
            textStyle = LocalTextStyle.current.copy(
                textAlign = TextAlign.Center,
                fontSize = 32.sp,
                color = GrayTextColor
            )
        )

    }
}

@Composable
fun TransactionButtonSave(
    onClick: () -> Unit
) {
    var size by remember {
        mutableStateOf(IntSize(0, 0))
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(84.dp)
            .padding(16.dp)
            .clip(RoundedCornerShape(12.dp))
            .onGloballyPositioned {
                size = it.size
            }
            .background(
                brush = mainGradient(
                    Offset(
                        x = size.width.toFloat(),
                        y = size.height.toFloat()
                    )
                )
            )
            .clickable { onClick.invoke() },
    ) {
        DefaultText(
            modifier = Modifier.align(Alignment.Center),
            text = stringResource(id = R.string.transaction_save_button_title),
            fontSize = 18.sp
        )
    }
}