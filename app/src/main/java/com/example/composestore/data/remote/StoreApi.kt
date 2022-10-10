package com.example.composestore.data.remote

import com.example.composestore.data.remote.dto.ProductDetailDto
import com.example.composestore.data.remote.dto.ProductDto
import retrofit2.http.GET
import retrofit2.http.Path

interface StoreApi {

    @GET("products")
    suspend fun getAllProducts(): List<ProductDto>

    @GET("products/{product_id}")
    suspend fun getProduct(@Path("product_id") product_id: String): ProductDetailDto

}