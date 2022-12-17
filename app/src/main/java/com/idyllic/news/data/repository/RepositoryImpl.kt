package com.idyllic.news.data.repository

import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.idyllic.news.data.remotesource.NewsApi
import com.idyllic.news.domain.pojo.ErrorResponse
import com.idyllic.news.domain.pojo.NewsResponse
import com.idyllic.news.domain.repository.RepositoryIntr
import com.idyllic.news.utils.NewsResource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class RepositoryImpl @Inject constructor(val api: NewsApi) : RepositoryIntr {
    override fun getAllArticles(apisKey: String): Flow<NewsResource<NewsResponse>> = flow {
         emit(NewsResource.Loading)
        val res = api.getAllArticles()
        Log.i("TAG", "getAllArticles: " + res.body())

        if (res.isSuccessful) {
            Log.i("TAG", "success: " + res.body()!!.articles.size)
            emit(NewsResource.Success(res.body()!!))
        }

        else{
            val gson = Gson()
            val type = object : TypeToken<ErrorResponse>() {}.type
            var errorResponse: ErrorResponse? = gson.fromJson(res.errorBody()!!.charStream(), type)
            Log.i("TAG", "getAllArticles: " + errorResponse)
        }

    }

    override suspend fun getAllArticlesUsingPagination(
        pageNumber: Int
    ): NewsResource<NewsResponse> {

        return try {
            val res = api.getAllArticlesUsingPagination(pageNum = pageNumber)
            NewsResource.Success(res.body()!!)
        } catch (ioEx: IOException) {
            NewsResource.Failed("check your network")
        }
    }
}