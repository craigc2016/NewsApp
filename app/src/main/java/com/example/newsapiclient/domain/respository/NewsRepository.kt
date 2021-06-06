package com.example.newsapiclient.domain.respository

import com.example.newsapiclient.data.model.APIResponse
import com.example.newsapiclient.data.model.Article
import com.example.newsapiclient.data.util.Resource
import kotlinx.coroutines.flow.Flow


/**
 *Created by Craig Cormack on 25/05/2021.
 */
interface NewsRepository {

    suspend fun getNewsHeadlines(country: String, page : Int) : Resource<APIResponse>
    suspend fun getSearchedNews(country: String, searchQuery: String, page: Int) : Resource<APIResponse>
    suspend fun saveNews(article: Article)
    suspend fun deleteNews(article: Article)
    fun getSavedNews() : Flow<List<Article>>
}