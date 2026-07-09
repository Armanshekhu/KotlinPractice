package com.example.kotlinbasic

fun main() {
    val circle = Circle()
    circle.draw()

    val triangle = Triangle()
    triangle.draw()

    val obj : Shape = Circle()
    obj.draw()

//  Array type is Shape and this is array of objects
    val array = arrayOf(Circle(), Triangle())

    for(arr in array) {
        arr.draw()
    }

}

//  open class means other classes can inherit from it
//  without open, Kotlin makes classes and methods final by default
open class Shape {
//   open fun means the function can be overridden
     open fun draw() {
        println("Drawing a shape")
    }
}

// : is used for inheritance
class Circle : Shape() {
//  override replaces the parent implementation.
    override fun draw() {
        println("Drawing a circle")
    }
}

class Triangle : Shape(){
    override fun draw() {
        println("Drawing a triangle")
    }
}
