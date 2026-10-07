class Solution {
    fun circularPermutation(n: Int, start: Int): List<Int> {
        val result = mutableListOf<Int>()
        val size = 1 shl n

        for (i in 0 until size) {
            val gray = i xor (i shr 1)
            result.add(gray xor start)
        }

        return result
    }
}