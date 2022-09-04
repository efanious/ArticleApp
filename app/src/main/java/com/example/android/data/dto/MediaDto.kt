package com.example.android.data.dto

import com.google.gson.annotations.SerializedName

data class MediaDto(
    val type: String?,
    val subtype: String?,
    val caption: String?,
    val copyright: String?,
    @SerializedName("approved_for_syndication") val approvedForSyndication: Int?,
    @SerializedName("media-metadata") val mediaMetadata: List<MediaMetaDataDto>?
)
