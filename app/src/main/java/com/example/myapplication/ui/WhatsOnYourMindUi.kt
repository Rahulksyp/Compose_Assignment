package com.example.myapplication.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import com.example.myapplication.ui.theme.Blue_2B308B
import com.example.myapplication.ui.utils.CustomHeadingText

@Composable
fun GetWhatsOnYouMindItemLayout(itemName: String, img: Int) {
    Card(
        modifier = Modifier
            .wrapContentWidth()
            .padding(horizontal = 4.dp),
        shape = RoundedCornerShape(50.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
            contentColor = Blue_2B308B
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 5.dp
        )
    ) {
        Row(
            modifier = Modifier
                .padding(end = 20.dp)
        ) {
            Card(shape = RoundedCornerShape(50.dp)) {
                Image(
                    painter = painterResource(id = img),
                    contentDescription = null,
                    modifier = Modifier
                        .width(40.dp)
                        .height(40.dp),
                    contentScale = ContentScale.Crop

                )
            }
            Text(
                text = itemName,
                modifier = Modifier
                    .padding(start = 8.dp)
                    .align(Alignment.CenterVertically),
                style = TextStyle(fontWeight = FontWeight.Medium)
            )
        }

    }
}


@Composable
fun WhatsOnYourMindList(itemList: List<ItemData>) {
    Column(
        modifier = Modifier
            .padding(top = 8.dp)
    ) {
        CustomHeadingText(stringResource(R.string.what_s_on_your_mind))
        LazyRow(
            modifier = Modifier.padding(bottom = 12.dp)
        ) {
            items(itemList) { item ->
                GetWhatsOnYouMindItemLayout(item.name, item.img)
            }
        }
    }

}

data class ItemData(val name: String, val img: Int)




