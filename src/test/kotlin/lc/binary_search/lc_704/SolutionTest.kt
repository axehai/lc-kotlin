package lc.binary_search.lc_704

import com.axehai.lc.binary_search.lc_704.Solution
import kotlin.test.Test
import kotlin.test.assertEquals


class SolutionTest {
    @Test
    fun `returns index when element is found`() {
        val actual = Solution().search(intArrayOf(-1, 0, 3, 5, 9, 12), 9)
        assertEquals(4, actual)
    }

    @Test
    fun `returns -1 when element is not found`() {
        val actual = Solution().search(intArrayOf(-1, 0, 3, 5, 9, 12), 15)
        assertEquals(-1, actual)
    }
}
