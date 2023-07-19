package com.muzamil.dictionarykmm.domain.util.di

import com.muzamil.dictionarykmm.domain.DictionaryUseCase
import com.muzamil.dictionarykmm.platformModule
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin

class UseCaseHelper: KoinComponent {
    private val dictionaryUseCase: DictionaryUseCase by inject()
    fun getDictionaryUseCase(): DictionaryUseCase {
        return dictionaryUseCase
    }
}

fun initKoin() = startKoin {
    modules(platformModule())
}