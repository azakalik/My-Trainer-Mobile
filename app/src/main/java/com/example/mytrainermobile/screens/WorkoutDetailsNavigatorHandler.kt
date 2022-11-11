package com.example.mytrainermobile.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController



sealed class WorkoutNavigatorItems(val route:String){
    object StartWorkout: WorkoutNavigatorItems("startWorkout")
    object RunningWorkout: WorkoutNavigatorItems("runningWorkout1")
}

@Composable
fun WorkoutDetailsNavigatorHandler(navController: NavHostController = rememberNavController()){

    val onNavigateToRunningWorkout1 = {
        navController.navigate(WorkoutNavigatorItems.RunningWorkout.route) {
        }
    }

    NavHost(navController= navController, startDestination =  WorkoutNavigatorItems.StartWorkout.route){
        composable(WorkoutNavigatorItems.StartWorkout.route) { StartWorkout(onNavigateToRunningWorkout1) }
        composable(WorkoutNavigatorItems.RunningWorkout.route) { RunningWorkout1() }
    }
}