package com.axehai.lc.sorting.lc_973

import java.util.PriorityQueue
import kotlin.comparisons.compareBy

class LC973 {
    fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
        val heap = PriorityQueue<IntArray>(compareByDescending { points ->
            points[0] * points[0] + points[1] * points[1]
        })
        points.forEach { coordinate ->
            heap.offer(coordinate)
            if (heap.size > k) {
                heap.poll()
            }
        }
        return Array(k) { heap.poll() }
    }
}

/**
 * fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
 *         val heap = PriorityQueue<IntArray>(compareBy { points ->
 *             points[0] * points[0] + points[1] * points[1]
 *         })
 *         heap.addAll(points)
 *         val result = Array<IntArray>(k, init = { IntArray(2) })
 *         for (i in 0 until k) {
 *             result[i] = heap.poll()
 *         }
 *         return result
 *     }
 */