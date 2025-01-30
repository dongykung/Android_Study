package com.dkproject.coroutines.Chapter6

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.CoroutineContext

@OptIn(ExperimentalStdlibApi::class)
private fun main() = runBlocking<Unit> {
    val coroutineName = CoroutineName("MyCoroutine")
    val dispatcher = Dispatchers.IO
    val myJob = Job()
    val coroutineContext: CoroutineContext = coroutineName + dispatcher + myJob

    val deletedCoroutineContext = coroutineContext.minusKey(CoroutineName)

    println(deletedCoroutineContext[CoroutineName])
    println(deletedCoroutineContext[CoroutineDispatcher])
    println(deletedCoroutineContext[Job])

    //minusKey 함수 사용 시 주의할 점
    // 호출한 CoroutineContext 객체는 그대로 유지되고, 구성 요소가 제거된 새로운 CoroutineContext 반환됨
}