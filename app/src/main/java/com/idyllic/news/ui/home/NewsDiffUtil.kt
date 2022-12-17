package com.idyllic.news.ui.home

import androidx.recyclerview.widget.DiffUtil
import com.idyllic.news.domain.pojo.Article

object NewsDiffUtil : DiffUtil.ItemCallback<Article>() {
    override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
        return oldItem == newItem
    }
}