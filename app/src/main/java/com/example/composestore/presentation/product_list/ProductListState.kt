package com.example.composestore.presentation.product_list

import com.example.composestore.domain.model.Product

data class ProductListState(
    val isLoading: Boolean = false,
    val products: List<Product> = emptyList(),
    val error: String = ""
)