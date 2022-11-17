package com.example.mytrainermobile.components

import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

@Composable
fun MicroTimer(totalTime: Long, isRunning: Boolean) {
    var currentTime by remember{
        mutableStateOf(totalTime)
    }
    LaunchedEffect(key1 = currentTime, key2 = isRunning) {
        if(currentTime > 0 && isRunning) {
            delay(100L)
            currentTime -= 100L
        }
        else if(currentTime == 0.toLong())
            currentTime = totalTime

    }
    Text( text = (currentTime / 1000).toString(), fontSize = 40.sp, fontWeight = FontWeight.Bold, color = Color.White)

}