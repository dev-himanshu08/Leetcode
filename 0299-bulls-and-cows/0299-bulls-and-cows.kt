class Solution {
    fun getHint(secret: String, guess: String): String {
        var bulls = 0
        var cows = 0

        val secretCount = IntArray(10)
        val guessCount = IntArray(10)

        for (i in secret.indices) {
            if (secret[i] == guess[i]) {
                bulls++
            } else {
                secretCount[secret[i] - '0']++
                guessCount[guess[i] - '0']++
            }
        }

        for (i in 0..9) {
            cows += minOf(secretCount[i], guessCount[i])
        }

        return "${bulls}A${cows}B"
    }
}