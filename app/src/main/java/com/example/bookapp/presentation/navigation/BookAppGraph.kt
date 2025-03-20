package com.example.bookapp.presentation.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.bookapp.presentation.screens.DetailedInfoScreen
import com.example.bookapp.presentation.screens.FavouriteScreen
import com.example.bookapp.presentation.screens.MainScreen

@Composable
fun BookAppGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(navController=navController,
        startDestination = "home",
        modifier= Modifier.fillMaxSize()){
        composable("home") {
            MainScreen(navController)
        }
        composable("detailedInfo") {
            DetailedInfoScreen(navController)
        }
        composable("favourite") {
            FavouriteScreen(navController)
        }
    }
}