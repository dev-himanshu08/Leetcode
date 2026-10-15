class Solution {
    fun decodeString(s: String): String {
        val countStack = java.util.Stack<Int>()
        val stringStack = java.util.Stack<String>()
        var current = ""
        var count = 0

        for (ch in s) {
            when {
                ch.isDigit() -> {
                    count = count * 10 + (ch - '0')
                }

                ch == '[' -> {
                    countStack.push(count)
                    stringStack.push(current)
                    count = 0
                    current = ""
                }

                ch == ']' -> {
                    current = stringStack.pop() + current.repeat(countStack.pop())
                }

                else -> {
                    current += ch
                }
            }
        }

        return current
    }
}