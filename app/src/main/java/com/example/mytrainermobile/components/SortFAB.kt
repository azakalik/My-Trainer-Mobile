package com.example.mytrainermobile.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
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
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Popup
import com.example.mytrainermobile.R
import com.example.mytrainermobile.aux_functions.getSortOptionsList
import com.example.mytrainermobile.screenStates.SortFABState
import com.example.mytrainermobile.ui.theme.DefaultBackground
import com.example.mytrainermobile.ui.theme.DefaultColor
import com.example.mytrainermobile.viewModels.SortFABViewModel

@Composable
fun SortFAB(
    showButton: Boolean,
    //viewModel: SortFABViewModel
) {
    /*
    // ----------------- FAB -----------------------------------
    if (showButton) {
        FloatingActionButton(
            onClick = { viewModel.toggleShowSortFAB() },
            contentColor = DefaultColor,
            containerColor = DefaultBackground,
        ) {
            Icon(Icons.Filled.Menu, stringResource(id = R.string.fab_name))
        }
    }

    // ------------------- POPUP ----------------------------------
    if (viewModel.state.showSortFAB) {
        Popup(
            alignment = Alignment.Center,
            onDismissRequest = { viewModel.toggleShowSortFAB() },
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.6f)
                    .border(
                        width = 2.dp,
                        color = DefaultColor,
                        shape = RoundedCornerShape(15.dp)
                    )
                    .background(color = DefaultBackground, shape = RoundedCornerShape(15.dp))
            ) {
                Column(
                    Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // --------- POPUP TITLE --------------------------------
                    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                        Text(
                            text = stringResource(id = R.string.fab_name),
                            color = Color.White,
                            modifier = Modifier.padding(10.dp),
                            fontSize = 20.sp
                        )
                    }
                    ShowRadioButtons(viewModel)
                    // ---------- POPUP BUTTONS ----------------------------
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        DefaultButton(
                            onClick = { viewModel.toggleShowSortFAB(); viewModel.unSaveChanges() },
                            text = stringResource(id = R.string.cancel)
                        )
                        DefaultButton(
                            onClick = {
                                viewModel.toggleShowSortFAB(); viewModel.saveChanges()
                            },
                            text = stringResource(id = R.string.accept)
                        )
                    }
                }
            }
        }
    }
     */
}

@Composable
fun ShowRadioButtons(viewModel: SortFABViewModel){
    val state = viewModel.state
    val radioOptions = state.sortOptions
    val stringNames = getSortOptionsList()
    var iterator = 0
//    val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[0]) }
// Note that Modifier.selectableGroup() is essential to ensure correct accessibility behavior
    Row() {
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
            text = "Descending",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(start = 16.dp),
            color = Color.White
        )
    }
}