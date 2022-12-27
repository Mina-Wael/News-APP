package com.idyllic.news.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.idyllic.news.databinding.MainRvRowBinding
import com.idyllic.news.domain.pojo.Article

class NewsAdapter(
    val onClick: (article: Article) -> Unit,
    diffCallback: DiffUtil.ItemCallback<Article>
) :
    PagingDataAdapter<Article, NewsAdapter.NewsHolder>(
        diffCallback
    ) {


    inner class NewsHolder(private val context: Context, private val binding: MainRvRowBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun setData(article: Article) {
            Glide.with(context).load(article.urlToImage).into(binding.image)
            binding.tvTitle.text = article.title
        }
        fun onItemClick(article: Article){
            binding.root.setOnClickListener {
                onClick(article)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsHolder {
        val binding = MainRvRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewsHolder(parent.context, binding)
    }

    override fun onBindViewHolder(holder: NewsHolder, position: Int) {
        holder.setData(getItem(position)!!)
        holder.onItemClick(getItem(position)!!)
    }


}