package com.idyllic.news.domain.repository

import com.idyllic.news.domain.pojo.Article

interface SavedRepositoryIntr {
    suspend fun insertArticle(article: Article)

    fun getAllArticles(): List<Article>

    fun deleteArticle(article: Article)

    fun getSingleArticle(id: Int): Article
}