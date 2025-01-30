package com.dkproject.coroutines.Chapter4

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

private fun main() = runBlocking<Unit> {
    val job: Job = launch(context = Dispatchers.Default, start = CoroutineStart.LAZY) {
        delay(1000L)
    }
    //LAZY로 생성하여 바로 isActive로 넘어가는 것을 막음
    printJobState(job,1)

    val job2: Job = launch(context = Dispatchers.Default) {
        delay(1000L)
    }
    printJobState(job2, 2)

    val job3: Job = launch(context = Dispatchers.Default) {
        delay(1000L)
    }
    delay(2000L)
    printJobState(job3, 3)

    val whileJob: Job = launch(Dispatchers.Default) {
        while(this.isActive) {
            println("작업 중")
        }
    }
    whileJob.cancel()
    printJobState(whileJob, 4)

    println("=====취소완료===")
    val job5: Job = launch(Dispatchers.Default) {
        delay(5000L)
    }
    job5.cancelAndJoin()
    printJobState(job5, 5)
}

fun printJobState(job: Job, number: Int) {
    println(
        "Job State\n + " +
                "isActive >> ${job.isActive}\n" +
                "isCancelled >> ${job.isCancelled}\n" +
                "isCompleted >> ${job.isCompleted}"
    )
}