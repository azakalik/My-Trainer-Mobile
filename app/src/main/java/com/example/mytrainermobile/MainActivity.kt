package com.example.mytrainermobile


import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.ComponentActivity
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mytrainermobile.screens.*
import com.example.mytrainermobile.ui.theme.MyTrainerMobileTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTrainerMobileTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "home") {
                    composable("arrive") { ArriveScreen(/*...*/) }
                    composable("favourites") { FavouritesView(/*...*/) }
                    composable("home") { HomeScreen() }
                    composable("myRoutines") { MyRoutines() }
                    composable("signIn") { ShowSignInScreen() }
                    composable("signUp") { ShowSignupScreen() }
                    composable("startWorkout") { StartWorkout() }
                    composable("runningWorkout1") { RunningWorkout1() }
                }
            }
        }
    }
}





