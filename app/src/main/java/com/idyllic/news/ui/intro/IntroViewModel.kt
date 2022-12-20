package com.idyllic.news.ui.intro


import androidx.lifecycle.ViewModel
import com.idyllic.news.data.localsource.SharedPrefDatabaseIntr
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class IntroViewModel @Inject constructor(private val database: SharedPrefDatabaseIntr) : ViewModel() {

    fun isFirstTime(): Boolean = database.isFirstTime()

    fun setFirstTime() = database.setFirstTime()


}