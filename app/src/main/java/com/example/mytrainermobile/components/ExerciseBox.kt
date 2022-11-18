package com.example.mytrainermobile.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mytrainermobile.ui.theme.DefaultColor
import com.example.mytrainermobile.viewModels.RunningWorkout1ViewModel


@Composable
fun ExerciseBox(
    exerciseTitle: String,
    exerciseDescription: String?,
    category: String,
    duration: Int?,
    repetitions: Int,
    viewModel: RunningWorkout1ViewModel
) {

    var running by remember { mutableStateOf(false) }
    var color = if (running) DefaultColor else Color.DarkGray
    var titleColor = if (running) Color.White else DefaultColor

    Card(
        modifier = Modifier
            .fillMaxWidth(1f)
            .height(95.dp)
            .clickable {
                if(!viewModel.uiState.running && !running) {
                    viewModel.start()
                    running = true
                }
                else if(viewModel.uiState.running && running){
                    running = false
                    viewModel.stop()
                }
                else if(viewModel.uiState.running && !running){
                    running = false
                }
                       },
        shape = RoundedCornerShape(15.dp)

    ) {
        Row(
            modifier = Modifier
                .background(color)
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = exerciseTitle,
                style = TextStyle(titleColor),
                fontSize = 28.sp
            )
            Column (verticalArrangement = Arrangement.Center){
                if (duration != null) {
                    if (duration.toLong() != 0L)
                        MicroTimer(totalTime = duration * 1000L, running)
                    else
                        Text(
                            text = repetitions.toString(),
                            fontSize = 40.sp,
                            fontWeight = FontWeight.Bold
                        )
                }
                Text("Seconds")
            }
        }
    }

}