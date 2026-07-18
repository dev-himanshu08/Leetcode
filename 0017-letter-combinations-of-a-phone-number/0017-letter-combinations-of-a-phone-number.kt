class Solution {
    fun letterCombinations(digits: String): List<String> {
        if (digits.isEmpty()) return emptyList()

        val phone = mapOf(
            '2' to "abc",
            '3' to "def",
            '4' to "ghi",
            '5' to "jkl",
            '6' to "mno",
            '7' to "pqrs",
            '8' to "tuv",
            '9' to "wxyz"
        )

        val result = mutableListOf<String>()
        val current = StringBuilder()

        fun backtrack(index: Int) {
            if (index == digits.length) {
                result.add(current.toString())
                return
            }

            val letters = phone[digits[index]]!!

            for (ch in letters) {
                current.append(ch)
                backtrack(index + 1)
                current.deleteCharAt(current.length - 1)
            }
        }

        backtrack(0)
        return result
    }
}