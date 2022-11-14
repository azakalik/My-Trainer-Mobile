package com.example.mytrainermobile.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Popup
import com.example.mytrainermobile.R
import com.example.mytrainermobile.data.model.Routine
import com.example.mytrainermobile.ui.theme.DefaultBackground

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
            ;

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
            ;

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
fun RateButton(routine: Routine) {
    var popupControl by remember { mutableStateOf(false) }
    val colorStar = if (popupControl) Color.Yellow else Color.White

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

    if (popupControl) {
        Popup(
            onDismissRequest = { popupControl = false },
        ) {
            Surface(
                border = BorderStroke(1.dp, MaterialTheme.colors.primary),
                shape = RoundedCornerShape(8.dp),
                color = DefaultBackground,
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
                            popupControl = false
                        }, text = stringResource(id = R.string.save))
                    }
                }
            }
        }
    }
}