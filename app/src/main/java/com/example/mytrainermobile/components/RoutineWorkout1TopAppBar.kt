package com.example.mytrainermobile.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.mytrainermobile.ui.theme.DefaultBackground
import com.example.mytrainermobile.ui.theme.DefaultColor
import com.example.mytrainermobile.viewModels.RunningWorkout1ViewModel

@Composable
fun RW1TopBar(viewModel: RunningWorkout1ViewModel, onNavigateToIndividualExercise: (id: Int) -> Unit,) {
    TopAppBar(backgroundColor = DefaultBackground, contentColor = DefaultColor, title = {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text =
            if (viewModel.uiState.currentCycle != null) viewModel.uiState.currentCycle!!.name
            else "No Cycle selected"
        )
    }, actions = { DefaultButton({ onNavigateToIndividualExercise(viewModel.uiState.currentCycle!!.id) }, "Detailed view") })
}