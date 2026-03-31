package com.axehai.playground

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

interface KitchenStation {
    suspend fun cookRice(): String
    suspend fun cookChicken(): String
}

data class Lunch(
    val rice: String,
    val chicken: String,
)

data class LunchReport(
    val rice: String?,
    val chicken: String?,
    val errors: List<String>,
)

class StructuredConcurrencyExercise {

    suspend fun prepareLunch(station: KitchenStation): Lunch = coroutineScope {
        val riceDeferred = async { station.cookRice() }
        val chickenDeferred = async { station.cookChicken() }
        Lunch(riceDeferred.await(), chickenDeferred.await())

    }

    suspend fun prepareLunchFailFast(station: KitchenStation): Lunch {
        TODO("Use structured concurrency so a chicken failure cancels the rice sibling.")
    }

    suspend fun prepareLunchSupervised(station: KitchenStation): LunchReport {
        TODO("Use supervisorScope so chicken failure does not cancel rice.")
    }
}
