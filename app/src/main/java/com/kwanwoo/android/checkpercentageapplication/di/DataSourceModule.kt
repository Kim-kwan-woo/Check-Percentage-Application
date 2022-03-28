package com.kwanwoo.android.checkpercentageapplication.di

import com.kwanwoo.android.data.remote.api.LoveCalculatorApi
import com.kwanwoo.android.data.repository.remote.datasource.MainDataSource
import com.kwanwoo.android.data.repository.remote.datasourceimpl.MainDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataSourceModule {

    @Provides
    @Singleton
    fun provideMainDataSource(
        loveCalculatorApi: LoveCalculatorApi
    ): MainDataSource {
        return MainDataSourceImpl(loveCalculatorApi)
    }
}