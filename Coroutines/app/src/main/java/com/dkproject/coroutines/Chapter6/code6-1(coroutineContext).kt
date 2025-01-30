package com.dkproject.coroutines.Chapter6

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

    launch(context = coroutineContext) {
        println("[${Thread.currentThread().name}] ${coroutineContext[CoroutineName]}")
    }
    // MyThread 스레드를 사용해 실행되고 코루틴 이름은 MyCoroutine
}