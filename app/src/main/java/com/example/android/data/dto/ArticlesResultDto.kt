package com.example.android.data.dto

import com.example.android.models.ArticlesResult

data class ArticlesResultDto(
    val uri: String?,
    val url: String?,
    val id: Double?,
    val asset_id: Double?,
    val source: String?,
    val published_date: String?,
    val title: String?,
    val media: List<MediaDto>?

) {
    fun toArticlesResult(): ArticlesResult {
        return ArticlesResult(
            uri = uri,
            url = url,
            id = id,
            asset_id = asset_id,
            source = source,
            published_date = published_date,
            title = title
        )
    }
}
