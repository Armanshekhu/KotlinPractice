package com.example.kotlinbasic

fun main() {
//  Non-nullable Type = variable cannot store null
    var s1:String = "Arman"
//  Nullable Type = variable that can stor null value also
    var s2:String? = null
    println(s1.isPalindrome())
//  Surround with null check
    if (s2 != null) {
//        println(s2.isPalindrome())
    }

//  Safe call operator = if s2 is null then return null instead of throwing an exception
    println(s2?.isPalindrome())

//  Elvis operator provide a default value when the variable is null
    var len = s2?.length ?: -1
    println(len)

//  Not-null assertion operation(!!) - I am sure this value is not null. If it is null, throw an exception
//    println(s2!!.length)

//  let - scope function
    s2?.let { // ?. check is s2 is not null
        println(s2.length) // if not null then let excutes
    }
}