package com.dkproject.compose_codelab.Chapter3.grammer

// groupBy() 함수를 사용하면 함수에 따라 목록을 맵으로 변환할 수 있습니다.
// 함수의 고유한 각 반환 값은 결과 맵의 키가 됩니다.
// 각 키의 값은 고유한 반환 값을 생성한 컬렉션의 모든 항목입니다.

val groupedMenu = cookies.groupBy { it.softBaked }
val softBakedMenu2 = groupedMenu[true] ?: listOf()
val crunchyMenu = groupedMenu[false] ?: listOf()
fun main() {
    println("Soft cookies:")
    softBakedMenu2.forEach {
        println("${it.name} - $${it.price}")
    }
    println("Crunchy cookies:")
    crunchyMenu.forEach {
        println("${it.name} - $${it.price}")
    }
}