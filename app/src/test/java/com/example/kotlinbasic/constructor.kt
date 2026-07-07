package com.example.kotlinbasic

fun main() {
    // Default Constructor
    val animal1 = Animal1()
    // Primary Constructor
    val animal2 = Animal2("Lalu",5,"Desi Billi","Black Grey")
    val animal3 = Animal3("Mufasa","Desi Billi")

}

class Animal1() {
    var name = "Lalu"
    var age = 5
    var breed = "Desi Billi"
    var color = "Black Grey"
}

// var or val should be written in primary constructor then only they are considered attributes
// otherwise they remain parameter

class Animal2(var name : String, var age : Int, var breed : String, var color : String) {
//  init block is a special block that is executed immediately after the primary constructor
//  Use - Validate constructor parameters, Initialize properties, Execute code whenever an object is created
//  you can create as my init block you require
    init {
        println("Name of animal is $name")
    }

}

//Secondary constructor ( It is always called with Primary constructor )
class Animal3(var name : String, var age : Int, var breed : String, var color : String) {
    constructor(animalName: String,animalColor: String) : this(animalName,1,"Desi Billi",animalColor)
    init {
        println("Name is $name")
        println("Age is $age")
    }

}


