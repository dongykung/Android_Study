package com.dkproject.coroutines.Chapter3

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

private fun main() = runBlocking<Unit> {
    launch(context = Dispatchers.Main) {
        println("[${Thread.currentThread().name}] 실행")
    }
}
