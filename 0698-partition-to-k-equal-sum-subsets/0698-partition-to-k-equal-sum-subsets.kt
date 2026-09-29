class Solution {
    fun canPartitionKSubsets(nums: IntArray, k: Int): Boolean {
        val total = nums.sum()

        if (total % k != 0) return false

        val target = total / k
        nums.sortDescending()

        if (nums[0] > target) return false

        val buckets = IntArray(k)

        fun backtrack(index: Int): Boolean {
            if (index == nums.size) {
                return true
            }

            val num = nums[index]

            for (i in 0 until k) {
                if (buckets[i] + num > target) continue

                buckets[i] += num

                if (backtrack(index + 1)) return true

                buckets[i] -= num

                if (buckets[i] == 0) break
            }

            return false
        }

        return backtrack(0)
    }
}