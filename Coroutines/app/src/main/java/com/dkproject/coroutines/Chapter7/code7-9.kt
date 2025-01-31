package com.dkproject.coroutines.Chapter7

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

private fun main() = runBlocking<Unit> {
    launch(context = CoroutineName("Coroutine1")) {
        val coroutine1Job = this.coroutineContext[Job]
        val newJob = Job(parent = coroutine1Job)
        //구조화가 깨질 뻔봤지만 newJob에서 부모를 설정함
        launch(context = CoroutineName("Coroutine2") + newJob){
            delay(100L)
            println("[${Thread.currentThread().name}] ${this.coroutineContext[CoroutineName]}")
        }
        newJob.complete() // 명시적으로 완료호출
    }
}