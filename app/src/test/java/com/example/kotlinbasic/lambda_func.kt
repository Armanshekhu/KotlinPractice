package com.example.kotlinbasic

fun main() {
//  Lambda function is an anonymous function(a function without a name) that can be passed as argument, stored in variable,
//  or returned from another function {input -> output}
    val lambdaFunction1 = {a:Int,b:Int->a+b} // Simple single line lambda function
    println(lambdaFunction1(3,2))
    val lambdaFunction2 = {name:String -> // Multiple line lambda function's last line becomes return type
        println("$name Achieved")
    }
    lambdaFunction2("Arman")

    val lambdaMinus : (Int, Int) -> Int = { x, y->x-y}
    println(lambdaMinus(5,2))

    val lambdaSquare1 : (Int) -> Int = {x -> x*x}
//  it is a special implicit parameter that kotlin provides only when you do not declare a parameter.
//  (it ->) it become the explicitly declared parameter which defeats the purpose of the implicit it.
    val lambdaSquare2 : (Int) -> Int = {it -> it*it}
    println(lambdaSquare1(9))
    println(lambdaSquare2(9))

//  Using Lambda function using higherOrder function
    arithmeticOpr1(4,5) { a, b -> a + b }
    arithmeticOpr1(4,5) { a, b -> a - b }
    arithmeticOpr1(4,5) { a, b -> a * b }
    arithmeticOpr1(4,5) { a, b -> a / b }
    arithmeticOpr1(4,5) { a, b -> a % b }
}

fun arithmeticOpr1(a:Int, b:Int, fn : (Int,Int)->Int) {
    val sum = fn(a,b)
    println(sum)
}


