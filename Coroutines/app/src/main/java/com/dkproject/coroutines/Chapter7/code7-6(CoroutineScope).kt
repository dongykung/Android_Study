package com.dkproject.coroutines.Chapter7

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.CoroutineContext

class CustomCoroutineScope: CoroutineScope {
    @OptIn(ExperimentalCoroutinesApi::class, DelicateCoroutinesApi::class)
    override val coroutineContext: CoroutineContext = Job() + newSingleThreadContext("CustomScopeThread")
}

private fun main() {
    val coroutineScope = CustomCoroutineScope()
    coroutineScope.launch {
        delay(100L)
        println("[${Thread.currentThread().name}] 코루틴 실행 완료")
    }
    Thread.sleep(1000L)
}