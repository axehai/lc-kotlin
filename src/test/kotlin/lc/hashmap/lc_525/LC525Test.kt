package lc.hashmap.lc_525

import com.axehai.lc.hashmap.lc_525.LC525
import kotlin.test.Test
import kotlin.test.assertEquals

class LC525Test {
    private val solution = LC525()

    @Test
    fun example1() {
        // [0,1] -> length 2
        assertEquals(2, solution.findMaxLength(intArrayOf(0, 1)))
    }

    @Test
    fun example2() {
        // [0,1,0] -> length 2
        assertEquals(2, solution.findMaxLength(intArrayOf(0, 1, 0)))
    }

    @Test
    fun edge_allZeros() {
        assertEquals(0, solution.findMaxLength(intArrayOf(0, 0, 0)))
    }

    @Test
    fun edge_allOnes() {
        assertEquals(0, solution.findMaxLength(intArrayOf(1, 1, 1)))
    }

    @Test
    fun edge_singleElement() {
        assertEquals(0, solution.findMaxLength(intArrayOf(0)))
        assertEquals(0, solution.findMaxLength(intArrayOf(1)))
    }

    @Test
    fun edge_longerSubarrayInMiddle() {
        // [0,0,1,0,0,0,1,1] -> length 6 (indices 1..6)
        assertEquals(6, solution.findMaxLength(intArrayOf(0, 0, 1, 0, 0, 0, 1, 1)))
    }

    @Test
    fun edge_entireArrayBalanced() {
        assertEquals(4, solution.findMaxLength(intArrayOf(0, 1, 1, 0)))
    }

    @Test
    fun edge_twoElements_unbalanced() {
        assertEquals(0, solution.findMaxLength(intArrayOf(0, 0)))
    }
}
