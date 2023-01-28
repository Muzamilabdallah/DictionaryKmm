package com.muzamil.dictionarykmm.presentation.dictionaryviewmodel

import com.muzamil.dictionarykmm.domain.DictionaryUseCase
import com.muzamil.dictionarykmm.domain.GeneralException
import com.muzamil.dictionarykmm.domain.util.toCommonStateFlow
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class DictionaryPresenter(
    private val dictionaryUseCase: DictionaryUseCase,
    private val coroutineScope: CoroutineScope?
) {
    private val viewModelScope = coroutineScope ?: CoroutineScope(Dispatchers.Main)

    private val _mutableState = MutableStateFlow(UiState())
    val state: StateFlow<UiState> = _mutableState.asStateFlow().toCommonStateFlow()
    private var job: Job? = null
    fun onEvent(event: Event) {
        when (event) {
            is Event.Search -> search(event.searchTerm)
        }
    }

    private fun search(searchTerm: String) {
        job?.cancel()
        job = viewModelScope.launch {
            delay(500)
            try {
                _mutableState.value = _mutableState.value.copy(
                    error = null,
                    Loading = true,
                    wordDtoItem = emptyList()
                )

                val result = dictionaryUseCase.invoke(searchTerm)
                if (result.isNotEmpty()) {
                    _mutableState.value = _mutableState.value.copy(
                        error = null,
                        Loading = false,
                        wordDtoItem = result
                    )
                }
            } catch (e: GeneralException) {
                e.printStackTrace()
                _mutableState.value = _mutableState.value.copy(
                    error = "error",
                    Loading = false,
                    wordDtoItem = emptyList()
                )
            }
        }
    }
}





