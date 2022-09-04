package com.example.android.data

import com.example.android.data.dto.ArticlesResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ArticleApi {

//    https://api.nytimes.com/svc/mostpopular/v2/emailed/7.json?api-key=fjT8nWGCSNJAPGfXGvlPz7zPJoBLfmFp

    @GET("/v2/emailed/7.json")
    suspend fun getPopularArticles(
        @Query("api-key") apiKey: String = "fjT8nWGCSNJAPGfXGvlPz7zPJoBLfmFp"
    ): ArticlesResponseDto
}