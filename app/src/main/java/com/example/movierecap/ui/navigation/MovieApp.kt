package com.example.movierecap.ui.navigation

import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.movierecap.ui.screens.MovieDetailScreen
import com.example.movierecap.ui.screens.MovieListScreen

@Composable
fun MovieApp(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "movieList"
    ) {
        composable(
            route = "movieList",
            enterTransition = {
                slideInHorizontally { fullWidth -> fullWidth } + fadeIn()
            },
            exitTransition = {
                slideOutHorizontally { fullWidth -> -fullWidth } + fadeOut()
            },
            popEnterTransition = {
                slideInHorizontally { fullWidth -> -fullWidth } + fadeIn()
            },
            popExitTransition = {
                slideOutHorizontally { fullWidth -> fullWidth } + fadeOut()
            }) {
            MovieListScreen(
                modifier = modifier,
                navController = navController
            )
        }

        composable(
            route = "movieDetail/{movieId}",
            arguments = listOf(navArgument("movieId") { type = NavType.IntType }),
            enterTransition = {
                slideInHorizontally { fullWidth -> fullWidth } + fadeIn()
            },
            exitTransition = {
                slideOutHorizontally { fullWidth -> -fullWidth } + fadeOut()
            },
            popEnterTransition = {
                slideInHorizontally { fullWidth -> -fullWidth } + fadeIn()
            },
            popExitTransition = {
                slideOutHorizontally { fullWidth -> fullWidth } + fadeOut()
            }
        ) { backStackEntry ->
            val movieIdArg = backStackEntry.arguments?.getInt("movieId")
            MovieDetailScreen(
                modifier = modifier,
                movieId = movieIdArg
            )
        }
    }
}
