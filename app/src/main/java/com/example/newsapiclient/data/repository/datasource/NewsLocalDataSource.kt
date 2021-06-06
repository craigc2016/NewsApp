package com.example.newsapiclient.data.repository.datasource

import com.example.newsapiclient.data.model.Article
import kotlinx.coroutines.flow.Flow


/**
 *Created by Craig Cormack on 26/05/2021.
 */
interface NewsLocalDataSource {

    suspend fun saveArticleToDB(article: Article)

    fun getSavedArticles() : Flow<List<Article>>

    suspend fun deleteArticlesFromDB(article: Article)
}