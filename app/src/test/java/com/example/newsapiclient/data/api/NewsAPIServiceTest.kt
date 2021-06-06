package com.example.newsapiclient.data.api

import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.google.common.truth.Truth.assertThat


/**
 *Created by Craig Cormack on 25/05/2021.
 */
class NewsAPIServiceTest {
    private lateinit var service: NewsAPIService
    private lateinit var server: MockWebServer

    @Before
    fun setUp() {
        server = MockWebServer()
        service = Retrofit.Builder()
            .baseUrl(server.url(""))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsAPIService::class.java)
    }

    private fun enqueueMockResponse(
        fileName: String
    ) {
        val inputStream = javaClass.classLoader!!.getResourceAsStream(fileName)
        val source = inputStream.source().buffer()
        val mockResponse = MockResponse()
        mockResponse.setBody(source.readString(Charsets.UTF_8))
        server.enqueue(mockResponse)
    }

    @After
    fun tearDown() {
        server.shutdown()
    }

    @Test
    fun getTopHeadlines_sendRequest_receivedExpected() {
        runBlocking {
            enqueueMockResponse("newsresponse.json")
            val responseBody = service.getTopHeadlines("us",1).body()
            val request = server.takeRequest()
            assertThat(responseBody).isNotNull()
            assertThat(request.path).isEqualTo("/v2/top-headlines?country=us&page=1&apiKey=55ccc7a54eec4c92a39e136a50fccc8e")
        }
    }

    @Test
    fun getTopHeadlines_receivedResponse_correctPageSize() {
        runBlocking {
            enqueueMockResponse("newsresponse.json")
            val responseBody = service.getTopHeadlines("us",1).body()
            val articlesList = responseBody!!.articles
            assertThat(articlesList.size).isEqualTo(20)
        }
    }

    @Test
    fun getTopHeadlines_receivedResponse_correctContent() {
        runBlocking {
            enqueueMockResponse("newsresponse.json")
            val responseBody = service.getTopHeadlines("us",1).body()
            val articlesList = responseBody!!.articles
            val article = articlesList[0]
            assertThat(article.author).isEqualTo("Marshall Cohen, CNN")
            assertThat(article.url).isEqualTo("https://www.cnn.com/2021/05/24/politics/william-barr-memo-trump-obstruction-doj-appeal/index.html")
            assertThat(article.publishedAt).isEqualTo("2021-05-25T06:39:00Z")

        }
    }
}