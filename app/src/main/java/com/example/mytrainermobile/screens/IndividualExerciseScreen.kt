package com.example.mytrainermobile.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mytrainermobile.data.model.Exercise
import com.example.mytrainermobile.components.Timer
import com.example.mytrainermobile.components.TopBar
import com.example.mytrainermobile.ui.theme.DefaultBackground
import com.example.mytrainermobile.ui.theme.DefaultColor

/*
* {
  "order": 1,
  "duration": 30,
  "repetitions": 0,
  "exercise": {
    "id": 1,
    "name": "Jumping Jacks",
    "detail": "Jumping Jacks",
    "type": "exercise",
    "date": 1620062203228,
    "metadata": null
  }
}*/
@Preview(showBackground = true)
@Composable
fun IndividualExerciseScreen() {
    val uistate = Exercise(1,"Jumping jacks","JUMP!!","Legs", duration = 20, repetitions = 0)

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        backgroundColor = DefaultBackground,
        topBar = { TopBar("Exercise Details") },
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                modifier = Modifier
                    .height(400.dp)
                    .padding(25.dp),
                border = BorderStroke(width = 2.dp, color = DefaultColor),
                backgroundColor = DefaultBackground,
                elevation = 100.dp
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    DetailText(title = "Name", description = uistate.name)
                    DetailText(title ="Detail" , description = uistate.detail)
                    DetailText(title = "type", description = "Exercise")
                    uistate.repetitions?.let { it1 -> DetailText(title = "repetitions", description ="ss" ) }
                }
            }


            uistate.duration?.let {
                //TODO PASAR A TIMER CALLBACK
                Timer(
                    totalTime = 10L * 1000L, //tiempo del ej -> pedir a viewmodel
                    handleColor = DefaultColor,
                    inactiveBarColor = Color.Gray,
                    activeBarColor = DefaultColor,
                    modifier = Modifier.size(185.dp)
                )
            }

        }
    }
}

@Composable
fun DetailText(title: String, description: String) {
    Text(
        text = "$title: $description",
        color = DefaultColor,
        fontSize = 28.sp,
        fontWeight = FontWeight.Bold
    )
}

