package com.dkproject.coroutines.Chapter7

import com.dkproject.coroutines.Chapter4.getElapsedTime
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

private fun main() = runBlocking<Unit> {
    val startTime = System.currentTimeMillis()
    val parentJob = launch {
        launch {
            delay(1000L)
            println("[${getElapsedTime(startTime)}]자식 코루틴 실행 완료")
        }
        println("[${getElapsedTime(startTime)}]부모 코루틴 실행 완료")
    }
    parentJob.invokeOnCompletion {
        println("[${getElapsedTime(startTime)}]모든 자식 코루틴이 완료되었습니다.")
    }
}