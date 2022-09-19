package com.example.purplemovies.ui.movies.bestrated

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.purplemovies.databinding.FragmentBestRatedBinding
import com.example.purplemovies.ui.UiResultStatus
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BestRatedFragment : Fragment() {

    private lateinit var binding: FragmentBestRatedBinding
    private val viewModel: BestRatedViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentBestRatedBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initSwipeRefreshLayout()
        initMoviesResultObserve()
        initErrorLayout()
    }

    private fun initMoviesResultObserve() {
        viewModel.moviesResult.observe(viewLifecycleOwner) {
            when (it) {
                is UiResultStatus.Loading -> {
                    binding.swipeRefreshLayout.isRefreshing = false
                    binding.progressBar.isVisible = true
                    binding.bestRatedRecyclerView.isVisible = false
                    binding.includeViewMoviesErrorState.layoutError.isVisible = false
                }
                is UiResultStatus.Success -> {
                    binding.progressBar.isVisible = false
                    binding.bestRatedRecyclerView.isVisible = true
                    binding.includeViewMoviesErrorState.layoutError.isVisible = false
                    binding.bestRatedRecyclerView.adapter = BestRatedAdapter(it.data)
                }
                is UiResultStatus.Error -> {
                    binding.progressBar.isVisible = false
                    binding.bestRatedRecyclerView.isVisible = false
                    binding.includeViewMoviesErrorState.layoutError.isVisible = true
                }
            }
        }
    }

    private fun initSwipeRefreshLayout() {
        binding.swipeRefreshLayout.setOnRefreshListener {
            viewModel.getBestRatedMovies()
        }
    }

    private fun initErrorLayout() {
        binding.includeViewMoviesErrorState.buttonTryAgain.setOnClickListener {
            viewModel.getBestRatedMovies()
        }
    }
}