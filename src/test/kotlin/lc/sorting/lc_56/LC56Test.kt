package lc.sorting.lc_56

import com.axehai.lc.sorting.lc_56.LC56
import kotlin.test.Test
import kotlin.test.assertTrue

class LC56Test {

    @Test
    fun example1() {
        val actual = LC56().merge(
            arrayOf(
                intArrayOf(1, 3),
                intArrayOf(2, 6),
                intArrayOf(8, 10),
                intArrayOf(15, 18)
            )
        )

        assertIntervalsEqual(
            arrayOf(
                intArrayOf(1, 6),
                intArrayOf(8, 10),
                intArrayOf(15, 18)
            ),
            actual
        )
    }

    @Test
    fun example2() {
        val actual = LC56().merge(
            arrayOf(
                intArrayOf(1, 4),
                intArrayOf(4, 5)
            )
        )

        assertIntervalsEqual(
            arrayOf(
                intArrayOf(1, 5)
            ),
            actual
        )
    }

    @Test
    fun example3() {
        val actual = LC56().merge(
            arrayOf(
                intArrayOf(4, 7),
                intArrayOf(1, 4)
            )
        )

        assertIntervalsEqual(
            arrayOf(
                intArrayOf(1, 7)
            ),
            actual
        )
    }

    @Test
    fun edge_disjointIntervalsRemainSeparate() {
        val actual = LC56().merge(
            arrayOf(
                intArrayOf(1, 2),
                intArrayOf(4, 5),
                intArrayOf(7, 9)
            )
        )

        assertIntervalsEqual(
            arrayOf(
                intArrayOf(1, 2),
                intArrayOf(4, 5),
                intArrayOf(7, 9)
            ),
            actual
        )
    }

    @Test
    fun edge_containedIntervalsCollapseToOuterRange() {
        val actual = LC56().merge(
            arrayOf(
                intArrayOf(1, 10),
                intArrayOf(2, 3),
                intArrayOf(4, 8)
            )
        )

        assertIntervalsEqual(
            arrayOf(
                intArrayOf(1, 10)
            ),
            actual
        )
    }

    private fun assertIntervalsEqual(expected: Array<IntArray>, actual: Array<IntArray>) {
        assertTrue(expected.contentDeepEquals(actual), "Expected=${expected.contentDeepToString()} Actual=${actual.contentDeepToString()}")
    }
}
