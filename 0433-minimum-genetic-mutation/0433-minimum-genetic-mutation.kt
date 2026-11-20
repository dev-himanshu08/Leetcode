class Solution {
    fun minMutation(startGene: String, endGene: String, bank: Array<String>): Int {
        val bankSet = bank.toHashSet()

        if (endGene !in bankSet) return -1

        val queue = ArrayDeque<Pair<String, Int>>()
        val visited = HashSet<String>()

        queue.add(startGene to 0)
        visited.add(startGene)

        val genes = charArrayOf('A', 'C', 'G', 'T')

        while (queue.isNotEmpty()) {
            val (gene, mutations) = queue.removeFirst()

            if (gene == endGene) {
                return mutations
            }

            val chars = gene.toCharArray()

            for (i in chars.indices) {
                val original = chars[i]

                for (c in genes) {
                    if (c == original) continue

                    chars[i] = c
                    val nextGene = String(chars)

                    if (nextGene in bankSet && nextGene !in visited) {
                        visited.add(nextGene)
                        queue.add(nextGene to mutations + 1)
                    }
                }

                chars[i] = original
            }
        }

        return -1
    }
}