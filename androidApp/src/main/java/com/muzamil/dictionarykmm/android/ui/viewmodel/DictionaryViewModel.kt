package com.muzamil.dictionarykmm.android.ui.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.muzamil.dictionarykmm.domain.DictionaryUseCase
import com.muzamil.dictionarykmm.presentation.dictionaryviewmodel.DictionaryPresenter
import com.muzamil.dictionarykmm.presentation.dictionaryviewmodel.Event

class DictionaryViewModel(private val dictionaryUseCase: DictionaryUseCase) : ViewModel() {
    val viewModel by lazy {
        DictionaryPresenter(dictionaryUseCase, viewModelScope)
    }

    val state = viewModel.state
    fun getWordInfo(event: Event) {
        viewModel.onEvent(event)
    }


}