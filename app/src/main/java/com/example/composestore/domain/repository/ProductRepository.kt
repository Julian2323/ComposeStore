package com.example.composestore.domain.repository

import com.example.composestore.data.remote.dto.ProductDetailDto
import com.example.composestore.data.remote.dto.ProductDto

interface ProductRepository {

    suspend fun getAllProducts(): List<ProductDto>

    suspend fun getProduct(product_id : String): ProductDetailDto

}