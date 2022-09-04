package com.example.android.data.dto

data class ArticlesResponseDto(
    val status: String?,
    val copyright: String?,
    val num_results: Int?,
    val results: List<ArticlesResultDto>?
)
