class Solution {
    fun intersect(nums1: IntArray, nums2: IntArray): IntArray {

        val map = HashMap<Int, Int>()
        val result = ArrayList<Int>()

        
        for (num in nums1) {
            map[num] = map.getOrDefault(num, 0) + 1
        }


        for (num in nums2) {
            val count = map.getOrDefault(num, 0)

            if (count > 0) {
                result.add(num)
                map[num] = count - 1
            }
        }

        return result.toIntArray()
    }
}