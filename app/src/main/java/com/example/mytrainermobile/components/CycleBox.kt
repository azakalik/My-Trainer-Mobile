package com.example.mytrainermobile.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mytrainermobile.ui.theme.DefaultColor

@Composable
fun CycleBox(name: String, description: String?, type: String, repetitions: Int) {
    Card(
        modifier = Modifier
            .fillMaxWidth(1f)
            .height(75.dp),
        shape = RoundedCornerShape(15.dp)

    ) {
        Row(
            modifier = Modifier
                .background(Color.DarkGray)
                .padding(8.dp)
        ) {
            //Image(painter = painterResource(id = R.drawable.))
            Column {
                Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = name,
                        style = TextStyle(DefaultColor),
                        fontSize = 20.sp
                    )
                    Text(text = repetitions.toString())
                }
                Row (horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()){
                    Text(
                        text = description!!,
                        style = TextStyle(Color.White),
                        fontSize = 14.sp
                    )// replace for Api.fetch(desc)
                    Text(text = type, style = TextStyle(Color.White), fontSize = 12.sp)
                }
            }
        }
    }
}