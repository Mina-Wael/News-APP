package com.idyllic.news.ui.intro

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.idyllic.news.MainActivity
import com.idyllic.news.R
import com.idyllic.news.databinding.FragmentIntroBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class IntroFragment : Fragment() {

    private var _binding: FragmentIntroBinding? = null
    private val binding get() = _binding!!

    private val viewModel: IntroViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentIntroBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (!viewModel.isFirstTime())
            navigateToHome()

        setupViewPager()
        setUpBtnNextListener()
        setUpBtnPrevListener()

        binding.btnSkip.setOnClickListener {
            viewModel.setFirstTime()
            navigateToHome()
        }
    }

    private fun navigateToHome() {
        findNavController().graph.setStartDestination(R.id.navigation_home)
        findNavController().navigate(R.id.action_navigation_notifications_to_navigation_home)
    }

    private fun setUpBtnNextListener() {
        binding.btnNext.setOnClickListener {
            if (binding.viewPager.currentItem < 2)
                binding.viewPager.currentItem = binding.viewPager.currentItem + 1
            else {
                viewModel.setFirstTime()
                navigateToHome()
            }
        }
    }

    private fun setUpBtnPrevListener() {
        binding.btnPrev.setOnClickListener {
            if (binding.viewPager.currentItem > 0)
                binding.viewPager.currentItem = binding.viewPager.currentItem - 1
        }
    }


    private fun setupViewPager() {
        val viewPagerAdapter = ViewPagerAdapter()
        binding.viewPager.apply {
            adapter = viewPagerAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}