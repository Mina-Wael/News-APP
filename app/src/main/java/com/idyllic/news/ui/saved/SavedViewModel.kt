package com.idyllic.news.ui.saved

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.idyllic.news.domain.repository.SavedRepositoryIntr
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SavedViewModel @Inject constructor(private val repo: SavedRepositoryIntr) : ViewModel() {

    fun getAllData() {
        viewModelScope.launch(Dispatchers.IO) {
            Log.i("TAG", "getAllData: " + repo.getAllArticles().size)
        }

    }
}