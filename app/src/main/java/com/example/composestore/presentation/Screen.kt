package com.example.composestore.presentation

sealed class Screen(val route: String) {
    object ProductListScreen: Screen("product_list_screen")
    object ProductDetailScreen: Screen("product_detail_screen")
    object SignupScreen: Screen("signup_screen")
    object LoginScreen: Screen("login_screen")
    object ProfileScreen: Screen("profile_screen")
    object FavoritesScreen: Screen("favorites_screen")
    object CartScreen: Screen("cart_screen")
}