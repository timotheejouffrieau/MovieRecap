package com.example.movierecap.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.movierecap.ui.components.MovieDetail
import com.example.movierecap.ui.viewmodels.MovieViewModel

@Composable
fun MovieDetailScreen(
    modifier: Modifier = Modifier,
    movieViewModel: MovieViewModel,
) {

    val movie by movieViewModel.selectedMovie.collectAsStateWithLifecycle()

    // Si aucune donnée n'est disponible, on affiche un message d'erreur
    if (movie == null) {
        Box(
            modifier = modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(
                modifier = Modifier.width(64.dp),
                color = MaterialTheme.colorScheme.secondary,
                trackColor = MaterialTheme.colorScheme.surfaceVariant,
            )
        }
        return
    }

    MovieDetail(
        modifier = modifier,
        movie = movie!!
    )
}

@Preview(showBackground = true)
@Composable
private fun MovieDetailScreenPreviewMovie() {
    MovieDetailScreen(movieViewModel = viewModel())
}