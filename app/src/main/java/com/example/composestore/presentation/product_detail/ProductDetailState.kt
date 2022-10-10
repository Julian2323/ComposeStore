package com.example.composestore.presentation.product_detail

import com.example.composestore.domain.model.ProductDetail

data class ProductDetailState(
    val isLoading: Boolean = false,
    val product: ProductDetail?= null,
    val error: String = ""
)