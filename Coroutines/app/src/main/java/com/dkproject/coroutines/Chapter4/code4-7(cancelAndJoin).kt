package com.dkproject.coroutines.Chapter4

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

private fun main() = runBlocking<Unit> {
    val longJob: Job = launch(Dispatchers.Default) {
        repeat(10) {
            delay(1001L)
            println("[${Thread.currentThread().name}] 반복횟수${it}")
        }
    }
    longJob.cancelAndJoin() // 취소될 때까지 runBlocking 코루틴 일시 중단
    println("[${Thread.currentThread().name}] 종료")
}