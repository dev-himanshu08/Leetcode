class Solution {
    fun compareVersion(version1: String, version2: String): Int {

        val v1 = version1.split(".")
        val v2 = version2.split(".")

        val n = maxOf(v1.size, v2.size)

        for (i in 0 until n) {
            val num1 = if (i < v1.size) v1[i].toInt() else 0
            val num2 = if (i < v2.size) v2[i].toInt() else 0

            if (num1 < num2) return -1
            if (num1 > num2) return 1
        }

        return 0
    }
}