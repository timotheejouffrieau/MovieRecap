package com.example.movierecap.domain.repository

import com.example.movierecap.data.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieRepository {

    fun getAllMovies(): Flow<List<Movie>>
    fun getMovieById(movieId: Int): Flow<Movie?>

}