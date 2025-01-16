package com.example.movierecap.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movierecap.data.model.Movie
import com.example.movierecap.data.repository.MovieRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MovieViewModel : ViewModel() {

    private val movieRepository: MovieRepository = MovieRepository()

    private val _movies = MutableStateFlow<List<Movie>>(emptyList())
    val movies: StateFlow<List<Movie>> = _movies

    private val _selectedMovie = MutableStateFlow<Movie?>(null)
    val selectedMovie: StateFlow<Movie?> = _selectedMovie

    init {
        // Simule une récupération des films
        viewModelScope.launch {
            movieRepository.getAllMovies().collect{ movieList ->
                _movies.value = movieList
            }
        }
    }

    fun selectMovie(movieId: Int) {
        if (_selectedMovie.value == null || _selectedMovie.value!!.id != movieId) {
            _selectedMovie.value = null
            viewModelScope.launch {
                movieRepository.getMovieById(movieId).collect{ movie ->
                    _selectedMovie.value = movie
                }
            }
        }
    }
}