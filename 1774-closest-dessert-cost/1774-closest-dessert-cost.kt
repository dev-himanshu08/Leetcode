class Solution {
    private var target = 0
    private var answer = Int.MAX_VALUE

    fun closestCost(baseCosts: IntArray, toppingCosts: IntArray, target: Int): Int {
        this.target = target

        for (base in baseCosts) {
            dfs(toppingCosts, 0, base)
        }

        return answer
    }

    private fun dfs(toppings: IntArray, index: Int, cost: Int) {
        updateAnswer(cost)

        if (index == toppings.size) return

        dfs(toppings, index + 1, cost)
        dfs(toppings, index + 1, cost + toppings[index])
        dfs(toppings, index + 1, cost + 2 * toppings[index])
    }

    private fun updateAnswer(cost: Int) {
        if (
            kotlin.math.abs(cost - target) < kotlin.math.abs(answer - target) ||
            (kotlin.math.abs(cost - target) == kotlin.math.abs(answer - target) && cost < answer)
        ) {
            answer = cost
        }
    }
}