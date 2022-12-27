package com.idyllic.news.data.repository

import com.idyllic.news.data.localsource.ArticleDao
import com.idyllic.news.domain.pojo.Article
import com.idyllic.news.domain.repository.SavedRepositoryIntr
import javax.inject.Inject

class SavedRepository @Inject constructor(private val dao: ArticleDao) : SavedRepositoryIntr {

    override suspend fun insertArticle(article: Article) {
        dao.insertArticle(article)
    }

    override fun getAllArticles(): List<Article> = dao.getAllArticles()

    override fun deleteArticle(article: Article) {
        dao.deleteArticle(article)
    }

    override fun getSingleArticle(id: Int): Article = dao.getSingleArticle(id)

}