package com.dkproject.coroutines.Chapter2.code1

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/*
runBlocking 함수는 메인 스레드를 점하는 코루틴을 만든다.
이 코루틴은 runBlocking 함수의 인자로 들어온 람다식을 실행하며,
람다식 내부의 모든 코드가 완료될 때까지 코루틴은 종료되지 않는다.
 */
private fun main() = runBlocking<Unit> {
    println("[${Thread.currentThread().name}] 실행")
    //runBlocking 함수의 람다식에서는 수신 객체인 CoroutineScope에 접근할 수 있다.
    //CoroutineScope 객체의 확장 함수로 정의된 launch 함수를 사용하여  코루틴을 추가로 생성 가능.
    launch {
        println("[${Thread.currentThread().name}]")
    }
    launch {
        println("[${Thread.currentThread().name}]")
    }
}