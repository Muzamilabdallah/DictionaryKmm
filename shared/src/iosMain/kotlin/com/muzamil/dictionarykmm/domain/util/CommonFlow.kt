package com.plcoding.translator_kmm.core.domain.util

import kotlinx.coroutines.*

import kotlinx.coroutines.flow.Flow


actual open class CommonFlow<T> actual constructor(
    private val flow: Flow<T>
) : Flow<T> by flow {

    // Collects values emitted by the flow
    fun subscribe(
        coroutineScope: CoroutineScope,
        dispatcher: CoroutineDispatcher,
        onCollect: (T) -> Unit
    ): com.plcoding.translator_kmm.core.domain.util.DisposableHandle {
        val job = coroutineScope.launch(dispatcher) {
            flow.collect(onCollect)
        }
        return  com.plcoding.translator_kmm.core.domain.util.DisposableHandle { job.cancel() }
    }

    // Shorthand for the first method
    @OptIn(DelicateCoroutinesApi::class)
    fun subscribe(
        onCollect: (T) -> Unit
    ):  com.plcoding.translator_kmm.core.domain.util.DisposableHandle {
        return subscribe(
            coroutineScope = GlobalScope,
            dispatcher = Dispatchers.Main,
            onCollect = onCollect
        )
    }
}