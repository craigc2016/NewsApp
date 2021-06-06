package com.example.newsapiclient.domain.usecase

import com.example.newsapiclient.data.model.Article
import com.example.newsapiclient.domain.respository.NewsRepository
import kotlinx.coroutines.flow.Flow


/**
 *Created by Craig Cormack on 25/05/2021.
 */
class GetSavedNewsUseCase(private val newsRepository: NewsRepository) {

   fun execute() : Flow<List<Article>> {
       return newsRepository.getSavedNews()
   }
}