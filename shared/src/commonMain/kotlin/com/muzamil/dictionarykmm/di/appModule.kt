package com.muzamil.dictionarykmm.di


import com.muzamil.dictionarykmm.data.remote.httpClient
import com.muzamil.dictionarykmm.data.remote.json

import com.muzamil.dictionarykmm.data.remote.repository.DictionaryRepository
import com.muzamil.dictionarykmm.data.remote.repository.DictionaryRepositoryImpl
import com.muzamil.dictionarykmm.domain.DictionaryUseCase
import com.muzamil.dictionarykmm.platformModule
import org.koin.core.Koin
import org.koin.core.context.startKoin
import org.koin.core.parameter.parametersOf
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module
import kotlin.reflect.KClass

fun initKoin(appDeclaration: KoinAppDeclaration = {}) = startKoin {
    appDeclaration()
    modules(commonModule, platformModule())
}

fun initKoin() = initKoin {}
val commonModule = module {
    single { json() }
    single { httpClient(get(),get()) }
    single<DictionaryRepository> { DictionaryRepositoryImpl(get()) }
    single { DictionaryUseCase(get()) }


}

fun <T> Koin.getDependency(clazz: KClass<*>): T {
    return get(clazz, null) { parametersOf(clazz.simpleName) } as T
}




