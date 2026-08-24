class Solution {
    fun findRepeatedDnaSequences(s: String): List<String> {
        if (s.length < 10) return emptyList()

        val seen = HashSet<String>()
        val repeated = HashSet<String>()

        for (i in 0..s.length - 10) {
            val sequence = s.substring(i, i + 10)

            if (!seen.add(sequence)) {
                repeated.add(sequence)
            }
        }

        return repeated.toList()
    }
}