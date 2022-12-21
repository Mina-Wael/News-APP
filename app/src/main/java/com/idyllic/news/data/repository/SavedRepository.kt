package com.idyllic.news.data.repository

import com.idyllic.news.data.localsource.ArticleDao
import com.idyllic.news.domain.pojo.Article
import com.idyllic.news.domain.repository.SavedRepositoryIntr
import javax.inject.Inject

class SavedRepository @Inject constructor(private val dao: ArticleDao) : SavedRepositoryIntr {
    override suspend fun insertArticle(article: Article) {
        TODO("Not yet implemented")
    }

    override fun getAllArticles(): List<Article> {
        TODO("Not yet implemented")
    }

    override fun deleteArticle(article: Article) {
        TODO("Not yet implemented")
    }

    override fun getSingleArticle(id: Int): Article {
        TODO("Not yet implemented")
    }
}