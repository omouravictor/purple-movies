package com.example.purplemovies.ui.movies.bestrated

import com.example.purplemovies.data.local.dao.MovieDao
import com.example.purplemovies.data.local.entity.MovieEntity
import com.example.purplemovies.data.network.model.RequestStatus
import com.example.purplemovies.data.network.model.tmdbapi.TmdbApi
import com.example.purplemovies.data.network.model.tmdbapi.movies.MoviesResponse
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class BestRatedLocalRepository @Inject constructor(
    private val movieDao: MovieDao
) {
    fun getAllMovies(): Flow<List<MovieEntity>> {
        return movieDao.getMovies()
    }

    suspend fun insertMovies(movieList: List<MovieEntity>) {
        movieDao.insertMovies(movieList)
    }

    suspend fun removeAllMovies() {
        movieDao.removeAllMovies()
    }
}

class BestRatedApiRepository @Inject constructor(
    private val tmdbApi: TmdbApi
) {
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