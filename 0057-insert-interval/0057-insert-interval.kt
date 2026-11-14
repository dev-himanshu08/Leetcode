class Solution {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        val result = mutableListOf<IntArray>()

        var start = newInterval[0]
        var end = newInterval[1]
        var i = 0

        while (i < intervals.size && intervals[i][1] < start) {
            result.add(intervals[i])
            i++
        }

        while (i < intervals.size && intervals[i][0] <= end) {
            start = minOf(start, intervals[i][0])
            end = maxOf(end, intervals[i][1])
            i++
        }

        result.add(intArrayOf(start, end))

        while (i < intervals.size) {
            result.add(intervals[i])
            i++
        }

        return result.toTypedArray()
    }
}