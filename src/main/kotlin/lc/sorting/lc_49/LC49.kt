package com.axehai.lc.sorting.lc_49

class LC49 {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val map = mutableMapOf<String, MutableList<String>>()
        for(s in strs){
            val key=getSortedVariant(s)
            if(map.contains(key)){
                map.getValue(key).add(s)
            }else{
                map[key] = mutableListOf(s)
            }
        }
        val ans = mutableListOf<List<String>>()
        print(ans)
        for(list in map.values){
            ans.add(list)
        }
        return ans
    }

    fun getSortedVariant(s: String): String {
        val freq = IntArray(26)
        for (c in s) {
            freq[c - 'a']++
        }

        val out = StringBuilder(s.length)
        for (i in 0 until 26) {
            repeat(freq[i]) {
                out.append('a' + i)
            }
        }
        return out.toString()
    }
}
