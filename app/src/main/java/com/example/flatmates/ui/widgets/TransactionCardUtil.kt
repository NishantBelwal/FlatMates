package com.example.flatmates.ui.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter


@Composable
fun TransactionCardUtil(
    imageSource: String,
    imageDescription:String,
    name: String,
    amount: String,
    sign: Boolean,
    days: Int
){
    val asyncPainter =
        rememberAsyncImagePainter(imageSource)
    var amount_color = Color.Red
    var amount = amount
    if(sign){
        amount_color = Color.Green
        amount = "+ ".plus(amount)
    }
    else{
        amount = "- ".plus(amount)
    }

    Column(
        Modifier.padding(all = 5.dp)
    ) {


        Card(
            elevation = 4.dp,
            shape = RoundedCornerShape(size = 12.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(all = 12.dp)
                    .width(150.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                Image(
                    modifier = Modifier
                        .clip(shape = CircleShape)
                        .size(size = 100.dp),
                    painter = asyncPainter,
                    contentDescription = imageDescription,
                    contentScale = ContentScale.Crop
                )

                Text(
                    text = name,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium
                )
                Text(
                    text = amount,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = amount_color
                )
                Spacer(modifier = Modifier.height(height = 18.dp))
                GradientProgressbar(days = days.toFloat())
                Text(
                    text = days.toString().plus(" days ago"),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.ExtraBold,
                )

            }
        }

    }
}

