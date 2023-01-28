package com.muzamil.dictionarykmm.data.remote.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Definition(
    @SerialName("definition")
    val definition: String?=null,
    @SerialName("example")
    val example: String?=null,
    @SerialName("synonyms")
    val synonyms: List<String>
)