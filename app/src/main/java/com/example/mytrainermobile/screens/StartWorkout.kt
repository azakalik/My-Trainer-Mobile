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
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mytrainermobile.R
import com.example.mytrainermobile.classes.Routine
import com.example.mytrainermobile.components.*
import com.example.mytrainermobile.ui.theme.DefaultBackground
import com.example.mytrainermobile.ui.theme.DefaultColor
import com.example.mytrainermobile.viewModels.StartWorkoutViewModel


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
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        StartButton(onNavigateToRunningWorkout1)
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun StartWorkout(onNavigateToRunningWorkout1: () -> Unit,routineId: Int) {

    val routineTitle = "Routine Title"

    val startWorkoutViewModel = StartWorkoutViewModel(routineId)

    val state = startWorkoutViewModel.state




    Scaffold(modifier = Modifier.fillMaxSize(),
        backgroundColor = DefaultBackground,
        topBar = { TopBar(routineTitle) },
        bottomBar = { StartBar(onNavigateToRunningWorkout1) },
    floatingActionButton = { RoutineInfoFAB(state)} ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(routineId.toString())
            Spacer(modifier = Modifier.padding(0.dp, 10.dp, 0.dp, 0.dp))
            DescriptorBox(routineTitle = routineTitle)
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
                items(state.cycles) {
                    Box(modifier = Modifier.padding(10.dp)) {
                        CycleBox(it.name, it.detail, it.type, it.repetitions)
                    }//reemplazar item por datos de la lista a enviar a routineBox2
                }
            }
        }
    }
}

@Composable
fun DescriptorBox(rating: String? = stringResource(id = R.string.no_information), category: String? = stringResource(id = R.string.no_information), difficulty: String? = stringResource(id = R.string.no_information), routineTitle: String) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(DefaultColor, RoundedCornerShape(0.dp, 15.dp, 15.dp, 0.dp))
            .offset(x = (-5).dp)
            .border(2.dp, Color.Black, shape = RoundedCornerShape(0.dp, 15.dp, 15.dp, 0.dp))
            .height(95.dp)
    ) {
        Row(modifier = Modifier.fillMaxSize(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
            Column(Modifier.offset(x = 10.dp), verticalArrangement = Arrangement.SpaceEvenly) {
                Text("Difficulty: $difficulty", color = Color.White)
                Text("Rating: $rating", color = Color.White)
                Text("Category: $category", color = Color.White)
            }
            Column(horizontalAlignment = Alignment.End, modifier = Modifier.fillMaxWidth()) {
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                    //FavouriteButton()
                    RateButton()
                    ShareButton(routineTitle)
                }
            }
        }
    }
}




