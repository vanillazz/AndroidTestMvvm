package com.ardyyy.dev.androidmvvm.data.models.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class HomeApiResponse(
    @Json(name = "data")
    val data: List<DataHome>
)

@JsonClass(generateAdapter = true)
data class DataHome(
    @Json(name = "items")
    val items: List<ItemHome>,
    @Json(name = "section")
    val section: String?,
    @Json(name = "section_title")
    val section_title: String?
)

@JsonClass(generateAdapter = true)
data class ItemHome(
    @Json(name = "article_image")
    val article_image: String?,
    @Json(name = "article_title")
    val article_title: String?,
    @Json(name = "link")
    val link: String?,
    @Json(name = "product_image")
    val product_image: String?,
    @Json(name = "product_name")
    val product_name: String?
)