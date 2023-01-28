package com.muzamil.dictionarykmm.domain

import com.muzamil.dictionarykmm.data.remote.model.wordInfoItem
import com.muzamil.dictionarykmm.data.remote.repository.DictionaryRepository
import com.muzamil.dictionarykmm.domain.util.Resource

class DictionaryUseCase(private val repository: DictionaryRepository) {
    suspend fun invoke(word: String) = repository.searchWord(word)
}