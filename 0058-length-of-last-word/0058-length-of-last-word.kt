class Solution {
    fun lengthOfLastWord(s: String): Int {
        val trimmedString = s.trim()
        val totalLength = trimmedString.length
        var spaceIndex = -1
        for(i in trimmedString.indices){
            if(trimmedString[i]==' '){
                spaceIndex = i
            }
        }

        return totalLength - (spaceIndex + 1)
    }
}