package com.example.mytrainermobile.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


@Composable
fun WorkoutDetailsNavigatorHandler(navController: NavHostController = rememberNavController()){

    val onNavigateToRunningWorkout1 = {
        navController.navigate("runningWorkout1") {
        }
    }

    NavHost(navController= navController, startDestination = "startWorkout" ){
        composable("startWorkout") { StartWorkout(onNavigateToRunningWorkout1) }
        composable("runningWorkout1") { RunningWorkout1() }
    }
}