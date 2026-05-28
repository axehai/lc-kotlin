package com.axehai.lc.binary_search.lc_33

class LC33 {
    fun search(nums: IntArray, target: Int): Int {
        fun binarySearch(low: Int, high: Int): Int {
            var lo = low; var hi = high
            while (lo <= hi) {
                val mid = lo + (hi - lo) / 2
                when {
                    nums[mid] == target -> return mid
                    nums[mid] > target  -> hi = mid - 1
                    else                -> lo = mid + 1
                }
            }
            return -1
        }
        val maxIdx = getRotationDegree(nums)
        return if (target >= nums[0]) binarySearch(0, maxIdx)
               else binarySearch(maxIdx + 1, nums.lastIndex)
    }

    fun getRotationDegree(nums: IntArray): Int {
        var low = 0
        var high = nums.lastIndex
        while (low < high) {
            val mid = low + (high - low) / 2
            if (nums[mid] > nums[high]) low = mid + 1
            else high = mid
        }
        return if (low == 0) nums.lastIndex else low - 1
    }
}

/*
LEARNINGS

1. val vs var discipline
   Always default to `val`. Only use `var` when you actually need to reassign.
   The original had `var mid` inside searchInRange — mid is never reassigned, so it should be `val`.

2. Local functions close over outer scope
   `binarySearch` is only ever called from `search` and always needs `nums` and `target`.
   Declaring it as a local function means it captures those from the enclosing scope automatically —
   no need to pass them as parameters, no need for a helper method on the class.

3. `when` as a multi-branch expression
   Cleaner than nested if/else when you have 3+ conditions on the same subject.
   Each branch is an expression, reads top to bottom without nesting.

4. Custom Range data class + destructuring (from your original — keep this trick)
   `data class Range(val start: Int, val end: Int)` gives you `var (low, high) = range` for free
   via the generated component1/component2 functions. Readable at near-zero cost.

5. Scope function `.let {}` to derive a value from another (from your original — keep this trick)
   `getRotationDegree(nums).let { if (...) Range(0, it) else Range(it+1, ...) }`
   Keeps the range derivation inline and avoids a named intermediate variable.

--- ORIGINAL ---

    fun search(nums: IntArray, target: Int): Int {
        val range = getRotationDegree(nums).let{
            if(target>=nums[0])
                Range(0,it)
            else
                Range(it+1,nums.lastIndex)
        }
        return searchInRange(nums,target,range)
    }

    fun searchInRange(nums: IntArray, target: Int, range: Range): Int {
        var (low, high) = range
        while (low <= high) {
            var mid = low + (high - low) / 2
            if (nums[mid] == target) return mid
            if (nums[mid] > target) {
                high = mid - 1
            } else {
                low = mid + 1
            }
        }
        return -1
    }

    data class Range(val start: Int, val end: Int)
*/