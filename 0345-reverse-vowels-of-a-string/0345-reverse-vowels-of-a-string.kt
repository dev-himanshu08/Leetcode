class Solution {
    fun reverseVowels(s: String): String {
        val chars = s.toCharArray()

        var left = 0
        var right = chars.size - 1

        val vowels = setOf('a', 'e', 'i', 'o', 'u',
                           'A', 'E', 'I', 'O', 'U')

        while (left < right) {

            
            while (left < right && chars[left] !in vowels) {
                left++
            }

            
            while (left < right && chars[right] !in vowels) {
                right--
            }

            
            val temp = chars[left]
            chars[left] = chars[right]
            chars[right] = temp

            left++
            right--
        }

        return String(chars)
    }
}