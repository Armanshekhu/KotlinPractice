package com.example.kotlinbasic

fun main() {
    val arr1 = arrayOf(10,2,3,41,9)
    var arr2 = arrayOf<String>("CS","IT","ME","ECE")
//  joinToString() is a collection function that concatenate(joins) all the elements of a collection into a
//  single string
    println(arr1.joinToString())

//  Array with index
    for((i,e) in arr2.withIndex()) {
        println("$i $e")
    }

//  Setting value
    arr2[2] = "S"
//  arr2.set(index,value)
    arr2.set(2,"ME")

//  Getting value
//  Print element using indexing
    println("arr2[2] : ${arr2[2]}")
    println("arr2[2] : ${arr2.get(2)}")

}