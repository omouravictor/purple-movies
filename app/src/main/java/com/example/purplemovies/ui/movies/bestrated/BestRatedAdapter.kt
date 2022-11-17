package com.example.purplemovies.ui.movies.bestrated

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.purplemovies.R
import com.example.purplemovies.data.local.entity.MovieEntity
import com.example.purplemovies.databinding.MovieItemLayoutBinding

class BestRatedAdapter(private var list: List<MovieEntity>) :
    RecyclerView.Adapter<BestRatedAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MovieViewHolder(
        MovieItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    class MovieViewHolder(binding: MovieItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private val bestRatedPosterImage = binding.posterImageMovie

        fun bind(movie: MovieEntity) {
            Glide.with(itemView)
                .load(movie.poster_url)
                .error(R.drawable.ic_baseline_broken_image)
                .into(bestRatedPosterImage)

            itemView.setOnClickListener {
                val action = BestRatedFragmentDirections
                    .actionBestRatedFragmentToMovieDetailsFragment(movie)
                findNavController(it).navigate(action) // Não é bom colocar navController aqui dentro
            }
        }
    }
}