class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        intervals.sortBy { it[0] }

        val result = mutableListOf<IntArray>()

        for (interval in intervals) {
            if (result.isEmpty() || result.last()[1] < interval[0]) {
                result.add(interval)
            } else {
                result.last()[1] = maxOf(result.last()[1], interval[1])
            }
        }

        return result.toTypedArray()
    }
}