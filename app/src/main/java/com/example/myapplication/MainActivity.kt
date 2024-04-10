package com.example.myapplication

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.ui.ItemData
import com.example.myapplication.ui.SetupCookUi
import com.example.myapplication.ui.bottomNav.SetupMainUi
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    private lateinit var mContext: Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mContext = this
        setContent {
            MyApplicationTheme {
                SetupMainUi(mContext, getItemList())
            }
        }
    }

    private fun getItemList(): List<ItemData> {
        return listOf(
            ItemData("Thali", R.drawable.italian_spaghetti_without_bg),
            ItemData("Italian Spaghetti", R.drawable.italian_spaghetti_without_bg),
            ItemData("Item 3", R.drawable.thali),
            ItemData("Item 4", R.drawable.thali2),
            ItemData("Item 5", R.drawable.italian_spaghetti_without_bg),
            ItemData("Item 6", R.drawable.newrice),
            ItemData("Item 7", R.drawable.rice)
        )
    }

}




