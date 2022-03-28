package com.kwanwoo.android.checkpercentageapplication.di

import com.kwanwoo.android.data.repository.MainRepositoryImpl
import com.kwanwoo.android.data.repository.remote.datasource.MainDataSource
import com.kwanwoo.android.domain.repository.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideMainRepository(
        mainDataSource: MainDataSource
    ): MainRepository {
        return MainRepositoryImpl(mainDataSource)
    }
}