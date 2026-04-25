package com.axehai.lc.hashmap.lc_525

class LC525 {
    fun findMaxLength(nums: IntArray): Int {
        var best = 0
        val map = mutableMapOf<Int, Int>().apply {
            put(0,-1)
        }
        var sumSoFar = 0
        for ((index, num) in nums.withIndex()) {
            sumSoFar += if (num == 0) -1 else 1
            map[sumSoFar]?.let { best = maxOf(best, index - it) }
            map.putIfAbsent(sumSoFar, index)
        }
        return best
    }
}
