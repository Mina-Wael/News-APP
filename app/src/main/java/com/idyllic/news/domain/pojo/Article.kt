package com.idyllic.news.domain.pojo

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "Article")
data class Article(
    @PrimaryKey(autoGenerate = true)
    @NotNull
    val id: Int?,
    val source: Source,
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val title: String,
    val url: String,
    val urlToImage: String
)

