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
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.time.Duration.Companion.milliseconds

//withContext:
//
//Does not create a new independent coroutine like launch.
//Changes the coroutine's context/dispatcher for the block.
//Suspends the current coroutine until the block finishes.
//Does not block the underlying thread while suspended.
//Can only be called from a suspend function or another coroutine.
class WithContextActivity : ComponentActivity() {
    private val TAG : String = "WithContextActivityResults"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launch {
            withContextDemo()
        }
        enableEdgeToEdge()
        setContent {}
    }

    suspend fun withContextDemo() {
        Log.d(TAG,"Started on ${Thread.currentThread().name}")
        val users = withContext(Dispatchers.IO){ // withContext is blocking means it suspend the thread until it code is completed
            fetchUsers()
        }
        Log.d(TAG,"User :: $users")
        val ages = withContext(Dispatchers.IO){
            fetchAges()
        }
        Log.d(TAG,"Age :: $ages")
    }

    suspend fun fetchUsers() : String {
        delay(2000.milliseconds)
        Log.d(TAG,"User fetched on ${Thread.currentThread().name}")
        return "Arman"
    }

    suspend fun fetchAges() : String {
        delay(2000.milliseconds)
        Log.d(TAG,"Age fetched on ${Thread.currentThread().name}")
        return "22"
    }
}


