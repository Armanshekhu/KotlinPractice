package com.example.kotlinbasic

fun main() {
    val a = 10
    val b = 15
    println(addition(a,b))

//  Using Named arguments
    println(subtraction(b = b))

    println(multiplication(a,b))

//  Function reference - refer to a function without calling it.
//  c store reference to addition function
    val c = ::addition
    println(c(a,b))

//  Using Signature Mapping it choose which function to call
    val d = subtraction(a,b)
    val e = subtraction(a,b,6)
}

// fun functionName(parameter1: Type,parameter2: Type,...): ReturnType {
//    function body
// }
fun addition(a : Int, b : Int) : Int {
    return a+b
}


// Default Parameter
fun subtraction(a : Int = 50, b : Int) : Int {
    return a-b
}

fun subtraction(a:Int,b:Int,c:Int) : Int {
    return a+b+c
}

// Function as an expression
fun multiplication(a : Int,b : Int) : Int = a*b

