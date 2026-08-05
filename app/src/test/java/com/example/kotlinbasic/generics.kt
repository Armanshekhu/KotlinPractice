package com.example.kotlinbasic

fun main() {
    show(4)
    show("Arman")
    show(false)
//  You can explicitly specific type also
    show<Int>(4)
    show<String>("Arman")

    var obj = Demo(1)
    var obj2 : Demo<String> = Demo("Arman")
    var obj3 : Demo<Int> = Demo(1)

}


// Generic function
fun <T> show(num : T) {
    println(num)
}

// Generic class
class Demo<T>(var num : T) {
    fun show() {
        println("This is $num")
    }
}