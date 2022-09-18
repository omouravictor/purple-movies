package com.example.purplemovies.data.local.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "movie_table")
data class MovieEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val poster_url: String,
    val release_date: String,
    val title: String,
    val vote_average: Double
) : Parcelable