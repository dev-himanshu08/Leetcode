class Solution {
    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        val map = HashMap<Int, Int>()

        for (i in nums.indices) {
            if (map.containsKey(nums[i])) {
                val previousIndex = map[nums[i]]!!

                if (i - previousIndex <= k) {
                    return true
                }
            }

            map[nums[i]] = i
        }

        return false
    }
}