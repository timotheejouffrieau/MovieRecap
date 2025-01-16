package com.example.movierecap.ui.navigation

import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.movierecap.ui.screens.MovieDetailScreen
import com.example.movierecap.ui.screens.MovieListScreen
import com.example.movierecap.ui.viewmodels.MovieViewModel

@Composable
fun MovieApp(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    val movieViewModel: MovieViewModel = viewModel()

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
                navController = navController,
                movieViewModel = movieViewModel
            )
        }

        composable(
            route = "movieDetail",
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
        ) {
            MovieDetailScreen(
                modifier = modifier,
                movieViewModel = movieViewModel
            )
        }
    }
}
