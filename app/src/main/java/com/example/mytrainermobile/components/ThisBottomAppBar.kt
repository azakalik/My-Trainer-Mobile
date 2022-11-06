package com.example.mytrainermobile.components

import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import com.example.mytrainermobile.ui.theme.DefaultBackground

@Composable
fun ThisBottomAppBar(onNavigateToHome: () -> Unit,
                     onNavigateToFavourites: () -> Unit,
                     onNavigateToExplore: () -> Unit,
                     onNavigateToProfile: () -> Unit) {
    var selectedItem by remember { mutableStateOf("") }

    NavigationBar(containerColor = DefaultBackground, contentColor = Color.Magenta) {
        NavigationBarItem(
            icon = { Icon(Icons.Filled.Home, contentDescription = "Home") },
            label = { Text("Home") },
            onClick = { selectedItem = "home"
                      onNavigateToHome()},
            selected = selectedItem == "home"
        )
        NavigationBarItem(
            icon = { Icon(Icons.Filled.Favorite, contentDescription = "Favourites") },
            label = { Text("Favourites") },
            onClick = { selectedItem = "fav"
                      onNavigateToFavourites()},
            selected = selectedItem == "fav"
        )
        NavigationBarItem(
            icon = { Icon(Icons.Filled.Search, contentDescription = "Explore") },
            label = { Text("Explore") },
            onClick = { selectedItem = "exp"
                      onNavigateToExplore()},
            selected = selectedItem == "exp"
        )
        NavigationBarItem(
            icon = { Icon(Icons.Filled.Person, contentDescription = "Me") },
            label = { Text("Me") },
            onClick = { selectedItem = "me"
                      onNavigateToProfile()},
            selected = selectedItem == "me"
        )
    }
}
