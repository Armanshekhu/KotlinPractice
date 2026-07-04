package com.example.kotlinbasic

fun main() {
    val a = 22
//  String interpolation is a feature that lets you embed variables or expressions directly inside a string
//  using the $ symbol, instead of concatenating strings with +
    println("My age is $a")

    println("My age is ${a+1}")
}