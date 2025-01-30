package com.dkproject.coroutines.Chapter4

import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

private fun main() = runBlocking<Unit> {
    val startTime = System.currentTimeMillis()
    val longJob: Job = launch(Dispatchers.Default) {
        repeat(10) {
            delay(1000L)
            println("[${getElapsedTime(startTime)}] 반복횟수${it}")
        }
    }
    delay(3500L)
    longJob.cancel()
}