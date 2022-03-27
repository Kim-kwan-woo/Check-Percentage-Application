package com.kwanwoo.android.data.mapper

import com.kwanwoo.android.data.remote.model.DataLoveResponse
import com.kwanwoo.android.domain.model.DomainLoveResponse

object MainMapper {
    fun loveMapper(
        dataResponse: DataLoveResponse?
    ) : DomainLoveResponse? {
        return if (dataResponse != null) {
            DomainLoveResponse(
                fname = dataResponse.fname,
                percentage = dataResponse.percentage,
                result = dataResponse.result,
                sname = dataResponse.sname
            )
        } else dataResponse
    }
}