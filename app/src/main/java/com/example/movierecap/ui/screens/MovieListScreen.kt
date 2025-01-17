package com.example.movierecap.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Sort
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.movierecap.ui.components.MovieList
import com.example.movierecap.ui.viewmodels.MovieViewModel

@Composable
fun MovieListScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    movieViewModel: MovieViewModel
) {
    val movies by movieViewModel.movies.collectAsStateWithLifecycle()
    var isExpanded by remember { mutableStateOf(false) }

    if (movies.isEmpty()) {
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

    Box(
        modifier = modifier.fillMaxSize()
    ) {
        Column {
            Text(
                text = "Liste des films",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp
            )
            MovieList(
                movies = movies,
                onMovieClick = { movieId ->
                    movieViewModel.selectMovie(movieId)
                    navController.navigate("movieDetail")
                }
            )
        }
        // Boutons superposés dans le coin inférieur droit
        Column(
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp)
        ) {
            // Si le FAB est déployé, afficher les options
            if (isExpanded) {
                MovieViewModel.SortMode.values().forEach { mode ->
                    FloatingActionButton(
                        onClick = {
                            movieViewModel.sortData(mode)
                            isExpanded = false // Replier après sélection
                        },
                        modifier = Modifier.size(56.dp)
                    ) {
                        Text(
                            text = mode.display
                        )
                    }
                }
            }

            FloatingActionButton(
                onClick = { isExpanded = !isExpanded },
                modifier = Modifier.size(64.dp)
            ) {
                Icon(
                    imageVector = if (isExpanded) Icons.Default.Close else Icons.AutoMirrored.Filled.Sort,
                    contentDescription = if (isExpanded) "Fermer" else "Trier"
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun MovieDetailScreenPreviewMovies() {
    MovieListScreen(
        navController = rememberNavController(),
        movieViewModel = viewModel()
    )
}