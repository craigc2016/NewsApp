package com.example.newsapiclient.presentation.di

import com.example.newsapiclient.data.db.ArticleDao
import com.example.newsapiclient.data.repository.datasource.NewsLocalDataSource
import com.example.newsapiclient.data.repository.datasourceimpl.NewsLocalDataSourceImpl
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
class LocalDataModule {

    @Singleton
    @Provides
    fun providesLocalDataSource(articleDao: ArticleDao) : NewsLocalDataSource{
        return NewsLocalDataSourceImpl(articleDao)
    }
}