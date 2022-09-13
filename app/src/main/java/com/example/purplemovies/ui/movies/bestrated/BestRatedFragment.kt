package com.example.purplemovies.ui.movies.bestrated

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.purplemovies.databinding.FragmentBestRatedBinding

class BestRatedFragment : Fragment() {

    private var _binding: FragmentBestRatedBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val bestRatedViewModel = ViewModelProvider(this)[BestRatedViewModel::class.java]

        _binding = FragmentBestRatedBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.bestRatedText
        bestRatedViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}