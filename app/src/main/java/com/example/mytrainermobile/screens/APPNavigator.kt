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



sealed class AppNavigatorItems(val route: String){
    object Favourites: AppNavigatorItems("favourites")
    object Explore: AppNavigatorItems("explore")
    object Profile: AppNavigatorItems("profile")
    object MyRoutines: AppNavigatorItems("myRoutines")
    object WorkoutNavigationHandler: AuthNavigatorItems("WorkoutNavigationHandler")
}

@Composable
fun AppNavigator(navController: NavHostController,padding: PaddingValues,startDestination: String = AppNavigatorItems.MyRoutines.route ){


    val onNavigateToStartWorkout = {
        navController.navigate(AppNavigatorItems.WorkoutNavigationHandler.route){
        }
    }

    NavHost(navController = navController, startDestination = startDestination) {
        composable(AppNavigatorItems.Favourites.route) { FavouritesView(onNavigateToStartWorkout) }
        composable(AppNavigatorItems.Explore.route) { ExploreScreen(onNavigateToStartWorkout) }
        composable(AppNavigatorItems.Profile.route) { ShowProfileScreen() }
        composable(AppNavigatorItems.MyRoutines.route) { MyRoutines(onNavigateToStartWorkout) }
        composable(AppNavigatorItems.WorkoutNavigationHandler.route) { WorkoutDetailsNavigatorHandler() }
    }

}

