class Solution {
    fun maxRepOpt1(text: String): Int {
        val total = IntArray(26)

        for (c in text) {
            total[c - 'a']++
        }

        var left = 0
        var maxFreq = 0
        var answer = 0
        val window = IntArray(26)

        for (right in text.indices) {
            val index = text[right] - 'a'
            window[index]++

            maxFreq = maxOf(maxFreq, window[index])

            while (right - left + 1 - maxFreq > 1) {
                window[text[left] - 'a']--
                left++
            }

            val length = right - left + 1
            val mostFrequentChar = text.substring(left, right + 1)
                .count { it == text[right] }

            answer = maxOf(
                answer,
                minOf(length, total[text[right] - 'a'])
            )
        }

        return answer
    }
}