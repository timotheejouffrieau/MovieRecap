package com.example.movierecap.data.repository

import com.example.movierecap.data.model.Movie
import com.example.movierecap.data.remote.MovieApiService
import com.example.movierecap.data.remote.dto.toMovie
import com.example.movierecap.domain.repository.MovieRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class MovieRepositoryImpl(
    private val apiService: MovieApiService,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : MovieRepository {
    override fun getAllMovies(): Flow<List<Movie>> {
        return flow {
            emit(apiService.getAllMovies().map { it.toMovie() })
        }.flowOn(dispatcher)
    }

    override fun getMovieById(movieId: Int): Flow<Movie?> {
        return flow {
            emit(apiService.getMovieById(movieId).toMovie())
        }.flowOn(dispatcher)
    }
}