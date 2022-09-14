package com.example.purplemovies.ui.movies.bestrated

import com.example.purplemovies.ResultState
import com.example.purplemovies.data.network.model.tmdbapi.TmdbApi
import com.example.purplemovies.data.network.model.tmdbapi.movies.MoviesResponse
import javax.inject.Inject

class BestRatedApiRepository @Inject constructor(private val tmdbApi: TmdbApi) {
    suspend fun getMovies(): ResultState<MoviesResponse?> {
        return try {
            val response = tmdbApi.getMovies()
            val responseBody = response.body()
            if (response.isSuccessful && responseBody != null)
                ResultState.Success(responseBody)
            else
                ResultState.Error(response.message())
        } catch (e: Exception) {
            ResultState.Error("An error occurred")
        }
    }
}