package com.dkproject.coroutines.Chapter3

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking

@OptIn(ExperimentalCoroutinesApi::class, DelicateCoroutinesApi::class)
private fun main() = runBlocking<Unit> {
    // 단일 스레드 디스패처
    val dispatcher: CoroutineDispatcher = newSingleThreadContext(name = "SingleThread")
    println("[${Thread.currentThread().name}]실행")
    launch(context = dispatcher) {
        println("[${Thread.currentThread().name}]실행")
    }
}