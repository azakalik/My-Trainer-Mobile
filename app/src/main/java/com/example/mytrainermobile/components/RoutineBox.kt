package com.example.mytrainermobile.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.mytrainermobile.aux_functions.pictureDecider
import com.example.mytrainermobile.data.classes.Routine

@Composable
fun RoutineBox(routine: Routine,
               onNavigateToStartWorkout: (id:Int) -> Unit) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .clickable(onClick = { onNavigateToStartWorkout(routine.id) })
            .size(150.dp, 215.dp),
        elevation = 10.dp,
        shape = RoundedCornerShape(15.dp)
    ) {
        Image(
            painter = painterResource(id = pictureDecider(routine.category)),
            contentDescription = "image",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()
        )
        Row(verticalAlignment = Alignment.Top, horizontalArrangement = Arrangement.End) {
            FavouriteButton(routine)
        }
        Row(verticalAlignment = Alignment.Bottom, horizontalArrangement = Arrangement.Start){
//            Text(text = routineName, fontSize = 20.sp, color = DefaultColor, modifier = Modifier.padding(start = 15.dp, bottom = 5.dp))
            RoutineTitleBox(title = routine.name)
        }

    }
}
