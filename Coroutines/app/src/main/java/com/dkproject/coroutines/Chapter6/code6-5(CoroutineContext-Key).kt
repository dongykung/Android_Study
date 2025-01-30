package com.dkproject.coroutines.Chapter6

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.Job
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.CoroutineContext

@OptIn(ExperimentalStdlibApi::class)
private fun main() = runBlocking<Unit> {
    val job = Job()
    val coroutineContext: CoroutineContext = Dispatchers.IO + CoroutineName("MyCoroutine")

    println(coroutineContext[CoroutineName.Key])
    println(coroutineContext[CoroutineDispatcher])
    println(coroutineContext[Job])
    //Key를 제거해도 동일한 결과
    // 왜냐면 자동으로 Key를 사용해서 연산 처리함
}