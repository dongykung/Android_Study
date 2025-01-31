package com.dkproject.coroutines.Chapter8

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

private fun main() = runBlocking<Unit> {
    launch(CoroutineName("Parent Coroutine")) {
        launch(CoroutineName("Coroutine1") + Job()) {
            launch(CoroutineName("Coroutine3")) {
                throw Exception("예외 발생")
            }
            delay(100L)
            println("[${Thread.currentThread().name}] ${coroutineContext[CoroutineName]}")
        }
        launch(CoroutineName("Coroutine2")) {
            delay(100L)
            println("[${Thread.currentThread().name}] ${coroutineContext[CoroutineName]}")
        }
    }
    delay(1000L)
}