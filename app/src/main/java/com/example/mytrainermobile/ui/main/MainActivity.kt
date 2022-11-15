package com.example.mytrainermobile.ui.main


import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.ComponentActivity
import com.example.mytrainermobile.screens.*
import com.example.mytrainermobile.ui.theme.MyTrainerMobileTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //val sortFABViewModel by viewModels<SortFABViewModel>()
        //val myRoutinesViewModel by viewModels<MyRoutinesViewModel>()
        //val favouritesViewModel by viewModels<FavouritesViewModel>()
        //val exploreViewModel by viewModels<ExploreViewModel>()
        setContent {
            MyTrainerMobileTheme {
                val systemUiController = rememberSystemUiController()
                systemUiController.setSystemBarsColor(
                    color = androidx.compose.ui.graphics.Color.Black
                )
                AuthNavigatorHandler()//sortFABViewModel = sortFABViewModel, myRoutinesViewModel = myRoutinesViewModel, favouritesViewModel = favouritesViewModel,) /*exploreViewModel = exploreViewModel)*/
            }
        }
    }
}
