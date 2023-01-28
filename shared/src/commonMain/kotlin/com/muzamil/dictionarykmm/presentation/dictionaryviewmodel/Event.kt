package com.muzamil.dictionarykmm.presentation.dictionaryviewmodel

sealed class Event {
    data class Search(val searchTerm: String) : Event()
}