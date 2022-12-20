package com.idyllic.news.data.localsource

interface SharedPrefDatabaseIntr {

    fun isFirstTime(): Boolean

    fun setFirstTime()

}