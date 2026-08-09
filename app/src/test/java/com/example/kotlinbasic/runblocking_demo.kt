package com.example.kotlinbasic

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration.Companion.milliseconds

@OptIn(DelicateCoroutinesApi::class)
fun main() {
    runBlocking { // runBlocking is a coroutine builder that blocks the current thread until the coroutine inside it completes , by default runs on main thread
                  // Don't continue to the next line until everything inside runBlocking has completed
                  // delay() suspends the coroutine for 1 second
                  // However, runBlocking is blocking the thread while waiting for its coroutine to finish
                  // used in unit test cases
        delay(1000.milliseconds)
        println("Coroutine Finished")
    }
    println("Main Waiting")
//  Without `runBlocking`, `launch` starts a coroutine without blocking the current thread or waiting for the coroutine to complete. Therefore, the `main()` function may finish before the coroutine completes its execution.
}

//runBlocking:
//
//Starts a coroutine.
//Blocks the current thread until the block finishes.
//Can be used from a non-suspend function.
//Commonly used at the boundary between normal blocking code and coroutines, such as main() in examples/tests.

//withContext:
//
//Does not create a new independent coroutine like launch.
//Changes the coroutine's context/dispatcher for the block.
//Suspends the current coroutine until the block finishes.
//Does not block the underlying thread while suspended.
//Can only be called from a suspend function or another coroutine.
