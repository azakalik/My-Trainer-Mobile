package com.example.mytrainermobile


import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mytrainermobile.screens.*
import com.example.mytrainermobile.ui.theme.MyTrainerMobileTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTrainerMobileTheme {
                val systemUiController = rememberSystemUiController()
                systemUiController.setSystemBarsColor(
                    color = androidx.compose.ui.graphics.Color.Black
                )
                MyAppNavHost()
            }
        }
    }
}

@Composable
fun MyAppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = "signIn"
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        val onNavigateToMyRoutines = {
            navController.navigate("myRoutines"){
                popUpTo(0)
            }
        }
        val onNavigateToFavourites = {
            navController.navigate("favourites"){
                popUpTo("myRoutines")
            }
        }
        val onNavigateToExplore = {
            navController.navigate("explore"){ //todo
                popUpTo("myRoutines")
            }
        }
        val onNavigateToProfile = {
            navController.navigate("profile"){
                popUpTo("myRoutines")
            }
        }
        val onNavigateToStartWorkout = {
            navController.navigate("startWorkout"){

            }
        }
        val onNavigateToRunningWorkout1 = {
            navController.navigate("runningWorkout1") {

            }
        }
        composable("arrive") { ArriveScreen(/*...*/) }
        composable("favourites") { FavouritesView(navController,onNavigateToMyRoutines, onNavigateToFavourites, onNavigateToExplore, onNavigateToProfile, onNavigateToStartWorkout) }
        composable("explore") { ExploreScreen(navController,onNavigateToMyRoutines, onNavigateToFavourites, onNavigateToExplore, onNavigateToProfile, onNavigateToStartWorkout) }
        composable("profile") { ShowProfileScreen(navController,onNavigateToMyRoutines, onNavigateToFavourites, onNavigateToExplore, onNavigateToProfile) }
        composable("myRoutines") { MyRoutines(navController,onNavigateToMyRoutines, onNavigateToFavourites, onNavigateToExplore, onNavigateToProfile, onNavigateToStartWorkout) }
        composable("signIn") { ShowSignInScreen(onNavigateToSignUp = {navController.navigate("signUp"){
            popUpTo("signUp"){inclusive = false}
        } }, onNavigateToMyRoutines) }
        composable("signUp") { ShowSignupScreen(onNavigateToSignIn = {navController.navigate("signIn"){
            popUpTo("signIn"){inclusive = true}
        } }, onNavigateToMyRoutines) }
        composable("startWorkout") { StartWorkout(onNavigateToRunningWorkout1) }
        composable("runningWorkout1") { RunningWorkout1() }
    }
}





