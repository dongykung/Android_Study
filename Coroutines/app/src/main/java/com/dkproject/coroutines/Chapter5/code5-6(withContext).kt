package com.dkproject.coroutines.Chapter5

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

private fun main() = runBlocking<Unit> {

    val result: String = withContext(context = Dispatchers.IO) { //main 에서 IO로 context Switching(컨텍스트 스위칭)
        delay(1000L)
        return@withContext "Dummy Response"
    }
    //IO에서 다시 Main 으로 context Switching(컨텍스트 스위칭)

    println(result)
    //async - await 대신 withContext를 사용했을 때

    println("[${Thread.currentThread().name}] runBlocking 블록 실행") // 코루틴1
    withContext(Dispatchers.IO) {
        println("[${Thread.currentThread().name}] withContext 블록 실행") // 코루틴1
    }
    println("[${Thread.currentThread().name}] runBlocking 블록 종료") // 코루틴1
    //withContext는 새로운 코루틴을 만들지 않고 기존의 코루틴을 활용함
    //기존의 코루틴에서 CoroutineContext 객체만 바뀌어서 실행됨
}