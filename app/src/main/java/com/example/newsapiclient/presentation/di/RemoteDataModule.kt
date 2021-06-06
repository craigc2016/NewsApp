package com.example.newsapiclient.presentation.di

import com.example.newsapiclient.data.api.NewsAPIService
import com.example.newsapiclient.data.repository.datasource.NewsRemoteDataSource
import com.example.newsapiclient.data.repository.datasourceimpl.NewsRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


/**
 *Created by Craig Cormack on 25/05/2021.
 */
@InstallIn(SingletonComponent::class)
@Module
class RemoteDataModule {

    @Singleton
    @Provides
    fun providesNewsRemoteDataSource(
        newsAPIService: NewsAPIService
    ) : NewsRemoteDataSource {
        return NewsRemoteDataSourceImpl(newsAPIService)
    }
}