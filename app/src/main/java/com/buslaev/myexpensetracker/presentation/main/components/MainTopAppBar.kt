package com.buslaev.myexpensetracker.presentation.main.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.buslaev.myexpensetracker.R
import com.buslaev.myexpensetracker.presentation.component.DefaultText
import com.buslaev.myexpensetracker.presentation.component.SettingButton
import com.buslaev.myexpensetracker.presentation.root.Screens
import com.buslaev.myexpensetracker.presentation.theme.BackgroundArrowColor
import com.buslaev.myexpensetracker.presentation.theme.ButtonHintColor

@Composable
fun MainTopAppBar(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        PersonTitle()
        SettingButton(onClick = { navController.navigate(Screens.SettingsScreen.route) })
    }
}

@Composable
fun PersonTitle() {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier.size(16.dp),
            imageVector = Icons.Default.Edit,
            contentDescription = null,
            tint = ButtonHintColor
        )

        Spacer(modifier = Modifier.width(8.dp))

        Column(verticalArrangement = Arrangement.SpaceBetween) {
            DefaultText(
                text = stringResource(id = R.string.default_welcome),
                fontSize = 14.sp,
                color = ButtonHintColor
            )
            DefaultText(
                text = "John Doe",
                fontSize = 16.sp,
                color = Color.Black,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}