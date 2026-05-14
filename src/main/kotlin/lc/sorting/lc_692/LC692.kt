package com.axehai.lc.sorting.lc_692

import java.util.PriorityQueue
import kotlin.comparisons.compareBy

class LC692 {
    fun topKFrequent(words: Array<String>, k: Int): List<String> {
        val map = mutableMapOf<String, Int>()
        val mHeap = PriorityQueue<WordCount> { w1, w2 ->
            if (w1.wordCount == w2.wordCount) w2.word.compareTo(w1.word)
            else w1.wordCount.compareTo(w2.wordCount)
        }
        for (word in words) {
            map[word] = map.getOrDefault(word, 0) + 1
        }

        for ((word, counter) in map.entries) {
            mHeap.offer(WordCount(word, counter))
            if (mHeap.size > k) {
                mHeap.poll()
            }
        }

        val result = mutableListOf<String>()
        repeat(k){
            result.add(mHeap.poll().word)
        }
        return result.reversed()
    }

    data class WordCount(val word: String, val wordCount: Int)
}

