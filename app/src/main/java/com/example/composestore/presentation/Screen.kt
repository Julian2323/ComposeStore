package com.example.composestore.presentation

sealed class Screen(val route: String) {
    object ProductListScreen: Screen("product_list_screen")
    object ProductDetailScreen: Screen("product_detail_screen")
}