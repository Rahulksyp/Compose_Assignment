package com.example.myapplication.ui.bottomNav

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.utils.AppUtils.showToast
import com.example.myapplication.R
import com.example.myapplication.ui.ItemData
import com.example.myapplication.ui.SetupCookUi
import com.example.myapplication.ui.theme.Blue_2B308B
import com.example.myapplication.ui.theme.Orange_E68939
import com.example.myapplication.ui.utils.SingleLineText

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SetupMainUi(context: Context, itemList: List<ItemData>) {
    var currentScreen by remember { mutableStateOf(Screen.Cook) }

    Scaffold(
        bottomBar = {
            GetBottomNavItem(context = context, currentScreen)
            { currentScreen == Screen.Cook }
        }
    ) {
        when (currentScreen) {

            Screen.Cook -> {
                SetupCookUi(context, itemList)
            }
            Screen.Favourites -> showToast(context, stringResource(R.string.work_in_progress))
            Screen.Manual -> showToast(context, stringResource(R.string.work_in_progress))
            Screen.Device -> showToast(context, stringResource(R.string.work_in_progress))
            Screen.Preferences -> showToast(context, stringResource(R.string.work_in_progress))
            Screen.Settings -> showToast(context, stringResource(R.string.work_in_progress))
        }
    }
}


@Composable
fun GetBottomNavItem(context: Context, currentScreen: Screen, onClick: () -> Unit) {
    BottomNavigation(
        backgroundColor = Color.White,
        contentColor = Blue_2B308B,
    ) {

        BottomNavigationItem(
            selected = currentScreen == Screen.Cook,
            onClick = { onClick() },
            icon = {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.grill),
                    contentDescription = stringResource(R.string.cook)
                )
            },
            label = { SingleLineText(stringResource(id = R.string.cook), TextStyle()) },
            selectedContentColor = Orange_E68939
        )
        BottomNavigationItem(
            selected = currentScreen == Screen.Favourites,
            onClick = { showToast(context, "work in progress") },
            icon = {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.heart),
                    contentDescription = stringResource(R.string.favourites)
                )
            },
            label = {
                SingleLineText(
                    stringResource(id = R.string.favourites),
                    TextStyle()
                )
            }
        )
        BottomNavigationItem(
            selected = currentScreen == Screen.Manual,
            onClick = { showToast(context, "work in progress") },
            icon = {
                Icon(
                    ImageVector.vectorResource(R.drawable.hat_chef),
                    contentDescription = stringResource(R.string.manual)
                )
            },
            label = { SingleLineText(stringResource(id = R.string.manual), TextStyle()) }
        )
        BottomNavigationItem(
            selected = currentScreen == Screen.Device,
            onClick = { showToast(context, "work in progress") },
            icon = {
                Icon(
                    ImageVector.vectorResource(R.drawable.laptop_mobile),
                    contentDescription = stringResource(R.string.device)
                )
            },
            label = { SingleLineText(stringResource(id = R.string.device), TextStyle()) }
        )
        BottomNavigationItem(
            selected = currentScreen == Screen.Preferences,
            onClick = { showToast(context, "work in progress") },
            icon = {
                Icon(
                    ImageVector.vectorResource(R.drawable.user_pen),
                    contentDescription = stringResource(R.string.preferences)
                )
            },
            label = {
                SingleLineText(
                    stringResource(id = R.string.preferences),
                    TextStyle()
                )
            }
        )
        BottomNavigationItem(
            selected = currentScreen == Screen.Settings,
            onClick = { showToast(context, "work in progress") },
            icon = {
                Icon(
                    ImageVector.vectorResource(R.drawable.baseline_settings_24),
                    contentDescription = stringResource(R.string.setting)
                )
            },
            label = { SingleLineText(stringResource(id = R.string.setting), TextStyle()) }
        )
        // Add more BottomNavigationItems for additional screens
    }
}



