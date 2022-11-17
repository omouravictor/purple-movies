package com.example.purplemovies.ui.movies.moviedetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.purplemovies.R
import com.example.purplemovies.data.local.entity.MovieEntity
import com.example.purplemovies.databinding.FragmentMovieDetailsBinding
import org.joda.time.LocalDate

class MovieDetailsFragment : Fragment() {

    private lateinit var binding: FragmentMovieDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentMovieDetailsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.get("movie_argument")?.also {
            it as MovieEntity

            Glide.with(view)
                .load(it.poster_url)
                .error(R.drawable.ic_baseline_broken_image)
                .into(binding.imageViewMovieBackdrop)

            Glide.with(view)
                .load(it.poster_url)
                .error(R.drawable.ic_baseline_broken_image)
                .into(binding.includeMovieItemLayout.posterImageMovie)

            binding.textViewMovieDetailsTitle.text = it.title

            val dateRelease = LocalDate.parse(it.release_date)
            binding.textViewMovieDetailsReleaseDate.text = dateRelease.year.toString()

            binding.textViewMovieDetailsVoteAverage.text = it.vote_average.toString()
        }
    }
}