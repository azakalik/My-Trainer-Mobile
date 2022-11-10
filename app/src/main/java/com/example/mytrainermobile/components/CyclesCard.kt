package com.example.mytrainermobile.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CyclesCard(cycle: String) {
    Box(modifier = Modifier.height(100.dp).width(300.dp).background(color = Color.Black), contentAlignment = Alignment.Center) {
        Text(text = cycle,color = Color.Magenta, fontSize = 28.sp)
    }
}



