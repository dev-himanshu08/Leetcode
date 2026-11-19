/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * class NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     constructor()
 *
 *     // Constructor initializes a single integer.
 *     constructor(value: Int)
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     fun isInteger(): Boolean
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     fun getInteger(): Int?
 *
 *     // Set this NestedInteger to hold a single integer.
 *     fun setInteger(value: Int): Unit
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     fun add(ni: NestedInteger): Unit
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     fun getList(): List<NestedInteger>?
 * }
 */
class Solution {
    fun deserialize(s: String): NestedInteger {
        if (s[0] != '[') {
            return NestedInteger(s.toInt())
        }

        val stack = java.util.Stack<NestedInteger>()
        var num = 0
        var sign = 1
        var hasNum = false

        for (i in s.indices) {
            val c = s[i]

            when {
                c == '[' -> {
                    stack.push(NestedInteger())
                }

                c == '-' -> {
                    sign = -1
                }

                c.isDigit() -> {
                    num = num * 10 + (c - '0')
                    hasNum = true
                }

                (c == ',' || c == ']') && hasNum -> {
                    stack.peek().add(NestedInteger(num * sign))
                    num = 0
                    sign = 1
                    hasNum = false
                }
            }

            if (c == ']' && stack.size > 1) {
                val current = stack.pop()
                stack.peek().add(current)
            }
        }

        return stack.pop()
    }
}