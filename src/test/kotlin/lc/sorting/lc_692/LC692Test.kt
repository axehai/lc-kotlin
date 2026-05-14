package lc.sorting.lc_692

import com.axehai.lc.sorting.lc_692.LC692
import kotlin.test.Test
import kotlin.test.assertEquals

class LC692Test {
    private val solution = LC692()

    @Test
    fun example1() {
        assertEquals(
            listOf("i", "love"),
            solution.topKFrequent(arrayOf("i", "love", "leetcode", "i", "love", "coding"), 2)
        )
    }

    @Test
    fun example2() {
        assertEquals(
            listOf("the", "is", "sunny", "day"),
            solution.topKFrequent(arrayOf("the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"), 4)
        )
    }

    @Test
    fun edge_singleWord() {
        assertEquals(listOf("a"), solution.topKFrequent(arrayOf("a"), 1))
    }

    @Test
    fun edge_allSameFrequencyLexOrder() {
        assertEquals(
            listOf("a", "b"),
            solution.topKFrequent(arrayOf("b", "a", "c"), 2)
        )
    }

    @Test
    fun edge_kEqualsAllWords() {
        assertEquals(
            listOf("a", "b", "c"),
            solution.topKFrequent(arrayOf("c", "b", "a"), 3)
        )
    }

    @Test
    fun edge_tieBreakLexicographic() {
        assertEquals(
            listOf("apple", "banana"),
            solution.topKFrequent(arrayOf("banana", "apple", "banana", "apple"), 2)
        )
    }

    @Test
    fun edge_higherFreqBeatsLex() {
        assertEquals(
            listOf("z", "a"),
            solution.topKFrequent(arrayOf("z", "z", "z", "a"), 2)
        )
    }
}
