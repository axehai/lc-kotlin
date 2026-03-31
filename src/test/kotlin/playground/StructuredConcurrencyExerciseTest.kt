package playground

import com.axehai.playground.KitchenStation
import com.axehai.playground.Lunch
import com.axehai.playground.LunchReport
import com.axehai.playground.StructuredConcurrencyExercise
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.test.runTest
import kotlin.test.Ignore
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

@OptIn(ExperimentalCoroutinesApi::class)
class StructuredConcurrencyExerciseTest {

    private val exercise = StructuredConcurrencyExercise()

    @Test
    fun prepareLunch_runsRiceAndChickenConcurrently() = runTest {
        val kitchen = FakeKitchen(now = { testScheduler.currentTime })

        val actual = exercise.prepareLunch(kitchen)

        assertEquals(Lunch(rice = "rice", chicken = "chicken"), actual)
        assertEquals(
            listOf(
                "rice:start@0",
                "chicken:start@0",
                "rice:done@1000",
                "chicken:done@1500",
            ),
            kitchen.events
        )
        assertEquals(1500, testScheduler.currentTime)
    }

    @Test
    @Ignore
    fun prepareLunchFailFast_cancelsRiceWhenChickenFails() = runTest {
        val kitchen = FakeKitchen(
            now = { testScheduler.currentTime },
            chickenShouldFail = true,
        )

        val error = assertFailsWith<IllegalStateException> {
            exercise.prepareLunchFailFast(kitchen)
        }

        assertEquals("chicken burned", error.message)
        assertEquals(
            listOf(
                "rice:start@0",
                "chicken:start@0",
                "chicken:fail@200",
                "rice:cancelled@200",
            ),
            kitchen.events
        )
        assertEquals(200, testScheduler.currentTime)
    }

    @Test
    @Ignore
    fun prepareLunchSupervised_allowsRiceToFinishWhenChickenFails() = runTest {
        val kitchen = FakeKitchen(
            now = { testScheduler.currentTime },
            chickenShouldFail = true,
        )

        val actual = exercise.prepareLunchSupervised(kitchen)

        assertEquals(
            LunchReport(
                rice = "rice",
                chicken = null,
                errors = listOf("chicken burned"),
            ),
            actual
        )
        assertEquals(
            listOf(
                "rice:start@0",
                "chicken:start@0",
                "chicken:fail@200",
                "rice:done@1000",
            ),
            kitchen.events
        )
        assertEquals(1000, testScheduler.currentTime)
    }

    private class FakeKitchen(
        private val now: () -> Long,
        private val chickenShouldFail: Boolean = false,
    ) : KitchenStation {

        val events = mutableListOf<String>()

        override suspend fun cookRice(): String {
            events += "rice:start@${now()}"
            return try {
                delay(1000)
                events += "rice:done@${now()}"
                "rice"
            } catch (exception: CancellationException) {
                events += "rice:cancelled@${now()}"
                throw exception
            }
        }

        override suspend fun cookChicken(): String {
            events += "chicken:start@${now()}"
            delay(200)

            if (chickenShouldFail) {
                events += "chicken:fail@${now()}"
                throw IllegalStateException("chicken burned")
            }

            delay(1300)
            events += "chicken:done@${now()}"
            return "chicken"
        }
    }
}
