package com.example.mytrainermobile.components

import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.mytrainermobile.data.model.Routine

@Composable
fun FavouriteButton(
    routine: Routine,
    callbackMakeFavourite: (routineId: Int) -> Unit,
    callbackRemoveFavourite: (routineId: Int) -> Unit
) {
    val color = if (routine.isFavourite) Color.Red else Color.White

    IconButton(onClick = {
        if (routine.isFavourite)
            callbackRemoveFavourite(routine.id)
        else
            callbackMakeFavourite(routine.id)
    }) {
        Icon(
            modifier = Modifier.size(35.dp),
            imageVector = Icons.Filled.Favorite,
            contentDescription = "Favorite",
            tint = color,
        )
    }
}
