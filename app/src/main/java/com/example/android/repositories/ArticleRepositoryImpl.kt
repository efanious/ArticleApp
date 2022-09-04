package com.example.android.repositories

import com.example.android.data.ArticleApi
import com.example.android.data.dto.ArticlesResponseDto
import com.example.android.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject


class ArticleRepositoryImpl @Inject constructor(private val articleApi: ArticleApi) :
    ArticleRepository {

    override suspend fun getPopularArticles(): Flow<Resource<ArticlesResponseDto>> = flow {
        emit(Resource.Loading())

        try {
            emit(Resource.Success(articleApi.getPopularArticles()))

        } catch (e: HttpException) {
            emit(
                Resource.Error(
                    message = "Oops something went wrong! " + e.message
                )
            )
        } catch (e: IOException) {
            emit(
                Resource.Error(
                    message = "Oops something went wrong! " + e.message
                )
            )
        }
    }
}