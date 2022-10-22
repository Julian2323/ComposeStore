package com.example.composestore.presentation.product_list


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.composestore.common.components.CustomScaffold
import com.example.composestore.presentation.Screen
import com.example.composestore.presentation.product_list.components.ProductListItem
import com.example.composestore.presentation.product_list.components.SearchBar


@Composable
fun ProductListScreen(
    navController: NavController,
    viewModel: ProductListViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .padding(top = 16.dp)
        ) {
            Text(
                text = "Hi, Julian",
                style = MaterialTheme.typography.h3,
                color = Color.Black,
                modifier = Modifier.padding(horizontal = 12.dp)
            )
            Spacer(modifier = Modifier.height(15.dp))
            SearchBar(
                hint = "Search...",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                //ViewModel Function to Impl Search Functionality
                viewModel.searchProductList(it)
            }
            Spacer(modifier = Modifier.height(15.dp))

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(20.dp)
            ) {
                items(state.products) { product ->
                    ProductListItem(
                        product = product,
                        onItemClicked = {
                            navController.navigate(Screen.ProductDetailScreen.route + "/${product.id}")
                        }
                    )
                }
            }
        }


        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }
        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}

@Composable
fun ProductListScreenImpl(
    navController: NavController
) {
    CustomScaffold(navController) {
        ProductListScreen(navController)
    }
}