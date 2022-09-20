package com.example.purplemovies.ui.movies.moviedetails

import android.os.Bundle
import android.widget.ScrollView
import androidx.lifecycle.ViewModel
import com.bumptech.glide.Glide
import com.example.purplemovies.R
import com.example.purplemovies.data.local.entity.MovieEntity
import com.example.purplemovies.databinding.FragmentMovieDetailsBinding
import org.joda.time.LocalDate

class MovieDetailsViewModel : ViewModel() {

    fun loadMovieDetails(binding: FragmentMovieDetailsBinding, arguments: Bundle?) {
        val view = binding.root

        arguments?.get("movie_argument")?.also {
            it as MovieEntity
            setMovieDetails(view, binding, it)
        }
    }

    private fun setMovieDetails(
        view: ScrollView,
        binding: FragmentMovieDetailsBinding,
        movie: MovieEntity
    ) {
        Glide.with(view)
            .load(movie.poster_url)
            .error(R.drawable.ic_baseline_broken_image)
            .into(binding.imageViewMovieBackdrop)

        Glide.with(view)
            .load(movie.poster_url)
            .error(R.drawable.ic_baseline_broken_image)
            .into(binding.includeMovieItemLayout.posterImageMovie)

        binding.textViewMovieDetailsTitle.text = movie.title

        val dateRelease = LocalDate.parse(movie.release_date)
        binding.textViewMovieDetailsReleaseDate.text = dateRelease.year.toString()

        binding.textViewMovieDetailsVoteAverage.text = movie.vote_average.toString()
    }
}