package lc.sliding_window.lc_3

import com.axehai.lc.sliding_window.lc_3.LC3
import kotlin.test.Test
import kotlin.test.assertEquals

class LC3Test {

    @Test
    fun example1() {
        val actual = LC3().lengthOfLongestSubstring("abcabcbb")
        assertEquals(3, actual)
    }

    @Test
    fun example2() {
        val actual = LC3().lengthOfLongestSubstring("bbbbb")
        assertEquals(1, actual)
    }

    @Test
    fun example3() {
        val actual = LC3().lengthOfLongestSubstring("pwwkew")
        assertEquals(3, actual)
    }

    @Test
    fun edge_emptyString() {
        val actual = LC3().lengthOfLongestSubstring("")
        assertEquals(0, actual)
    }

    @Test
    fun edge_allUniqueCharacters() {
        val actual = LC3().lengthOfLongestSubstring("abcdef")
        assertEquals(6, actual)
    }

    @Test
    fun edge_duplicateForcesLeftPointerJump() {
        val actual = LC3().lengthOfLongestSubstring("abba")
        assertEquals(2, actual)
    }

    @Test
    fun edge_repeatAfterLongUniqueRun() {
        val actual = LC3().lengthOfLongestSubstring("dvdf")
        assertEquals(3, actual)
    }
}
