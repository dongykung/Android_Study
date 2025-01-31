package com.dkproject.coroutines

import com.dkproject.coroutines.Chapter4.getElapsedTime
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

import kotlinx.coroutines.*
import kotlin.coroutines.ContinuationInterceptor

private fun main() = runBlocking<Unit> {
   val waitJob: Job = launch {
       delay(500L)
       println("나 끝날 때 까지 기다려")
   }

    val waitJob2: Job = launch {
        delay(1000L)
        println("두 번째도 기다려!")
    }
    joinAll(waitJob, waitJob2)
    print("언제 끝나냐..")
}