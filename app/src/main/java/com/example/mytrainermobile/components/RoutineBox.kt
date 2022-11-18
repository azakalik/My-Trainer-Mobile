package com.example.mytrainermobile.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mytrainermobile.aux_functions.pictureDecider
import com.example.mytrainermobile.data.model.Routine
import com.example.mytrainermobile.ui.theme.DefaultBackground
import com.example.mytrainermobile.ui.theme.DefaultColor
import com.example.mytrainermobile.ui.theme.DefaultSecondary
import com.example.mytrainermobile.R


@Composable
fun RoutineBox(
    routine: Routine,
    onNavigateToStartWorkout: (id: Int) -> Unit,
    bigScreenMode: Boolean
) {
    if (bigScreenMode) {
        Box(modifier = Modifier
            .size(300.dp, 215.dp)
            .padding(20.dp)) {
            Row(Modifier.fillMaxSize()) {
                Card(
                    modifier = Modifier
                        .clickable(onClick = { onNavigateToStartWorkout(routine.id) })
                        .size(150.dp, 215.dp),
                    elevation = 10.dp,
                    shape = RoundedCornerShape(15.dp, 0.dp, 0.dp, 15.dp)
                ) {
                    Image(
                        painter = painterResource(id = pictureDecider(routine.category.detail)),
                        contentDescription = "image",
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier
                    )
                }
                SideTitleBox(routine = routine)
            }
        }
    } else {
        Card(
            modifier = Modifier
                .padding(10.dp)
                .clickable(onClick = { onNavigateToStartWorkout(routine.id) })
                .size(150.dp, 215.dp),
            elevation = 10.dp,
            shape = RoundedCornerShape(15.dp)
        ) {
            Image(
                painter = painterResource(id = pictureDecider(routine.category.detail)),
                contentDescription = "image",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
            )
            Row(verticalAlignment = Alignment.Bottom, horizontalArrangement = Arrangement.Start) {
                RoutineTitleBox(title = routine.name)
            }
        }
    }
}

@Composable
fun RoutineTitleBox(title: String) {
    Box(
        modifier = Modifier
            .border(
                width = 2.dp,
                color = DefaultColor,
                shape = RoundedCornerShape(0.dp, 0.dp, 15.dp, 15.dp)
            )
            .background(color = DefaultBackground)
            .fillMaxWidth()
    ) {
        Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
            Text(
                text = title,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                modifier = Modifier.padding(vertical = 5.dp),
            )
        }
    }
}

@Composable
fun SideTitleBox(routine: Routine){
    Box(
        modifier = Modifier
            .border(
                width = 2.dp,
                color = DefaultColor,
                shape = RoundedCornerShape(0.dp, 15.dp, 15.dp, 0.dp)
            )
            .background(
                color = DefaultSecondary,
                shape = RoundedCornerShape(0.dp, 15.dp, 15.dp, 0.dp)
            )
            .fillMaxSize()
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(20.dp), horizontalAlignment = Alignment.Start, verticalArrangement = Arrangement.SpaceAround) {
            Text(
                text = stringResource(id = R.string.info_name, routine.name),
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                modifier = Modifier.padding(vertical = 5.dp),
            )
            Text(
                text = stringResource(id = R.string.info_difficulty, routine.difficulty.toString()),
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                modifier = Modifier.padding(vertical = 5.dp),
            )
            Text(
                text = stringResource(id = R.string.info_rating, routine.score.toString()),
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                modifier = Modifier.padding(vertical = 5.dp),
            )
            Text(
                text = stringResource(id = R.string.info_category, routine.category.name),
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                modifier = Modifier.padding(vertical = 5.dp),
            )
        }
    }
}
