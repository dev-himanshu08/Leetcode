class Solution {
    fun lengthLongestPath(input: String): Int {
        val pathLength = IntArray(input.length + 1)
        var maxLength = 0

        for (line in input.split("\n")) {
            val depth = line.takeWhile { it == '\t' }.length
            val name = line.substring(depth)

            pathLength[depth + 1] = pathLength[depth] + name.length + 1

            if (name.contains(".")) {
                maxLength = maxOf(maxLength, pathLength[depth + 1] - 1)
            }
        }

        return maxLength
    }
}