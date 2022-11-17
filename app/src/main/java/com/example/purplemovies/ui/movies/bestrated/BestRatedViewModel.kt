package com.example.purplemovies.ui.movies.bestrated

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.purplemovies.data.local.entity.MovieEntity
import com.example.purplemovies.data.network.model.RequestStatus
import com.example.purplemovies.data.network.model.tmdbapi.movies.MoviesResponse
import com.example.purplemovies.data.repository.BestRatedApiRepository
import com.example.purplemovies.data.repository.BestRatedLocalRepository
import com.example.purplemovies.ui.UiResultStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BestRatedViewModel @Inject constructor(
    private val localRepository: BestRatedLocalRepository,
    private val apiRepository: BestRatedApiRepository
) : ViewModel() {

    private var movieFromBank: Flow<List<MovieEntity>> = localRepository.getAllMovies()
    val moviesResult = MutableLiveData<UiResultStatus<List<MovieEntity>>>()

    init {
        getBestRatedMovies()
    }

    fun getBestRatedMovies() {
        viewModelScope.launch {
            moviesResult.postValue(UiResultStatus.Loading)
            when (val request = apiRepository.getMovies()) {
                is RequestStatus.Success -> {
                    val savedMovies = saveOnDb(request.data)
                    moviesResult.postValue(UiResultStatus.Success(savedMovies))
                }
                is RequestStatus.Error -> {
                    movieFromBank.collect {
                        if (it.isNotEmpty())
                            moviesResult.postValue(UiResultStatus.Success(it))
                        else
                            moviesResult.postValue(UiResultStatus.Error(request.errorMessage))
                    }
                }
            }
        }
    }

    private suspend fun saveOnDb(data: MoviesResponse): List<MovieEntity> {
        val moviesList: MutableList<MovieEntity> = mutableListOf()
        data.forEach {
            moviesList.add(
                MovieEntity(
                    it.id,
                    it.poster_url,
                    it.release_date,
                    it.title,
                    it.vote_average
                )
            )
        }
        localRepository.removeAllMovies()
        localRepository.insertMovies(moviesList)
        return moviesList
    }
}