package com.idyllic.news.utils

import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar

object Common {

    const val BASE_URL = "https://newsapi.org/v2/"
    const val API_KEY = "cc73e45ff8d745df99c30e4aa7e33379"

}

fun Fragment.showSnackBar(view: View, message: String) {
    Snackbar.make(view, message, Snackbar.LENGTH_SHORT).show()
}