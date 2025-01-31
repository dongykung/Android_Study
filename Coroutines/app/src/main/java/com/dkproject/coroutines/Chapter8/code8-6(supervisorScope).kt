package com.dkproject.coroutines.Chapter8

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.supervisorScope

private fun main() = runBlocking<Unit> {
    supervisorScope {
        launch(CoroutineName("Coroutine1"))  {
            launch(CoroutineName("Coroutine3")) {
                throw Exception("예외 발생")
            }
            delay(100L)
            println("[${Thread.currentThread().name}], ${coroutineContext[CoroutineName]}")
        }
        launch(CoroutineName("Coroutine2")) {
            delay(100L)
            println("[${Thread.currentThread().name}], ${coroutineContext[CoroutineName]}")
        }
    }
}