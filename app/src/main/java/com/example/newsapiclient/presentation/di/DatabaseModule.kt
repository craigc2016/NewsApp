package com.example.newsapiclient.presentation.di

import android.app.Application
import androidx.room.Room
import com.example.newsapiclient.data.db.ArticleDao
import com.example.newsapiclient.data.db.ArticleDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


/**
 *Created by Craig Cormack on 26/05/2021.
 */
@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun providesNewsDatabase(app:Application) : ArticleDatabase {
        return Room.databaseBuilder(
            app,
            ArticleDatabase::class.java,
            "news_db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun providesNewDao(articleDatabase: ArticleDatabase) : ArticleDao {
        return articleDatabase.getArticleDao()
    }
}