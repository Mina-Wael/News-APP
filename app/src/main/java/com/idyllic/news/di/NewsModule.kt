package com.idyllic.news.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.idyllic.news.data.localsource.ArticleDao
import com.idyllic.news.data.localsource.LocalDatabase
import com.idyllic.news.data.localsource.SharedPrefDatabase
import com.idyllic.news.data.localsource.SharedPrefDatabaseIntr
import com.idyllic.news.data.remotesource.NewsApi
import com.idyllic.news.data.repository.RepositoryImpl
import com.idyllic.news.domain.repository.RepositoryIntr
import com.idyllic.news.utils.Common.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class NewsModule {

    @Provides
    @Singleton
    fun getApi(): NewsApi =
        Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
            .build().create(NewsApi::class.java)

    @Provides
    @Singleton
    fun getRepo(newsApi: NewsApi): RepositoryIntr = RepositoryImpl(newsApi)

    @Provides
    @Singleton
    fun provideSharedPref(context: Application): SharedPreferences =
        context.getSharedPreferences("SharedPref", Context.MODE_PRIVATE)

    @Provides
    @Singleton
    fun provideSharedDatabase(sharedPreferences: SharedPreferences): SharedPrefDatabaseIntr =
        SharedPrefDatabase(sharedPreferences)

    @Provides
    @Singleton
    fun provideLocalDatabase(context: Application): ArticleDao =
        Room.databaseBuilder(context, LocalDatabase::class.java, "ArticleDatabase").build().getDao()
}