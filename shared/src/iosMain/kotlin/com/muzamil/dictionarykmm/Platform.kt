package com.muzamil.dictionarykmm

import com.muzamil.dictionarykmm.data.remote.httpClient
import com.muzamil.dictionarykmm.data.remote.json
import io.ktor.client.*
import io.ktor.client.engine.darwin.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import org.koin.dsl.module


actual fun platformModule() = module {
    single { Darwin.create() }
}

