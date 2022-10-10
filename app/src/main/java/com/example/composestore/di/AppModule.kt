package com.example.composestore.di

import com.example.composestore.common.Constants.BASE_URL
import com.example.composestore.data.remote.StoreApi
import com.example.composestore.data.repository.ProductRepositoryImpl
import com.example.composestore.domain.repository.ProductRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesStoreApi(): StoreApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(StoreApi::class.java)
    }

    @Provides
    @Singleton
    fun provideProductRepository(api: StoreApi): ProductRepository {
        return ProductRepositoryImpl(api)
    }

}