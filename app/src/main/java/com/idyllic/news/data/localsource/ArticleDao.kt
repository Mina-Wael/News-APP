package com.idyllic.news.data.localsource

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.idyllic.news.domain.pojo.Article

@Dao
interface ArticleDao {

    @Insert(onConflict = REPLACE)
     fun insertArticle(article: Article)

    @Query("Select * from Article")
    fun getAllArticles(): List<Article>

    @Delete
    fun deleteArticle(article: Article)

    @Query("select * from article where id=:id")
    fun getSingleArticle(id: Int): Article

}