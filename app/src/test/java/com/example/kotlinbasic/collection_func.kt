package com.example.kotlinbasic

fun main() {
    val list = listOf("MSC","Madam","civic","CS","radar")
//  Filter function
    var palindrome = list.filter(::isPalindrome) // Using reference operator
    var palindrome2 = list.filter(  // Using anonymous
        fun (str:String) : Boolean {
            return str.lowercase()==str.lowercase().reversed()
        }
    )
    var palindrome3 = list.filter{isPalindrome(it)} // Using lambda expression
    println(palindrome)
    println(palindrome2)
    println(palindrome3)


//  Map function
    println(list.map{it+" length is "+it.length})

//  forEach function
    list.forEach{
        println(it)
    }

//  count function
    println(list.count())
}

fun isPalindrome(str:String) : Boolean {
    return str.lowercase()==str.lowercase().reversed()
}