package com.example.myapplication.ui

import android.content.Context
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import com.example.myapplication.ui.theme.White_f4f5f9
import com.example.myapplication.ui.toolbar.ShowSearchBar
import com.example.myapplication.ui.utils.AppUtils
import com.example.myapplication.ui.utils.ButtonWithImage


@Composable
fun SetupCookUi(context: Context, itemList: List<ItemData>) {
    var isCookTimeDialogVisible by remember { mutableStateOf(false) }
    var searchValue by remember { mutableStateOf("") }
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 50.dp)
            .background(White_f4f5f9)
            .verticalScroll(scrollState),
    ) {
        Column {
            ShowSearchBar(
                leadingIcon = Icons.Default.Search,
                placeholder = stringResource(R.string.search_for_dish_and_ingredient),
                value = searchValue,
                onValueChange = {
                    searchValue = it
                    Log.d(
                        "TAG", "showPre: $it"
                    )
                },
                onIconClick = {
                    AppUtils.showToast(context, "work in progress")
                },
            )
            Column(
                modifier = Modifier.padding(start = 12.dp, end = 12.dp)
            ) {
                WhatsOnYourMindList(itemList)
                RecommendationList(itemList, onItemClick = {
                    isCookTimeDialogVisible = true
                })
                Buttons(onClick = {
                    AppUtils.showToast(context, "work in progress")
                })
            }
        }

    }

    if (isCookTimeDialogVisible) {
        Log.d("TAG", "SetupCookUi: $")
        TimeInputSample(onDismissRequest = { isCookTimeDialogVisible = false },
            onConfirmRequest = { isCookTimeDialogVisible = false })
    }
}

@Composable
fun Buttons(onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        val modifier = Modifier
            .weight(1f)
            .height(60.dp)
            .padding(8.dp)


        ButtonWithImage(modifier, "Explore all dishes", R.drawable.orange_btn) { onClick() }

        ButtonWithImage(modifier, "Confused ?", R.drawable.pizza_patter) { onClick() }

    }
}

