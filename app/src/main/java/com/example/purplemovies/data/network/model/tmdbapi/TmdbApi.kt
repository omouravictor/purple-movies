package com.example.purplemovies.data.network.model.tmdbapi

import com.example.purplemovies.data.network.model.tmdbapi.moviedetails.MovieDetailsResponse
import com.example.purplemovies.data.network.model.tmdbapi.movies.MoviesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TmdbApi {

    @GET("/movies-v2")
    suspend fun getMovies(
    ): Response<MoviesResponse>

    @GET("/movies-v2")
    suspend fun getMovieDetail(
        @Query("id") movieId: Int
    ): Response<MovieDetailsResponse>

}