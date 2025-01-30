package com.dkproject.coroutines.Chapter2.code1

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// CoroutineName 사용해 코루틴에 이름 추가하기
private fun main() = runBlocking<Unit>(context = CoroutineName("Main")) {
    println("[${Thread.currentThread().name}] 실행")

    launch(context = CoroutineName("Coroutine1")) {
        println("[${Thread.currentThread().name}] 실행")
    }

    launch(context = CoroutineName("Coroutine2")) {
        println("[${Thread.currentThread().name}] 실행")
    }
}