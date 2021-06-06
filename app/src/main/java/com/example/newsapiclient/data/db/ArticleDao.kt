package com.example.newsapiclient.data.db

import androidx.room.*
import com.example.newsapiclient.data.model.Article
import kotlinx.coroutines.flow.Flow


/**
 *Created by Craig Cormack on 26/05/2021.
 */
@Dao
interface ArticleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(article: Article)

    @Query("SELECT * FROM articles")
    fun getAllArticles(): Flow<List<Article>>

    @Delete
    suspend fun deleteArticle(article: Article)

}