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
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.mytrainermobile.R
import com.example.mytrainermobile.components.*
import com.example.mytrainermobile.ui.theme.DefaultBackground
import com.example.mytrainermobile.ui.theme.DefaultColor


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
    val routineTitle = "Routine Title"
    Scaffold(modifier = Modifier.fillMaxSize(),
        backgroundColor = DefaultBackground,
        topBar = { TopBar(routineTitle) },
        bottomBar = { StartBar(onNavigateToRunningWorkout1) }) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxSize(1f)
        ) {
            Spacer(modifier = Modifier.padding(0.dp, 10.dp, 0.dp, 0.dp))
            DescriptorBox(null, null, null, routineTitle)
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
fun DescriptorBox(rating: Float? = null, creator: String? = null, difficulty: Int? = null, routineTitle: String) {

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
                    FavouriteButton(description = true)
                    RateButton()
                    ShareButton(routineTitle)
                }
            }
        }
    }
}




