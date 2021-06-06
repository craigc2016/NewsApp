package com.example.newsapiclient.domain.usecase

import com.example.newsapiclient.data.model.APIResponse
import com.example.newsapiclient.domain.respository.NewsRepository
import com.example.newsapiclient.data.util.Resource


/**
 *Created by Craig Cormack on 25/05/2021.
 */
class GetNewsHeadlinesUseCase(private val newsRepository: NewsRepository) {

    suspend fun execute(country: String, page: Int) : Resource<APIResponse> {
        return newsRepository.getNewsHeadlines(country,page)
    }

}