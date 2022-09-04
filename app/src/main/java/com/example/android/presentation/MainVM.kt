package com.example.android.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.data.dto.ArticlesResponseDto
import com.example.android.repositories.ArticleRepositoryImpl
import com.example.android.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainVM @Inject constructor(private val articleRepositoryImpl: ArticleRepositoryImpl) :
    ViewModel() {

    private val _response = MutableLiveData<Resource<ArticlesResponseDto>>()

    val response: LiveData<Resource<ArticlesResponseDto>>
        get() = _response

    fun getArticles() {

        viewModelScope.launch {

            articleRepositoryImpl.getPopularArticles().collect { result ->

                when (result) {
                    is Resource.Success -> {
                        _response.postValue(Resource.Success(result.data))
                    }
                    is Resource.Error -> {
                        _response.postValue(result.message?.let { Resource.Error(it) })
                    }
                    is Resource.Loading -> {
                        _response.postValue(Resource.Loading(null))
                    }
                }
            }
        }
    }

}