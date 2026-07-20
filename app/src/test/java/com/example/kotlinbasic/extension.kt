package com.example.kotlinbasic

fun main() {
    val circle = Circle1()
    println(circle.area(4))
    println(circle.perimeter(4))

    val str = "Madan"
    println(str.isPalindrome())
}

class Circle1{
    fun area(r:Int) : Double {
        return 3.14*r*r
    }
}

fun Circle1.perimeter(r:Int) : Double {
    return 2*3.14*r
}


fun String.isPalindrome() : Boolean {
    return this.lowercase() == this.lowercase().reversed()
}