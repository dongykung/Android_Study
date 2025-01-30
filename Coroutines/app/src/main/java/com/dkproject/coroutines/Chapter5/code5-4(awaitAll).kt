package com.dkproject.coroutines.Chapter5

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

private fun main() = runBlocking<Unit> {
    val startTime = System.currentTimeMillis()
    val participantDeferred1: Deferred<Array<String>> = async {
        delay(1000L)
        return@async arrayOf("James", "Jason")
    }

    val participantDeferred2: Deferred<Array<String>> = async {
        delay(1000L)
        return@async arrayOf("Jenny")
    }
    val results: List<Array<String>> = awaitAll(participantDeferred1, participantDeferred2)
}