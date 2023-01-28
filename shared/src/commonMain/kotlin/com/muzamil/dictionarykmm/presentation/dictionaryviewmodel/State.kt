package com.muzamil.dictionarykmm.presentation.dictionaryviewmodel


import com.muzamil.dictionarykmm.data.remote.model.wordInfoItem

data class UiState(
    val error: String? = "",
    val Loading: Boolean? = false,
    val wordDtoItem: List<wordInfoItem>? = emptyList()
)


