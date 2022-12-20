package com.idyllic.news.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.idyllic.news.MainActivity
import com.idyllic.news.databinding.FragmentHomeBinding
import com.idyllic.news.utils.NewsResult
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlin.math.log

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    lateinit var newsAdapter: NewsAdapter
    var i = 1

    val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onResume() {
        super.onResume()

        if (!viewModel.isNavViewVisible) {
            (activity as MainActivity).showNavigationBottom()
            (activity as MainActivity).supportActionBar!!.show()
            viewModel.isNavViewVisible = true
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpRecycler()
        observeNewsList()

    }

    private fun setUpRecycler() {
        newsAdapter = NewsAdapter(NewsDiffUtil)
        binding.mainRv.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun observeNewsList() {
        lifecycleScope.launchWhenCreated {
            viewModel.newsList.collectLatest {
                newsAdapter.submitData(it)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}