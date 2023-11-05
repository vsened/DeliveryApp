package com.vsened.deliveryapp.di

import com.vsened.deliveryapp.data.repository.RepositoryImpl
import com.vsened.deliveryapp.domain.repository.Repository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindStockRepository(
        repositoryImpl: RepositoryImpl
    ): Repository
}