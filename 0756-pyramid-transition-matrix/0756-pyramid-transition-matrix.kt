class Solution {
    fun pyramidTransition(bottom: String, allowed: List<String>): Boolean {
        val map = HashMap<String, MutableList<Char>>()

        for (pattern in allowed) {
            val key = pattern.substring(0, 2)
            map.getOrPut(key) { mutableListOf() }.add(pattern[2])
        }

        fun dfs(row: String): Boolean {
            if (row.length == 1) return true

            val next = StringBuilder()

            fun build(index: Int): Boolean {
                if (index == row.length - 1) {
                    return dfs(next.toString())
                }

                val key = row.substring(index, index + 2)
                val options = map[key] ?: return false

                for (c in options) {
                    next.append(c)

                    if (build(index + 1)) return true

                    next.deleteCharAt(next.length - 1)
                }

                return false
            }

            return build(0)
        }

        return dfs(bottom)
    }
}