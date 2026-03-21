package com.axehai.lc.sliding_window.lc1493

class LC1493 {
    fun longestSubarray(nums: IntArray): Int {
        var best = 0
        var left = 0
        var zeroCount = 0
        for (right in nums.indices) {
            if (nums[right] == 0) zeroCount++
            while (zeroCount > 1) {
                if (nums[left] == 0) zeroCount--
                left++
            }
            best = maxOf(best,right-left)
        }
        return best
    }
}