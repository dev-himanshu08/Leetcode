class Solution {
    fun convert(s: String, numRows: Int): String {
         if (numRows == 1 || numRows >= s.length)
            return s

        val rows = MutableList(numRows) { StringBuilder() }

        var currentRow = 0
        var goingDown = true

        for (ch in s) {
            rows[currentRow].append(ch)

            if (currentRow == 0) {
                goingDown = true
            } else if (currentRow == numRows - 1) {
                goingDown = false
            }

            currentRow += if (goingDown) 1 else -1
        }

        val result = StringBuilder()

        for (row in rows) {
            result.append(row)
        }

        return result.toString()

    }
}