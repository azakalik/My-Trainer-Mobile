package com.example.mytrainermobile.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Popup
import com.example.mytrainermobile.R
import com.example.mytrainermobile.components.DefaultButton
import com.example.mytrainermobile.components.ExerciseBox
import com.example.mytrainermobile.ui.theme.DefaultBackground
import com.example.mytrainermobile.ui.theme.DefaultColor


@Composable
fun WorkoutBar() {
    var popupControl by remember { mutableStateOf(false) }

    // heart favourite
    var selected by remember { mutableStateOf(false) }
    val color = if (selected) DefaultColor else Color.White

    // star rate
    var selected2 by remember { mutableStateOf(false) }
    val colorStar = if (selected2) Color.Yellow else Color.White

    Box(
        Modifier
            .background(Color(0xFF1E1E1E))
            .fillMaxWidth(1f)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
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
            IconButton(onClick = { selected = !selected }) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(text = stringResource(id = R.string.favourite), color = Color.White)
                    Icon(
                        modifier = Modifier.size(35.dp),
                        imageVector = Icons.Filled.Favorite,
                        contentDescription = "Favorite",
                        tint = color,
                    )
                }
            }
            IconButton(onClick = { popupControl = true }) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(text = stringResource(id = R.string.rate), color = Color.White)
                    Icon(
                        modifier = Modifier.size(35.dp),
                        imageVector = Icons.Filled.Star,
                        contentDescription = "Star",
                        tint = colorStar,
                    )
                }
            }
            if (popupControl) {
                Popup(
/*popupPositionProvider =
                    WindowCenterOffsetPositionProvider(),*/
                    onDismissRequest = { popupControl = false },
                ) {
                    Surface(
                        border = BorderStroke(1.dp, MaterialTheme.colors.primary),
                        shape = RoundedCornerShape(8.dp),
                        color = Color(0xCC1E1E1E),
                        modifier = Modifier
                            .fillMaxSize(1f)
                            .padding(60.dp, 230.dp, 60.dp, 230.dp)
                    ) {
                        Column(
                            modifier = Modifier.padding(10.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.SpaceEvenly
                        ) {
                            Text(
                                text = stringResource(id = R.string.ratepopup),
                                color = Color.White,
                                fontSize = 20.sp
                            )
                            RatingSystem()
                            Row(
                                horizontalArrangement = Arrangement.SpaceAround,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                DefaultButton(
                                    onClick = { popupControl = false },
                                    text = stringResource(id = R.string.cancel)
                                )
                                DefaultButton(onClick = {
                                    popupControl = false; selected2 = !selected2
                                }, text = stringResource(id = R.string.save))
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun RatingSystem() {
    // rating : 1
    var selected1 by remember { mutableStateOf(false) }
    val colorStar1 = if (selected1) Color.Yellow else Color.White
    // rating : 2
    var selected2 by remember { mutableStateOf(false) }
    val colorStar2 = if (selected2) Color.Yellow else Color.White
    // rating : 3
    var selected3 by remember { mutableStateOf(false) }
    val colorStar3 = if (selected3) Color.Yellow else Color.White
    // rating : 4
    var selected4 by remember { mutableStateOf(false) }
    val colorStar4 = if (selected4) Color.Yellow else Color.White
    // rating : 5
    var selected5 by remember { mutableStateOf(false) }
    val colorStar5 = if (selected5) Color.Yellow else Color.White

    Row() {
        IconButton(onClick = {
            if (!selected1) selected1 = !selected1; if (selected2) selected2 =
            !selected2; if (selected3) selected3 = !selected3; if (selected4) selected4 =
            !selected4; if (selected5) selected5 = !selected5
        }) {
            Icon(
                modifier = Modifier.size(35.dp),
                imageVector = Icons.Filled.Star,
                contentDescription = "Star",
                tint = colorStar1,
            )
        }
        IconButton(onClick = {
            if (!selected1) selected1 = !selected1; if (!selected2) selected2 =
            !selected2; if (selected3) selected3 = !selected3; if (selected4) selected4 =
            !selected4; if (selected5) selected5 = !selected5
        }) {
            Icon(
                modifier = Modifier.size(35.dp),
                imageVector = Icons.Filled.Star,
                contentDescription = "Star",
                tint = colorStar2,
            )
        }
        IconButton(onClick = {
            if (!selected1) selected1 = !selected1; if (!selected2) selected2 =
            !selected2; if (!selected3) selected3 = !selected3; if (selected4) selected4 =
            !selected4; if (selected5) selected5 = !selected5
        }) {
            Icon(
                modifier = Modifier.size(35.dp),
                imageVector = Icons.Filled.Star,
                contentDescription = "Star",
                tint = colorStar3,
            )
        }
        IconButton(onClick = {
            if (!selected1) selected1 = !selected1; if (!selected2) selected2 =
            !selected2; if (!selected3) selected3 = !selected3; if (!selected4) selected4 =
            !selected4; if (selected5) selected5 = !selected5
        }) {
            Icon(
                modifier = Modifier.size(35.dp),
                imageVector = Icons.Filled.Star,
                contentDescription = "Star",
                tint = colorStar4,
            )
        }
        IconButton(onClick = {
            if (!selected1) selected1 = !selected1; if (!selected2) selected2 =
            !selected2; if (!selected3) selected3 = !selected3; if (!selected4) selected4 =
            !selected4; if (!selected5) selected5 = !selected5
        }) {
            Icon(
                modifier = Modifier.size(35.dp),
                imageVector = Icons.Filled.Star,
                contentDescription = "Star",
                tint = colorStar5,
            )
        }
    }
}

@Composable
fun StartButton(onNavigateToRunningWorkout1: () -> Unit) {
    Button(
        onClick = { onNavigateToRunningWorkout1() },
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = DefaultColor),
        modifier = Modifier
            .fillMaxWidth(0.5F)
            .padding(0.dp, 5.dp, 0.dp, 10.dp),
    ) {
        Text(text = stringResource(id = R.string.start), color = Color.Black, fontSize = 16.sp)
    }
}

@Composable
fun StartBar(onNavigateToRunningWorkout1: () -> Unit) {
    Box(
        Modifier
            .background(DefaultBackground)
            .fillMaxWidth(1f),
        contentAlignment = Alignment.Center
    ) {
        StartButton(onNavigateToRunningWorkout1)
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun StartWorkout(onNavigateToRunningWorkout1: () -> Unit) {
    val list = listOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 4, 5, 6, 7, 8)
    Scaffold(modifier = Modifier.fillMaxSize(),
        backgroundColor = DefaultBackground,
        topBar = { WorkoutBar() },
        bottomBar = { StartBar(onNavigateToRunningWorkout1) }) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxSize(1f)
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
            .background(DefaultColor, RoundedCornerShape(0.dp, 15.dp, 15.dp, 0.dp))
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
                        modifier = Modifier
                            .size(40.dp)
                            .padding(0.dp, 10.dp, 10.dp, 0.dp),
                        imageVector = Icons.Filled.Share,
                        contentDescription = "Share",
                        tint = Color.White
                    )
                    Text(
                        text = stringResource(id = R.string.share),
                        color = Color.White,
                        modifier = Modifier.padding(0.dp, 0.dp, 10.dp, 0.dp)
                    )
                }
            }
        }
    }
}




