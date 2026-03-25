package com.axehai.lc.sliding_window.lc_1004

class LC1004 {
    fun longestOnes(nums: IntArray, k: Int): Int {
        var ans = 0
        var left = 0
        var zeroesInRange = 0
        for (right in nums.indices) {
            if (nums[right] == 0) zeroesInRange++
            while (zeroesInRange > k) {
                if (nums[left++] == 0) zeroesInRange--
            }
            ans=maxOf(right-left+1,ans)
        }
        return ans
    }
}
