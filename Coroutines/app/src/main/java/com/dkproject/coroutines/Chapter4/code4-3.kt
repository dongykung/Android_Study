package com.dkproject.coroutines.Chapter4

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

private fun main() = runBlocking<Unit> {
    val updateTokenJob = launch(Dispatchers.IO) {
        println("[${Thread.currentThread().name}] 토큰 업데이트 시작")
        delay(100)
        println("[${Thread.currentThread().name}] 토큰 업데이트 완료")
    }
    val inndependentJob = launch(Dispatchers.IO) {
        println("[${Thread.currentThread().name}] 독립적인작업 시작")
        delay(1000)
        println("[${Thread.currentThread().name}] 독립적인작업 완료")
    }
    updateTokenJob.join()
    val networkCallJob = launch(Dispatchers.IO) {
        println("[${Thread.currentThread().name}] 네트워크 요청")
    }
}