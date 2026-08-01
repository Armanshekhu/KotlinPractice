package com.example.kotlinbasic

//Context is a handle to the Android system. It lets your app interact with the operating system.
//Think of it as entry point to Android resource and services.
fun main() {
    val emp = Employee()
//  One way
//  emp.id = 1
//  emp.name = "Arman"

//  Apply - most common for object initialization
//  Second way
    val x = emp.apply{ // {} means lambda function
        id = 1
        this.name = "Arman"
    }

    println("Id : ${emp.id} Name : ${emp.name}")

//  Let - for null checking
    val emp1:Employee? = Employee()

    var y = emp1?.let{
        println(it.name)
    }

//  With
    var z = with(emp) {
        println(this.name)
    }

//  Run
    emp1?.run{
        println(name)
    }

//  Also
    emp.also {
        println("Name is ${it.name}")
    }
}

/*
Scope Functions
    -let
    -run
    -with
    -apply
    -also
*/

class Employee {
    var id:Int = 0
    var name:String = ""
}