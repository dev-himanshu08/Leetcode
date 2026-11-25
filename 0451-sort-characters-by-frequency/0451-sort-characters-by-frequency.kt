class Solution {
    fun frequencySort(s: String): String {
        val map = HashMap<Char, Int>()

        for (ch in s) {
            map[ch] = (map[ch] ?: 0) + 1
        }

        val result = StringBuilder()

        for ((ch, freq) in map.entries.sortedByDescending { it.value }) {
            repeat(freq) {
                result.append(ch)
            }
        }

        return result.toString()
    }
}