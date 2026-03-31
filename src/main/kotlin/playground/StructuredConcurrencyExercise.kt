package com.axehai.playground

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

    suspend fun prepareLunch(station: KitchenStation): Lunch {
        TODO("Use coroutineScope + async so rice and chicken cook in parallel.")
    }

    suspend fun prepareLunchFailFast(station: KitchenStation): Lunch {
        TODO("Use structured concurrency so a chicken failure cancels the rice sibling.")
    }

    suspend fun prepareLunchSupervised(station: KitchenStation): LunchReport {
        TODO("Use supervisorScope so chicken failure does not cancel rice.")
    }
}
