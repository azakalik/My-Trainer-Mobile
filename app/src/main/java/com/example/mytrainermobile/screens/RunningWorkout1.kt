@file:JvmName("ViewRoutineKt")

package com.example.mytrainermobile.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.outlined.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mytrainermobile.components.ExerciseBox



@Composable
fun RunningWorkout1() {

    val list = listOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 4, 5 ,6 ,7 ,8)

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        backgroundColor = Color.DarkGray,
        topBar = { TopBar("your workout") },
    //    bottomBar = { BottomBar()}
    )
    {


        LazyColumn(
            modifier = Modifier
                .padding(it)
                .fillMaxSize(), contentPadding = PaddingValues(20.dp)
        ) {
            items(items = list, itemContent = { item ->

                Box(modifier = Modifier.padding(10.dp).pointerInput(Unit){
                    detectTapGestures(
                        onDoubleTap = {/*TODO DOUBLETAP*/},
                        onTap = {/*TODO */}
                    )
                }) {
                    ExerciseBox()
                }//reemplazar item por datos de la lista a enviar a routineBox2
            })
        }
        }
    }





@Composable
fun BottomBar(){
    BottomAppBar(backgroundColor = Color.Black, contentColor = Color.Magenta) {
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
fun TopBar(title: String) {
    TopAppBar(backgroundColor = Color.Black, contentColor = Color.Magenta, title = {
        TitleWorkout(title = "Your Workout")
    }, navigationIcon =
    {
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                modifier = Modifier.size(33.dp),
                imageVector = Icons.Filled.KeyboardArrowLeft,
                contentDescription = "back arrow"
            )
        }
    })
}

@Composable
fun TitleWorkout(title: String) {
    Text(modifier = Modifier.fillMaxWidth(), text = title)
}