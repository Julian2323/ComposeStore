package com.example.composestore.common.components

import com.example.composestore.R

sealed class BottomNavItem(var route: String, var icon: Int, var title: String) {
    object Home : BottomNavItem("product_list_screen", R.drawable.ic_home, "Home")
    object Favorite : BottomNavItem("favorites_screen", R.drawable.ic_favorite, "Favorite")
    object Cart : BottomNavItem("cart_screen", R.drawable.ic_shopping_cart, "Cart")
    object Profile : BottomNavItem("profile_screen", R.drawable.ic_profile, "Profile")
}