package com.muzamil.dictionarykmm.data.remote.repository

import com.muzamil.dictionarykmm.data.remote.model.wordInfoItem

interface DictionaryRepository {
    suspend fun searchWord(word:String):List<wordInfoItem>
}