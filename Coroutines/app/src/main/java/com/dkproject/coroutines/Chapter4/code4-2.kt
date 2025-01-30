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
    val networkCallJob = launch(Dispatchers.IO) {
        println("[${Thread.currentThread().name}] 네트워크 요청")
    }
    // 위처럼 하면 큰일남
    Thread.sleep(110)
    println("==========================")
    val updatedTokenJob2 = launch(Dispatchers.IO) {
        println("[${Thread.currentThread().name}] 토큰 업데이트 시작")
        delay(100)
        println("[${Thread.currentThread().name}] 토큰 업데이트 완료")
    }
    updatedTokenJob2.join()
    val networkCallJob2 = launch(Dispatchers.IO) {
        println("[${Thread.currentThread().name}] 네트워크 요청")
    }
}