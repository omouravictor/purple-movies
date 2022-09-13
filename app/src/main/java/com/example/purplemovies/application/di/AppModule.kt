package com.example.purplemovies.application.di

import com.example.purplemovies.data.network.model.tmdbapi.TmdbApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideTmdbApi(): TmdbApi = Retrofit.Builder()
        .baseUrl("https://desafio-mobile.nyc3.digitaloceanspaces.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(TmdbApi::class.java)
}