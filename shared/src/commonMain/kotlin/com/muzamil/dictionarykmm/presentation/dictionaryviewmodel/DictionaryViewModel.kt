package com.muzamil.dictionarykmm.presentation.dictionaryviewmodel

import com.muzamil.dictionarykmm.domain.DictionaryUseCase
import com.muzamil.dictionarykmm.domain.GeneralException
import com.plcoding.translator_kmm.core.domain.util.toCommonStateFlow

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

class DictionaryViewModel(
    private val dictionaryUseCase: DictionaryUseCase,
    private val coroutineScope: CoroutineScope?
) {
    private val viewModelScope = coroutineScope ?: CoroutineScope(Dispatchers.Main)


    private val _state = MutableStateFlow(UiState())
    val state = _state
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue =UiState()
        )
        .toCommonStateFlow()

    private var job: Job? = null
    fun onEvent(event: UiEvent) {
        when (event) {
            is UiEvent.Search -> search(event.searchTerm)
        }
    }

    private fun search(searchTerm: String) {
        job?.cancel()
        job = viewModelScope.launch {
            delay(500)
            try {
                _state.value = _state.value.copy(
                    error = null,
                    Loading = true,
                    wordDtoItem = emptyList()
                )

                val result = dictionaryUseCase.invoke(searchTerm)
                if (result.isNotEmpty()) {
                    _state.value = _state.value.copy(
                        error = null,
                        Loading = false,
                        wordDtoItem = result
                    )
                }
            } catch (e: GeneralException) {
                e.printStackTrace()
                _state.value = _state.value.copy(
                    error = "error",
                    Loading = false,
                    wordDtoItem = emptyList()
                )
            }
        }
    }
}





