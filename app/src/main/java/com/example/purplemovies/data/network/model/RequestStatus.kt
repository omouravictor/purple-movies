package com.example.purplemovies.data.network.model

sealed class RequestStatus<out T> {
    data class Success<out T>(val data: T) : RequestStatus<T>()
    data class Error(val errorMessage: String) : RequestStatus<Nothing>()
}
