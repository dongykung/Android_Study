package com.dkproject.coroutines.Chapter6

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.CoroutineContext

private fun main() = runBlocking<Unit> {
    val myJob: Job = Job()
    val coroutineContext: CoroutineContext = Dispatchers.IO + myJob
    // Job 객체를 생성해 추가하면 코루틴의 구조하가 깨짐 / 주의가 필요한 부분인 부분
}