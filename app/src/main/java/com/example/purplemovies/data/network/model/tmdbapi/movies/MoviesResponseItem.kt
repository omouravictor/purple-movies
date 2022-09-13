package com.example.purplemovies.data.network.model.tmdbapi.movies

data class MoviesResponseItem(
    val genres: List<String>,
    val id: Int,
    val poster_url: String,
    val release_date: String,
    val title: String,
    val vote_average: Double
)