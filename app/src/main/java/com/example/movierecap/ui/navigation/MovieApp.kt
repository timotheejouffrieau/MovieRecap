package com.example.movierecap.ui.navigation

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
        composable("movieList") {
            MovieListScreen(
                modifier = modifier,
                navController = navController
            )
        }

        composable(
            "movieDetail/{movieId}",
            arguments = listOf(navArgument("movieId") { type = NavType.IntType })
        ) { backStackEntry ->
            val movieIdArg = backStackEntry.arguments?.getInt("movieId")
            MovieDetailScreen(
                modifier = modifier,
                movieId = movieIdArg
            )
        }
    }
}
