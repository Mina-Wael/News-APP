package com.idyllic.news.utils

sealed class NewsResult<out R> {

    object Loading : NewsResult<Nothing>()
    class Success<T>(val data: T) : NewsResult<T>()
    class Failed(val message: String) : NewsResult<Nothing>()

}
