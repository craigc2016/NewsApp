package com.example.newsapiclient.presentation.di

import com.example.newsapiclient.presentation.adapter.NewsAdapter
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
class AdapterModule {

    @Singleton
    @Provides
    fun providesNewsAdapter() : NewsAdapter = NewsAdapter()
}