package com.dkproject.coroutines.Chapter6

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

private fun main() = runBlocking<Unit> {
    val emptyCoroutineContext: CoroutineContext = EmptyCoroutineContext + CoroutineName("dongkyung")

    launch(context = emptyCoroutineContext) {
        println("[${Thread.currentThread().name}] ${coroutineContext[CoroutineName]}")
    }
}