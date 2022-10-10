package com.example.composestore.presentation.product_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composestore.common.Constants
import com.example.composestore.common.Resource
import com.example.composestore.domain.use_case.get_product.GetProductUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ProductDetailViewModel @Inject constructor(
    private val getProductUseCase: GetProductUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(ProductDetailState())
    val state: State<ProductDetailState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_PRODUCT_ID)?.let { product_id ->
            getProduct(product_id)
        }
    }

    private fun getProduct(product_id : String) {
        getProductUseCase(product_id).onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _state.value = ProductDetailState(product = result.data )
                }
                is Resource.Error -> {
                    _state.value = ProductDetailState(error = result.message ?: "An unexpected error occurred.")
                }
                is Resource.Loading -> {
                    _state.value = ProductDetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}