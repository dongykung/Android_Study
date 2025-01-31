package com.dkproject.coroutines.Chapter7

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

private fun main() = runBlocking<Unit> {
    val coroutineScope = CoroutineScope(Dispatchers.IO)
    coroutineScope.launch {
        delay(100L)
        println("[${Thread.currentThread().name}] 코루틴 실행 완료")
    }.join()
}