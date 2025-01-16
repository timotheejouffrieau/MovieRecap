package com.example.movierecap.data.remote

import com.example.movierecap.data.remote.dto.MovieDto
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieApiService {

    @GET("api/v1/movies")
    suspend fun getAllMovies(): List<MovieDto>

    @GET("api/v1/movies/{id}")
    suspend fun getMovieById(@Path("id") movieId: Int): MovieDto

}