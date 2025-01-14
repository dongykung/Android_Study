package com.dkproject.compose_codelab.Chapter3.grammer

val fullMenu = cookies.map {
    "${it.name} - ${it.price}"
}

fun main() {
    fullMenu.forEach {
        println(it)
    }
}