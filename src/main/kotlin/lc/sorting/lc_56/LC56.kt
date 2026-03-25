package com.axehai.lc.sorting.lc_56

import kotlin.emptyArray

class LC56 {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        if (intervals.isEmpty()) return emptyArray()

        intervals.sortBy { it[0] }
        val result = intervals.fold(mutableListOf<IntArray>()) { merged, current ->
            val prev = merged.lastOrNull()

            if (prev == null || prev[1] < current[0]) {
                merged.add(current)
            } else {
                merged.last()[1] = maxOf(prev[1], current[1])
            }
            merged
        }

        return result.toTypedArray()
    }
}

/**
 * class Solution {
 *     fun merge(intervals: Array<IntArray>): Array<IntArray> {
 *         intervals.sortBy { it[0] }
 *
 *         val result = mutableListOf<IntArray>()
 *         for (range in intervals) {
 *             if (result.isEmpty()) {
 *                 result.add(range.copyOf())
 *             } else {
 *                 if (result.last()[1] < range[0]) {
 *                     result.add(range.copyOf())
 *                 } else {
 *                     result.last()[1] = maxOf(result.last()[1], range[1])
 *                 }
 *             }
 *         }
 *
 *         return result.toTypedArray()
 *     }
 * }
 */
