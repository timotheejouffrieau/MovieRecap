package com.example.movierecap.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.movierecap.R

@Composable
fun MovieDetail(
    movieId: Int,
    onBack: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val movie = movies.find { it.id == movieId }

    Column(
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "MovieDetail",
            style = MaterialTheme.typography.headlineMedium,
        )
        // Rappel : movie?.let {...}
        // Si movie n'est pas null, alors on execute le bloc de code à l'intérieur de let
        movie?.let {
            Text(
                text = movie.title,
                style = MaterialTheme.typography.bodyLarge,
            )
            Text(
                text = stringResource(
                    id = R.string.movie_author,
                    movie.author,
                ),
                style = MaterialTheme.typography.bodyMedium,
            )
            Text(
                text = stringResource(
                    id = R.string.movie_rate,
                    movie.rate,
                ),
                style = MaterialTheme.typography.bodyMedium,
            )
        }
        Button(
            onClick = {
                // Action when the button is clicked
                onBack()
            },
            // onClick = onBack,
        ) {
            Text(text = "Retour")
        }


    }
}