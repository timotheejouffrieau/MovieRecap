package com.example.movierecap.data.model

data class Movie(
    val id : Int,
    val title: String,
    val author: String,
    val rate: Float,
    val posterUrl: String = ""
)
