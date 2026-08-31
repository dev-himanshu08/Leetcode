class Solution {
    fun maxSatisfied(
        customers: IntArray,
        grumpy: IntArray,
        minutes: Int
    ): Int {

        var baseSatisfied = 0

        for (i in customers.indices) {
            if (grumpy[i] == 0) {
                baseSatisfied += customers[i]
            }
        }

        var extra = 0
        var maxExtra = 0

        for (i in customers.indices) {
            if (grumpy[i] == 1) {
                extra += customers[i]
            }

            if (i >= minutes && grumpy[i - minutes] == 1) {
                extra -= customers[i - minutes]
            }

            maxExtra = maxOf(maxExtra, extra)
        }

        return baseSatisfied + maxExtra
    }
}