package com.example.kotlinbasic

fun main() {
    var i=1
    while(i<=5) {
        println(i)
        i++
    }
    i=1
//  At least executes one time
    do{
        println(i)
        i++
    }while(i<=5)
}