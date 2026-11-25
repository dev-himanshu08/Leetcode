class Solution {
    fun validIPAddress(queryIP: String): String {
        if (queryIP.contains('.')) {
            val parts = queryIP.split('.')

            if (parts.size != 4) return "Neither"

            for (part in parts) {
                if (part.isEmpty()) return "Neither"
                if (part.length > 1 && part[0] == '0') return "Neither"
                if (!part.all { it.isDigit() }) return "Neither"

                val num = part.toIntOrNull() ?: return "Neither"
                if (num !in 0..255) return "Neither"
            }

            return "IPv4"
        }

        if (queryIP.contains(':')) {
            val parts = queryIP.split(':')

            if (parts.size != 8) return "Neither"

            for (part in parts) {
                if (part.length !in 1..4) return "Neither"

                if (!part.all {
                        it in '0'..'9' ||
                        it in 'a'..'f' ||
                        it in 'A'..'F'
                    }) {
                    return "Neither"
                }
            }

            return "IPv6"
        }

        return "Neither"
    }
}