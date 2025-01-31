package com.dkproject.coroutines.Chapter3

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.newFixedThreadPoolContext
import kotlinx.coroutines.runBlocking

@OptIn(DelicateCoroutinesApi::class)
private fun main() = runBlocking<Unit>{
    println("[${Thread.currentThread().name}]실행")
    // 멀티 스레드 디스패처 만들기
    val multiThreadDispatcher: CoroutineDispatcher =
        newFixedThreadPoolContext(nThreads = 2, name = "MultiiThread")
    launch(multiThreadDispatcher + CoroutineName("Coroutine1")) {
        println("[${Thread.currentThread().name}]실행, ${coroutineContext[CoroutineName]}")
    }
    launch(context = multiThreadDispatcher + CoroutineName("Coroutine2")) {
        println("[${Thread.currentThread().name}]실행, ${coroutineContext[CoroutineName]}")
    }
}
