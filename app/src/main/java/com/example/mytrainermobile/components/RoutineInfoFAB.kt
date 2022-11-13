package com.example.mytrainermobile.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Popup
import com.example.mytrainermobile.R
import com.example.mytrainermobile.screenStates.StartWorkoutState
import com.example.mytrainermobile.ui.theme.DefaultBackground
import com.example.mytrainermobile.ui.theme.DefaultColor

@Composable
fun RoutineInfoFAB( state: StartWorkoutState ) {
    var popupControl by remember { mutableStateOf(false) }
    FloatingActionButton(
        onClick = { popupControl = !popupControl },
        contentColor = DefaultColor,
        containerColor = DefaultBackground,
    ) {
        Icon(Icons.Filled.Info, stringResource(id = R.string.info_fab_name))
    }

    // -------- POPUP ---------------------
    if (popupControl) {
        Popup(
            alignment = Alignment.Center,
            onDismissRequest = { popupControl = !popupControl },
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.6f)
                    .border(
                        width = 2.dp,
                        color = DefaultColor,
                        shape = RoundedCornerShape(15.dp)
                    )
                    .background(color = DefaultBackground, shape = RoundedCornerShape(15.dp))
            ) {
                Column(
                    Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = stringResource(id = R.string.info_fab_name),
                        color = Color.White,
                        modifier = Modifier.padding(10.dp),
                        fontSize = 20.sp
                    )
                    Text(
                        text = stringResource(id = R.string.info_name, state.routine.name),
                        color = Color.White,
                        modifier = Modifier.padding(10.dp),
                    )
                    Text(
                        text = stringResource(id = R.string.info_description, state.routine.description),
                        color = Color.White,
                        modifier = Modifier.padding(10.dp),
                    )
                    Text(
                        text = stringResource(id = R.string.info_difficulty, state.routine.difficulty),
                        color = Color.White,
                        modifier = Modifier.padding(10.dp),
                    )
                    Text(
                        text = stringResource(id = R.string.info_rating, state.routine.rating.toString()),
                        color = Color.White,
                        modifier = Modifier.padding(10.dp),
                    )
                    Text(
                        text = stringResource(id = R.string.info_category, state.routine.category),
                        color = Color.White,
                        modifier = Modifier.padding(10.dp),
                    )

                    Row(Modifier.fillMaxWidth().padding(10.dp), horizontalArrangement = Arrangement.Center) {
                        DefaultButton(
                            onClick = { popupControl = false },
                            text = stringResource(id = R.string.close)
                        )
                    }
                }
            }
        }
    }
}