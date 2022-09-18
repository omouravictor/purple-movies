package com.example.purplemovies.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.purplemovies.data.local.dao.MovieDao
import com.example.purplemovies.data.local.entity.MovieEntity

@Database(entities = [MovieEntity::class], version = 1)
abstract class MovieRoomDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}