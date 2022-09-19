package com.example.purplemovies.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.purplemovies.data.local.entity.MovieEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {

    @Query("SELECT * from movie_table")
    fun getMovies(): Flow<List<MovieEntity>>

    @Insert
    suspend fun insertMovies(movieEntity: List<MovieEntity>)

    @Query("DELETE from movie_table")
    suspend fun removeAllMovies()
}