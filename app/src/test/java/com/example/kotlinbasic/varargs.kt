package com.example.kotlinbasic

fun main() {
//  Using vararg
    show(2,3,4,5,6,7)

//  Using array
//  var arr = arrayOf(2,3,4,5,6,7) this give error because for primitive type vararg internally convert then value into primitive
//  type array and stores them like IntArray, DoubleArray
//  Using correctly by type specific array
    var arr = intArrayOf(2,3,4,5,6,7)
//  * Spread Operator
    show(*arr)

//  But non-primitive data type you don't need type specific array and here it store object type array not primitive type array
    var arr2 = arrayOf("A","B","C","D","E")
    show2(*arr2)

}

fun show(vararg number : Int) {
    for(i in number) {
        println(i)
    }
}

fun show2(vararg number : String) {
    for(i in number) {
        println(i)
    }
}
