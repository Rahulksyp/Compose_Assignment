package com.example.myapplication.ui.utils

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.Blue_2B308B

@Composable
fun SmallText(
    text: String,
    isCustomStyle: Boolean = false,
    textStyle: TextStyle = TextStyle(),
) {

    val customTextStyle = if (isCustomStyle) textStyle else TextStyle(
        fontSize = 11.sp
    )
    Text(
        text, textAlign = TextAlign.Center, style = customTextStyle
    )
}

@Composable
fun CustomHeadingText(heading: String) {
    val style = TextStyle(color = Blue_2B308B, fontSize = 20.sp, fontWeight = FontWeight.Medium)
    SmallText(heading, true, style)
    Spacer(modifier = Modifier.padding(bottom = 16.dp))
}

@Composable
fun NormalText(text: String, textAlign: TextAlign, style: TextStyle) {
    Text(
        text = text,
        textAlign = textAlign,
        style = style
    )
}

@Composable
fun SingleLineText(name: String, style: TextStyle) {
    BoxWithConstraints {
        androidx.compose.material.Text(
            modifier = Modifier
                .wrapContentWidth(unbounded = true)
                .requiredWidth(maxWidth + 24.dp), // 24.dp = the padding * 2
            text = name,
            softWrap = false,
            textAlign = TextAlign.Center,
            style = style
        )
    }
}