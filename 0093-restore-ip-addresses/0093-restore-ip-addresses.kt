class Solution {
    fun restoreIpAddresses(s: String): List<String> {
        val result = mutableListOf<String>()

        fun backtrack(index: Int, parts: MutableList<String>) {
            if (parts.size == 4) {
                if (index == s.length) {
                    result.add(parts.joinToString("."))
                }
                return
            }

            for (end in index until minOf(index + 3, s.length)) {
                val part = s.substring(index, end + 1)

                if (part.length > 1 && part[0] == '0') {
                    break
                }

                if (part.toInt() > 255) {
                    break
                }

                parts.add(part)
                backtrack(end + 1, parts)
                parts.removeAt(parts.size - 1)
            }
        }

        backtrack(0, mutableListOf())
        return result
    }
}