package lc.sorting.lc2418

import com.axehai.lc.sorting.lc2418.LC2418
import kotlin.test.Test
import kotlin.test.assertContentEquals

class LC2418Test {

    @Test
    fun example1() {
        val actual = LC2418().sortPeople(
            arrayOf("Mary", "John", "Emma"),
            intArrayOf(180, 165, 170)
        )
        assertContentEquals(arrayOf("Mary", "Emma", "John"), actual)
    }

    @Test
    fun example2() {
        val actual = LC2418().sortPeople(
            arrayOf("Alice", "Bob", "Bob"),
            intArrayOf(155, 185, 150)
        )
        assertContentEquals(arrayOf("Bob", "Alice", "Bob"), actual)
    }

    @Test
    fun edge_singlePerson() {
        val actual = LC2418().sortPeople(
            arrayOf("Solo"),
            intArrayOf(172)
        )
        assertContentEquals(arrayOf("Solo"), actual)
    }

    @Test
    fun edge_alreadySortedDescending() {
        val actual = LC2418().sortPeople(
            arrayOf("Tall", "Mid", "Short"),
            intArrayOf(190, 180, 170)
        )
        assertContentEquals(arrayOf("Tall", "Mid", "Short"), actual)
    }

    @Test
    fun edge_reverseSortedAscending() {
        val actual = LC2418().sortPeople(
            arrayOf("Short", "Mid", "Tall"),
            intArrayOf(170, 180, 190)
        )
        assertContentEquals(arrayOf("Tall", "Mid", "Short"), actual)
    }

    @Test
    fun edge_mixedNamesWithDistinctHeights() {
        val actual = LC2418().sortPeople(
            arrayOf("Zoe", "Adam", "Liam", "Olivia"),
            intArrayOf(165, 182, 176, 190)
        )
        assertContentEquals(arrayOf("Olivia", "Adam", "Liam", "Zoe"), actual)
    }
}
