package com.example.myapplication.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import com.example.myapplication.ui.theme.Blue_2B308B
import com.example.myapplication.ui.theme.Orange_E68939
import com.example.myapplication.ui.theme.White_EEEEEE
import com.example.myapplication.ui.utils.CustomHeadingText
import com.example.myapplication.ui.utils.NormalText


@Composable
fun RecommendationList(itemList: List<ItemData>, onItemClick: (String) -> Unit) {

    var selectedItemIndex by remember { mutableStateOf(-1) }
    Column(
        modifier = Modifier
            .padding(top = 8.dp)
    ) {
        CustomHeadingText(stringResource(R.string.recommendations))

        LazyRow(
            modifier = Modifier.padding(bottom = 20.dp)
        ) {
            itemsIndexed(itemList) { index, item ->
                val isSelected = index == selectedItemIndex
                RecommendationItem(
                    item = item,
                    isSelected = isSelected,
                    onItemClick = {
                        selectedItemIndex = index
                        onItemClick(item.name)
                    }
                )
            }

        }

    }

}

@Composable
fun RecommendationItem(item: ItemData, isSelected: Boolean, onItemClick: () -> Unit) {
    Column(
        modifier = Modifier
    ) {
        Card(
            modifier = Modifier
                .padding(top = 8.dp)
                .padding(horizontal = 4.dp)
                .clickable {
                    onItemClick()
                },
            shape = RoundedCornerShape(10.dp),
            colors = CardDefaults.cardColors(
                containerColor = if (isSelected) Blue_2B308B else Color.White,
                contentColor = if (isSelected) Color.White else Blue_2B308B
            ),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),

                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                Card(
                    shape = RoundedCornerShape(8.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = White_EEEEEE,
                        contentColor = Color.Blue
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(12.dp)

                        ) {

                            Image(
                                painter = painterResource(id = item.img),
                                contentDescription = null,
                                modifier = Modifier
                                    .width(130.dp)
                                    .height(150.dp)
                            )

                        }
                        Image(
                            painter = painterResource(id = R.drawable.non_veg),
                            contentDescription = "",
                            modifier = Modifier
                                .align(Alignment.TopEnd)
                                .padding(4.dp)

                        )

                    }
                }
                Box(
                    modifier = Modifier
                        .offset(y = (-10).dp),
                    contentAlignment = Alignment.Center
                ) {
                    ShowRating()
                }

                NormalText(
                    text = item.name,
                    textAlign = TextAlign.Center,
                    style = TextStyle(fontWeight = FontWeight.Medium)
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(R.drawable.grill_hot_alt),
                        contentDescription = null,
                        modifier = Modifier
                            .width(16.dp)
                            .height(16.dp),
                        colorFilter = if (isSelected) ColorFilter.tint(Color.White) else ColorFilter.tint(
                            Color.Black
                        )
                    )
                    Spacer(modifier = Modifier.width(8.dp)) // Add space between the image and text

                    NormalText(
                        text = stringResource(R.string._30_min_medium_prep),
                        textAlign = TextAlign.Center,
                        style = TextStyle(
                            fontSize = 11.sp,
                            color = if (isSelected) Color.White else Color.Black,
                            fontWeight = FontWeight.Medium
                        )
                    )
                }

            }
        }
    }

}


@Composable
fun ShowRating() {
    Row(
        modifier = Modifier
            .wrapContentWidth()
            .background(color = Orange_E68939, shape = RoundedCornerShape(50.dp))
            .padding(4.dp),
    ) {
        Image(
            painter = painterResource(R.drawable.baseline_star_24),
            contentDescription = null,
            modifier = Modifier
                .width(12.dp)
                .height(12.dp),
        )
        Spacer(modifier = Modifier.width(4.dp))

        NormalText(
            "4.2",
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontSize = 11.sp,
                color = Color.White,
                fontWeight = FontWeight.Medium
            )
        )
    }
}



