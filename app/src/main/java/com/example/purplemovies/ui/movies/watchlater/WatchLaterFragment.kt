package com.example.purplemovies.ui.movies.watchlater

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.purplemovies.databinding.FragmentWatchLaterBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WatchLaterFragment : Fragment() {

    private var _binding: FragmentWatchLaterBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val watchLaterViewModel = ViewModelProvider(this)[WatchLaterViewModel::class.java]

        _binding = FragmentWatchLaterBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.watchLaterText
        watchLaterViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}