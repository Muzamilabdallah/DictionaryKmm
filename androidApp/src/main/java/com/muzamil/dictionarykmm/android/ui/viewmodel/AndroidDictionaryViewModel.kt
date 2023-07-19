package com.muzamil.dictionarykmm.android.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.muzamil.dictionarykmm.domain.DictionaryUseCase
import com.muzamil.dictionarykmm.presentation.dictionaryviewmodel.DictionaryViewModel
import com.muzamil.dictionarykmm.presentation.dictionaryviewmodel.UiEvent

class AndroidDictionaryViewModel(private val dictionaryUseCase: DictionaryUseCase) : ViewModel() {
    val viewModel by lazy {
        DictionaryViewModel(dictionaryUseCase, viewModelScope)
    }

    val state = viewModel.state
    fun getWordInfo(event: UiEvent) {
        viewModel.onEvent(event)
    }


}