class Solution {
    fun ambiguousCoordinates(s: String): List<String> {
        val result = mutableListOf<String>()
        val str = s.substring(1, s.length - 1)

        for (i in 1 until str.length) {
            val left = str.substring(0, i)
            val right = str.substring(i)

            val leftNums = generate(left)
            val rightNums = generate(right)

            for (x in leftNums) {
                for (y in rightNums) {
                    result.add("($x, $y)")
                }
            }
        }

        return result
    }

    private fun generate(s: String): List<String> {
        val result = mutableListOf<String>()

        // Integer
        if (s.length == 1 || s[0] != '0') {
            result.add(s)
        }

        // Decimal
        if (s.length > 1 && s.last() != '0') {
            for (i in 1 until s.length) {
                val left = s.substring(0, i)
                val right = s.substring(i)

                if (left.length > 1 && left[0] == '0') continue

                result.add("$left.$right")
            }
        }

        return result
    }
}