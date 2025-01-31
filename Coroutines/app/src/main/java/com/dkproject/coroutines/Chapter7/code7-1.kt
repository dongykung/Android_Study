package com.dkproject.coroutines.Chapter7

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.CoroutineContext

@OptIn(ExperimentalCoroutinesApi::class, DelicateCoroutinesApi::class)
private fun main() = runBlocking<Unit> {
    val coroutineContext: CoroutineContext = newSingleThreadContext("MyThread") + CoroutineName("MyCoroutine")
    launch(coroutineContext) {
        println("[${Thread.currentThread().name}] ${coroutineContext[CoroutineName]}")
        launch {
            println("[${Thread.currentThread().name}] ${coroutineContext[CoroutineName]}")
        }
    }
}