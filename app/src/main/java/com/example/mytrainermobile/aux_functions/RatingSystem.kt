package com.example.mytrainermobile.aux_functions

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

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