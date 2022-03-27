package com.kwanwoo.android.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kwanwoo.android.domain.model.DomainLoveResponse
import com.kwanwoo.android.domain.usecase.CheckLoveCalculatorUseCase
import com.kwanwoo.android.domain.utils.ErrorType
import com.kwanwoo.android.domain.utils.RemoteErrorEmitter
import com.kwanwoo.android.domain.utils.ScreenState
import com.kwanwoo.android.presentation.widget.utils.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val checkLoveCalculatorUseCase: CheckLoveCalculatorUseCase
): ViewModel(), RemoteErrorEmitter {

    val apiCallEvent: LiveData<ScreenState>
        get() = _apiCallEvent
    private var _apiCallEvent = SingleLiveEvent<ScreenState>()

    var apiCallResult = DomainLoveResponse("", "", 0, "")
    var apiErrorType = ErrorType.UNKNOWN
    var apiErrorMessage = "none"
    var manNameResult = "man"
    var womanNameResult = "woman"

    fun checkLoveCalculator(
        host: String,
        key: String,
        mName: String,
        wName: String) = viewModelScope.launch {
        checkLoveCalculatorUseCase.execute(this@MainViewModel, host, key, mName, wName).let { response ->
            if (response != null) {
                apiCallResult = response
                _apiCallEvent.postValue(ScreenState.LOADING)
            } else {
                _apiCallEvent.postValue(ScreenState.ERROR)
            }
        }
    }
    override fun onError(msg: String) {
        apiErrorMessage = msg
    }

    override fun onError(errorType: ErrorType) {
        apiErrorType = errorType
    }
}