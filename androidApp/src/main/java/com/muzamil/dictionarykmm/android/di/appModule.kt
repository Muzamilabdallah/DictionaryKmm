package com.muzamil.dictionarykmm.android.di

import com.muzamil.dictionarykmm.android.ui.viewmodel.DictionaryViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val  appModule = module{
    viewModel{ DictionaryViewModel(get()) }
}