package com.example.kotlinbasic

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.example.kotlinbasic.ui.theme.KotlinBasicTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.milliseconds

class SuspendingFunctionDemo : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Button(
                    onClick = {
                        lifecycleScope.launch {
                            launch {
                                first()
                            }
                            launch {
                                second()
                            }
                        }
                    }
                ) {
                    Text("Start Demo")
                }
            }
        }
    }
}

private const val TAG = "SuspendingDemo"

suspend fun first() {
    Log.d(TAG, "Coroutine 1: Start -> ${Thread.currentThread().name}")
    delay(1000.milliseconds)
    Log.d(TAG, "Coroutine 1: Resume -> ${Thread.currentThread().name}")
}

suspend fun second() {
    Log.d(TAG, "Coroutine 2: Start -> ${Thread.currentThread().name}")
    delay(1000.milliseconds)
    Log.d(TAG, "Coroutine 2: Resume -> ${Thread.currentThread().name}")
}