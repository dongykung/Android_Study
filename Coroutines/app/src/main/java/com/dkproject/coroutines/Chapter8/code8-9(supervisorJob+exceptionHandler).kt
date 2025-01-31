package com.dkproject.coroutines.Chapter8

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

private fun main() = runBlocking<Unit> {
    val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        println("예외 발생 $throwable")
    }
    val supervisedScope = CoroutineScope(SupervisorJob() + exceptionHandler)
    supervisedScope.launch {
        launch(CoroutineName("Coroutine1")) {
            throw Exception("Coroutine1에 예외가 발생했습니다")
        }
        launch(CoroutineName("Coroutine2")) {
            delay(100L)
            println("[${Thread.currentThread().name}]")
        }
    }
    delay(1000L)
    //예외를 전파받지 않더라도 예외에 대한 정보는 전달받으므로 오류처리를 하게됨
}