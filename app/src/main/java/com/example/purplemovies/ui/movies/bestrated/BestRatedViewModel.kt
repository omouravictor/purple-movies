package com.example.purplemovies.ui.movies.bestrated

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.purplemovies.data.network.model.RequestStatus
import com.example.purplemovies.data.network.model.tmdbapi.movies.MoviesResponseItem
import com.example.purplemovies.ui.UiResultStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BestRatedViewModel @Inject constructor(
    private val apiRepository: BestRatedApiRepository
) : ViewModel() {

    var moviesResult = MutableLiveData<UiResultStatus<List<MoviesResponseItem>>>()

    init {
        getBestRatedMovies()
    }

    fun getBestRatedMovies() {
        viewModelScope.launch {
            moviesResult.postValue(UiResultStatus.Loading)
            when (val request = apiRepository.getMovies()) {
                is RequestStatus.Success -> {
                    moviesResult.postValue(UiResultStatus.Success(request.data))
                }
                is RequestStatus.Error -> {
                    moviesResult.postValue(UiResultStatus.Error(request.errorMessage))
                }
            }
        }
    }
}