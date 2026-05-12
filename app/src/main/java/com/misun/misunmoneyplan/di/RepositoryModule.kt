package com.misun.misunmoneyplan.di

import com.misun.misunmoneyplan.data.repository.AssetRepositoryImpl
import com.misun.misunmoneyplan.domain.repository.AssetRepository
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
    abstract fun bindAssetRepository(
        assetRepositoryImpl: AssetRepositoryImpl
    ): AssetRepository
}
