package com.example.mytrainermobile.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mytrainermobile.R
import com.example.mytrainermobile.aux_functions.pictureDecider
import com.example.mytrainermobile.ui.theme.DefaultColor

@Composable
fun RoutineBox(routineName: String, routineType: String,
               onNavigateToStartWorkout: () -> Unit) {
    var selected by remember { mutableStateOf(false) }
    val color = if (selected) DefaultColor else Color.White
    Card(
        modifier = Modifier
            .padding(10.dp)
            .clickable ( onClick={ onNavigateToStartWorkout() } )
            .size(150.dp, 215.dp),
        elevation = 10.dp,
        shape = RoundedCornerShape(15.dp)
    ) {
        Image(
            painter = painterResource(id = pictureDecider(routineType)),
            contentDescription = "image",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()
        )
        Row(verticalAlignment = Alignment.Top, horizontalArrangement = Arrangement.End) {
            IconButton(onClick = { selected = !selected }) {
                Icon(
                    Icons.Filled.Favorite,
                    contentDescription = "Favorite",
                    modifier = Modifier.size(30.dp),
                    tint = color,
                )
            }
        }
        Row(verticalAlignment = Alignment.Bottom, horizontalArrangement = Arrangement.Start){
            Text(text = routineName, fontSize = 20.sp, color = Color.White, modifier = Modifier.padding(start = 15.dp, bottom = 5.dp))
        }
    }
}
