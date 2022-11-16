package com.example.mytrainermobile.ui.main


import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mytrainermobile.screens.*
import com.example.mytrainermobile.ui.theme.MyTrainerMobileTheme
import com.example.mytrainermobile.util.ViewModelFactory
import com.example.mytrainermobile.util.getViewModelFactory
import com.example.mytrainermobile.viewModels.*
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val sortFABViewModel by viewModels<SortFABViewModel>()

        setContent {
            MyTrainerMobileTheme {
                val exploreViewModel : ExploreViewModel = viewModel(factory =  getViewModelFactory())
                val myRoutinesViewModel: MyRoutinesViewModel = viewModel(factory = getViewModelFactory())
                val favouritesViewModel: FavouritesViewModel = viewModel(factory = getViewModelFactory())
                val mainViewModel: MainViewModel = viewModel(factory = getViewModelFactory())
                val systemUiController = rememberSystemUiController()
                systemUiController.setSystemBarsColor(
                    color = androidx.compose.ui.graphics.Color.Black
                )
                if(mainViewModel.uiState.isAuthenticated){
                    AppNavigatorHandler(
                        sortFABViewModel = sortFABViewModel,
                        myRoutinesViewModel = myRoutinesViewModel,
                        favouritesViewModel = favouritesViewModel,
                        exploreViewModel = exploreViewModel,
                    )
                }
                else{
                    AuthNavigatorHandler(sortFABViewModel = sortFABViewModel, myRoutinesViewModel = myRoutinesViewModel, favouritesViewModel = favouritesViewModel, exploreViewModel = exploreViewModel)
                }
            }
        }
    }
}
