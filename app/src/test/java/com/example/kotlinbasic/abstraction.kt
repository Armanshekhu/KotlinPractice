package com.example.kotlinbasic

fun main() {

    val array = arrayOf(Triangles(),Circles(),Picture())
    for(shape in array) {
        shape.name()
    }

}
// you can have abstract function as well as abstract variable
// abstract class are by default considered open
// abstract class can not be instantiated - means you can directly create its object
// you can have more than one abstract function in a class
// Meaning of abstract - If I don't know the value of a variable or implementation of a function,
// but we know it subclasses will implement as use it according to them so we make them abstract

// Multiple interfaces can also be used to mimic multiple inheritance
abstract class Shapes:Name,Star {
    abstract var i : Int
    abstract fun draw()
    abstract fun side()
}

// function inside interface are abstract my default
//now name function can be used across two separate inheritance tree
interface Name {
//  abstract function as no-body
    fun name()
//  open function can also be implemented
    fun xyz() {
        println("xyz")
    }
}

interface Star {

}

class Circles:Shapes() {
    override var i = 0
    override fun draw() {
        println("Draw a circle")
    }
    override fun side() {
        println("Circle has $i sides")
    }
    override fun name() {
        println("Name is circle")
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

    override fun name() {
        println("Name is triangle")
    }
}


class Picture:Name {
    override fun name() {
        println("Name is Picture")
    }

}