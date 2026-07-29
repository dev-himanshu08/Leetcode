class Solution {
    fun longestValidParentheses(s: String): Int {
        val stack = java.util.Stack<Int>()
        stack.push(-1)

        var maxLength = 0

        for (i in s.indices) {
            if (s[i] == '(') {
                stack.push(i)
            } else {
                stack.pop()

                if (stack.isNotEmpty()) {
                    maxLength = maxOf(maxLength, i - stack.peek())
                } else {
                    stack.push(i)
                }
            }
        }

        return maxLength
    }
}