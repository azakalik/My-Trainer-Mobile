package com.example.mytrainermobile.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Popup
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mytrainermobile.R
import com.example.mytrainermobile.components.*
import com.example.mytrainermobile.data.model.Cycle
import com.example.mytrainermobile.data.model.Routine
import com.example.mytrainermobile.screenStates.showPopup
import com.example.mytrainermobile.ui.theme.DefaultBackground
import com.example.mytrainermobile.ui.theme.DefaultColor
import com.example.mytrainermobile.util.getViewModelFactory
import com.example.mytrainermobile.viewModels.StartWorkoutViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.lang.Thread.sleep


@Composable
fun StartBar(onNavigateToRunningWorkout1: (id: Int) -> Unit, routineId: Int) {
    Box(
        Modifier
            .background(DefaultBackground)
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        DefaultButton(
            text = stringResource(id = R.string.start),
            onClick = { onNavigateToRunningWorkout1(routineId) }
        )
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun StartWorkout(
    onNavigateToRunningWorkout1: (id: Int) -> Unit,
    routineId: Int,
    viewModel: StartWorkoutViewModel = viewModel(factory = getViewModelFactory())
) {

    //----------------------------Callbacks and resources initialization
    var fetchInformation by remember { mutableStateOf(true) }
    if (fetchInformation) {
        viewModel.getRoutineCycles(routineId)
        viewModel.getRoutine(routineId)
        fetchInformation = false
    }

    val uiState = viewModel.uiState

    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()

    val makeFavouriteCallback = {
            id: Int -> viewModel.makeFavourite(id) ;
            coroutineScope.launch {
                when (scaffoldState.snackbarHostState.showSnackbar(message = "Routine has been favourited, now available in my routines", actionLabel = "OK", duration = SnackbarDuration.Short)) {
                    SnackbarResult.ActionPerformed -> scaffoldState.snackbarHostState.currentSnackbarData?.dismiss()
                    else -> {}
                }
            }
    }
    val removeFavouriteCallback = { id: Int -> viewModel.removeFavourite(id)
        coroutineScope.launch {
            when (scaffoldState.snackbarHostState.showSnackbar(message = "Routine is no longer favourited", actionLabel = "OK",duration = SnackbarDuration.Short) ){
                SnackbarResult.ActionPerformed -> scaffoldState.snackbarHostState.currentSnackbarData?.dismiss()
                else -> {}
            }
        }
    }

    val showRatingSnackbar = {
        coroutineScope.launch {
            when (scaffoldState.snackbarHostState.showSnackbar(message = "Routine has been rated succesfully", actionLabel = "OK",duration = SnackbarDuration.Short) ){
                SnackbarResult.ActionPerformed -> scaffoldState.snackbarHostState.currentSnackbarData?.dismiss()
                else -> {}
            }
        }
    }



        //--------------------------------------------------------Screen Rendering --------------

    if (uiState.routine != null) {
        Scaffold(modifier = Modifier.fillMaxSize(),
            scaffoldState = scaffoldState,
            backgroundColor = DefaultBackground,
            snackbarHost = {
                           SnackbarHost(it) { state ->
                               Snackbar(actionColor = DefaultColor, backgroundColor = Color.DarkGray, contentColor = Color.White, snackbarData = state)
                           }
            },
            topBar = { TopBar(uiState.routine.name) },
            bottomBar = { StartBar(onNavigateToRunningWorkout1, routineId) },
            floatingActionButton = { RoutineInfoFAB(viewModel) }) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top,
                modifier = Modifier.fillMaxSize()

            ) {
                Spacer(modifier = Modifier.padding(0.dp, 10.dp, 0.dp, 0.dp))
                DescriptorBox(uiState.routine, viewModel, makeFavouriteCallback, removeFavouriteCallback, showRatingSnackbar)
                LazyColumn(
                    modifier = Modifier
                        .padding(), contentPadding = PaddingValues(20.dp, 10.dp, 20.dp, 60.dp)
                ) {
                    items(uiState.cycles) {
                        Box(modifier = Modifier.padding(10.dp)) {
                            CycleBox(
                                it,
                                viewModel,
                            )
                        }
                    }
                }
            }
        }
    }

    // ------------- CYCLE INFORMATION POPUP ------------------------------
    if (uiState.showPopup) {
        Popup(
            alignment = Alignment.Center,
            onDismissRequest = { viewModel.closePopup() },
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
                    Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = "Cycle information",
                        color = Color.White,
                        modifier = Modifier.padding(10.dp),
                        fontSize = 20.sp
                    )
                    Text(
                        "Cycle name: " + uiState.currentCycleForPopup!!.name
                    )
                    Text(
                        "Detail: " + uiState.currentCycleForPopup.detail
                    )
                    Text(
                        "Type: " + uiState.currentCycleForPopup.type
                    )
                    Text(
                        "Repetitions: " + uiState.currentCycleForPopup.repetitions
                    )
                    Text(
                        "Order: " + uiState.currentCycleForPopup.order
                    )//todo fijarse si se va
                    Row(
                        Modifier
                            .padding(10.dp)
                            .fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                        DefaultButton(onClick = { viewModel.closePopup() }, text = "Close")
                    }
                }
            }
        }
    }
}

@Composable
fun DescriptorBox(
    routine: Routine,
    viewModel: StartWorkoutViewModel,
    makeFavouriteCallback: (Int) -> Job,
    removeFavouriteCallback: (Int) -> Job,
    showRatingSnackBar: () -> Job
) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(DefaultColor, RoundedCornerShape(0.dp, 15.dp, 15.dp, 0.dp))
            .offset(x = (-5).dp)
            .border(2.dp, Color.Black, shape = RoundedCornerShape(0.dp, 15.dp, 15.dp, 0.dp))
            .height(95.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(Modifier.offset(x = 10.dp), verticalArrangement = Arrangement.SpaceEvenly) {
                Text(
                    stringResource(
                        id = R.string.info_difficulty,
                        routine.difficulty.toString()
                    ),
                    color = Color.White
                )
                Text(
                    stringResource(R.string.info_rating, routine.score.toString()),
                    color = Color.White
                )
                Text(
                    stringResource(id = R.string.info_category, routine.category.name),
                    color = Color.White
                )
            }
            Column(horizontalAlignment = Alignment.End, modifier = Modifier.fillMaxWidth()) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    FavouriteButton(routine = routine, callbackMakeFavourite = makeFavouriteCallback, callbackRemoveFavourite = removeFavouriteCallback)
                    RateButton(viewModel = viewModel, routineId = routine.id,showRatingSnackBar)
                    ShareButton(routineTitle = routine.name, routineId = routine.id)
                }
            }
        }
    }
}




