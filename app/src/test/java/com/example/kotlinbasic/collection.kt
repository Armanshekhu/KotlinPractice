package com.example.kotlinbasic

fun main() {
//    listEx()
//    setEx()
    mapEx()
}

fun listEx() {
    //  Immutable list
    var list = listOf(1,3,5,7)
    println(list)
//  list[0] = 8 error
    println(list[0])
    println(list.get(0))

//  Mutable list can use both val and var
    var list2 = mutableListOf(1,3,5,7)
    list2.addAll(list)
    println(list2)
    list2[0] = 8
    println(list2[0])
    println(list2.add(0))
    println(list2)
    println(list2.contains(8))
    println(list2.containsAll(listOf(3,5)))
}

fun setEx() {
    val subjectSet = setOf("CS","Physics","Chemistry","Math","CS","Physics")
    println(subjectSet)
    println(subjectSet.elementAt(0))
    println(subjectSet.contains("English"))
    subjectSet.forEach { subject->
        println(subject)
    }

    val subjectSet2 = mutableSetOf("CS","Physics","Chemistry","Math","CS","Physics")
    println(subjectSet2)
    subjectSet2.add("English")
    println(subjectSet2)
    subjectSet2.remove("CS")
    println(subjectSet2)
}

fun mapEx() {
//  Immutable map
    var map = mapOf(1 to "1",2 to "2",3 to "3",3 to "4")
    println(map)

//  Mutable map
    var map2 = mutableMapOf<Int,String>(1 to "1",2 to "2",3 to "3")
    map2.put(1,"4")
    println(map2)
    map2[1] = "1"
    println(map2)
    map2.remove(1)
    println(map2)
    map2.put(4,"4")
    println(map2)
    map2.replace(4,"10")
    println(map2)

    for((key,value) in map2) {
        println("Key is $key : Value is $value")
    }
}