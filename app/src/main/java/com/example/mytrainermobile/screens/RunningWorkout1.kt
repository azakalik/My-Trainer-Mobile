package com.example.mytrainermobile.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mytrainermobile.R
import com.example.mytrainermobile.components.ExerciseBox
import com.example.mytrainermobile.components.Timer
import com.example.mytrainermobile.components.TopBar
import com.example.mytrainermobile.ui.theme.DefaultBackground
import com.example.mytrainermobile.ui.theme.DefaultColor

@Preview (showBackground = true)
@Composable
fun RunningWorkout1() {

    val list = listOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 4, 5, 6, 7, 8)

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        backgroundColor = DefaultBackground,
        topBar = { TopBar("Routine title") },
        floatingActionButton = {
            FloatingActionButton(onClick = { /**/ }, modifier = Modifier.size(130.dp), backgroundColor = DefaultBackground) {
                Timer(
                    totalTime = 10L * 1000L, //tiempo del ej -> pedir a viewmodel
                    handleColor = DefaultColor,
                    inactiveBarColor = Color.Gray,
                    activeBarColor = DefaultColor,
                    modifier = Modifier.size(85.dp)
                )
            }
        },
        isFloatingActionButtonDocked = true,
        bottomBar = {
            BottomAppBar(
                // Defaults to null, that is, No cutout
                modifier = Modifier.background(Transparent),
                cutoutShape = MaterialTheme.shapes.small.copy(
                    CornerSize(percent = 50)
                )
            ) {}
        }
    )
    {
        Column() {
            LazyRow(
                modifier = Modifier
                    .padding(it)
                    .padding(top = 25.dp)
                    .fillMaxWidth()
                    .background(DefaultBackground)
            ) {
                items(items = list, itemContent = {
                    CycleBox(1,true)
                })
            }
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize(), contentPadding = PaddingValues(20.dp)
            ) {
                items(items = list, itemContent = { item ->

                    Box(modifier = Modifier
                        .padding(10.dp)
                        .pointerInput(Unit) {
                            detectTapGestures(
                                onDoubleTap = {/*TODO DOUBLETAP*/ },
                                onTap = {/*TODO */ }
                            )
                        }) {
                        ExerciseBox()
                    }//reemplazar item por datos de la lista a enviar a routineBox2
                })
            }
        }
    }
}


@Composable
fun CycleBox(cycleNumber: Int, isSelected: Boolean = false) {
    Box(
        modifier = Modifier
            .width(200.dp)
            .background(
                if (isSelected) DefaultColor else Color.Black,
                RoundedCornerShape(15.dp, 15.dp, 15.dp, 15.dp)
            )
            .border(2.dp, Color.Black, shape = RoundedCornerShape(15.dp, 15.dp, 15.dp, 15.dp))
            .height(50.dp), contentAlignment = Alignment.Center
    ) {
        //TODO agregar condicional de longitud!, para poder distinguir warmup y coolof
        Text(text = stringResource(id = R.string.cycleWithNumber,cycleNumber),color = if ( isSelected ) Color.White else DefaultColor)
    }
}
@Composable
fun TimerBox() {


}
