package com.dkproject.coroutines.Chapter3

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

private fun main() = runBlocking<Unit> {
    launch(context = Dispatchers.IO) {
        println("[${Thread.currentThread().name}] 실행")
    }

    /*
    limitedParallelism을 사용하면 Default가 사용할 수 있는 스레드 중 일부만을 사용하도록 할 수 있었다.
    하지만 IO는 공유 스레드풀의 스레드로 구성된 새로운 스레드 풀을 만들어내며, 만들어낼 수 있는 스레드에 제한이 있는 IO나 Default와 달리 스레드의 수를 제한 없이 만들어낼 수 있다.
    그렇다면 언제 IO의 limitedParallelism을 사용할가? =
    #### 바로 특정한 작업이 다른 작업에 영향을 받지 않아야 할 때, 별도 스레드 풀에서 실행되는 것이 필요할 때
    다만 이 함수는 공유 스레드 풀에서 새로운 스레드를 만들어내고, 새로운 스레드 생성은 비싼 작업이므로 남용하지말자.
     */
}
