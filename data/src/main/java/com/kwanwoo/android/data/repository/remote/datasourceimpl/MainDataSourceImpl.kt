package com.kwanwoo.android.data.repository.remote.datasourceimpl

import com.kwanwoo.android.data.remote.api.LoveCalculatorApi
import com.kwanwoo.android.data.remote.model.DataLoveResponse
import com.kwanwoo.android.data.repository.remote.datasource.MainDataSource
import com.kwanwoo.android.data.utils.base.BaseDataSource
import com.kwanwoo.android.domain.utils.RemoteErrorEmitter
import javax.inject.Inject

class MainDataSourceImpl @Inject constructor(
    private val loveCalculatorApi: LoveCalculatorApi
) : BaseDataSource(), MainDataSource {
    override suspend fun checkLoveCalculator(
        remoteErrorEmitter: RemoteErrorEmitter,
        host: String,
        key: String,
        mName: String,
        wName: String
    ): DataLoveResponse? {
        return safeApiCall(remoteErrorEmitter) {
            loveCalculatorApi.getPercentage(host = host, key = key, fName = mName, sName = wName)
        }?.body()
    }
}