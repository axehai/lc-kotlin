package lc.sliding_window.lc1004

import com.axehai.lc.sliding_window.lc1004.LC1004
import kotlin.test.Test
import kotlin.test.assertEquals


class LC1004Test {

    @Test
    fun example1() {
        val actual = LC1004().longestOnes(intArrayOf(1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0), 2)
        assertEquals(6, actual)
    }

    @Test
    fun example2() {
        val actual = LC1004().longestOnes(
            intArrayOf(0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1),
            3
        )
        assertEquals(10, actual)
    }

    @Test
    fun edge_singleElementZeroCanBeFlipped() {
        val actual = LC1004().longestOnes(intArrayOf(0), 1)
        assertEquals(1, actual)
    }

    @Test
    fun edge_noFlipsAllowed() {
        val actual = LC1004().longestOnes(intArrayOf(1, 0, 1, 1, 0, 1), 0)
        assertEquals(2, actual)
    }

    @Test
    fun edge_allZerosLimitedByK() {
        val actual = LC1004().longestOnes(intArrayOf(0, 0, 0, 0), 2)
        assertEquals(2, actual)
    }

    @Test
    fun edge_kLargeEnoughForWholeArray() {
        val actual = LC1004().longestOnes(intArrayOf(0, 1, 0, 1, 1, 0), 6)
        assertEquals(6, actual)
    }
}
