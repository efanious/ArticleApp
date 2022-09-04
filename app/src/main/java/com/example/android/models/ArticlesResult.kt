package com.example.android.models

import android.os.Parcel
import android.os.Parcelable

data class ArticlesResult(
    val uri: String?,
    val url: String?,
    val id: Double?,
    val asset_id: Double?,
    val source: String?,
    val published_date: String?,
    val title: String?,

    ) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(uri)
        parcel.writeString(url)
        parcel.writeValue(id)
        parcel.writeValue(asset_id)
        parcel.writeString(source)
        parcel.writeString(published_date)
        parcel.writeString(title)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ArticlesResult> {
        override fun createFromParcel(parcel: Parcel): ArticlesResult {
            return ArticlesResult(parcel)
        }

        override fun newArray(size: Int): Array<ArticlesResult?> {
            return arrayOfNulls(size)
        }
    }
}