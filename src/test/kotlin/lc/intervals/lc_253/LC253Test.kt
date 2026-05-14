package lc.intervals.lc_253

import com.axehai.lc.intervals.lc_253.LC253
import kotlin.test.Test
import kotlin.test.assertEquals

class LC253Test {

    @Test
    fun example1() {
        assertEquals(3, LC253().findPlatform(
            intArrayOf(900, 940, 950, 1100, 1500, 1800),
            intArrayOf(910, 1200, 1120, 1130, 1900, 2000)
        ))
    }

    @Test
    fun example2() {
        assertEquals(1, LC253().findPlatform(
            intArrayOf(900, 1235, 1100),
            intArrayOf(1000, 1240, 1200)
        ))
    }

    @Test
    fun example3() {
        assertEquals(3, LC253().findPlatform(
            intArrayOf(1000, 935, 1100),
            intArrayOf(1200, 1240, 1130)
        ))
    }

    @Test
    fun edge_singleTrain() {
        assertEquals(1, LC253().findPlatform(
            intArrayOf(900),
            intArrayOf(1000)
        ))
    }

    @Test
    fun edge_allNonOverlapping() {
        assertEquals(1, LC253().findPlatform(
            intArrayOf(900, 1000, 1100),
            intArrayOf(950, 1050, 1150)
        ))
    }

    @Test
    fun edge_twoOverlapping() {
        assertEquals(2, LC253().findPlatform(
            intArrayOf(900, 920),
            intArrayOf(1000, 1100)
        ))
    }

    @Test
    fun edge_arrivalEqualsDeParture() {
        // GFG: arrival == departure counts as overlap, needs a new platform
        assertEquals(2, LC253().findPlatform(
            intArrayOf(900, 1000),
            intArrayOf(1000, 1100)
        ))
    }

    @Test
    fun edge_largeRandom() {
        assertEquals(8, LC253().findPlatform(
            intArrayOf(2225, 1729, 1835, 951, 1143, 515, 1525, 743, 1025, 1611, 1827, 2203, 1116, 1514, 723),
            intArrayOf(2231, 2003, 2149, 2252, 2352, 2153, 1625, 1049, 1337, 1639, 2151, 2330, 1633, 1611, 2009)
        ))
    }

    @Test
    fun edge_allSameTime() {
        // all trains present simultaneously
        assertEquals(4, LC253().findPlatform(
            intArrayOf(800, 800, 800, 800),
            intArrayOf(900, 900, 900, 900)
        ))
    }
}
