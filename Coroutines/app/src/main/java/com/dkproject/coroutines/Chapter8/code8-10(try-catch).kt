package com.dkproject.coroutines.Chapter8

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.supervisorScope

private fun main() = runBlocking<Unit> {
    launch {
        try {
            throw Exception("예외 발생")
        } catch (e: Exception) {
            println(e.message)
        }
    }
    launch {
        delay(100L)
        println("코루틴2 종료")
    }

    supervisorScope {
        val deferred: Deferred<String> = async {
            throw Exception("예외 발생")
        }
        try {
            deferred.await()
        } catch (e: Exception) {
            println(e.message)
        }
    }
}