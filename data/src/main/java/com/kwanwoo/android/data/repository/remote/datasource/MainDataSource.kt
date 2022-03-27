package com.kwanwoo.android.data.repository.remote.datasource

import com.kwanwoo.android.data.remote.model.DataLoveResponse
import com.kwanwoo.android.domain.utils.RemoteErrorEmitter

interface MainDataSource {
    suspend fun checkLoveCalculator(
        remoteErrorEmitter: RemoteErrorEmitter,
        host: String,
        key: String,
        mName: String, //fname : 남자이름
        wName: String //sname : 여자이름
    ) : DataLoveResponse?
}