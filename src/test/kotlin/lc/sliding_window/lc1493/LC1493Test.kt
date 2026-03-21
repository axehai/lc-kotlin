package lc.sliding_window.lc1493

import com.axehai.lc.sliding_window.lc1493.LC1493
import kotlin.test.Test
import kotlin.test.assertEquals

class LC1493Test {

    @Test
    fun example1() {
        val actual = LC1493().longestSubarray(intArrayOf(1, 1, 0, 1))
        assertEquals(3, actual)
    }

    @Test
    fun example2() {
        val actual = LC1493().longestSubarray(intArrayOf(0, 1, 1, 1, 0, 1, 1, 0, 1))
        assertEquals(5, actual)
    }

    @Test
    fun example3() {
        val actual = LC1493().longestSubarray(intArrayOf(1, 1, 1))
        assertEquals(2, actual)
    }

    @Test
    fun edge_singleZero() {
        val actual = LC1493().longestSubarray(intArrayOf(0))
        assertEquals(0, actual)
    }

    @Test
    fun edge_singleOneMustStillDelete() {
        val actual = LC1493().longestSubarray(intArrayOf(1))
        assertEquals(0, actual)
    }

    @Test
    fun edge_allZeros() {
        val actual = LC1493().longestSubarray(intArrayOf(0, 0, 0, 0))
        assertEquals(0, actual)
    }

    @Test
    fun edge_deleteMiddleZeroToJoinRuns() {
        val actual = LC1493().longestSubarray(intArrayOf(1, 1, 1, 0, 1, 1))
        assertEquals(5, actual)
    }

    @Test
    fun edge_multipleZerosPreventJoiningEverything() {
        val actual = LC1493().longestSubarray(intArrayOf(1, 1, 0, 1, 0, 1, 1, 1))
        assertEquals(4, actual)
    }
}
