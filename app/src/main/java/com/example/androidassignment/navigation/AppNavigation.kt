package com.example.androidassignment.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.androidassignment.ui.screens.detail.DetailScreen
import com.example.androidassignment.ui.screens.home.HomeScreen

@Composable
fun AppNavigation(modifier: Modifier = Modifier) {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {

        composable(
            route = Screen.Home.route
        ) {
            HomeScreen(
                navigateToDetail = {movieId->
                    navController.navigate(Screen.Detail.createRoute(movieId))
                },
                onPlayClick = {
                    navController.navigate(Screen.Detail.createRoute("0"))
                }
            )
        }

        composable(
            route = Screen.Detail.route,
            arguments = listOf(
                navArgument("movieId") {
                    type = NavType.StringType
                    nullable = false
                }
            )
        ) {
            val movieId=checkNotNull(it.arguments?.getString("movieId"))
            DetailScreen(
                movieId=movieId,
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }

    }
}