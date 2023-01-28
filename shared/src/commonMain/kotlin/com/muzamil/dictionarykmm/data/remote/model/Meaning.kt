package com.muzamil.dictionarykmm.data.remote.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Meaning(

    @SerialName("definitions")
    val definitions: List<Definition>?=null ,
    @SerialName("partOfSpeech")
    val partOfSpeech: String?=null,

)