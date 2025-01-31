package com.dkproject.coroutines.Chapter8

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

private fun main() = runBlocking<Unit> {
    val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        println("${coroutineContext[CoroutineName]} 에서 예외 발생 $throwable")
    }
    launch(CoroutineName("Coroutiine1") + exceptionHandler) {
        throw Exception("예외 발생")
    }
    /*
    만약 자식 코루틴이 부모 코루틴으로 예외를 전파하면 자식 코루틴에서는 예외가 처리된 것으로 봐 자식 코루틴에 설정된 Handler 객체는 동작하지 않는다.
때문에 구조화된 코루틴상에 여러 CoroutineExceptionHandler 객체가 설정돼 있더라도 마지막으로 예외를 전파받는 위치에 설정된 CoroutineExceptionHandler 객체만
예외를 처리한다.
이런 특징 때문에 CoroutineExceptionHandler 객체는 '공통 예외 처리기' 로서 동작할 수 있다.
     */
}