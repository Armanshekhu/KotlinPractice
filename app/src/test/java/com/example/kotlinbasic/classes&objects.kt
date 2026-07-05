package com.example.kotlinbasic

fun main() {
    var person1 = Person1()
    var person2 = Person2("Arman",22,"Male","Android Developer")
    var person3 = Person2("Farhan",19,"Male","Full Stack Developer")
    person1.getAge()
    person2.work()
    person3.work()
}

class Person1 {
    var name = "Arman"
    var age = 22
    var gender = "Male"
    var occupation = "Android Developer"

    fun work() : Unit {
        println("$name is a $occupation")
    }

    fun getAge() : Unit {
        println("Age is $age")
    }

    fun getGender() : Unit {
        println("$name is $gender")
    }
 }

//  Class with Primary Constructor
class Person2(var name : String, var age : Int, var gender : String, var occupation : String) {
    fun work() : Unit {
        println("$name is $occupation")
    }

    fun getAge() : Unit {
        println("Age is $age")
    }

    fun getGender() : Unit {
        println("$name is $gender")
    }
}