package com.example.mytrainermobile.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*


import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Popup
import com.example.mytrainermobile.R
import com.example.mytrainermobile.data.model.Cycle
import com.example.mytrainermobile.components.TopBar
import com.example.mytrainermobile.ui.theme.DefaultBackground
import com.example.mytrainermobile.ui.theme.DefaultColor
import com.example.mytrainermobile.util.getViewModelFactory
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mytrainermobile.components.ExerciseBox
import com.example.mytrainermobile.viewModels.RunningWorkout1ViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun RunningWorkout1(
    routineId: Int,
    viewModel: RunningWorkout1ViewModel = viewModel(factory = getViewModelFactory()),
) {

    var fetchInformation by remember{mutableStateOf(true)}
    if (fetchInformation){
        viewModel.getRoutineCycles(routineId)
        fetchInformation = false
    }

    var popupControl by remember { mutableStateOf(false) }


    val uiState = viewModel.uiState

    val scaffoldState = rememberScaffoldState()
    rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        modifier = Modifier.fillMaxSize(),
        backgroundColor = DefaultBackground,
        topBar = { TopBar("Routine title") },
        bottomBar = {
            BottomAppBar(
                // Defaults to null, that is, No cutout
                modifier = Modifier.background(Transparent),
                backgroundColor = DefaultBackground,
                cutoutShape = MaterialTheme.shapes.small.copy(
                    CornerSize(percent = 50)
                )
            ) {}
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                backgroundColor = DefaultColor ,
                contentColor = Color.White ,
                text = { Text(stringResource(id = R.string.viewCycles)) },
                onClick = {
                    popupControl = !popupControl
                }
            )
        }
    )
    {

        if(popupControl) {
            Popup(
                onDismissRequest = { popupControl = false },
                alignment = Alignment.Center
            ) {
                Surface(
                    border = BorderStroke(1.dp, MaterialTheme.colors.primary),
                    shape = RoundedCornerShape(8.dp),
                    color = DefaultBackground,
                    modifier = Modifier
                        .fillMaxSize(0.5f)
                        //.padding(60.dp, 230.dp, 60.dp, 230.dp),

                ){
                    Column(
                        modifier = Modifier.padding(10.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Text(
                            text = stringResource(id = R.string.cycle),
                            color = Color.White,
                            fontSize = 20.sp
                        )
                        DrawerBody(
                            items = uiState.cycles.orEmpty(),
                            Modifier,
                            onItemClick = {
                                viewModel.getCycleExercises(it.id)
                                popupControl = false
                            }
                        )
                    }
                }
            }
        }
        Column() {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize(), contentPadding = PaddingValues(20.dp)
            ) {
                items(uiState.cycleExercises.orEmpty())
                {
                    Box(modifier = Modifier
                        .padding(10.dp)
                        .pointerInput(Unit) {
                            detectTapGestures(
                                onDoubleTap = {/*TODO DOUBLETAP*/ },
                                onTap = {/*TODO */ }
                            )
                        }) {
                        it.repetitions?.let { it1 ->
                            ExerciseBox(it.exercise.name,  it.exercise.detail, it.exercise.type, it.duration,
                                it1
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun DrawerBody(
    items: List<Cycle>,
    modifier: Modifier,
    onItemClick: (Cycle) -> Unit
){
    LazyColumn(modifier) {
        items(items) { item ->
            Row(
                modifier = Modifier.fillMaxWidth().clickable { onItemClick(item) }.padding(16.dp)
            ){
                Text(text = item.name, modifier = Modifier.weight(1f))
            }
        }
    }
}



