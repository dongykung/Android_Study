package com.dkproject.coroutines.Chapter7

import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

private fun main() = runBlocking<Unit> {
    val runBolockingJob = coroutineContext[Job]
    launch {
        val launchJob = coroutineContext[Job]
        if(runBolockingJob === launchJob) {
            println("runBlocking과 launch는 같은 Job 객체를 가짐")
        } else {
            println("runBlocking과 launch는 다른 Job 객체를 가짐")
        }
    }
}