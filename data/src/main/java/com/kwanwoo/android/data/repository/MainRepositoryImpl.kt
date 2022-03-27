package com.kwanwoo.android.data.repository

import com.kwanwoo.android.data.mapper.MainMapper
import com.kwanwoo.android.data.repository.remote.datasource.MainDataSource
import com.kwanwoo.android.domain.model.DomainLoveResponse
import com.kwanwoo.android.domain.repository.MainRepository
import com.kwanwoo.android.domain.utils.RemoteErrorEmitter
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val mainDataSource: MainDataSource
) : MainRepository{
    override suspend fun checkLoveCalculator(
        remoteErrorEmitter: RemoteErrorEmitter,
        host: String,
        key: String,
        mName: String,
        wName: String
    ): DomainLoveResponse? {
        return MainMapper.loveMapper(mainDataSource.checkLoveCalculator(remoteErrorEmitter, host, key, mName, wName))
    }
}