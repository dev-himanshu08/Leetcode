class Solution {
    fun maxFreq(s: String, maxLetters: Int, minSize: Int, maxSize: Int): Int {
        val map = HashMap<String, Int>()
        val freq = IntArray(26)

        var left = 0
        var unique = 0
        var answer = 0

        for (right in s.indices) {
            val index = s[right] - 'a'

            if (freq[index] == 0) {
                unique++
            }
            freq[index]++

            if (right - left + 1 > minSize) {
                val removeIndex = s[left] - 'a'
                freq[removeIndex]--

                if (freq[removeIndex] == 0) {
                    unique--
                }

                left++
            }

            if (right - left + 1 == minSize && unique <= maxLetters) {
                val sub = s.substring(left, right + 1)
                map[sub] = map.getOrDefault(sub, 0) + 1

                answer = maxOf(answer, map[sub]!!)
            }
        }

        return answer
    }
}