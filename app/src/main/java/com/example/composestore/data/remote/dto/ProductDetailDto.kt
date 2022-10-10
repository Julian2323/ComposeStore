package com.example.composestore.data.remote.dto

import com.example.composestore.domain.model.ProductDetail
import com.google.gson.annotations.SerializedName

data class ProductDetailDto(
    @SerializedName("category")
    val category: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: String,
    @SerializedName("price")
    val price: Double,
    @SerializedName("rating")
    val ratingDto: RatingDto,
    @SerializedName("title")
    val title: String
)

fun ProductDetailDto.toProductDetail():ProductDetail {
    return ProductDetail(
        category = category,
        description = description,
        id = id,
        image = image,
        price = price,
        title = title,
        rating = ratingDto.toDomain()
    )

}