class Solution {
    fun totalFruit(fruits: IntArray): Int {
        val map = HashMap<Int, Int>()
        var left = 0
        var maxFruits = 0

        for (right in fruits.indices) {
            map[fruits[right]] = (map[fruits[right]] ?: 0) + 1

            while (map.size > 2) {
                map[fruits[left]] = map[fruits[left]]!! - 1

                if (map[fruits[left]] == 0) {
                    map.remove(fruits[left])
                }

                left++
            }

            maxFruits = maxOf(maxFruits, right - left + 1)
        }

        return maxFruits
    }
}