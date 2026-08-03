class Solution {
    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
        candidates.sort()
        val result = mutableListOf<List<Int>>()
        val current = mutableListOf<Int>()

        fun backtrack(start: Int, remain: Int) {
            if (remain == 0) {
                result.add(ArrayList(current))
                return
            }

            for (i in start until candidates.size) {
                if (i > start && candidates[i] == candidates[i - 1]) continue
                if (candidates[i] > remain) break

                current.add(candidates[i])
                backtrack(i + 1, remain - candidates[i])
                current.removeAt(current.size - 1)
            }
        }

        backtrack(0, target)
        return result
    }
}