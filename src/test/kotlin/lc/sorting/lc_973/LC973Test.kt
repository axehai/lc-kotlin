package lc.sorting.lc_973

import com.axehai.lc.sorting.lc_973.LC973
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class LC973Test {

    @Test
    fun example1() {
        val actual = LC973().kClosest(
            arrayOf(
                intArrayOf(1, 3),
                intArrayOf(-2, 2)
            ),
            1
        )

        assertPointsEqualIgnoringOrder(
            arrayOf(
                intArrayOf(-2, 2)
            ),
            actual
        )
    }

    @Test
    fun example2() {
        val actual = LC973().kClosest(
            arrayOf(
                intArrayOf(3, 3),
                intArrayOf(5, -1),
                intArrayOf(-2, 4)
            ),
            2
        )

        assertPointsEqualIgnoringOrder(
            arrayOf(
                intArrayOf(3, 3),
                intArrayOf(-2, 4)
            ),
            actual
        )
    }

    @Test
    fun edge_kEqualsPointCountReturnsEverything() {
        val actual = LC973().kClosest(
            arrayOf(
                intArrayOf(2, 2),
                intArrayOf(1, 1),
                intArrayOf(0, 5)
            ),
            3
        )

        assertPointsEqualIgnoringOrder(
            arrayOf(
                intArrayOf(2, 2),
                intArrayOf(1, 1),
                intArrayOf(0, 5)
            ),
            actual
        )
    }

    @Test
    fun edge_handlesNegativeCoordinates() {
        val actual = LC973().kClosest(
            arrayOf(
                intArrayOf(-4, -1),
                intArrayOf(2, 2),
                intArrayOf(-1, -1),
                intArrayOf(3, 0)
            ),
            2
        )

        assertPointsEqualIgnoringOrder(
            arrayOf(
                intArrayOf(-1, -1),
                intArrayOf(2, 2)
            ),
            actual
        )
    }

    @Test
    fun edge_preservesUniqueClosestSubset() {
        val actual = LC973().kClosest(
            arrayOf(
                intArrayOf(10, 0),
                intArrayOf(1, 2),
                intArrayOf(2, 1),
                intArrayOf(6, 6),
                intArrayOf(3, 3)
            ),
            3
        )

        assertPointsEqualIgnoringOrder(
            arrayOf(
                intArrayOf(1, 2),
                intArrayOf(2, 1),
                intArrayOf(3, 3)
            ),
            actual
        )
    }

    private fun assertPointsEqualIgnoringOrder(expected: Array<IntArray>, actual: Array<IntArray>) {
        assertEquals(expected.size, actual.size, "Expected ${expected.size} points but got ${actual.size}")

        val expectedPoints = expected.map { it.joinToString(",") }.sorted()
        val actualPoints = actual.map { it.joinToString(",") }.sorted()
        assertTrue(expectedPoints == actualPoints, "Expected=$expectedPoints Actual=$actualPoints")
    }
}
