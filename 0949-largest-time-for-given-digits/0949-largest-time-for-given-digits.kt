class Solution {
    fun largestTimeFromDigits(arr: IntArray): String {
        var ans = ""

        for (i in arr.indices) {
            for (j in arr.indices) {
                if (j == i) continue

                for (k in arr.indices) {
                    if (k == i || k == j) continue

                    for (l in arr.indices) {
                        if (l == i || l == j || l == k) continue

                        val hour = arr[i] * 10 + arr[j]
                        val minute = arr[k] * 10 + arr[l]

                        if (hour < 24 && minute < 60) {
                            val time = "%02d:%02d".format(hour, minute)

                            if (time > ans) {
                                ans = time
                            }
                        }
                    }
                }
            }
        }

        return ans
    }
}