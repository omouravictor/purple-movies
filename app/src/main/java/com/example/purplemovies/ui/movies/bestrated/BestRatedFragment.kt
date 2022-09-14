package com.example.purplemovies.ui.movies.bestrated

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.purplemovies.databinding.FragmentBestRatedBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BestRatedFragment : Fragment() {

    private lateinit var binding: FragmentBestRatedBinding
    private val viewModel: BestRatedViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBestRatedBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        viewModel.movies.observe(viewLifecycleOwner) {
            binding.bestRatedRecyclerView.adapter = BestRatedAdapter(it)
        }
    }
}