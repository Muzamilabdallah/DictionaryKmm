package com.muzamil.dictionarykmm.presentation.dictionaryviewmodel

sealed class UiEvent {
    data class Search(val searchTerm: String) : UiEvent()
}