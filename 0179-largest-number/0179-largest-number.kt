class Solution {
    fun largestNumber(nums: IntArray): String {
        val arr = nums.map { it.toString() }

        val sorted = arr.sortedWith(Comparator { a, b ->
            (b + a).compareTo(a + b)
        })

        if (sorted[0] == "0") return "0"

        return sorted.joinToString("")
    }
}