package com.example.kotlinbasic

fun main() {
//  As it is the object so use the name itself to access variable or functions
    println(ABC.name)
    ABC.getName()

//  Object as expression
//  Substitution for anonymous class( where class has no name)
    val obj = object{
        val name = "ABC"
        fun getName() {
            println("Name is $name")
        }
    }

    println(obj.name)
    obj.getName()

    val obj2 = object:Y{
        override fun getName() {
            println("This is anonymous object")
        }
    }

    obj2.getName()
}

// You can't specify constructor for object
// object ABC() wrong
// If class can have many constructor but when used object keyword only one object can be created
object ABC: X() {
    val name = "Arman"

    fun getName() {
        println("Name is $name")
    }
}

// If ABC is object and it inherits X then it need constructor
open class X {
}

interface Y {
    fun getName()
}