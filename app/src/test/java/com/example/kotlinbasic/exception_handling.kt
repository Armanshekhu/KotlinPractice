package com.example.kotlinbasic

fun main() {
//  Try surrounds the suspicious code and it can't be used alone
    try {
//        var a = "abc".toInt()
        isEven(5)
//  catch catches the exception and display the message
    } catch(e:NumberFormatException) {
        println("${e.message}")
    } catch(e: Exception) {
        println(e)
    } finally {
        println("Done")
    }
}

// Throw - used to throw custom exception
fun isEven(num:Int) {
    if(num%2!=0) {
        throw IllegalArgumentException("Number is not Even")
    }
}