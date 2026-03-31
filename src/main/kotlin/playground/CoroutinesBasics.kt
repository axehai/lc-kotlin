package com.axehai.playground

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds


fun main()  {
    println("welcome, we only serve chicken-rice")

    val parentJob = CoroutineScope(Dispatchers.Unconfined).launch {
        launch {
            prepareRice()
        }.invokeOnCompletion {
            println("Rice completion")
        }
        launch {
            prepareChicken()
        }.invokeOnCompletion {
            println("chicken completion")
        }
    }


    println("end of main")
}

suspend fun prepareRice() {
    println("starting to cook rice")
    delay(2.seconds)
    println("rice is ready")
}

suspend fun prepareChicken() {
    println("starting to cook chicken")
    delay(3.seconds)
    println("chicken is ready")
}
