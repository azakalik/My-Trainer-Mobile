package com.example.mytrainermobile.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.mytrainermobile.R

@Composable
fun RoutineBox(routineName: String, routineType: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
            .clickable {  /*TODO*/ },
        elevation = 10.dp,
        shape = RoundedCornerShape(15.dp)
    ) {
        Box(modifier = Modifier.height(90.dp)) {
            Image(
                painter = painterResource(id = R.drawable.arms),
                contentDescription = "image",
                contentScale = ContentScale.FillBounds
            )

        }
    }
}