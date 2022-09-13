package com.example.purplemovies.data.network.model.tmdbapi.moviedetails

data class MovieDetailsResponse(
    val adult: Boolean,
    val backdrop_url: String,
    val belongs_to_collection: BelongsToCollectionItem,
    val budget: Int,
    val genres: List<String>,
    val homepage: Any,
    val id: Int,
    val imdb_id: String,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_url: String,
    val production_companies: List<ProductionCompanyItem>,
    val production_countries: List<ProductionCountryItem>,
    val release_date: String,
    val revenue: Int,
    val runtime: Int,
    val spoken_languages: List<SpokenLanguageItem>,
    val status: String,
    val tagline: String,
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int
)