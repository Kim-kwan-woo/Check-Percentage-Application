package com.kwanwoo.android.domain.repository

import com.kwanwoo.android.domain.model.DomainLoveResponse
import com.kwanwoo.android.domain.utils.RemoteErrorEmitter

interface MainRepository {
    suspend fun checkLoveCalculator(
        remoteErrorEmitter: RemoteErrorEmitter,
        host: String,
        key: String,
        mName: String, //fname : 남자이름
        wName: String //sname : 여자이름
    ) : DomainLoveResponse?
}