package com.example.mytrainermobile.data.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.mytrainermobile.R


sealed class BottomNavigationData(val title: Int, val icon: ImageVector, val route:String) {
    object MyRoutines: BottomNavigationData(R.string.Routines, Icons.Filled.Home,"myRoutines")
    object Favourites: BottomNavigationData(R.string.Favourites,Icons.Filled.Favorite,"favourites")
    object Explore: BottomNavigationData(R.string.explore,Icons.Filled.Search,"explore")
    object Profile: BottomNavigationData(R.string.Me,Icons.Filled.Person,"profile")
}