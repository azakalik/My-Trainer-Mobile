package com.example.mytrainermobile.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mytrainermobile.data.model.Exercise
import com.example.mytrainermobile.components.Timer
import com.example.mytrainermobile.components.TopBar
import com.example.mytrainermobile.ui.theme.DefaultBackground
import com.example.mytrainermobile.ui.theme.DefaultColor
import com.example.mytrainermobile.util.getViewModelFactory
import com.example.mytrainermobile.viewModels.IndividualExerciseScreenViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mytrainermobile.R
import com.example.mytrainermobile.components.DefaultButton
import com.example.mytrainermobile.components.MicroTimer


@Composable
fun IndividualExerciseScreen(routineId: Int, viewModel: IndividualExerciseScreenViewModel = viewModel(factory = getViewModelFactory())) {

    val uiState = viewModel.uiState
    var fetchInformation by remember { mutableStateOf(true) }
    if (fetchInformation) {
        viewModel.getRoutineCycles(routineId)
        fetchInformation = false
    }

    var newExercise by remember { mutableStateOf(true) }


    Scaffold(
        modifier = Modifier.fillMaxSize(),
        backgroundColor = DefaultBackground,
        topBar = {
            if(uiState.cycle != null && !uiState.finished){
                TopBar(uiState.cycle.name)
            }
            else{
                TopBar(stringResource(R.string.endtitle))
            }
                 }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if(viewModel.uiState.message == null) {

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
                        if (!uiState.finished) {
                            uiState.exercise?.exercise?.let { it1 ->
                                DetailText(
                                    title = stringResource(
                                        R.string.name
                                    ), description = it1.name
                                )
                            }
                            uiState.exercise?.exercise?.detail?.let { it1 ->
                                DetailText(
                                    title = stringResource(
                                        id = R.string.detail
                                    ), description = it1
                                )
                            }
                            uiState.exercise?.exercise?.type?.let { it1 ->
                                DetailText(
                                    title = stringResource(
                                        id = R.string.type
                                    ), description = it1
                                )
                            }
                            val time = uiState.exercise?.duration?.toLong()

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceEvenly,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                DefaultButton(
                                    onClick = {
                                        viewModel.prevExercise(); newExercise = !newExercise
                                    },
                                    text = stringResource(id = R.string.prev)
                                )
                                if (uiState.exercise?.duration != 0 && time != null) {
                                    if (newExercise) {
                                        Timer(
                                            totalTime = time * 1000L,
                                            handleColor = DefaultColor,
                                            inactiveBarColor = DefaultBackground,
                                            activeBarColor = DefaultColor,
                                            modifier = Modifier.size(100.dp),
                                        )
                                    } else {
                                        Timer(
                                            totalTime = time * 1000L,
                                            handleColor = DefaultColor,
                                            inactiveBarColor = DefaultBackground,
                                            activeBarColor = DefaultColor,
                                            modifier = Modifier.size(100.dp),
                                        )
                                    }
                                } else {
                                    Column() {
                                        DetailText(
                                            title = stringResource(id = R.string.repetitions),
                                            description = uiState.exercise?.repetitions.toString()
                                        )
                                    }
                                }
                                DefaultButton(
                                    onClick = {
                                        viewModel.nextExercise(); newExercise = !newExercise
                                    },
                                    text = stringResource(id = R.string.next)
                                )
                            }
                        } else {
                            Text(
                                text = stringResource(id = R.string.ended), color = DefaultColor,
                                fontSize = 28.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }
            else{
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = viewModel.uiState.message!!,
                        fontSize = 20.sp,
                        color = Color.White
                    )
                }
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

