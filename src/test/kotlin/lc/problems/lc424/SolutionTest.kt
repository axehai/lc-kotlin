package lc.problems.lc424

import com.axehai.lc.sliding_window.lc424.Solution
import kotlin.test.Test
import kotlin.test.assertEquals


class SolutionTest {

    @Test
    fun example1() {
        val actual = Solution().characterReplacement("ABAB", 2)
        assertEquals(4, actual)
    }

    @Test
    fun example2() {
        val actual = Solution().characterReplacement("AABABBA", 1)
        assertEquals(4, actual)
    }

    @Test
    fun edge_singleChar() {
        val actual = Solution().characterReplacement("A", 0)
        assertEquals(1, actual)
    }

    @Test
    fun edge_noReplacement() {
        val actual = Solution().characterReplacement("ABCDE", 0)
        assertEquals(1, actual)
    }

}