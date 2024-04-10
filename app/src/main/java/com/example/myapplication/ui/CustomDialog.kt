package com.example.myapplication.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TimeInput
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.myapplication.R
import com.example.myapplication.ui.theme.Blue_282E9B
import com.example.myapplication.ui.theme.Blue_2B308B
import com.example.myapplication.ui.theme.Orange_E68939
import com.example.myapplication.ui.theme.White_EEEEEE
import com.example.myapplication.ui.utils.SmallText


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimeInputSample(
    onDismissRequest: () -> Unit, onConfirmRequest: () -> Unit
) {
    val state = rememberTimePickerState()
    TimePickerDialog(
        onCancel = {
            onDismissRequest()
        },
    ) {
        TimeInput(state = state)
    }
}


@Composable
fun TimePickerDialog(
    title: String = "Schedule cooking time",
    onCancel: () -> Unit,
    content: @Composable () -> Unit,
) {
    Dialog(
        onDismissRequest = onCancel,
        properties = DialogProperties(
            usePlatformDefaultWidth = false
        ),
    ) {
        Surface(
            shape = MaterialTheme.shapes.extraLarge,
            tonalElevation = 6.dp,
            color = Color.White,
            modifier = Modifier
                .width(IntrinsicSize.Min)
                .height(IntrinsicSize.Min)
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        modifier = Modifier.wrapContentWidth(), text = title, style = TextStyle(
                            fontWeight = FontWeight.Medium, color = Blue_2B308B, fontSize = 16.sp
                        )
                    )

                    Card(
                        modifier = Modifier.align(Alignment.TopEnd),
                        shape = RoundedCornerShape(50.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = White_EEEEEE, contentColor = Color.Blue
                        ),
                    ) {
                        Box(modifier = Modifier
                            .padding(6.dp)
                            .clickable { onCancel() }) {
                            Image(
                                painter = painterResource(R.drawable.baseline_close_24),
                                contentDescription = null,
                                colorFilter = ColorFilter.tint(
                                    Blue_282E9B
                                )
                            )
                        }
                    }

                }
                Spacer(modifier = Modifier.height(12.dp))
                content()
                Row(
                    modifier = Modifier
                        .wrapContentHeight()
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {

                    TextButton(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f),
                        onClick = { onCancel() },
                        contentPadding = ButtonDefaults.ButtonWithIconContentPadding
                    ) {
                        val style = TextStyle(
                            color = Color.Red,
                            fontWeight = FontWeight.Medium,
                            textDecoration = TextDecoration.Underline
                        )
                        SmallText(
                            "Delete", isCustomStyle = true, textStyle = style
                        )
                    }

                    OutlinedButton(
                        onClick = { onCancel() },
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f),
                        colors = ButtonDefaults.buttonColors(
                            contentColor = Orange_E68939, containerColor = Color.White
                        ),
                        border = BorderStroke(width = 1.dp, color = Orange_E68939)
                    ) {
                        SmallText("Re-schedule")
                    }

                    Spacer(modifier = Modifier.width(8.dp))

                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f),
                        onClick = { onCancel() },
                        contentPadding = ButtonDefaults.ButtonWithIconContentPadding,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Orange_E68939, contentColor = Color.White
                        )
                    ) {

                        SmallText("Cook Now")
                    }
                }
            }
        }
    }
}




