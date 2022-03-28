package com.kwanwoo.android.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.kwanwoo.android.domain.utils.ErrorType
import com.kwanwoo.android.domain.utils.ScreenState
import com.kwanwoo.android.presentation.R
import com.kwanwoo.android.presentation.base.BaseFragment
import com.kwanwoo.android.presentation.databinding.FragmentManNameBinding
import com.kwanwoo.android.presentation.viewmodel.MainViewModel

class ManNameFragment : BaseFragment<FragmentManNameBinding>(R.layout.fragment_man_name) {
    private val mainViewModel by activityViewModels<MainViewModel>()
    override fun init() {
        binding.fragment = this
        observeViewModel()
    }

    fun nextBtnClick(view: View) {
        binding.loadingBar.visibility = View.VISIBLE

        mainViewModel.checkLoveCalculator(
            "love-calculator.p.rapidapi.com",
            "2680d3153emsh6c2d370d2204a1dp189c51jsn8fbb5e8533f4",
            binding.nameEditTxt.text.toString(),
            mainViewModel.womanNameResult)


    }

    private fun observeViewModel() {
        mainViewModel.apiCallEvent.observe(this) {
            binding.loadingBar.visibility = View.INVISIBLE
            when(it) {
                ScreenState.LOADING -> this.findNavController().navigate(R.id.action_manNameFragment_to_resultFragment)
                ScreenState.ERROR -> toastErrorMsg()
                else -> shortShowToast("알 수 없는 오류가 발생했습니다.")
            }
        }
    }

    private fun toastErrorMsg() {
        when(mainViewModel.apiErrorType) {
            ErrorType.NETWORK -> longShowToast("네트워크 오류가 발생했습니다.")
            ErrorType.SESSION_EXPIRED -> longShowToast("세션이 만료되었습니다.")
            ErrorType.TIMEOUT -> longShowToast("호출 시간이 초과되었습니다.")
            ErrorType.UNKNOWN -> longShowToast("예기치 못한 오류가 발생했습니다.")
        }
    }
}