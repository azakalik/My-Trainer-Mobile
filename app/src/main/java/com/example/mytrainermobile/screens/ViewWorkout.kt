package com.example.mytrainermobile.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mytrainermobile.components.ExerciseBox
import com.example.mytrainermobile.R


@Composable
fun StartButton() {
    Button(
        onClick = { },
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Magenta),
        modifier = Modifier
            .fillMaxWidth(0.5F)
            .padding(0.dp, 5.dp, 0.dp, 10.dp),
    ) {
        Text(text = stringResource(id = R.string.start))
    }
}

@Composable
fun WorkoutBar() {
    Box(
        Modifier
            .background(Color(0xFF1E1E1E))
            .fillMaxWidth(1f)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    modifier = Modifier.size(85.dp),
                    imageVector = Icons.Filled.KeyboardArrowLeft,
                    contentDescription = "back arrow",
                    tint = Color.White,
                )
            }
        }
        Column(modifier = Modifier.fillMaxWidth(1f), horizontalAlignment = Alignment.End) {
            IconButton(onClick = { /*TODO*/ }) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(text = stringResource(id = R.string.favourite), color = Color.White)
                    Icon(
                        modifier = Modifier.size(35.dp),
                        imageVector = Icons.Filled.Favorite,
                        contentDescription = "Favorite",
                        tint = Color.White,
                    )
                }
            }
            IconButton(onClick = { /*TODO*/ }) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(text = stringResource(id = R.string.rate), color = Color.White)
                    Icon(
                        modifier = Modifier.size(35.dp),
                        imageVector = Icons.Filled.Star,
                        contentDescription = "Star",
                        tint = Color.White,
                    )
                }
            }
        }
    }
}

@Composable
fun StartBar() {
    Box(
        Modifier
            .background(Color(0xFF1E1E1E))
            .fillMaxWidth(1f),
        contentAlignment = Alignment.Center
    ) {
        StartButton()
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Preview
@Composable
fun ViewWorkout() {
    val list = listOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 4, 5, 6, 7, 8)
    Scaffold(modifier = Modifier.fillMaxSize(),
        backgroundColor = Color.DarkGray,
        topBar = { WorkoutBar() },
        bottomBar = { StartBar() }) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxSize(1f)
                .background(Color.DarkGray)
        ) {
            Spacer(modifier = Modifier.padding(0.dp, 10.dp, 0.dp, 0.dp))
            DescriptorBox()
            Box(
                modifier = Modifier
                    .height(120.dp)
                    .width(120.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.arms),
                    contentDescription = "image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    contentScale = ContentScale.FillBounds
                )
            }
            LazyColumn(
                modifier = Modifier
                    .padding(), contentPadding = PaddingValues(20.dp, 10.dp, 20.dp, 60.dp)
            ) {
                items(items = list, itemContent = { item ->
                    Box(modifier = Modifier.padding(10.dp)) {
                        ExerciseBox()
                    }//reemplazar item por datos de la lista a enviar a routineBox2
                })
            }
        }
    }
}

@Composable
fun DescriptorBox() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Magenta, RoundedCornerShape(0.dp, 15.dp, 15.dp, 0.dp))
            .offset(x = (-5).dp)
            .border(2.dp, Color.Black, shape = RoundedCornerShape(0.dp, 15.dp, 15.dp, 0.dp))
            .height(95.dp)
    ) {
        Column() {
            Row(Modifier.offset(x = 10.dp)) {
                Text("Routine Title", fontSize = 24.sp, color = Color.White)
            }
            Spacer(modifier = Modifier.padding(7.dp, 0.dp, 0.dp, 0.dp))
            Row(Modifier.offset(x = 10.dp)) {
                Text("38'", color = Color.White) // tiempo de rutina???
                Text("Intermediate", color = Color.White) // dificultad
            }
            Spacer(modifier = Modifier.padding(7.dp, 0.dp, 0.dp, 0.dp))
            Row(Modifier.offset(x = 10.dp)) {
                Text("Rating", color = Color.White) // rating
                Text("username", color = Color.White) // username????
            }
        }
        Column(horizontalAlignment = Alignment.End, modifier = Modifier.fillMaxWidth()) {
            IconButton(onClick = { /*TODO*/ }) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(
                        modifier = Modifier.size(40.dp).padding(0.dp, 10.dp, 10.dp, 0.dp),
                        imageVector = Icons.Filled.Share,
                        contentDescription = "Share",
                        tint = Color.White
                    )
                    Text(text = stringResource(id = R.string.share), color = Color.White, modifier = Modifier.padding(0.dp, 0.dp, 10.dp, 0.dp))
                }
            }
        }
    }
}