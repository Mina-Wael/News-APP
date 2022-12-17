package com.idyllic.news.domain.pojo

data class NewsResponse(val status: String, val totalResults: Int, val articles: List<Article>)
