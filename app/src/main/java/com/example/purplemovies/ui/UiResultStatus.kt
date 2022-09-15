package com.example.purplemovies.ui

sealed class UiResultStatus<out T> {
    object Loading : UiResultStatus<Nothing>()
    data class Success<out T>(val data: T) : UiResultStatus<T>()
    data class Error(val errorMessage: String) : UiResultStatus<Nothing>()
}
