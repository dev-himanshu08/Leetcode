class Solution {
    fun combinationSum3(k: Int, n: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        val current = mutableListOf<Int>()

        fun backtrack(start: Int, sum: Int) {
            if (current.size == k) {
                if (sum == n) {
                    result.add(current.toList())
                }
                return
            }

            if (sum >= n) return

            for (num in start..9) {
                current.add(num)
                backtrack(num + 1, sum + num)
                current.removeAt(current.lastIndex)
            }
        }

        backtrack(1, 0)
        return result
    }
}