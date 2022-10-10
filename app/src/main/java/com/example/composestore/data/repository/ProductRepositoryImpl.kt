package com.example.composestore.data.repository

import com.example.composestore.data.remote.StoreApi
import com.example.composestore.data.remote.dto.ProductDetailDto
import com.example.composestore.data.remote.dto.ProductDto
import com.example.composestore.domain.repository.ProductRepository
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val api: StoreApi
) : ProductRepository {

    override suspend fun getAllProducts(): List<ProductDto> {
        return api.getAllProducts()
    }

    override suspend fun getProduct(product_id: String): ProductDetailDto {
        return api.getProduct(product_id)
    }

}