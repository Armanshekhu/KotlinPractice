package com.example.kotlinbasic

fun main() {
// They are like static and you can access them using class Name
    Person.Student.name()

//  Using companion
    Person.name()


    val person = Person3.Factory.create("Student")
    println(person.type)
}

// You can many as many object but remember key a singleton
// so Student and Teacher will have one instance
class Person {
    object Student{
        fun name() {
            println("Name is Student")
        }
    }

//  This means Person becomes companion of Teacher and use functions properties without object name
    companion object Teacher{
        fun name() {
            println("Name is Teacher")
        }
    }
}

// Factory Pattern is a creational design pattern that hides object creation from the user
class Person3(val type:String){
    object Factory {
        fun create(type:String):Person3 {
            return when(type) {
                "student" -> Person3("Student")
                "teacher" -> Person3("Teacher")
                else -> Person3("person")
            }
        }
    }
}