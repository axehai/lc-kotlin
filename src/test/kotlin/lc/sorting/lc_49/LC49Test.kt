package lc.sorting.lc_49

import com.axehai.lc.sorting.lc_49.LC49
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class LC49Test {

    @Test
    fun example1() {
        val actual = LC49().groupAnagrams(arrayOf("eat", "tea", "tan", "ate", "nat", "bat"))
        assertGroupsEqual(listOf(listOf("bat"), listOf("nat", "tan"), listOf("ate", "eat", "tea")), actual)
    }

    @Test
    fun example2() {
        val actual = LC49().groupAnagrams(arrayOf(""))
        assertGroupsEqual(listOf(listOf("")), actual)
    }

    @Test
    fun example3() {
        val actual = LC49().groupAnagrams(arrayOf("a"))
        assertGroupsEqual(listOf(listOf("a")), actual)
    }

    @Test
    fun edge_allSameAnagram() {
        val actual = LC49().groupAnagrams(arrayOf("abc", "bca", "cab"))
        assertGroupsEqual(listOf(listOf("abc", "bca", "cab")), actual)
    }

    @Test
    fun edge_noAnagrams() {
        val actual = LC49().groupAnagrams(arrayOf("abc", "def", "ghi"))
        assertGroupsEqual(listOf(listOf("abc"), listOf("def"), listOf("ghi")), actual)
    }

    @Test
    fun edge_singleChar() {
        val actual = LC49().groupAnagrams(arrayOf("a", "b", "a"))
        assertGroupsEqual(listOf(listOf("a", "a"), listOf("b")), actual)
    }

    @Test
    fun edge_emptyStringsGrouped() {
        val actual = LC49().groupAnagrams(arrayOf("", "a", ""))
        assertGroupsEqual(listOf(listOf("", ""), listOf("a")), actual)
    }

    @Test
    fun edge_mixedLengths() {
        val actual = LC49().groupAnagrams(arrayOf("ab", "ba", "abc", "bca", "a"))
        assertGroupsEqual(listOf(listOf("ab", "ba"), listOf("abc", "bca"), listOf("a")), actual)
    }

    private fun assertGroupsEqual(expected: List<List<String>>, actual: List<List<String>>) {
        assertEquals(expected.size, actual.size, "Expected ${expected.size} groups but got ${actual.size}")
        val normalize = { groups: List<List<String>> -> groups.map { it.sorted() }.sortedWith(compareBy({ it.size }, { it.joinToString() })) }
        assertTrue(normalize(expected) == normalize(actual), "Expected=$expected Actual=$actual")
    }
}
