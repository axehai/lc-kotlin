package com.axehai.lc.sliding_window.lc3

class LC3 {
    fun lengthOfLongestSubstring(s: String): Int {
        var best = 0
        var left = 0
        val lastSeen = mutableMapOf<Char, Int>()
        for ((right, el) in s.withIndex()) {
            lastSeen[el]?.let { index ->
                if (index >= left) {
                    left = index + 1
                }
            }
            best = maxOf(best, right - left + 1)
            lastSeen[el]=right
        }
        return best
    }
}

/*
My implementation
fun lengthOfLongestSubstring(s: String): Int {
        var best = 0
        var left = 0
        val lastSeen = mutableMapOf<Char, Int>()
        for (right in s.indices) {
            val el = s[right]
            if (lastSeen.getOrDefault(el, -1) >= left) { //shrink left when last seen violates current range
                left = lastSeen[el]?.plus(1) ?: 0
            }
            best = maxOf(best, right - left + 1)
            lastSeen[el] = right
        }
        return best
    }
 */

/*
fun lengthOfLongestSubstring(s: String): Int {
        var best = 0
        var left = 0
        val lastSeen = mutableMapOf<Char, Int>()

        for (right in s.indices) {
            val ch = s[right]
            val previousIndex = lastSeen[ch]

            if (previousIndex != null && previousIndex >= left) {
                left = previousIndex + 1
            }

            lastSeen[ch] = right
            best = maxOf(best, right - left + 1)
        }

        return best
    }
 */