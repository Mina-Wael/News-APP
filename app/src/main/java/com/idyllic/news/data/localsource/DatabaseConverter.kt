package com.idyllic.news.data.localsource

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.idyllic.news.domain.pojo.Source

class DatabaseConverter {

    @TypeConverter
    fun convertSourceToGson(source: Source): String {
        return Gson().toJson(source)
    }

    @TypeConverter
    fun convertGsonToSource(gson: String): Source {
        return Gson().fromJson(gson, Source::class.java)
    }
}