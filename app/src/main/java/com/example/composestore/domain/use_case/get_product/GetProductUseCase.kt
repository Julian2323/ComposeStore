package com.example.composestore.domain.use_case.get_product

import com.example.composestore.common.Resource
import com.example.composestore.data.remote.dto.ProductDetailDto
import com.example.composestore.data.remote.dto.toProductDetail
import com.example.composestore.domain.model.ProductDetail
import com.example.composestore.domain.repository.ProductRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetProductUseCase @Inject constructor(
    private val repository: ProductRepository
) {

    operator fun invoke(product_id: String): Flow<Resource<ProductDetail>> = flow {

        try {
            emit(Resource.Loading())
            val product =repository.getProduct(product_id).toProductDetail()
            emit(Resource.Success<ProductDetail>(product))
        } catch (e: HttpException) {
            emit(Resource.Error<ProductDetail>(e.localizedMessage ?: "An unexpected error has occurred."))
        } catch (e: IOException) {
            emit(Resource.Error<ProductDetail>("Couldn't reach the server, Check your internet connection"))
        }
    }
}