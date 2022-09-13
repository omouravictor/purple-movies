package com.example.purplemovies.ui.movies.watchlater

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WatchLaterViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Assistir mais tarde"
    }
    val text: LiveData<String> = _text
}