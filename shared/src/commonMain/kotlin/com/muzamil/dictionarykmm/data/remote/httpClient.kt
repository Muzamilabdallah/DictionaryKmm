package com.muzamil.dictionarykmm.data.remote

import io.ktor.client.*
import io.ktor.client.engine.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json


fun createJson() = Json { isLenient = true; ignoreUnknownKeys = true }
fun createHttpClient(
    json: Json,
    android: HttpClientEngine,
) =
    HttpClient(android) {
        install(ContentNegotiation) {
            json(json)
        }
        install(Logging) {
            level = LogLevel.ALL
        }

    }



