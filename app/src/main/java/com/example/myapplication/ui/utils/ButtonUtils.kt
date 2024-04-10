package com.example.myapplication.ui.utils

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.R

@Composable
fun NormalRoundedButton(text: String, modifier: Modifier, onClick: () -> Unit) {
    val gradient = Brush.horizontalGradient(listOf(Color(0xFFE68B3A), Color(0xFFDF5E33)))
    Button(
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
        contentPadding = PaddingValues(),
        onClick = { onClick() },
        shape = RoundedCornerShape(50.dp)
    ) {
        Box(
            modifier = androidx.compose.ui.Modifier
                .background(gradient)
                .then(modifier),
            contentAlignment = Alignment.Center,
        ) {
            SingleLineText(text, TextStyle(color = Color.White))
        }
    }
}

@Composable
fun ButtonWithImage(modifier: Modifier, text: String, img: Int, onClick: () -> Unit) {
    Button(
        modifier = modifier,
        contentPadding = PaddingValues(),
        onClick = { onClick() },
        shape = RoundedCornerShape(50.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth(),
                painter = painterResource(id = img),
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
            )

            SingleLineText(text, TextStyle(color = Color.White))
        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun PreviewButtonWithImage() {
    ButtonWithImage(Modifier, "Rahul", R.drawable.orange_btn) {}
}