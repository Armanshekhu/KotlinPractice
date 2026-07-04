package com.example.kotlinbasic

fun main() {
    val a = 15
    val b = 8

    println("Addition (a+b) = ${a+b}")
    println("Subtraction (a+b) = ${a-b}")
    println("Multiplication (a*b) = ${a*b}")
    println("Division (a/b) = ${a/b.toFloat()}")
    println("Modulus (a%b) = ${a%b}")


    var x = 10
    x+=10
    println("x+=10 $x")
    x-=10
    println("x-=10 $x")
    x*=10
    println("x*=10 $x")
    x/=10
    println("x/=10 $x")
    x%=10
    println("x%=10 $x")


    val i=10
    val j=15

    println("i<j:${i<j}")
    println("i>j:${i>j}")
    println("i<=j:${i<=j}")
    println("i>=j:${i>=j}")
    println("i==j:${i==j}")
    println("i!=j:${i!=j}")

    val l = 10
    val m = 20
    val n = 30
    println("l>m && m<n : ${l>m && m<n}")
    println("l>m || l<n : ${l>m || l<n}")
    println("!(l<m) : ${l<m}")

    var v = 4
    println("++v :${++v}")
    println("v++ :${v++}")
    println(v)
    println("--v :${--v}")
    println("v-- :${v--}")
    println("v :${v}")
}