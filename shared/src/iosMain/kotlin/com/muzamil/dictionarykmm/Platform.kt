package com.muzamil.dictionarykmm


import com.muzamil.dictionarykmm.domain.DictionaryUseCase
import io.ktor.client.engine.darwin.*

import org.koin.dsl.module


actual fun platformModule() = module {
    single { Darwin.create() }

        single { DictionaryUseCase(get()) }

}






