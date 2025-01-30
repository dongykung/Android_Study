package com.dkproject.coroutines.Chapter4

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

private fun main() = runBlocking<Unit> {
    val convertImageJob1: Job = launch(Dispatchers.Default) {
        Thread.sleep(1000L)
        println("[${Thread.currentThread().name}] 이미지 변환 완료")
    }
    val convertImageJob2: Job = launch(Dispatchers.Default) {
        Thread.sleep(1000L)
        println("[${Thread.currentThread().name}] 이미지 변환 완료")
    }

    joinAll(convertImageJob1, convertImageJob1) // 이미지 1,2 가 변환될 때까지 대기
    val uploadImageJob: Job = launch(Dispatchers.IO) {
        println("[${Thread.currentThread().name}] 이미지1,2 upload")
    }
}