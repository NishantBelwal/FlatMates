package com.example.flatmates.ui.widgets

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import coil.compose.rememberAsyncImagePainter


@Composable
fun IconUtil(
    imageSource: String,
    imageDescription:String
){
    val contextForToast = LocalContext.current.applicationContext
    val asyncPainter =
        rememberAsyncImagePainter(imageSource)

    Image(
        painter = asyncPainter,
        contentDescription = "Dog Image",
        modifier = Modifier.clickable {
            Toast.makeText(contextForToast, "Click!", Toast.LENGTH_SHORT).show()
        }
    )

}