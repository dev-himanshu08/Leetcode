class Solution {
    fun numTilePossibilities(tiles: String): Int {
        val count = IntArray(26)

        for (ch in tiles) {
            count[ch - 'A']++
        }

        return backtrack(count)
    }

    private fun backtrack(count: IntArray): Int {
        var total = 0

        for (i in 0 until 26) {
            if (count[i] == 0) continue

            total++
            count[i]--

            total += backtrack(count)

            count[i]++
        }

        return total
    }
}