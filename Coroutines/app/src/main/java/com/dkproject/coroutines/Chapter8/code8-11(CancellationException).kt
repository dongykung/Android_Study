package com.dkproject.coroutines.Chapter8

import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

private fun main() = runBlocking<Unit>(CoroutineName("runBlocking 코루틴")) {
    launch(CoroutineName("Coroutine1")) {
        launch(CoroutineName("Coroutine2")) {
            throw CancellationException() // 예외를 전파시키지 않음
        }
        delay(100L)
        println("[${Thread.currentThread().name}] ${coroutineContext[CoroutineName]}")
    }
    delay(100L)
    println("[${Thread.currentThread().name}] ${coroutineContext[CoroutineName]}")
}