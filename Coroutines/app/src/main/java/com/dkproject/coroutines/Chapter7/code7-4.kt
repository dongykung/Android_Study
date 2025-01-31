package com.dkproject.coroutines.Chapter7

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

private fun main() = runBlocking<Unit> {
    val parentJob = launch(Dispatchers.IO) {
        val dbResultsDeferred: List<Deferred<String>> = listOf("db1", "db2", "db3")
            .map {
                async {
                    delay(1000L)
                    println("db: $it")
                    return@async it
                }
            }
        val dbResults: List<String> = dbResultsDeferred.awaitAll()
        println("dbResults: $dbResults")
    }
    parentJob.cancel()
}