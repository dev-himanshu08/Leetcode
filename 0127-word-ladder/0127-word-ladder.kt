class Solution {
    fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {
        val wordSet = wordList.toHashSet()

        if (endWord !in wordSet) return 0

        val queue = ArrayDeque<Pair<String, Int>>()
        queue.add(Pair(beginWord, 1))

        val visited = HashSet<String>()
        visited.add(beginWord)

        while (queue.isNotEmpty()) {
            val (word, steps) = queue.removeFirst()

            if (word == endWord) return steps

            val chars = word.toCharArray()

            for (i in chars.indices) {
                val original = chars[i]

                for (c in 'a'..'z') {
                    chars[i] = c
                    val newWord = String(chars)

                    if (newWord in wordSet && newWord !in visited) {
                        visited.add(newWord)
                        queue.add(Pair(newWord, steps + 1))
                    }
                }

                chars[i] = original
            }
        }

        return 0
    }
}