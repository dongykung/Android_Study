package com.dkproject.coroutines.Chapter3

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

@OptIn(ExperimentalCoroutinesApi::class)
private fun main() = runBlocking<Unit> {
    launch(Dispatchers.Default) {
        println("[${Thread.currentThread().name}] 실행")
    }

    // 스레드 개수 제한
    launch(Dispatchers.Default.limitedParallelism(2)) {
        repeat(10) {
           launch {
               println("[${Thread.currentThread().name}] 실행")
           }
        }
    }
}