package com.example.composestore.domain.use_case.get_products

import com.example.composestore.common.Resource
import com.example.composestore.data.remote.dto.toDomain
import com.example.composestore.domain.model.Product
import com.example.composestore.domain.repository.ProductRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetProductsUseCase @Inject constructor(
    private val repository: ProductRepository
) {

    operator fun invoke(): Flow<Resource<List<Product>>> = flow {
        try {
            emit(Resource.Loading<List<Product>>())
            val products = repository.getAllProducts().map { it.toDomain() }
            emit(Resource.Success<List<Product>>(products))
        } catch (e: HttpException) {
            emit(Resource.Error<List<Product>>(e.localizedMessage ?: "An unexpected error occurred."))
        } catch (e: IOException) {
            emit(Resource.Error<List<Product>>("Couldn't reach server. Check your internet connection."))
        }
    }
}