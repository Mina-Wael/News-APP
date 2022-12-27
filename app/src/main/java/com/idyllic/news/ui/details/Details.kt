package com.idyllic.news.ui.details

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.github.ivbaranov.mfb.MaterialFavoriteButton
import com.idyllic.news.MainActivity
import com.idyllic.news.databinding.FragmentDetailsBinding
import com.idyllic.news.domain.pojo.Article
import com.idyllic.news.utils.showSnackBar
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class Details : Fragment() {

    val args: DetailsArgs by navArgs()

    private val viewModel: DetailsViewModel by viewModels()

    private var _binding: FragmentDetailsBinding? = null
    val binding: FragmentDetailsBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDetailsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showData(args.article)

        binding.btnSave.setOnFavoriteChangeListener(MaterialFavoriteButton.OnFavoriteChangeListener
        { buttonView, favorite ->

            if (favorite) {
                viewModel.saveArticle(args.article)
                showSnackBar(binding.root, "Saved")
            } else {
                viewModel.deleteArticle(args.article)
                showSnackBar(binding.root, "Deleted")
            }
        })

        binding.image.setOnClickListener {
            Log.i("TAG", "onViewCreated: " + viewModel.getAllArt())
        }
    }

    private fun showData(article: Article) {

        Glide.with(requireContext()).load(article.urlToImage).into(binding.image)
        binding.description.text = article.description
        binding.content.text = article.content

    }

    override fun onResume() {
        super.onResume()

        (activity as MainActivity).hideNavigationBottom()
        (activity as MainActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        (activity as MainActivity).showNavigationBottom()
    }
}