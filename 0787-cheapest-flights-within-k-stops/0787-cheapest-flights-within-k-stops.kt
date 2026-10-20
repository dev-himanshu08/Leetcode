class Solution {
    fun findCheapestPrice(
        n: Int,
        flights: Array<IntArray>,
        src: Int,
        dst: Int,
        k: Int
    ): Int {
        val INF = Int.MAX_VALUE / 2
        var prices = IntArray(n) { INF }
        prices[src] = 0

        repeat(k + 1) {
            val temp = prices.clone()

            for (flight in flights) {
                val from = flight[0]
                val to = flight[1]
                val price = flight[2]

                if (prices[from] != INF) {
                    temp[to] = minOf(temp[to], prices[from] + price)
                }
            }

            prices = temp
        }

        return if (prices[dst] == INF) -1 else prices[dst]
    }
}