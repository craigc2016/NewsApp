package com.example.newsapiclient.data.repository.datasource

import com.example.newsapiclient.data.model.APIResponse
import retrofit2.Response


/**
 *Created by Craig Cormack on 25/05/2021.
 */
interface NewsRemoteDataSource {

    suspend fun getTopHeadlines(country:String, page: Int) : Response<APIResponse>
    suspend fun getSearchedNews(country:String, searchQuery: String,  page: Int) : Response<APIResponse>
}