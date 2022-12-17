package com.idyllic.news.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.idyllic.news.data.remotesource.NewsApi
import com.idyllic.news.data.repository.NewsPagingSource
import com.idyllic.news.domain.pojo.Article
import com.idyllic.news.domain.repository.RepositoryIntr
import com.idyllic.news.utils.Common.API_KEY
import com.idyllic.news.utils.NewsResource
import com.idyllic.news.utils.NewsResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val api: NewsApi,
    private val repo: RepositoryIntr
) : ViewModel() {

    private val _articles = MutableLiveData<NewsResult<List<Article>>>()

    val articles: LiveData<NewsResult<List<Article>>> = _articles

    fun getAllNews() {

        repo.getAllArticles(API_KEY).onEach {
            when (it) {
                is NewsResource.Loading -> {}
                is NewsResource.Success -> {
                    _articles.postValue(NewsResult.Success(it.data.articles))
                }
                is NewsResource.Failed -> {}
            }
        }.launchIn(viewModelScope)

    }

    val newsList = Pager(PagingConfig(20)) {
        NewsPagingSource(api)
    }.flow.cachedIn(viewModelScope)
}