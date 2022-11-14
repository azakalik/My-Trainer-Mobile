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
import com.example.mytrainermobile.data.model.Routine
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

    val state = startWorkoutViewModel




    Scaffold(modifier = Modifier.fillMaxSize(),
        backgroundColor = DefaultBackground,
        topBar = { TopBar(routineTitle) },
        bottomBar = { StartBar(onNavigateToRunningWorkout1) },
        /*floatingActionButton = { RoutineInfoFAB(state)}*/ ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(routineId.toString())
            Spacer(modifier = Modifier.padding(0.dp, 10.dp, 0.dp, 0.dp))
            //DescriptorBox(state.routine)
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
                /*items(state.cycles) {
                    Box(modifier = Modifier.padding(10.dp)) {
                        CycleBox(it.name, it.detail, it.type, it.repetitions)
                    }//reemplazar item por datos de la lista a enviar a routineBox2
                }*/
            }
        }
    }
}

@Composable
fun DescriptorBox(routine: Routine) {

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
                Text(stringResource(id = R.string.info_difficulty, routine.difficulty.toString()), color = Color.White)
                Text(stringResource(R.string.info_rating, routine.score.toString()), color = Color.White)
                Text(stringResource(id = R.string.info_category, routine.category), color = Color.White)
            }
            Column(horizontalAlignment = Alignment.End, modifier = Modifier.fillMaxWidth()) {
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                    FavouriteButton(routine)
                    RateButton(routine)
                    ShareButton(routine.name)
                }
            }
        }
    }
}




