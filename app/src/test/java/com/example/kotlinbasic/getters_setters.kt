package com.example.kotlinbasic

import androidx.compose.animation.fadeOut

fun main() {
    val voter1 = Voter1();
    val voter2 = Voter2();
    voter2.output()
//    voter2.ageToVote = 12;
    voter2.output()
}

class Voter1() {
//  late init can't be used on primitive datatypes
//  late init can't be used with val
    lateinit var ageToVote : String;
}

class Voter2() {
//    getter and setter always comes under the attribute
    var ageToVote = 18
//  field is a special keyword in kotlin that refers to the backing field
//  - the actual variable where the property's value is stored
        get(){
            println("Age to vote should be greater or equal to 18")
            return field
        }
        set(value) {
            if(value<18) {
                println("Age to vote cannot be lesser than 18")
            } else {
                field = value
            }
        }
    fun output() {
        println(ageToVote)
    }
}