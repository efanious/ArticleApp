package com.example.android.repositories

import com.example.android.data.dto.ArticlesResponseDto
import com.example.android.util.Resource
import kotlinx.coroutines.flow.Flow

interface ArticleRepository {

    suspend fun getPopularArticles(): Flow<Resource<ArticlesResponseDto>>
}