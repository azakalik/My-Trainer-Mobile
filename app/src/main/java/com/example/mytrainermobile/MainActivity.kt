package com.example.mytrainermobile


import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mytrainermobile.screens.*
import com.example.mytrainermobile.ui.theme.MyTrainerMobileTheme
import com.example.mytrainermobile.viewModels.ExploreViewModel
import com.example.mytrainermobile.viewModels.FavouritesViewModel
import com.example.mytrainermobile.viewModels.MyRoutinesViewModel
import com.example.mytrainermobile.viewModels.SortFABViewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val sortFABViewModel by viewModels<SortFABViewModel>()
        val myRoutinesViewModel by viewModels<MyRoutinesViewModel>()
        val favouritesViewModel by viewModels<FavouritesViewModel>()
        val exploreViewModel by viewModels<ExploreViewModel>()
        setContent {
            MyTrainerMobileTheme {
                val systemUiController = rememberSystemUiController()
                systemUiController.setSystemBarsColor(
                    color = androidx.compose.ui.graphics.Color.Black
                )
                AuthNavigatorHandler(sortFABViewModel = sortFABViewModel, myRoutinesViewModel = myRoutinesViewModel, favouritesViewModel = favouritesViewModel, exploreViewModel = exploreViewModel)
            }
        }
    }
}
