package com.dkproject.coroutines.Chapter5

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

private fun main() = runBlocking<Unit> {
    val networkDeferred: Deferred<String> = async(context = Dispatchers.IO) {
        delay(1000L)
        return@async "Dummy Response"
    }
    val result: String = networkDeferred.await()
    print(result)
}