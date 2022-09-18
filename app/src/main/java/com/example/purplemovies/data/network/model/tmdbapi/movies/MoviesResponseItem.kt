package com.example.purplemovies.data.network.model.tmdbapi.movies

import com.example.purplemovies.data.local.entity.MovieEntity

data class MoviesResponseItem(
    val genres: List<String>,
    val id: Int,
    val poster_url: String,
    val release_date: String,
    val title: String,
    val vote_average: Double
)

fun MoviesResponseItem.toMovieEntity(): MovieEntity {
    return MovieEntity(
        id = this.id,
        poster_url = this.poster_url,
        release_date = this.release_date,
        title = this.title,
        vote_average = this.vote_average
    )
}