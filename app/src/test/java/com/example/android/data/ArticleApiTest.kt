package com.example.android.data


import com.example.android.data.dto.ArticlesResponseDto
import com.example.android.data.dto.ArticlesResultDto
import com.example.android.data.dto.MediaDto
import com.example.android.data.dto.MediaMetaDataDto
import com.example.android.repositories.ArticleRepositoryImpl
import com.google.gson.annotations.SerializedName
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever


class ArticleServiceTestMockWebServer {

    private val mediaMeta1 = MediaMetaDataDto(
        "sdsd",
        "sdwe",
        23,
        567
    )

    private val media1 = MediaDto(
        "sdsd",
        "sdsqf", "sdsd", "sdsadf", 21, listOf(mediaMeta1)
    )

    private var articleRes1 = ArticlesResultDto(
        "sdsd",
        "dsssd",
        223344.0, 2839233.0,
        "sdsdsa", "dsds",
        "tsrews",
        listOf(media1)
    )
    private val testJson = ArticlesResponseDto(
        "sdsd",
        "sds",
        1,
        listOf(articleRes1)
    )

//    @get:Rule
//    val mockWebServer = MockWebServer()
//
//
//    private val retrofit by lazy {
//        Retrofit.Builder()
//            .baseUrl(mockWebServer.url("/"))
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//    }
//
//
//    private val articleApi by lazy {
//        retrofit.create(ArticleApi::class.java)
//    }

    private val articleService: ArticleApi = mock()
    private val repository = ArticleRepositoryImpl(articleService)

    @Test
    fun getPopularArticlesEmitsArticles() = runTest {


        whenever(
            articleService.getPopularArticles()
        ).thenReturn(testJson)

        val testObserver = repository.getPopularArticles()

        //testObserver.assertValue(testJson)

//        mockWebServer.enqueue(
//            MockResponse()
//                .setBody(testJson)
//                .setResponseCode(200)
//        )
//
//        val testObserver = articleApi.getPopularArticles()
//
//        testObserver.assertValue(Joke(id, joke))

//        // WHEN
//        var posts: List<Post> = emptyList()
//        launch {
//            posts = postApi.getPosts()
//        }
//
//        advanceUntilIdle()
//
//        // THEN
//        Truth.assertThat(posts).isNotNull()
//        Truth.assertThat(posts.size).isEqualTo(100)
    }

}