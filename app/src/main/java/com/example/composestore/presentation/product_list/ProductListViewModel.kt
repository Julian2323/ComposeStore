package com.example.composestore.presentation.product_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composestore.common.Resource
import com.example.composestore.domain.model.Product
import com.example.composestore.domain.use_case.get_products.GetProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(
    private val getProductsUseCase: GetProductsUseCase
) : ViewModel() {

    private val _state = mutableStateOf(ProductListState())
    val state: State<ProductListState> = _state

    var productList = mutableStateOf<List<Product>>(listOf())
    var loadError = mutableStateOf("")
    var isLoading = mutableStateOf(false)
    var endReached = mutableStateOf(false)

    private var cachedProductList = listOf<Product>()
    private var isSearchStarting = true
    var isSearching = mutableStateOf(false)


    init {
        getProducts()
    }

    private fun getProducts() {
        getProductsUseCase().onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _state.value = ProductListState(products = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = ProductListState(error = result.message ?: "An unexpected error has occurred.")
                }
                is Resource.Loading -> {
                    _state.value = ProductListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

    fun searchProductList(query: String) {
        val listToSearch = if (isSearchStarting) {
            productList.value
        } else {
            cachedProductList
        }
        viewModelScope.launch(Dispatchers.Default) {
            if (query.isEmpty()) {
                productList.value = cachedProductList
                isSearching.value = false
                isSearchStarting = true
                return@launch
            }
            val results = listToSearch.filter {
                it.title.contains(query.trim(), ignoreCase = true) ||
                        it.id.toString() == query.trim()
            }
            if (isSearchStarting) {
                cachedProductList = productList.value
                isSearchStarting = false
            }
            productList.value = results
            isSearching.value = true
        }
    }

}