package com.example.kotlinbasic

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@Preview(showBackground = true)
@Composable
fun MainScreen() {

    println("Thread name : ${Thread.currentThread()}")
    var num by remember{ mutableIntStateOf(0) }
    var counter by remember{mutableStateOf("Counter")}
    var result by remember{mutableStateOf("Total Sum")}

    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(counter)

        Spacer(Modifier.height(16.dp))

        Button(
            onClick= {
                num += 1
                counter = "Counter : $num"
            }
        ) {
            Text("Increment")
        }

        Spacer(Modifier.height(24.dp))

        Text(result)

        Spacer(Modifier.height(16.dp))

        Button(
            onClick= {
                result = "Calculating..."

                scope.launch {
                    val sum = calculateSum()
                    result = " Total Sum : $sum"
                }
            }
        ) {
            Text("Calculate Sum")
        }
    }
}

suspend fun calculateSum() : Long = withContext(Dispatchers.Default) {
    println("Thread name inside calculateSum: ${Thread.currentThread()}")
    var sum = 0L
    for(i in 1..1_500_000_000) {
        sum += i
    }
    sum
}

@Preview(showBackground = true)
@Composable
fun MainScreen1() {

    println("Thread name : ${Thread.currentThread()}")
    var num by remember{ mutableIntStateOf(0) }
    var counter by remember{mutableStateOf("Counter")}
    var result by remember{mutableStateOf("Total Sum")}

    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(counter)

        Spacer(Modifier.height(16.dp))

        Button(
            onClick= {
                num += 1
                counter = "Counter : $num"
            }
        ) {
            Text("Increment")
        }

        Spacer(Modifier.height(24.dp))

        Text(result)

        Spacer(Modifier.height(16.dp))

        Button(
            onClick= {
                scope.launch {
                    result = "Calculating..."
                    val sum = withContext(Dispatchers.Default) {
                        calculateSum1()
                    }
                    result = " Total Sum : $sum"
                }

            }
        ) {
            Text("Calculate Sum")
        }
    }
}

fun calculateSum1() : Long  {
    println("Thread name inside calculateSum: ${Thread.currentThread()}")
    var sum = 0L
    for(i in 1..6_500_000_000) {
        sum += i
    }
    return sum
}