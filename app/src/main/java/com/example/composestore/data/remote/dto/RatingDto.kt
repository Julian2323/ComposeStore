package com.example.composestore.data.remote.dto

import com.example.composestore.domain.model.Rating
import com.google.gson.annotations.SerializedName

data class RatingDto(
    @SerializedName("count")
    val count: Int,
    @SerializedName("rate")
    val rate: Double
)

fun RatingDto.toDomain(): Rating {
    return Rating(
        count = count,
        rate = rate
    )
}
