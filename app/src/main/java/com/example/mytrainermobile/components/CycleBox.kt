package com.example.mytrainermobile.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mytrainermobile.data.model.Cycle
import com.example.mytrainermobile.ui.theme.DefaultColor
import com.example.mytrainermobile.ui.theme.DefaultSecondary
import com.example.mytrainermobile.viewModels.StartWorkoutViewModel
import com.example.mytrainermobile.R


@Composable
fun CycleBox(
    cycle: Cycle,
    viewModel: StartWorkoutViewModel
) {
    Card(
        modifier = Modifier
            .fillMaxWidth(1f)
            .height(75.dp)
            .clickable(onClick = { viewModel.openPopup(cycle) }),
        shape = RoundedCornerShape(15.dp)

    ) {
        Row(
            modifier = Modifier
                .background(DefaultSecondary)
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column() {
                Text(
                    text = cycle.name,
                    style = TextStyle(DefaultColor),
                    fontSize = 20.sp
                )
            }
            Column(verticalArrangement = Arrangement.SpaceAround, modifier = Modifier.fillMaxHeight()) {
                Text(text = stringResource( R.string.reps, cycle.repetitions.toString()))
                Text(text = stringResource(id = R.string.cycleType, cycle.type), style = TextStyle(Color.White))
            }
        }
    }
}