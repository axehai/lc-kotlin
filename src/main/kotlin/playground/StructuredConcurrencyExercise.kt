package com.axehai.playground

import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.supervisorScope

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

    suspend fun prepareLunchFailFast(station: KitchenStation): Lunch = coroutineScope {
        val riceDeferred = async { station.cookRice() }
        val chickenDeferred = async { station.cookChicken() }
        Lunch(riceDeferred.await(), chickenDeferred.await())
    }

    suspend fun prepareLunchSupervised(station: KitchenStation): LunchReport = supervisorScope {
        val riceDeferred = async { station.cookRice() }
        val chickenDeferred = async { station.cookChicken() }
        val errorList = mutableListOf<String>()

        val rice = try {
            riceDeferred.await()
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            errorList.add(e.message?:"unknown rice error")
            null
        }

        val chicken = try {
            chickenDeferred.await()
        }catch (e: CancellationException){
            throw e
        }
        catch (e: Exception) {
            errorList.add(e.message ?: "unknown chicken error")
            null
        }

        LunchReport(rice, chicken, errorList)
    }
}
