class Solution {
    fun circularArrayLoop(nums: IntArray): Boolean {
        val n = nums.size

        fun next(index: Int): Int {
            return ((index + nums[index]) % n + n) % n
        }

        for (i in 0 until n) {
            if (nums[i] == 0) continue

            val direction = nums[i] > 0

            var slow = i
            var fast = i

            while (true) {
                val slowNext = next(slow)

                if ((nums[slowNext] > 0) != direction) break

                val fastNext = next(fast)

                if ((nums[fastNext] > 0) != direction) break

                val fastNext2 = next(fastNext)

                if ((nums[fastNext2] > 0) != direction) break

                slow = slowNext
                fast = fastNext2

                if (slow == fast) {
                    if (slow == next(slow)) {
                        break
                    }

                    return true
                }
            }

            var current = i

            while ((nums[current] > 0) == direction && nums[current] != 0) {
                val nextIndex = next(current)

                if (nextIndex == current) {
                    nums[current] = 0
                    break
                }

                nums[current] = 0
                current = nextIndex
            }
        }

        return false
    }
}