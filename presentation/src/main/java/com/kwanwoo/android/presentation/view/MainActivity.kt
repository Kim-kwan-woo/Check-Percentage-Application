package com.kwanwoo.android.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.kwanwoo.android.presentation.R
import com.kwanwoo.android.presentation.base.BaseActivity
import com.kwanwoo.android.presentation.databinding.ActivityMainBinding
import com.kwanwoo.android.presentation.viewmodel.MainViewModel
import com.pss.barlibrary.CustomBar.Companion.setTransparentBar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    private val mainViewModel by viewModels<MainViewModel>()
    override fun init() {
        setTransparentBar(this)
    }
}