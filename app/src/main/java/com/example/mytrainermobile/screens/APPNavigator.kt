package com.example.mytrainermobile.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mytrainermobile.components.SortFAB
import com.example.mytrainermobile.components.ThisBottomAppBar
import com.example.mytrainermobile.ui.theme.DefaultBackground
import com.example.mytrainermobile.viewModels.ExploreViewModel
import com.example.mytrainermobile.viewModels.FavouritesViewModel
import com.example.mytrainermobile.viewModels.MyRoutinesViewModel
import com.example.mytrainermobile.viewModels.SortFABViewModel


@Composable
fun AppNavigatorHandler(
    navController: NavHostController = rememberNavController(),
    sortFABViewModel: SortFABViewModel,
    myRoutinesViewModel: MyRoutinesViewModel,
    favouritesViewModel: FavouritesViewModel,
    exploreViewModel: ExploreViewModel,
) {
    var bottomBarStateManager by rememberSaveable { mutableStateOf(true) }
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val bottomBarScreens = listOf(
        AppNavigatorItems.Favourites.route,
        AppNavigatorItems.MyRoutines.route,
        AppNavigatorItems.Explore.route,
        AppNavigatorItems.Profile.route
    )
    val filterScreen = listOf(
        AppNavigatorItems.Favourites.route,
        AppNavigatorItems.MyRoutines.route,
        AppNavigatorItems.Explore.route
    )
    var floatingActionButtonManager by rememberSaveable { mutableStateOf(true) }

    val currentRoute = navBackStackEntry?.destination?.route

    floatingActionButtonManager = currentRoute in filterScreen
    bottomBarStateManager = currentRoute in bottomBarScreens

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(DefaultBackground),
        floatingActionButton = {
            SortFAB(
                floatingActionButtonManager,
                viewModel = sortFABViewModel
            )
        },
        bottomBar = {
            ThisBottomAppBar(navController, bottomBarStateManager)
        },
    ) {
        AppNavigator(
            navController = navController,
            padding = it,
            myRoutinesViewModel = myRoutinesViewModel,
            favouritesViewModel = favouritesViewModel,
            exploreViewModel = exploreViewModel
        )
    }
}


sealed class WorkoutNavigatorItems(val route: String) {
    object StartWorkout : WorkoutNavigatorItems("startWorkout")
    object RunningWorkout : WorkoutNavigatorItems("runningWorkout1")
}


sealed class AppNavigatorItems(val route: String) {
    object Favourites : AppNavigatorItems("favourites")
    object Explore : AppNavigatorItems("explore")
    object Profile : AppNavigatorItems("profile")
    object MyRoutines : AppNavigatorItems("myRoutines")
}

@Composable
fun AppNavigator(
    navController: NavHostController,
    padding: PaddingValues,
    startDestination: String = AppNavigatorItems.MyRoutines.route,
    myRoutinesViewModel: MyRoutinesViewModel,
    favouritesViewModel: FavouritesViewModel,
    exploreViewModel: ExploreViewModel,
) {


    val onNavigateToStartWorkout = { routineId: Int ->
        navController.navigate("${WorkoutNavigatorItems.StartWorkout.route}/$routineId") {
        }
    }
    val onNavigateToRunningWorkout1 = {
        navController.navigate(WorkoutNavigatorItems.RunningWorkout.route) {
        }
    }

    NavHost(navController = navController, startDestination = startDestination) {
        composable(AppNavigatorItems.Favourites.route) {
            FavouritesView(
                onNavigateToStartWorkout,
                favouritesViewModel
            )
        }
        composable(AppNavigatorItems.Explore.route) {
            ExploreScreen(
                onNavigateToStartWorkout,
                exploreViewModel
            )
        }
        composable(AppNavigatorItems.Profile.route) { ShowProfileScreen() }
        composable(AppNavigatorItems.MyRoutines.route) {
            MyRoutines(
                onNavigateToStartWorkout,
                myRoutinesViewModel
            )
        }
        composable(
            "${WorkoutNavigatorItems.StartWorkout.route}/{id}",
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) {
            it.arguments?.getInt("id")?.let { routineId ->
                StartWorkout(
                    onNavigateToRunningWorkout1, routineId
                )
            }
        }
        composable(WorkoutNavigatorItems.RunningWorkout.route) { RunningWorkout1() }
    }

}

