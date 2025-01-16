package com.example.movierecap.data.remote.dto

import com.example.movierecap.data.model.Movie
import com.google.gson.annotations.SerializedName

data class MovieDto(
    @SerializedName("id") val id : Int,
    @SerializedName("title") val title: String,
    @SerializedName("director") val director: String,
    @SerializedName("rating") val rating: Float
)

fun MovieDto.toMovie() : Movie {
    return Movie(
        id = id,
        title = title,
        author = director,
        rate = rating / 2
    )
}
