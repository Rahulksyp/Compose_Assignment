package com.example.myapplication.ui.toolbar

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import com.example.myapplication.ui.theme.Blue_282E9B
import com.example.myapplication.ui.theme.Blue_2B308B
import com.example.myapplication.ui.theme.Red_D05862


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShowSearchBar(
    leadingIcon: ImageVector,
    placeholder: String,
    value: String,
    onValueChange: (String) -> Unit,
    onIconClick: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier.weight(1f)
        ) {
            OutlinedTextField(
                leadingIcon = {
                    Icon(
                        imageVector = leadingIcon, contentDescription = null, tint = Blue_282E9B
                    )
                },
                value = value,
                onValueChange = onValueChange,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
                    .height(50.dp),
                placeholder = {
                    Text(
                        text = placeholder, color = Color.Gray, maxLines = 1
                    )
                },
                maxLines = 1,
                singleLine = true,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Blue_2B308B,
                    unfocusedBorderColor = Blue_2B308B,
                    cursorColor = Blue_2B308B,
                    focusedTextColor = Blue_2B308B
                ),
                shape = RoundedCornerShape(50.dp),
            )
        }
        Row(
            verticalAlignment = Alignment.Top, horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Icon(imageVector = ImageVector.vectorResource(R.drawable.baseline_notifications_24),
                contentDescription = null,
                tint = Blue_2B308B,
                modifier = Modifier.clickable { onIconClick() })

            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.baseline_power_settings_new_24),
                contentDescription = null,
                tint = Red_D05862,
                modifier = Modifier
                    .padding(end = 8.dp)
                    .clickable { onIconClick() },
            )
        }
    }
}
