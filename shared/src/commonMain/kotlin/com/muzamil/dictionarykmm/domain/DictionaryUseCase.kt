package com.muzamil.dictionarykmm.domain


import com.muzamil.dictionarykmm.data.remote.repository.DictionaryRepository


class DictionaryUseCase(private val repository: DictionaryRepository) {
    suspend fun invoke(word: String) = repository.searchWord(word)
}