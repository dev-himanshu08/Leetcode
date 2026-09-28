class Solution {
    fun letterCasePermutation(s: String): List<String> {
        val result = mutableListOf<String>()
        val chars = s.toCharArray()

        fun backtrack(index: Int) {
            if (index == chars.size) {
                result.add(String(chars))
                return
            }

            if (chars[index].isLetter()) {
                chars[index] = chars[index].lowercaseChar()
                backtrack(index + 1)

                chars[index] = chars[index].uppercaseChar()
                backtrack(index + 1)
            } else {
                backtrack(index + 1)
            }
        }

        backtrack(0)
        return result
    }
}