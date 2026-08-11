package com.example.kotlinbasic

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.example.kotlinbasic.ui.theme.KotlinBasicTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.milliseconds

class LaunchAsyncDemo : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        lifecycleScope.launch {
            loadHomeScreen()
        }
        setContent {}
    }
}

suspend fun saveUserLogs() {
    val job = CoroutineScope(Dispatchers.IO).launch{
        println("Saving started")
        delay(1000.milliseconds) // Stimulating network call
        println("Saving done")
    }
    job.join()
    println("User logs getting saved")
}

suspend fun fetchUserProfile() {
    val userDeferred = CoroutineScope(Dispatchers.IO).async { // deferred string return type bcz value will be returned after sum time
        Log.d("User Profile","Fetching user profile...")
        delay(1000.milliseconds)
        "CS Tech Tube" // last line is the return value
    }
    Log.d("User Profile","Doing other work...")
    val userName = userDeferred.await()
    Log.d("User Profile","User name: $userName")
}

fun loadHomeScreen() {
    CoroutineScope(Dispatchers.IO).launch {

        val userDeferred = async {
            Log.d("User_logs","Fetching user...")
            delay(1000.milliseconds)
            "Arman Shekhu"
        }

        val ageDeferred = async {
            Log.d("User_logs","Fetching age...")
            delay(1000.milliseconds)
            "22"
        }

        val professionDeferred = async {
            Log.d("User_logs","Fetching profession...")
            "Android Developer"
        }

        val result = "Name : ${userDeferred.await()} | Age : ${ageDeferred.await()} | Profession : ${professionDeferred.await()}"

        Log.d("User_logs","Dashboard : $result")
    }
}
