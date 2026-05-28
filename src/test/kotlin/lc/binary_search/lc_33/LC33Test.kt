package lc.binary_search.lc_33

import com.axehai.lc.binary_search.lc_33.LC33
import kotlin.test.Test
import kotlin.test.assertEquals

class LC33Test {
    private val lc = LC33()

    @Test
    fun example1() {
        // nums = [4,5,6,7,0,1,2], target = 0 => 4
        assertEquals(4, lc.search(intArrayOf(4, 5, 6, 7, 0, 1, 2), 0))
    }

    @Test
    fun example2() {
        // nums = [4,5,6,7,0,1,2], target = 3 => -1
        assertEquals(-1, lc.search(intArrayOf(4, 5, 6, 7, 0, 1, 2), 3))
    }

    @Test
    fun example3() {
        // nums = [1], target = 0 => -1
        assertEquals(-1, lc.search(intArrayOf(1), 0))
    }

    @Test
    fun edge_targetAtPivot() {
        // target is exactly at the rotation point
        assertEquals(4, lc.search(intArrayOf(6, 7, 8, 9, 1, 2, 3), 1))
    }

    @Test
    fun edge_notRotated() {
        // array is not rotated at all
        assertEquals(3, lc.search(intArrayOf(1, 2, 3, 4, 5), 4))
    }

    @Test
    fun edge_singleElement_found() {
        assertEquals(0, lc.search(intArrayOf(5), 5))
    }

    @Test
    fun edge_twoElements_rotated() {
        assertEquals(1, lc.search(intArrayOf(3, 1), 1))
    }

    @Test
    fun edge_targetFirst() {
        assertEquals(0, lc.search(intArrayOf(5, 1, 2, 3, 4), 5))
    }

    @Test
    fun edge_targetLast() {
        assertEquals(6, lc.search(intArrayOf(2, 3, 4, 5, 6, 7, 1), 1))
    }
}
