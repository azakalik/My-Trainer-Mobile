package com.example.mytrainermobile.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TitleForSection() {
    Text(
        text = "My Trainer",
        color = Color.Magenta,
        fontSize = 44.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(60.dp, 0.dp, 0.dp, 0.dp)
    )
}

@Composable
fun TitleBox(title: String, startPadding: Dp, maxHeight: Float, maxWidth: Float) {
    Box(
        modifier = Modifier
            .offset(x = (-5).dp)
            .border(
                width = 2.dp,
                color = Color.Magenta,
                shape = RoundedCornerShape(0.dp, 15.dp, 15.dp, 0.dp)
            )
            .fillMaxHeight(maxHeight)
            .fillMaxWidth(maxWidth)
    ) {
        Text(
            text = title,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            modifier = Modifier.padding(
                start = startPadding,
                top = 5.dp,
                bottom = 0.dp,
                end = 2.dp
            )
        )
    }
}