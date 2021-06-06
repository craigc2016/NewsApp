package com.example.newsapiclient.data.repository.datasourceimpl

import com.example.newsapiclient.data.db.ArticleDao
import com.example.newsapiclient.data.model.Article
import com.example.newsapiclient.data.repository.datasource.NewsLocalDataSource
import kotlinx.coroutines.flow.Flow


/**
 *Created by Craig Cormack on 26/05/2021.
 */
class NewsLocalDataSourceImpl(
    private val articleDao: ArticleDao
) : NewsLocalDataSource {

    override suspend fun saveArticleToDB(article: Article) {
       articleDao.insert(article)
    }

    override fun getSavedArticles(): Flow<List<Article>> {
        return articleDao.getAllArticles()
    }

    override suspend fun deleteArticlesFromDB(article: Article) {
        articleDao.deleteArticle(article)
    }
}