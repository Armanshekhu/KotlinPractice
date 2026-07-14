# Kotlin Basic Fundamentals 🚀

![Kotlin](https://img.shields.io/badge/Kotlin-2.2.10-7F52FF?logo=kotlin&logoColor=white)
![Platform](https://img.shields.io/badge/Platform-Android-3DDC84?logo=android&logoColor=white)
![Build](https://img.shields.io/badge/Build-Gradle%20KTS-02303A?logo=gradle&logoColor=white)
![License](https://img.shields.io/badge/License-MIT-blue)

A comprehensive repository dedicated to mastering the Kotlin programming language — from basic syntax to advanced features like Sealed Classes, Generics, Coroutines, and Flow — with a focus on real-world **Android development**.

---

## 📌 Project Overview

This project is a personal playground and reference guide for Kotlin on Android. It contains clean, documented, runnable code examples designed to demonstrate **"The Kotlin Way"** of solving problems — idiomatic, null-safe, and concise.

Every concept below includes a short explanation and a working code snippet you can run directly from the test files.

---

## 📖 Table of Contents

1. [Kotlin Basics](#1-kotlin-basics)
2. [Null Safety](#2-null-safety)
3. [Functions](#3-functions)
4. [Object-Oriented Programming](#4-object-oriented-programming)
5. [Sealed Classes & Enums](#5-sealed-classes--enums)
6. [Data Classes & Collections](#6-data-classes--collections)
7. [Generics](#7-generics)
8. [Extension Functions](#8-extension-functions)
9. [Scope Functions](#9-scope-functions-let-run-with-apply-also)
10. [Higher-Order Functions & Lambdas](#10-higher-order-functions--lambdas)
11. [Delegation & Property Delegates](#11-delegation--property-delegates)
12. [Coroutines](#12-coroutines)
13. [Kotlin Flow](#13-kotlin-flow-stateflow--sharedflow)
14. [Android-Specific Kotlin](#14-android-specific-kotlin)
15. [Tech Stack](#-tech-stack)
16. [Getting Started](#-getting-started)
17. [Roadmap](#-roadmap)
18. [Contributing](#-contributing)
19. [License](#-license)

---

## 1. Kotlin Basics

Variables, `val` vs `var`, string templates, and basic control flow.

```kotlin
fun basics() {
    val name: String = "Android"      // immutable
    var counter = 0                   // mutable, type inferred

    println("Hello, $name! Counter is ${counter + 1}")

    // Ranges & for loops
    for (i in 1..5 step 2) println(i)

    // if as an expression
    val max = if (5 > 3) 5 else 3
}
```

## 2. Null Safety

Kotlin's type system distinguishes nullable and non-nullable types at compile time.

```kotlin
var nickname: String? = null

// Safe call
println(nickname?.length)

// Elvis operator
val length = nickname?.length ?: 0

// Not-null assertion (use sparingly!)
val forced = nickname!!.length

// Safe casting
val value: Any = "text"
val asInt = value as? Int   // null instead of ClassCastException
```

## 3. Functions

Default arguments, named arguments, single-expression functions, and vararg.

```kotlin
fun greet(name: String, greeting: String = "Hello") = "$greeting, $name!"

fun sum(vararg numbers: Int): Int = numbers.sum()

fun main() {
    println(greet(name = "Kotlin"))
    println(sum(1, 2, 3, 4))
}
```

## 4. Object-Oriented Programming

Constructors, inheritance, and access modifiers.

```kotlin
open class Animal(protected val name: String) {
    open fun makeSound() = println("$name makes a sound")
}

class Dog(name: String) : Animal(name) {
    override fun makeSound() = println("$name barks")
}

class Cat(name: String) : Animal(name) {
    private val purrLevel = 10
    override fun makeSound() = println("$name purrs at level $purrLevel")
}
```

## 5. Sealed Classes & Enums

Sealed classes model restricted hierarchies — ideal for representing UI/data states.

```kotlin
sealed class Result<out T> {
    data class Loading(val message: String = "Loading...") : Result<Nothing>()
    data class Success<T>(val data: T) : Result<T>()
    data class Failure(val error: Throwable) : Result<Nothing>()
}

fun <T> stateCheck(state: Result<T>) {
    when (state) {
        is Result.Loading -> println(state.message)
        is Result.Success -> println("Success: ${state.data}")
        is Result.Failure -> println("Error: ${state.error.message}")
        // No 'else' branch needed — the compiler knows Result is sealed!
    }
}
```

> **Note:** In `when` branches, always fully qualify nested sealed subclasses (`Result.Success`) rather than relying on unqualified names — this keeps exhaustiveness checks reliable as the hierarchy grows.

## 6. Data Classes & Collections

```kotlin
data class User(val id: Int, val name: String, val age: Int)

fun collections() {
    val users = listOf(
        User(1, "Alice", 25),
        User(2, "Bob", 17),
        User(3, "Carol", 30)
    )

    val adults = users.filter { it.age >= 18 }
    val names = users.map { it.name }
    val byAge = users.sortedBy { it.age }
    val total = users.sumOf { it.age }
    val grouped = users.groupBy { it.age >= 18 }

    println("Adults: $adults, Total age: $total")
}
```

## 7. Generics

```kotlin
class Box<T>(val item: T) {
    fun get(): T = item
}

// Generic function with a bound
fun <T : Comparable<T>> findMax(a: T, b: T): T = if (a > b) a else b

// Reified type parameter (only possible with inline functions)
inline fun <reified T> isType(value: Any): Boolean = value is T

fun main() {
    println(findMax(10, 20))
    println(isType<String>("Kotlin")) // true
}
```

## 8. Extension Functions

Add functionality to existing classes without inheritance — heavily used across the Android SDK.

```kotlin
fun String.isValidEmail(): Boolean =
    this.matches(Regex("[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]+"))

fun View.visible() { visibility = View.VISIBLE }
fun View.gone() { visibility = View.GONE }

fun main() {
    println("test@example.com".isValidEmail())
}
```

## 9. Scope Functions (`let`, `run`, `with`, `apply`, `also`)

```kotlin
data class Person(var name: String, var age: Int)

fun scopeFunctions() {
    val person = Person("Alice", 25).apply {
        age += 1   // configure the object, returns `this`
    }

    person.let {
        println("Name: ${it.name}")   // operate on non-null, returns result
    }

    val summary = person.run {
        "Person: $name, $age"          // returns result, `this` context
    }

    person.also {
        println("Logging: $it")        // side effects, returns `this`
    }

    with(person) {
        println("$name is $age years old") // no receiver return needed
    }
}
```

## 10. Higher-Order Functions & Lambdas

```kotlin
fun calculate(a: Int, b: Int, operation: (Int, Int) -> Int): Int = operation(a, b)

fun main() {
    val sum = calculate(4, 5) { x, y -> x + y }
    val product = calculate(4, 5) { x, y -> x * y }

    // Function references
    val list = listOf(3, 1, 4, 1, 5)
    println(list.sortedWith(compareByDescending { it }))
}
```

## 11. Delegation & Property Delegates

```kotlin
import kotlin.properties.Delegates

class Settings {
    var username: String by Delegates.observable("Guest") { _, old, new ->
        println("Username changed from $old to $new")
    }
}

// `by lazy` — common for expensive initialization in Android (e.g., ViewModels)
val expensiveResource: String by lazy {
    println("Computed once")
    "Result"
}
```

## 12. Coroutines

Kotlin's approach to asynchronous, non-blocking programming — the standard for Android background work.

```kotlin
import kotlinx.coroutines.*

fun main() = runBlocking {
    // launch: fire-and-forget coroutine
    val job = launch(Dispatchers.Default) {
        delay(1000)
        println("Background work done")
    }

    // async: returns a result via Deferred
    val deferred: Deferred<Int> = async(Dispatchers.IO) {
        delay(500)
        42
    }

    println("Result: ${deferred.await()}")
    job.join()
}

// In a ViewModel:
class MyViewModel : ViewModel() {
    fun fetchData() {
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO) {
                repository.getData()
            }
            _uiState.value = result
        }
    }
}
```

## 13. Kotlin Flow (StateFlow / SharedFlow)

Reactive streams built on top of coroutines — the modern replacement for LiveData.

```kotlin
class WeatherViewModel : ViewModel() {
    private val _uiState = MutableStateFlow<Result<Weather>>(Result.Loading())
    val uiState: StateFlow<Result<Weather>> = _uiState.asStateFlow()

    private val _events = MutableSharedFlow<String>()
    val events: SharedFlow<String> = _events.asSharedFlow()

    fun loadWeather() {
        viewModelScope.launch {
            repository.getWeatherStream()
                .map { Result.Success(it) }
                .catch { emit(Result.Failure(it)) }
                .collect { _uiState.value = it }
        }
    }
}

// In Compose:
@Composable
fun WeatherScreen(viewModel: WeatherViewModel) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()
}
```

## 14. Android-Specific Kotlin

- **Jetpack Compose** — declarative UI using Kotlin functions annotated `@Composable`.
- **KTX extensions** — idiomatic wrappers over Android APIs (`core-ktx`, `fragment-ktx`, `lifecycle-ktx`).
- **View Binding / Data Binding** with Kotlin synthetic-free, type-safe view access.
- **Room + Coroutines/Flow** for reactive, offline-first database access.
- **Sealed classes for Navigation & UI state**, as shown in [Section 5](#5-sealed-classes--enums).
- **Dependency Injection** with Hilt/Koin using Kotlin constructor injection.

```kotlin
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(text = "Hello, $name!", modifier = modifier)
}

@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    fun getAllUsers(): Flow<List<User>>
}
```

---

## 🛠 Tech Stack

| Category        | Details                          |
|------------------|-----------------------------------|
| Language         | Kotlin 2.2.10                    |
| Build System     | Gradle (Kotlin DSL)              |
| Minimum SDK      | 24 (Android)                      |
| Async            | Kotlin Coroutines & Flow          |
| Testing          | JUnit 4, MockK (planned)          |
| IDE              | Android Studio Ladybug+ / IntelliJ IDEA |

---

## 🚀 Getting Started

### Prerequisites

- Android Studio Ladybug (or newer) or IntelliJ IDEA
- JDK 17 or higher

### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/your-username/KotlinBasic.git
   ```
2. **Open in Android Studio**: `File > Open` → select the cloned folder
3. **Run the examples**: Navigate to `app/src/test/java/com/example/kotlinbasic/` and run the `main()` functions inside each file to see output in the console.

---

## 📝 Roadmap

- [x] Sealed Classes for state management
- [x] Type-safe `when` expressions
- [x] OOP: constructors, inheritance, access modifiers
- [x] Generics and reified types
- [x] Kotlin Coroutines (scopes, contexts, jobs)
- [x] Kotlin Flow (StateFlow / SharedFlow)
- [ ] Unit testing examples with MockK
- [ ] Jetpack Compose UI examples
- [ ] Room database + Flow integration
- [ ] Dependency Injection with Hilt
- [ ] Kotlin Multiplatform (KMP) basics

---

## 🤝 Contributing

Contributions are welcome! If you'd like to add a new concept or improve an existing example:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/generics-examples`)
3. Commit your changes with clear messages
4. Open a Pull Request

---

## 📄 License

This project is licensed under the [MIT License](LICENSE).
