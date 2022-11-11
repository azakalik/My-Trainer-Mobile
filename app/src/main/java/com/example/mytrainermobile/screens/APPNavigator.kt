package com.example.mytrainermobile.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mytrainermobile.components.SortFAB
import com.example.mytrainermobile.components.ThisBottomAppBar
import com.example.mytrainermobile.ui.theme.DefaultBackground


@Composable
fun AppNavigatorHandler(navController: NavHostController = rememberNavController()){
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(DefaultBackground),
        floatingActionButton = { SortFAB() },
        bottomBar = {
            ThisBottomAppBar(navController)
        },
    ){
        AppNavigator(navController =  navController, padding = it)
    }
}


@Composable
fun AppNavigator(navController: NavHostController,padding: PaddingValues,startDestination: String = "myRoutines" ){


    val onNavigateToStartWorkout = {
        navController.navigate("WorkoutNavigationHandler"){
        }
    }

    NavHost(navController = navController, startDestination = startDestination) {
        composable("favourites") { FavouritesView(onNavigateToStartWorkout) }
        composable("explore") { ExploreScreen(onNavigateToStartWorkout) }
        composable("profile") { ShowProfileScreen() }
        composable("myRoutines") { MyRoutines(onNavigateToStartWorkout) }
        composable("WorkoutNavigationHandler") { WorkoutDetailsNavigatorHandler() }
    }

}

