class Solution {
    fun maxTurbulenceSize(arr: IntArray): Int {
        if (arr.size < 2) return arr.size

        var left = 0
        var right = 1
        var maxLength = 1

        while (right < arr.size) {

            if (arr[right] == arr[right - 1]) {
                left = right
            } else if (
                right == 1 ||
                (arr[right] > arr[right - 1]) !=
                (arr[right - 1] > arr[right - 2])
            ) {
            } else {
                left = right - 1
            }

            maxLength = maxOf(maxLength, right - left + 1)
            right++
        }

        return maxLength
    }
}