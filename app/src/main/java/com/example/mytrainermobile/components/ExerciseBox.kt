package com.example.mytrainermobile.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Popup
import com.example.mytrainermobile.ui.theme.DefaultColor
import com.example.mytrainermobile.R
import com.example.mytrainermobile.screens.DrawerBody
import com.example.mytrainermobile.ui.theme.DefaultBackground


@Composable
fun ExerciseBox(exerciseTitle: String, exerciseDescription: String?, category: String, duration: Int?, repetitions: Int) {
    var popupControl by remember { mutableStateOf(false) }
    var running by remember { mutableStateOf(false)}
    var color = if(running) DefaultColor else Color.Gray
    var titleColor = if(running) Color.White else DefaultColor
    if(popupControl) {
        Popup(
            onDismissRequest = { popupControl = false },
            alignment = Alignment.Center,
        ) {
            Surface(
                border = BorderStroke(1.dp, MaterialTheme.colors.primary),
                shape = RoundedCornerShape(8.dp),
                color = DefaultBackground,
                modifier = Modifier
                    .clickable { popupControl = !popupControl }
                    .padding(100.dp)

            ){
                Column(
                    modifier = Modifier.padding(10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    Text(
                        text = stringResource(id = R.string.details),
                        color = Color.White,
                        fontSize = 20.sp
                    )
                    Text(
                        text = exerciseDescription.orEmpty(),
                        color = Color.White,
                        fontSize = 20.sp
                    )
                }
            }
        }
    }
    Card(
        modifier = Modifier
            .fillMaxWidth(1f)
            .height(95.dp)
            .clickable { running = !running },
        shape = RoundedCornerShape(15.dp)

    ) {
        Row(
            modifier = Modifier
                .background(color)
                .padding(8.dp)
        ) {
            Column {
                Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = exerciseTitle,
                        style = TextStyle(titleColor),
                        fontSize = 28.sp
                    )
                    if (duration != null) {
                        if(duration.toLong() != 0L)
                            MicroTimer(totalTime = duration*1000L, running)
                        else
                            Text(text = repetitions.toString(), fontSize = 40.sp, fontWeight = FontWeight.Bold)
                    }
                }
                Row (horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()){
                    Text(
                        text = stringResource(id = R.string.seeDetails),
                        style = TextStyle(Color.White),
                        fontSize = 22.sp,
                        modifier = Modifier.clickable { popupControl = !popupControl }
                    )
                    Text(text = category, style = TextStyle(Color.White), fontSize = 20.sp)
                }
            }
        }
    }
}