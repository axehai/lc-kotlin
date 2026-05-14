package com.axehai.lc.intervals.lc_253

/*
 * LC 253 – Minimum Number of Platforms (Minimum Platforms)
 * Difficulty: Medium | Source: GeeksForGeeks
 *
 * Given arrival arr[] and departure dep[] times of trains on the same day,
 * find the minimum number of platforms needed so that no train waits.
 * A platform cannot serve two trains at the same time; if a train arrives
 * before another departs, an extra platform is needed.
 *
 * Times are in 24-hour format HHMM (e.g. 900 = 9:00, 1350 = 13:50).
 * Leading zeros are optional. Arrays may be unsorted.
 *
 * Constraints:
 *   1 ≤ n ≤ 10^5
 *   0000 ≤ arr[i] ≤ dep[i] ≤ 2359
 *
 * Examples:
 *   arr=[900,940,950,1100,1500,1800], dep=[910,1200,1120,1130,1900,2000] → 3
 *   arr=[900,1235,1100],              dep=[1000,1240,1200]               → 1
 *   arr=[1000,935,1100],              dep=[1200,1240,1130]               → 3
 */
class LC253 {
    fun findPlatform(arr: IntArray, dep: IntArray): Int {

        val listOfEvents = mutableListOf<Event>().apply {
            addAll(arr.map { Event.Arrival(it) })
            addAll(dep.map { Event.Departure(it) })

            sortWith(Comparator { e1, e2 ->
                if (e1.timestamp == e2.timestamp) {
                    when (e1) {
                        is Event.Arrival if e2 is Event.Departure -> -1
                        is Event.Departure if e2 is Event.Arrival -> 1
                        else -> 0
                    }
                } else
                    e1.timestamp.compareTo(e2.timestamp)
            })
        }

        var curr = 0
        var best = 0
        for (event in listOfEvents) {
            when (event) {
                is Event.Arrival -> {
                    curr++
                    best = maxOf(curr, best)
                }

                is Event.Departure -> {
                    curr--
                    curr = maxOf(0, curr)
                }
            }
        }

        return best
    }

    sealed class Event(val timestamp: Int) {
        data class Arrival(val t: Int) : Event(t)
        data class Departure(val t: Int) : Event(t)
    }
}


/**
 * gfg link: https://www.geeksforgeeks.org/problems/minimum-platforms-1587115620/1
 */