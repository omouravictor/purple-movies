package com.example.purplemovies.ui.movies.bestrated

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.purplemovies.R
import com.example.purplemovies.data.network.model.tmdbapi.movies.MoviesResponseItem
import com.example.purplemovies.databinding.MovieItemLayoutBinding

class BestRatedAdapter(private var list: List<MoviesResponseItem>) :
    RecyclerView.Adapter<BestRatedAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding =
            MovieItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    class MovieViewHolder(private val binding: MovieItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: MoviesResponseItem) {
            Glide.with(itemView)
                .load(movie.poster_url)
                .fallback(R.drawable.ic_baseline_broken_image_24)
                .error(R.drawable.ic_baseline_question_mark_24)
                .into(binding.posterImageMovie)
        }
    }
}