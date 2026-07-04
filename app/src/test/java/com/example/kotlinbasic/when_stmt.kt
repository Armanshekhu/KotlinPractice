package com.example.kotlinbasic

fun main() {
    var a = 10
    var b = 15
    var operation = "sub"

//  When as a statement
    when(operation) {
        "add" ->  {
            var c = a+b
            println("Addition of a and b is $c")
        }
        "sub" ->  println("Subtraction of a and b is ${a-b}")
        "mul" ->  println("Multiplication of a and b is ${a*b}")
        "div" ->  println("Division of a and b is ${a/b}")
        "mod" ->  println("Modulus of a and b is ${a%b}")
        else -> println("Wrong Operation specified")
    }

//  When as an expression
    var ans = when(operation) {
        "add" -> a+b
        "sub" ->  a-b
        "mul" ->  a*b
        "div" ->  a/b
        "mod" ->  a%b
        else -> 0
    }

    println("Ans is $ans")

//  Using in, !, until
    val c=10
    when(c) {
        2 -> println("c is 2")
        in 3..5 -> println("c is between 3 and 5")
        !in 6 ..10 -> println("c is not between 6 to 8")
        in 9 until 12 -> println("c is between 9 to 12")
        else -> println("Not in range")
    }
}