class Solution {
    fun lastRemaining(n: Int): Int {
        var head = 1
        var step = 1
        var remaining = n
        var leftToRight = true

        while (remaining > 1) {
            if (leftToRight || remaining % 2 == 1) {
                head += step
            }

            remaining /= 2
            step *= 2
            leftToRight = !leftToRight
        }

        return head
    }
}