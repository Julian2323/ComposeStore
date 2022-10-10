package com.example.composestore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composestore.presentation.Screen
import com.example.composestore.presentation.product_detail.ProductDetailScreen
import com.example.composestore.presentation.product_list.ProductListScreen
import com.example.composestore.ui.theme.ComposeStoreTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeStoreTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.ProductListScreen.route
                    ) {
                        composable(
                            route = Screen.ProductListScreen.route
                        ) {
                            ProductListScreen(navController)
                        }
                        composable(
                            route = Screen.ProductDetailScreen.route + "/{product_id}"
                        ) {
                            ProductDetailScreen()
                        }
                    }
                }
            }
        }
    }
}

