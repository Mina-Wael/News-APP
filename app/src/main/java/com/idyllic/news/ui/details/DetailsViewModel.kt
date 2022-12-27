package com.idyllic.news.ui.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.idyllic.news.domain.pojo.Article
import com.idyllic.news.domain.repository.SavedRepositoryIntr
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(private val repo: SavedRepositoryIntr) : ViewModel() {

    fun saveArticle(article: Article) {
        viewModelScope.launch(Dispatchers.IO) {
            repo.insertArticle(article)
        }
    }

    fun deleteArticle(article: Article) {
        repo.deleteArticle(article)
    }

    fun getAllArt(): List<Article> = repo.getAllArticles()
}