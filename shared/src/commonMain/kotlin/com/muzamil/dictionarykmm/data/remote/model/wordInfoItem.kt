package com.muzamil.dictionarykmm.data.remote.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class wordInfoItem(
    @SerialName("license")
    val license: License,
    @SerialName("meanings")
    val meanings: List<Meaning>,
    @SerialName("phonetic")
    val phonetic: String,

    @SerialName("sourceUrls")
    val sourceUrls: List<String>,
    @SerialName("word")
    val word: String
)