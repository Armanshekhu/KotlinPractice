package com.example.kotlinbasic

fun main() {
    for(i in 1..10 ) {
        println(i)
    }

    for(i in 1 until 10) {
        println(i)
    }

    for(i in 1 ..10 step 2) {
        println(i)
    }

    for(i in 10 downTo 1 step 2) {
        println(i)
    }

    for(i in 1..10) {
        println("3 * $i = ${3*i}")
    }
}