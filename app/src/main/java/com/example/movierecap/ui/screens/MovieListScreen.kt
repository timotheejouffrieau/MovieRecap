package com.example.movierecap.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.movierecap.data.repository.MovieRepository
import com.example.movierecap.ui.components.MovieList

@Composable
fun MovieListScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    val movies = MovieRepository.getAllMovies()

    if (movies.isEmpty()) {
        Box(
            modifier = modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Il n'y pas de films",
                style = MaterialTheme.typography.titleLarge,
                modifier = modifier.padding(16.dp)
            )
        }
        return
    }

    Column(
        modifier = modifier,
    ) {
        Text(
            text = "Liste des films",
            modifier = Modifier.fillMaxWidth().padding(top = 16.dp),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp
        )
        MovieList(
            movies = movies,
            onMovieClick =  { movieId ->
                navController.navigate("movieDetail/$movieId")
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun MovieDetailScreenPreviewMovies() {
    MovieListScreen(navController = rememberNavController())
}