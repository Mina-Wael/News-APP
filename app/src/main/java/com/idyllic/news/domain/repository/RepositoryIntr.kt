package com.idyllic.news.domain.repository

import com.idyllic.news.domain.pojo.NewsResponse
import com.idyllic.news.utils.NewsResource
import kotlinx.coroutines.flow.Flow

interface RepositoryIntr {

    fun getAllArticles(apisKey: String): Flow<NewsResource<NewsResponse>>
    suspend fun getAllArticlesUsingPagination(
        pageNumber: Int
    ): NewsResource<NewsResponse>
}