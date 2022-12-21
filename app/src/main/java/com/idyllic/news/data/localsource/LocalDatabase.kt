package com.idyllic.news.data.localsource

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.idyllic.news.domain.pojo.Article

@Database(entities = [Article::class], version = 0)
@TypeConverters(DatabaseConverter::class)
abstract class LocalDatabase : RoomDatabase() {

    abstract fun getDao():ArticleDao

}