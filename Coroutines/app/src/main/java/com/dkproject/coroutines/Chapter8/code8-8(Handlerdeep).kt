package com.dkproject.coroutines.Chapter8

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

private fun main() = runBlocking<Unit> {
    val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        println("${coroutineContext[CoroutineName]}에서 예외 발생 $throwable")
    }
    CoroutineScope(CoroutineName("Coroutine1") + exceptionHandler).launch {
        throw Exception("예외 발생")
    }
    delay(1000L)
}