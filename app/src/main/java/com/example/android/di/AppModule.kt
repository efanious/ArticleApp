package com.example.android.di

import com.example.android.data.ArticleApi
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesGson(): Gson = GsonBuilder().setLenient().create()

    @Provides
    @Singleton
    fun providesPopularArticles(gson: Gson): ArticleApi {
        return Retrofit.Builder()
            .baseUrl("https://api.nytimes.com/svc/mostpopular")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ArticleApi::class.java)
    }

}