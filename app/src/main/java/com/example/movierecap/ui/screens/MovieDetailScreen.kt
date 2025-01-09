package com.example.movierecap.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.movierecap.data.repository.MovieRepository
import com.example.movierecap.ui.components.MovieDetail

@Composable
fun MovieDetailScreen(
    modifier: Modifier = Modifier,
    movieId: Int?
) {

    val movie = MovieRepository.getMovieById(movieId)

    // Si aucune donnée n'est disponible, on affiche un message d'erreur
    if (movie == null) {
        Box(
            modifier = modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Aucun film sélectionné ou le film n'a pas été trouvé",
                style = MaterialTheme.typography.titleLarge,
                modifier = modifier.padding(16.dp)
            )
        }
        return
    }

    MovieDetail(
        modifier = modifier,
        movie = movie
    )
}

@Preview(showBackground = true)
@Composable
private fun MovieDetailScreenPreviewMovie() {
    MovieDetailScreen(movieId = 1)
}

@Preview(showBackground = true)
@Composable
private fun MovieDetailScreenPreviewNoMovie() {
    MovieDetailScreen(movieId = null)
}