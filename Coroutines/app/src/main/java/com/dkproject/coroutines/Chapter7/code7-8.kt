package com.dkproject.coroutines.Chapter7

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

@OptIn(ExperimentalStdlibApi::class, ExperimentalCoroutinesApi::class)
private fun main() {
    val newScope = CoroutineScope(CoroutineName("MyCoroutine") + Dispatchers.IO)
    newScope.launch(CoroutineName("LaunchCoroutine")) {
        println(this.coroutineContext[CoroutineName])
        println(this.coroutineContext[CoroutineDispatcher])
        val launchJob = this.coroutineContext[Job]
        val newScopeJob = newScope.coroutineContext[Job]
        println("launchJob?.parent === newScopeJob >> ${launchJob?.parent === newScopeJob }")
    }
    Thread.sleep(1000L)
}