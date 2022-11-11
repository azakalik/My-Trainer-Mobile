package com.example.mytrainermobile


import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.ComponentActivity
import androidx.compose.material3.Scaffold
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
                RootNavigationGraph()
            }
        }
    }
}

@Composable
fun RootNavigationGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = "signIn"
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {

        val onNavigateToAppNavigator = {
            navController.navigate("appNavigatorHandler"){
                popUpTo("appNavigatorHandler")
            }
        }

        composable("arrive") { ArriveScreen(/*...*/) }
        composable("signIn") { ShowSignInScreen(onNavigateToSignUp = {navController.navigate("signUp"){
            popUpTo("signUp"){inclusive = false}
        } }, onNavigateToAppNavigator) }
        composable("signUp") { ShowSignupScreen(onNavigateToSignIn = {navController.navigate("signIn"){
            popUpTo("signIn"){inclusive = true}
        } }, onNavigateToAppNavigator) }
        composable("appNavigatorHandler"){ AppNavigatorHandler() }



    }
}





