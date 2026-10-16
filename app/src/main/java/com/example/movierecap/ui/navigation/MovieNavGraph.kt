package com.example.movierecap.ui.navigation

import kotlinx.serialization.Serializable

/*
enum class MovieNavGraph {
    MOVIE_LIST,
    MOVIE_DETAIL(
        val id : String,
    )
}
 */

sealed class MovieNavGraph {

    @Serializable
    data object MovieList : MovieNavGraph()

    @Serializable
    data class MovieDetails(
        val id: Int,
    ) : MovieNavGraph()

}











