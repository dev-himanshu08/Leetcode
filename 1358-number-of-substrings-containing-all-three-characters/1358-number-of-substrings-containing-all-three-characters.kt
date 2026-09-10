class Solution {
    fun numberOfSubstrings(s: String): Int {
        val count = IntArray(3)
        var left = 0
        var answer = 0

        for (right in s.indices) {
            count[s[right] - 'a']++

            while (count[0] > 0 && count[1] > 0 && count[2] > 0) {
                answer += s.length - right

                count[s[left] - 'a']--
                left++
            }
        }

        return answer
    }
}