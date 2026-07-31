package com.example.kotlinbasic

// Higher Order function - is a function that can take another function as parameter
// or return a function, or does both
fun main() {
    println(square(2))
//  sq is Kfunction1<Int,Int> type bcz it take one parameter and return one
//  :: is called callable reference and can be used to store a function inside
//  a variable without invoking its constructor(mean need to pass parameter)
    val sq = ::square
    println("Square of 10 is ${sq(10)}")
    arithmeticOpr(10,9,::add) // reference call
    arithmeticOpr(10,7, fun (a:Int, b:Int):Int { // anonymous function(full function without name)
        return a+b
    })
}

fun square(num : Int) : Int {
    return num*num
}

fun add(n1 : Int, n2 : Int) : Int{
    return n1+n2
}

fun arithmeticOpr(a:Int,b:Int, fn:(Int, Int) -> Int) {
    val result = (fn(a,b))
    println(result)
}