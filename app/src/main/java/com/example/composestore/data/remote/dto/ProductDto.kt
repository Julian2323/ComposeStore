package com.example.composestore.data.remote.dto

import com.example.composestore.domain.model.Product
import com.google.gson.annotations.SerializedName

data class ProductDto(
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

/*fun ProductDto.toProduct(): Product {
    return Product(
        category = category,
        description = description,
        id = id,
        image = image,
        price = price,
        title = title,
        rating = ratingDto.toDomain()
    )
}*/
internal fun ProductDto.toDomain(): Product {
    return Product(
        category = category,
        description = description,
        id = id,
        image = image,
        price = price,
        rating = ratingDto.toDomain(),
        title = title
    )
}

