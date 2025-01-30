package com.dkproject.coroutines.Chapter5

import com.dkproject.coroutines.Chapter4.printJobState
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

private fun main() = runBlocking<Unit> {
    val networkDeferred: Deferred<String> = async {
        delay(1000L)
        return@async "Dummy Response"
    }
    networkDeferred.join()
    networkDeferred.await() // 두 코드 다 기다리는거임
    printJobState(networkDeferred, 1)
}