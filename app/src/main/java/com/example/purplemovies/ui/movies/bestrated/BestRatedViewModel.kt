package com.example.purplemovies.ui.movies.bestrated

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BestRatedViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Melhores avaliados"
    }
    val text: LiveData<String> = _text
}