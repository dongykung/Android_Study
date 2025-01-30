package com.dkproject.coroutines.Chapter5

import com.dkproject.coroutines.Chapter4.getElapsedTime
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

private fun main() = runBlocking<Unit> {
    val startTime = System.currentTimeMillis()
    val helloString = withContext(Dispatchers.IO) {
        delay(1000L)
        return@withContext "Hello"
    }
    val wolrdString = withContext(Dispatchers.IO) {
        delay(1000L)
        return@withContext "World"
    }
    println("[${getElapsedTime(startTime)}] $helloString $wolrdString")
    //이러면 2초가 걸려버림 비효율적임 ㅇㅇ

    val helloDeferred: Deferred<String> = async {
        delay(1000L)
        return@async "Hello"
    }
    val worldDeferred: Deferred<String> = async {
        delay(1000L)
        return@async "World"
    }
    val results = listOf(helloDeferred, worldDeferred).awaitAll()
    println("[${getElapsedTime(startTime)}] ${results[0]} ${results[1]}")
}