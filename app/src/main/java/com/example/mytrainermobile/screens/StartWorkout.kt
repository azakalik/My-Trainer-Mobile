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
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Popup
import com.example.mytrainermobile.R
import com.example.mytrainermobile.aux_functions.RatingSystem
import com.example.mytrainermobile.components.DefaultButton
import com.example.mytrainermobile.components.ExerciseBox
import com.example.mytrainermobile.components.TopBar
import com.example.mytrainermobile.ui.theme.DefaultBackground
import com.example.mytrainermobile.ui.theme.DefaultColor


//@Composable
//fun WorkoutBar() {
//
//
// heart favourite

//
//    Box(
//        Modifier
//            .background(DefaultBackground)
//            .fillMaxWidth()
//    ) {
//        Column {
//            IconButton(onClick = { /*TODO*/ }) {
//                Icon(
//                    modifier = Modifier.size(85.dp),
//                    imageVector = Icons.Filled.KeyboardArrowLeft,
//                    contentDescription = "back arrow",
//                    tint = Color.White,
//                )
//            }
//        }
//        Column(modifier = Modifier.fillMaxWidth(1f), horizontalAlignment = Alignment.End) {
//            IconButton(onClick = { heartPopupSelected = !heartPopupSelected }) {
//                Row(verticalAlignment = Alignment.CenterVertically) {
//                    Text(text = stringResource(id = R.string.favourite), color = Color.White)
//                    Icon(
//                        modifier = Modifier.size(35.dp),
//                        imageVector = Icons.Filled.Favorite,
//                        contentDescription = "Favorite",
//                        tint = color,
//                    )
//                }
//            }
//            IconButton(onClick = { popupControl = true }) {
//                Row(verticalAlignment = Alignment.CenterVertically) {
//                    Text(text = stringResource(id = R.string.rate), color = Color.White)
//                    Icon(
//                        modifier = Modifier.size(35.dp),
//                        imageVector = Icons.Filled.Star,
//                        contentDescription = "Star",
//                        tint = colorStar,
//                    )
//                }
//            }
//            if (popupControl) {
//                Popup(
///*popupPositionProvider =
//                    WindowCenterOffsetPositionProvider(),*/
//                    onDismissRequest = { popupControl = false },
//                ) {
//                    Surface(
//                        border = BorderStroke(1.dp, MaterialTheme.colors.primary),
//                        shape = RoundedCornerShape(8.dp),
//                        color = Color(0xCC1E1E1E),
//                        modifier = Modifier
//                            .fillMaxSize(1f)
//                            .padding(60.dp, 230.dp, 60.dp, 230.dp)
//                    ) {
//                        Column(
//                            modifier = Modifier.padding(10.dp),
//                            horizontalAlignment = Alignment.CenterHorizontally,
//                            verticalArrangement = Arrangement.SpaceEvenly
//                        ) {
//                            Text(
//                                text = stringResource(id = R.string.ratepopup),
//                                color = Color.White,
//                                fontSize = 20.sp
//                            )
//                            RatingSystem()
//                            Row(
//                                horizontalArrangement = Arrangement.SpaceAround,
//                                modifier = Modifier.fillMaxWidth()
//                            ) {
//                                DefaultButton(
//                                    onClick = { popupControl = false },
//                                    text = stringResource(id = R.string.cancel)
//                                )
//                                DefaultButton(onClick = {
//                                    popupControl = false; ratePopupSelected = !ratePopupSelected
//                                }, text = stringResource(id = R.string.save))
//                            }
//                        }
//                    }
//                }
//            }
//        }
//    }
//}

@Composable
fun StartButton(onNavigateToRunningWorkout1: () -> Unit) {
    DefaultButton(
        text = stringResource(id = R.string.start),
        onClick = { onNavigateToRunningWorkout1() })
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
        topBar = { TopBar("Routine title") },
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
fun DescriptorBox(rating: Float? = null, creator: String? = null, difficulty: Int? = null) {
    var heartPopupSelected by remember { mutableStateOf(false) }
    val color = if (heartPopupSelected) DefaultColor else Color.White
    var popupControl by remember { mutableStateOf(false) }

    // star rate
    var ratePopupSelected by remember { mutableStateOf(false) }
    val colorStar = if (ratePopupSelected) Color.Yellow else Color.White
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(DefaultColor, RoundedCornerShape(0.dp, 15.dp, 15.dp, 0.dp))
            .offset(x = (-5).dp)
            .border(2.dp, Color.Black, shape = RoundedCornerShape(0.dp, 15.dp, 15.dp, 0.dp))
            .height(95.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Column(Modifier.offset(x = 10.dp), verticalArrangement = Arrangement.SpaceEvenly) {
                Text("Difficulty: ", color = Color.White)
                Text("Rating: ", color = Color.White)
                Text("Creator: ", color = Color.White)
            }
            Column(horizontalAlignment = Alignment.End, modifier = Modifier.fillMaxWidth()) {
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                    IconButton(onClick = { heartPopupSelected = !heartPopupSelected }) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Icon(
                                modifier = Modifier.size(35.dp),
                                imageVector = Icons.Filled.Favorite,
                                contentDescription = "Favorite",
                                tint = color,
                            )
                            Text(
                                text = stringResource(id = R.string.favourite),
                                color = Color.White
                            )
                        }
                    }
                    IconButton(onClick = { popupControl = true }) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Icon(
                                modifier = Modifier.size(35.dp),
                                imageVector = Icons.Filled.Star,
                                contentDescription = "Star",
                                tint = colorStar,
                            )
                            Text(text = stringResource(id = R.string.rate), color = Color.White)
                        }
                    }
                    IconButton(onClick = {}) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Icon(
                                modifier = Modifier
                                    .size(35.dp),
                                imageVector = Icons.Filled.Share,
                                contentDescription = "Share",
                                tint = Color.White
                            )
                            Text(
                                text = stringResource(id = R.string.share),
                                color = Color.White
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
                                            popupControl = false; ratePopupSelected =
                                            !ratePopupSelected
                                        }, text = stringResource(id = R.string.save))
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}




