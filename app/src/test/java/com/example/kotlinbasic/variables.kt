package com.example.kotlinbasic

fun main() {
//  val once a value is assigned, you cannot assign a new value to the variable.
    val a = 12
    println(a)
//  var variable value can be changed after it is created.
    var b = 14
    println(a)
    b = 3
    println(a)

//  Declaring means creating a variable by specifying its name and (usually) its type.
//  Initializing means assigning the first value to a variable
//  val c : Int = 5

//    Explicitly Defining Type
    val c : Int = 8
    println(c)
}

// Type Inference is a feature where the Kotlin compiler automatically determines the datatype of a variable
// based on the value assigned to it.this means you don't have to explicitly specify the type in many cases.