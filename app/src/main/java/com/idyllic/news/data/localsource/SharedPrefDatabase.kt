package com.idyllic.news.data.localsource

import android.content.SharedPreferences
import javax.inject.Inject

class SharedPrefDatabase @Inject constructor(private val sharedPref: SharedPreferences) : SharedPrefDatabaseIntr {


    override fun isFirstTime(): Boolean = sharedPref.getBoolean("FirstTime", true)

    override fun setFirstTime() {
        sharedPref.edit().putBoolean("FirstTime", false).apply()
    }


}