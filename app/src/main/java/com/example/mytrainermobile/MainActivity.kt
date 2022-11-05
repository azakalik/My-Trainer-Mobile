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

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTrainerMobileTheme {
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
        val onNavigateToHome = {
            navController.navigate("home"){
                popUpTo(0)
            }
        }
        composable("arrive") { ArriveScreen(/*...*/) }
        composable("favourites") { FavouritesView(/*...*/) }
        composable("home") { HomeScreen() }
        composable("myRoutines") { MyRoutines() }
        composable("signIn") { ShowSignInScreen(onNavigateToSignUp = {navController.navigate("signUp"){
            popUpTo("signUp"){inclusive = false}
        } }, onNavigateToHome) }
        composable("signUp") { ShowSignupScreen(onNavigateToSignIn = {navController.navigate("signIn"){
            popUpTo("signIn"){inclusive = true}
        } }, onNavigateToHome) }
        composable("startWorkout") { StartWorkout() }
        composable("runningWorkout1") { RunningWorkout1() }
    }
}





