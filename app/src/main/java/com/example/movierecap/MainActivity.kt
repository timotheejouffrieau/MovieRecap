package com.example.movierecap

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.movierecap.ui.theme.MovieRecapTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MovieRecapTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    val movies = listOf(
                        Movie(1,"The Dark Knight", "Christopher Nolan", 4.8f),
                        Movie(2,"Inception", "Christopher Nolan", 4.7f),
                        Movie(3,"Interstellar", "Christopher Nolan", 4.6f),
                        Movie(4,"The Matrix", "Wachowski Sisters", 4.9f),
                        Movie(5,"Pulp Fiction", "Quentin Tarantino", 4.9f),
                        Movie(6,"The Shawshank Redemption", "Frank Darabont", 4.9f),
                        Movie(7,"The Godfather", "Francis Ford Coppola", 5.0f),
                        Movie(8,"Fight Club", "David Fincher", 4.8f),
                        Movie(9,"Forrest Gump", "Robert Zemeckis", 4.8f),
                        Movie(10,"The Avengers", "Joss Whedon", 4.6f),
                        Movie(11,"Titanic", "James Cameron", 4.7f),
                        Movie(12,"Avatar", "James Cameron", 4.7f),
                        Movie(13,"Gladiator", "Ridley Scott", 4.8f),
                        Movie(14,"The Lion King", "Roger Allers", 4.9f),
                        Movie(15,"Star Wars: A New Hope", "George Lucas", 4.9f),
                        Movie(16,"The Prestige", "Christopher Nolan", 4.8f),
                        Movie(17,"Blade Runner 2049", "Denis Villeneuve", 4.7f),
                        Movie(18,"The Grand Budapest Hotel", "Wes Anderson", 4.6f),
                        Movie(19,"Spider-Man: Into the Spider-Verse", "Bob Persichetti", 4.8f),
                        Movie(20,"The Departed", "Martin Scorsese", 4.7f)
                    )

                    MovieList(
                        modifier = Modifier.padding(innerPadding),
                        movies = movies
                    )
                }
            }
        }
    }
}