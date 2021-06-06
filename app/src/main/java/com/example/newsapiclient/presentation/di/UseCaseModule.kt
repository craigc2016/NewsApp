package com.example.newsapiclient.presentation.di

import com.example.newsapiclient.domain.respository.NewsRepository
import com.example.newsapiclient.domain.usecase.*
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
class UseCaseModule {

    @Singleton
    @Provides
    fun providesGetNewsHeadlinesUseCase(
        newsRepository: NewsRepository
    ) : GetNewsHeadlinesUseCase{
        return GetNewsHeadlinesUseCase(newsRepository)
    }

    @Singleton
    @Provides
    fun providesGetSearchedNewsUseCase(
            newsRepository: NewsRepository
    ) : GetSearchedNewsUseCase{
        return GetSearchedNewsUseCase(newsRepository)
    }

    @Singleton
    @Provides
    fun providesSavedNewsUseCase(
        newsRepository: NewsRepository
    ) : SaveNewsUseCase {
        return SaveNewsUseCase(newsRepository)
    }

    @Singleton
    @Provides
    fun providesGetSavedNewsUseCase(
        newsRepository: NewsRepository
    ) : GetSavedNewsUseCase {
        return GetSavedNewsUseCase(newsRepository)
    }

    @Singleton
    @Provides
    fun providesDeleteSavedNewsUseCase(
        newsRepository: NewsRepository
    ) : DeleteSavedNewsUseCase {
        return DeleteSavedNewsUseCase(newsRepository)
    }
}