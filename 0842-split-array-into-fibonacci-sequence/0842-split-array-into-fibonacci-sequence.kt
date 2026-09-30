class Solution {
    fun splitIntoFibonacci(num: String): List<Int> {
        val result = mutableListOf<Int>()

        fun backtrack(index: Int): Boolean {
            if (index == num.length) {
                return result.size >= 3
            }

            var value = 0L

            for (i in index until num.length) {
                if (i > index && num[index] == '0') break

                value = value * 10 + (num[i] - '0')

                if (value > Int.MAX_VALUE) break

                if (result.size >= 2) {
                    val sum = result[result.size - 1].toLong() +
                              result[result.size - 2].toLong()

                    if (value < sum) continue
                    if (value > sum) break
                }

                result.add(value.toInt())

                if (backtrack(i + 1)) {
                    return true
                }

                result.removeAt(result.lastIndex)
            }

            return false
        }

        return if (backtrack(0)) result else emptyList()
    }
}