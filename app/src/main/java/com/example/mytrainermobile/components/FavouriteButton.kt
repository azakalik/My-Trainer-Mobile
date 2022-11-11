package com.example.mytrainermobile.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.mytrainermobile.R

@Composable
fun FavouriteButton(description : Boolean) {
    var heartPopupSelected by remember { mutableStateOf(false) }
    val color = if (heartPopupSelected) Color.Red else Color.White

    IconButton(onClick = { heartPopupSelected = !heartPopupSelected }) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(
                modifier = Modifier.size(35.dp),
                imageVector = Icons.Filled.Favorite,
                contentDescription = "Favorite",
                tint = color,
            )
            if(description) {
                Text(
                    text = stringResource(id = R.string.favourite),
                    color = Color.White
                )
            }
        }
    }
}