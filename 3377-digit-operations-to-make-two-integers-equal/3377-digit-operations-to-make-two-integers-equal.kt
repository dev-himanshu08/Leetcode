class Solution {
    fun minOperations(n: Int, m: Int): Int {
        if (isPrime(n)) return -1

        val limit = maxOf(n, m)
        val dist = HashMap<Int, Long>()
        val pq = PriorityQueue<Pair<Long, Int>>(compareBy { it.first })

        dist[n] = n.toLong()
        pq.offer(n.toLong() to n)

        while (pq.isNotEmpty()) {
            val (cost, num) = pq.poll()

            if (cost != dist[num]) continue
            if (num == m) return cost.toInt()

            val digits = num.toString().toCharArray()

            for (i in digits.indices) {
                val original = digits[i] - '0'

                for (change in intArrayOf(-1, 1)) {
                    val nextDigit = original + change
                    if (nextDigit !in 0..9) continue
                    if (i == 0 && nextDigit == 0) continue

                    digits[i] = ('0'.code + nextDigit).toChar()
                    val next = String(digits).toInt()
                    digits[i] = ('0'.code + original).toChar()

                    if (isPrime(next)) continue

                    val newCost = cost + next
                    if (newCost < (dist[next] ?: Long.MAX_VALUE)) {
                        dist[next] = newCost
                        pq.offer(newCost to next)
                    }
                }
            }
        }

        return -1
    }

    private fun isPrime(num: Int): Boolean {
        if (num < 2) return false
        if (num == 2) return true
        if (num % 2 == 0) return false

        var i = 3
        while (i.toLong() * i <= num) {
            if (num % i == 0) return false
            i += 2
        }

        return true
    }
}