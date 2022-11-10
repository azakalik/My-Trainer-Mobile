package com.example.mytrainermobile.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mytrainermobile.ui.theme.DefaultBackground
import com.example.mytrainermobile.ui.theme.DefaultColor

@Composable
fun TitleForSection() {
    Text(
        text = "My Trainer",
        color = DefaultColor,
        fontSize = 44.sp,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun TitleBox(title: String) {
    Box(
        modifier = Modifier
            .offset(x = (-5).dp)
            .border(
                width = 2.dp,
                color = DefaultColor,
                shape = RoundedCornerShape(0.dp, 15.dp, 15.dp, 0.dp)
            )
    ){
        Row() {
            Text(
                text = title,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                modifier = Modifier.padding(vertical = 5.dp, horizontal = 10.dp)
            )
        }
    }
}

@Composable
fun RoutineTitleBox(title:String){
    Box(
        modifier = Modifier
            .border(
                width = 2.dp,
                color = DefaultColor,
                shape = RoundedCornerShape(0.dp, 0.dp, 15.dp, 15.dp)
            ).background(color = DefaultBackground).fillMaxWidth()
    ){
        Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
            Text(
                text = title,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                modifier = Modifier.padding(vertical = 5.dp),
            )
        }
    }
}