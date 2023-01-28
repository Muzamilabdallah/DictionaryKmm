package com.muzamil.dictionarykmm.data.remote.repository

import com.muzamil.dictionarykmm.core.Constant
import com.muzamil.dictionarykmm.data.remote.model.WordInfo
import com.muzamil.dictionarykmm.data.remote.model.wordInfoItem
import com.muzamil.dictionarykmm.domain.GeneralError
import com.muzamil.dictionarykmm.domain.GeneralException
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.utils.io.errors.*

class DictionaryRepositoryImpl(private val httpClient: HttpClient) : DictionaryRepository {
    override suspend fun searchWord(word: String): List<wordInfoItem> {
        val result = try {
            httpClient.get {
                url("${Constant.BAS_EURL}$word")
            }
        } catch (e: IOException) {
            print(e)
            throw Exception(e)
        }
        return try {
            result.body()
        } catch (e: Exception) {
            print(e.message)
            when (result.status.value) {
                400 -> throw GeneralException(GeneralError.BAD_REQUEST)
                404 -> throw GeneralException(GeneralError.NOT_FOUND)
                500 -> throw GeneralException(GeneralError.SERVER_ERROR)
                else ->
                    throw GeneralException(GeneralError.UNKOWN_ERROR)

            }
        }
    }
}