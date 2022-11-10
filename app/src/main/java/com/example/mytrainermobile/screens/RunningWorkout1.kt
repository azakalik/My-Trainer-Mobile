@file:JvmName("ViewRoutineKt")

package com.example.mytrainermobile.screens

import android.graphics.Paint.Align
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mytrainermobile.R
import com.example.mytrainermobile.components.ExerciseBox
import com.example.mytrainermobile.components.TopBar
import com.example.mytrainermobile.ui.theme.DefaultColor
@Preview (showBackground = true)
@Composable
fun RunningWorkout1() {

    val list = listOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 4, 5, 6, 7, 8)

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        backgroundColor = Color.DarkGray,
        topBar = { TopBar("your workout") },
        //    bottomBar = { BottomBar()}
    )
    {

        Column() {

            LazyRow(
                modifier = Modifier
                    .padding(it).padding(top=25.dp)
                    .fillMaxWidth()
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
fun BottomBar() {
    BottomAppBar(backgroundColor = Color.Black, contentColor = DefaultColor) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.Transparent),
            horizontalArrangement = Arrangement.SpaceEvenly,
        ) {
            IconButton(
                onClick = { /*TODO*/ },
            ) {
                Icon(
                    Icons.Filled.ArrowBack,
                    contentDescription = "Previous Exercise",
                    modifier = Modifier.size(33.dp)
                )
            }

            IconButton(
                onClick = { /*TODO*/ },
            ) {
                Icon(
                    Icons.Outlined.PlayArrow,
                    contentDescription = "Previous Exercise",
                    modifier = Modifier.size(33.dp)
                )
            }

            IconButton(
                onClick = { /*TODO*/ },
            ) {
                Icon(
                    Icons.Filled.ArrowForward,
                    contentDescription = "Previous Exercise",
                    modifier = Modifier.size(33.dp)
                )
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