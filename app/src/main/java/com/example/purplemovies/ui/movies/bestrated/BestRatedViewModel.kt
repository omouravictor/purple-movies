package com.example.purplemovies.ui.movies.bestrated

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.purplemovies.ResultState
import com.example.purplemovies.data.network.model.tmdbapi.movies.MoviesResponseItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BestRatedViewModel @Inject constructor(
    private val apiRepository: BestRatedApiRepository
) : ViewModel() {

    var movies = MutableLiveData<List<MoviesResponseItem>>()

    init {
        getMovies()
    }

    private fun getMovies() {
        viewModelScope.launch {
            when (val request = apiRepository.getMovies()) {
                is ResultState.Success -> {
                    movies.postValue(request.data!!)
                }
                is ResultState.Error -> {
                    println(request.message)
                }
            }
        }
    }

}