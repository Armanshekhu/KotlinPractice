package com.example.kotlinbasic

fun main() {
    var student = Student("Arman",22,"O")
    var student2 = Student("Arman",22,"O")

    println(student.toString())
//  For normal class they this give false bcz it compares their address
    println(student.equals(student2))

    var student1 = Student2("Arman",22,"O")
    var student12 = Student2("Arman",22,"O")
//  For data class they are equals as it compares the values and gives true
    println(student1 == student12)
    println(student12)
    var student3 =  student12.copy(age=23)
    println(student3)


//  student1 and student12 has same hashcode bcz they have same values
    println(student1.hashCode())
    println(student12.hashCode())
    println(student3.hashCode())

    println(student3.component1())
    println(student3.component2())
    println(student3.component3())

    val(studentName,studentAge,studentGrade) = student3
    println("$studentName $studentAge $studentGrade")
}

class Student(val name : String,val age : Int,val grade : String)

data class Student2(val name : String,val age : Int,val grade : String)