package com.idyllic.news.data.repository

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.idyllic.news.data.remotesource.NewsApi
import com.idyllic.news.domain.pojo.Article


class NewsPagingSource(val api: NewsApi) : PagingSource<Int, Article>() {
    override fun getRefreshKey(state: PagingState<Int, Article>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {
        var nextKey = params.key

        val res = api.getAllArticlesUsingPagination(pageNum = nextKey)

        Log.i("TAG", "load: $nextKey" + " size " + res.body()?.articles?.size)
        if (res.body() == null)
            nextKey = null
        return LoadResult.Page(res.body()?.articles ?: emptyList(), null, nextKey)
    }
}