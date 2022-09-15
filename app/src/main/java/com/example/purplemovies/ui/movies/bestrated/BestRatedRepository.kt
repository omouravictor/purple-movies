package com.example.purplemovies.ui.movies.bestrated

import com.example.purplemovies.data.network.model.RequestStatus
import com.example.purplemovies.data.network.model.tmdbapi.TmdbApi
import com.example.purplemovies.data.network.model.tmdbapi.movies.MoviesResponse
import javax.inject.Inject

class BestRatedApiRepository @Inject constructor(private val tmdbApi: TmdbApi) {
    suspend fun getMovies(): RequestStatus<MoviesResponse> {
        return try {
            val response = tmdbApi.getMovies()
            val responseBody = response.body()
            if (response.isSuccessful && responseBody != null)
                RequestStatus.Success(responseBody)
            else
                RequestStatus.Error(response.message())
        } catch (e: Exception) {
            RequestStatus.Error("An error occurred")
        }
    }
}