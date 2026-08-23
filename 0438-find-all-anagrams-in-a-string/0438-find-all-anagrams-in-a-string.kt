class Solution {
    fun findAnagrams(s: String, p: String): List<Int> {

        if (p.length > s.length) return emptyList()

        val result = mutableListOf<Int>()

        val pCount = IntArray(26)
        val windowCount = IntArray(26)

        for (ch in p) {
            pCount[ch - 'a']++
        }

        for (i in s.indices) {

            windowCount[s[i] - 'a']++

            if (i >= p.length) {
                windowCount[s[i - p.length] - 'a']--
            }

            if (windowCount.contentEquals(pCount)) {
                result.add(i - p.length + 1)
            }
        }

        return result
    }
}