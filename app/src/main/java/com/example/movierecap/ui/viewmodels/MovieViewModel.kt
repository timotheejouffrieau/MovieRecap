package com.example.movierecap.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movierecap.data.model.Movie
import com.example.movierecap.data.remote.MovieClient
import com.example.movierecap.data.repository.MovieRepositoryImpl
import com.example.movierecap.domain.repository.MovieRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MovieViewModel : ViewModel() {

    //Idéalement il faut sortir la dépendance et créer un MovieViewModelFactory
    private val movieApiService = MovieClient.create()
    private val movieRepository: MovieRepository = MovieRepositoryImpl(movieApiService)

    private val _movies = MutableStateFlow<List<Movie>>(emptyList())
    val movies: StateFlow<List<Movie>> = _movies

    private val _selectedMovie = MutableStateFlow<Movie?>(null)
    val selectedMovie: StateFlow<Movie?> = _selectedMovie

    init {
        // Simule une récupération des films
        viewModelScope.launch {
            movieRepository.getAllMovies().collect { movieList ->
                _movies.value = movieList
            }
        }
    }

    fun selectMovie(movieId: Int) {
        if (_selectedMovie.value == null || _selectedMovie.value!!.id != movieId) {
            _selectedMovie.value = null
            viewModelScope.launch {
                movieRepository.getMovieById(movieId).collect { movie ->
                    _selectedMovie.value = movie
                }
            }
        }
    }

    fun sortData(sortMode: SortMode) {
        _movies.value = when (sortMode) {
            SortMode.TITLE -> _movies.value.sortedBy { it.title }
            SortMode.AUTHOR -> _movies.value.sortedBy { it.author }
            SortMode.RATE -> _movies.value.sortedBy { it.rate }
        }
    }

    enum class SortMode(val display: String) {
        TITLE("Titre"),
        AUTHOR("Réal"),
        RATE("Note")
    }
}
