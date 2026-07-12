package com.example.kotlinbasic

fun main() {

}
// you can have abstract function as well as abstract variable
// abstract class are by default considered open
// abstract class can not be instantiated - means you can directly create its object
// you can have more than one abstract function in a class
// Meaning of abstract - If I don't know the value of a variable or implementation of a function,
// but we know it subclasses will implement as use it according to them so we make them abstract
abstract class Shapes {
    abstract var i : Int
    abstract fun draw()
    abstract fun side()
    fun name() {
        println("Name is Shapes")
    }
}

class Circles:Shapes() {
    override var i = 0
    override fun draw() {
        println("Draw a circle")
    }
    override fun side() {
        println("Circle has $i sides")
    }
}

class Triangles:Shapes() {
    override var i = 3
    override fun draw() {
        println("Draw a triangle")
    }
    override fun side() {
        println("Triangle has $i sides")
    }
}