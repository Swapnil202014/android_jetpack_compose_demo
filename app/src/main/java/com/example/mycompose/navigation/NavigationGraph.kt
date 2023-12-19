package com.example.mycompose.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mycompose.screens.ExploreScreen
import com.example.mycompose.screens.HomeScreen
import com.example.mycompose.screens.InputHomeScreen
import com.example.mycompose.screens.RestaurantScreen

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Explore : Screen("explore")
    object Restaurants : Screen("restaurants")
    object InputHome : Screen("inputHome")
}

@Composable
fun NavigationGraph(
    contentPaddingValues: PaddingValues, onTitleChanged: (String) -> Unit
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController, startDestination = Screen.InputHome.route
    ) {
        composable(Screen.Home.route) {
            HomeScreen(contentPaddingValues,
                onTitleChanged = onTitleChanged,
                navigateToExploreScreen = { navController.navigate(Screen.Explore.route) })
        }
        composable(Screen.Explore.route) {
            ExploreScreen(contentPaddingValues,
                onTitleChanged = onTitleChanged,
                navigateToRestaurantScreen = {
                    navController.navigate(Screen.Restaurants.route)
                })
        }
        composable("${Screen.Restaurants.route}/{name}") {
                backStackEntry ->
            RestaurantScreen(
                contentPaddingValues,
                restaurantName = backStackEntry.arguments?.getString("name"),
                onTitleChanged = onTitleChanged,
                navigateToInputHomeScreen = {
                    navController.navigate(Screen.InputHome.route)
                })

        }
        composable(Screen.InputHome.route) {
            InputHomeScreen(contentPaddingValues,
                onTitleChanged = onTitleChanged,
                navigateToRestaurantScreen = { name ->
                    navController.navigate("${Screen.Restaurants.route}/$name")
                })
        }
    }
}