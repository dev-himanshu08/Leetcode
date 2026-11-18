class Solution {
    fun removeDuplicateLetters(s: String): String {
        val last = IntArray(26)

        for (i in s.indices) {
            last[s[i] - 'a'] = i
        }

        val stack = StringBuilder()
        val used = BooleanArray(26)

        for (i in s.indices) {
            val c = s[i]
            val index = c - 'a'

            if (used[index]) continue

            while (
                stack.isNotEmpty() &&
                stack.last() > c &&
                last[stack.last() - 'a'] > i
            ) {
                used[stack.last() - 'a'] = false
                stack.deleteCharAt(stack.length - 1)
            }

            stack.append(c)
            used[index] = true
        }

        return stack.toString()
    }
}