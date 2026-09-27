class Solution {
    fun shoppingOffers(
        price: List<Int>,
        special: List<List<Int>>,
        needs: List<Int>
    ): Int {

        val memo = HashMap<List<Int>, Int>()

        fun dfs(needs: List<Int>): Int {
            if (memo.containsKey(needs)) {
                return memo[needs]!!
            }

            var minCost = 0
            for (i in price.indices) {
                minCost += needs[i] * price[i]
            }

            for (offer in special) {
                val newNeeds = needs.toMutableList()
                var valid = true

                for (i in price.indices) {
                    if (offer[i] > needs[i]) {
                        valid = false
                        break
                    }
                    newNeeds[i] -= offer[i]
                }

                if (valid) {
                    minCost = minOf(
                        minCost,
                        offer[price.size] + dfs(newNeeds)
                    )
                }
            }

            memo[needs] = minCost
            return minCost
        }

        return dfs(needs)
    }
}