package com.idyllic.news.utils

sealed class NewsResource<out R> {
    object Loading : NewsResource<Nothing>()
    class Success<T>(val data: T) : NewsResource<T>()
    class Failed(val message: String) : NewsResource<Nothing>()

}
