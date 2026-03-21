package com.axehai.lc.sorting.lc2418

class LC2418 {
    fun sortPeople(names: Array<String>, heights: IntArray): Array<String> {
        val ar = names.indices.sortedByDescending {
            heights[it]
        }.map { names[it] }

        return ar.toTypedArray()
    }

}