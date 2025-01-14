package com.dkproject.compose_codelab.Chapter3.grammer

val softBakedMenu = cookies.filter {
    it.softBaked
}

fun main() {
    println("Soft cookies:")
    softBakedMenu.forEach {
        println("${it.name} - $${it.price}")
    }
}