package com.example.myapplication.ui.utils

import android.content.Context
import android.widget.Toast

object AppUtils {
    fun showToast(context: Context, msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }
}