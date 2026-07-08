package com.example.kotlinbasic
// Multiple inheritance is not supported in java

fun main() {
    val obj = DerivedClass()
//    println(obj.name)
    println(obj.name2)
//    obj.show()
    obj.show2()


    val car = Car()
    println(car.name)
    car.drive()

    val vehicle = Vehicle()
    println(vehicle.name)
    vehicle.drive()
}

open class BaseClass {
    var name = "BaseClass"
    fun show() {
        println("I am Base Class")
    }
}

class DerivedClass : BaseClass() {
    var name2 = "DerivedClass"
    fun show2() {
        println("I am ${name}")
        println("I am Derived Class")
    }
}


open class Vehicle {
//  Using init to check if object of base is created internally when creating object of derived class
    init {
        println("This is Vehicle")
    }
    open var name = "Vehicle"
    open fun drive() {
        println("Driving Vehicle")
    }
}

class Car : Vehicle(){
    init{
        println("This is Car")
    }
    override var name = "Car"
    override fun drive() {
//      Super is used to access members(functions, properties, or constructors) of the parent(super class)
        super.drive()
        println("Driving Car")
    }
}