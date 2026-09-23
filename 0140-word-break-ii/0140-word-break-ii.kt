class Solution {
    fun wordBreak(s: String, wordDict: List<String>): List<String> {
        val dict = wordDict.toHashSet()
        val memo = HashMap<Int, List<String>>()

        fun dfs(start: Int): List<String> {
            if (start == s.length) return listOf("")

            if (start in memo) return memo[start]!!

            val result = mutableListOf<String>()

            for (end in start + 1..s.length) {
                val word = s.substring(start, end)

                if (word in dict) {
                    for (rest in dfs(end)) {
                        if (rest.isEmpty()) {
                            result.add(word)
                        } else {
                            result.add("$word $rest")
                        }
                    }
                }
            }

            memo[start] = result
            return result
        }

        return dfs(0)
    }
}