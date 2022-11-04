package com.example.mytrainermobile.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mytrainermobile.R

@Composable
fun RoutineBox(routineName: String, routineType: String) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .clickable {  /*TODO*/ }
            .size(150.dp, 215.dp),
        elevation = 10.dp,
        shape = RoundedCornerShape(15.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.arms),
            contentDescription = "image",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()
        )
        Row(verticalAlignment = Alignment.Top, horizontalArrangement = Arrangement.End) {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    Icons.Filled.Favorite,
                    contentDescription = "Favorite",
                    modifier = Modifier.size(ButtonDefaults.IconSize),
                    tint = Color.LightGray,
                )
            }
        }
    }
}