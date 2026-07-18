class Solution {
    fun maxArea(height: IntArray): Int {
        var left = 0
        var right = height.size - 1
        var maxArea = 0

        while (left < right) {
            val width = right - left
            val currentArea = minOf(height[left], height[right]) * width

            maxArea = maxOf(maxArea, currentArea)

            if (height[left] < height[right]) {
                left++
            } else {
                right--
            }
        }

        return maxArea
    }
}