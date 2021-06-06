package com.example.newsapiclient.domain.usecase

import com.example.newsapiclient.data.model.Article
import com.example.newsapiclient.domain.respository.NewsRepository


/**
 *Created by Craig Cormack on 25/05/2021.
 */
class SaveNewsUseCase(private val newsRepository: NewsRepository) {
    suspend fun execute(article: Article)  = newsRepository.saveNews(article)
}