package com.dkproject.coroutines.Chapter3

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.newFixedThreadPoolContext
import kotlinx.coroutines.runBlocking

@OptIn(DelicateCoroutinesApi::class)
private fun main() = runBlocking<Unit> {
    // 부모 코루틴의 CoroutineDispatcher 사용해 자식 코루틴 실행하기
    val multiThreadDispatcher = newFixedThreadPoolContext(nThreads = 2, name = "MultiThread")

    // 바깥쪽의 코루틴을 부모 코루틴, 내부에서 생성되는 새로운 코루틴을 자식 코루틴
    launch(context = multiThreadDispatcher) { // 부모 코루틴
        println("[${Thread.currentThread().name}] 실행")
        launch(context = multiThreadDispatcher) { // 자식 코루틴
            println("[${Thread.currentThread().name}] 실행")
        }
        launch(context = multiThreadDispatcher) { // 자식 코루틴
            println("[${Thread.currentThread().name}] 실행")
        }
    }
}