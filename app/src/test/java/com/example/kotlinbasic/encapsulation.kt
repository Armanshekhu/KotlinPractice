package com.example.kotlinbasic

fun main() {
    var obj = A()
    println(obj.a)

    var obj2 = B()
    println(obj2.show())
}


// At root level - means not encapsulation
// protected can not be used for root level variable or function
var a=0
fun abc(){}
public open class A{
    public var a = 10
    //b is encapsulated in this class and can't be accessed even then using obj
    private var b = 12
    //c is protected and are visible in the subclasses
    protected var c = 14

}

internal class B:A(){
    fun show() {
        println(c)
    }
}