class Solution {
    fun judgePoint24(cards: IntArray): Boolean {

        fun dfs(nums: List<Double>): Boolean {
            if (nums.size == 1) {
                return kotlin.math.abs(nums[0] - 24.0) < 1e-6
            }

            for (i in nums.indices) {
                for (j in i + 1 until nums.size) {

                    val remaining = mutableListOf<Double>()

                    for (k in nums.indices) {
                        if (k != i && k != j) {
                            remaining.add(nums[k])
                        }
                    }

                    val a = nums[i]
                    val b = nums[j]

                    val results = mutableListOf<Double>()

                    results.add(a + b)
                    results.add(a - b)
                    results.add(b - a)
                    results.add(a * b)

                    if (kotlin.math.abs(b) > 1e-6) {
                        results.add(a / b)
                    }

                    if (kotlin.math.abs(a) > 1e-6) {
                        results.add(b / a)
                    }

                    for (result in results) {
                        remaining.add(result)

                        if (dfs(remaining)) {
                            return true
                        }

                        remaining.removeAt(remaining.lastIndex)
                    }
                }
            }

            return false
        }

        return dfs(cards.map { it.toDouble() })
    }
}