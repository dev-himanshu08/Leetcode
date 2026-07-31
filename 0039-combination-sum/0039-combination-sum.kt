class Solution {
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()

        fun backtrack(start: Int, remain: Int, current: MutableList<Int>) {
            if (remain == 0) {
                result.add(ArrayList(current))
                return
            }

            if (remain < 0) return

            for (i in start until candidates.size) {
                current.add(candidates[i])
                backtrack(i, remain - candidates[i], current)
                current.removeAt(current.size - 1)
            }
        }

        backtrack(0, target, mutableListOf())
        return result
    }
}