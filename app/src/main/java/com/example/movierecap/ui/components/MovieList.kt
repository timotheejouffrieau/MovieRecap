package com.example.movierecap.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.movierecap.data.model.Movie

@Composable
fun MovieList(
    modifier: Modifier = Modifier,
    movies: List<Movie>
) {
    LazyColumn(
        modifier = modifier.padding(8.dp)
    ) {
        items(movies) { movie ->
            MovieCard(
                title = movie.title,
                author = movie.author,
                rate = movie.rate
            )
            Spacer(modifier = Modifier.height(4.dp)) // Espacement entre les cartes
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMovieList() {
    val movies = listOf(
        Movie(1, "The Dark Knight", "Christopher Nolan", 4.8f),
        Movie(2, "Inception", "Christopher Nolan", 4.7f),
        Movie(3, "Interstellar", "Christopher Nolan", 4.6f)
    )
    MovieList(movies = movies)
}
