class Solution {
    fun findSubstring(s: String, words: Array<String>): List<Int> {
        val result = mutableListOf<Int>()

        if (words.isEmpty() || s.isEmpty()) return result

        val wordLength = words[0].length
        val wordCount = words.size
        val totalLength = wordLength * wordCount

        if (s.length < totalLength) return result

        val wordMap = HashMap<String, Int>()

        for (word in words) {
            wordMap[word] = wordMap.getOrDefault(word, 0) + 1
        }

        for (start in 0 until wordLength) {
            var left = start
            var right = start
            var count = 0
            val currentMap = HashMap<String, Int>()

            while (right + wordLength <= s.length) {
                val word = s.substring(right, right + wordLength)
                right += wordLength

                if (word in wordMap) {
                    currentMap[word] = currentMap.getOrDefault(word, 0) + 1
                    count++

                    while (currentMap[word]!! > wordMap[word]!!) {
                        val leftWord = s.substring(left, left + wordLength)
                        currentMap[leftWord] = currentMap[leftWord]!! - 1
                        left += wordLength
                        count--
                    }

                    if (count == wordCount) {
                        result.add(left)

                        val leftWord = s.substring(left, left + wordLength)
                        currentMap[leftWord] = currentMap[leftWord]!! - 1
                        left += wordLength
                        count--
                    }
                } else {
                    currentMap.clear()
                    count = 0
                    left = right
                }
            }
        }

        return result
    }
}