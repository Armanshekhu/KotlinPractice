package com.example.kotlinbasic

fun main() {
    val a = 4
    val b = 5
//  If as a statement
    if(a>b) {
        println("$a is greater than $b")
    } else {
        println("$b is greater than $a")
    }

//  If as a statement
//  In kotlin there is no ternary operator instead of the out can use if as an expression
    var max = 0
    max = if(a<b) b else a
    println("max is $max")


    val mark = 100
    val grade = if(mark>=80) "Excellent" else if(mark>80 && mark>=60) "Good" else "Average"
    println("Your grade is $grade")
}