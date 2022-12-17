package com.idyllic.news.data.remotesource

import com.idyllic.news.domain.pojo.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface NewsApi {


    @GET("everything")
    suspend fun getAllArticles(
        @Header("X-Api-Key") apiKey: String = "4ae54b98e70842769138e04879873836",
        @Query("page") page: Int = 2,
        @Query("pageSize") pageSize: Int = 20
    ): Response<NewsResponse>

    @GET("top-headlines")
    suspend fun getAllArticlesUsingPagination(
        @Header("X-Api-Key") apiKey: String = "4ae54b98e70842769138e04879873836",
        @Query("page") pageNum: Int?,
        @Query("country") country: String = "us"
    ): Response<NewsResponse>


}