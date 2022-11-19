package com.example.mytrainermobile.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import com.example.mytrainermobile.aux_functions.getSortOptionsList
import com.example.mytrainermobile.ui.theme.DefaultColor
import com.example.mytrainermobile.viewModels.DefaultViewModelInterface
import com.example.mytrainermobile.R



@Composable
fun ShowRadioButtons(viewModel: DefaultViewModelInterface){
    val state = viewModel.getState()
    val radioOptions = state.sortOptions
    val stringNames = getSortOptionsList()
    var iterator = 0

    Row {
        Column(Modifier.selectableGroup()) {
            radioOptions.forEach { text ->
                Row(
                    Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                        .selectable(
                            selected = (text == state.auxSortingBy),
                            onClick = { viewModel.toggleAuxSortingBy(text) },
                            role = Role.RadioButton
                        )
                        .padding(horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = (text == state.auxSortingBy),
                        onClick = null, // null recommended for accessibility with screenreaders
                        colors = RadioButtonDefaults.colors(selectedColor = DefaultColor)
                    )
                    Text(
                        text = stringNames[iterator++],
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(start = 16.dp),
                        color = Color.White
                    )
                }
            }
        }
    }

    Row(
        Modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Switch(
            modifier = Modifier
                .semantics { contentDescription = "Toggle sort descendingly" },
            checked = state.auxSortDescending,
            onCheckedChange = { viewModel.toggleAuxSortDescending() },
            colors = SwitchDefaults.colors(
                checkedTrackColor = DefaultColor,
                uncheckedTrackColor = Color.Transparent
            )
        )
        Text(
            text = stringResource(id = R.string.dir),
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(start = 16.dp),
            color = Color.White
        )
    }
}