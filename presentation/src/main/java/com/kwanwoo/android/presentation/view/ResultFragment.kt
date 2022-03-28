package com.kwanwoo.android.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.kwanwoo.android.presentation.R
import com.kwanwoo.android.presentation.base.BaseFragment
import com.kwanwoo.android.presentation.databinding.FragmentResultBinding
import com.kwanwoo.android.presentation.viewmodel.MainViewModel

class ResultFragment : BaseFragment<FragmentResultBinding>(R.layout.fragment_result) {
    private val mainViewModel by activityViewModels<MainViewModel>()
    override fun init() {
        binding.fragment = this
        initResult()
    }

    private fun initResult() {
        binding.score.text = mainViewModel.apiCallResult.percentage.toString()
        when(mainViewModel.apiCallResult.percentage) {
            in 0..20 -> setLoveMsgTxt("거의 남남 이네요...ㅠㅠ")
            in 21..40 -> setLoveMsgTxt("잘 맞지는 않는거 같아요...")
            in 41..70 -> setLoveMsgTxt("기대해도 좋겠는데요?")
            in 71..90 -> setLoveMsgTxt("잘 맞는 커플이네요!!")
            in 91..99 -> setLoveMsgTxt("축하드려요!! 엄청난 인연이네요")
            100 -> {
                setLoveMsgTxt("완벽하네요!! 이런게 천생연분?")
            }
            else -> setLoveMsgTxt("알 수 없는 힘?!")
        }
    }

    private fun setLoveMsgTxt(msg: String) = binding.message.setText(msg)

    fun backMainBtnClick(view: View) {
        this.findNavController().navigate(R.id.action_resultFragment_to_mainFragment)
    }

}