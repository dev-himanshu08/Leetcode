class Solution {
    fun removeInvalidParentheses(s: String): List<String> {
        val result = mutableSetOf<String>()

        var left = 0
        var right = 0

        for (ch in s) {
            if (ch == '(') {
                left++
            } else if (ch == ')') {
                if (left > 0) {
                    left--
                } else {
                    right++
                }
            }
        }

        fun isValid(str: String): Boolean {
            var count = 0

            for (ch in str) {
                if (ch == '(') {
                    count++
                } else if (ch == ')') {
                    count--
                    if (count < 0) return false
                }
            }

            return count == 0
        }

        fun dfs(
            index: Int,
            current: String,
            leftRemove: Int,
            rightRemove: Int
        ) {
            if (index == s.length) {
                if (leftRemove == 0 && rightRemove == 0 && isValid(current)) {
                    result.add(current)
                }
                return
            }

            val ch = s[index]

            if (ch == '(' && leftRemove > 0) {
                dfs(index + 1, current, leftRemove - 1, rightRemove)
            }

            if (ch == ')' && rightRemove > 0) {
                dfs(index + 1, current, leftRemove, rightRemove - 1)
            }

            dfs(
                index + 1,
                current + ch,
                leftRemove,
                rightRemove
            )
        }

        dfs(0, "", left, right)

        return result.toList()
    }
}